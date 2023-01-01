package org.starcoin.jsonrpc.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.starcoin.jsonrpc.JSONRPC2Request;
import org.starcoin.jsonrpc.JSONRPC2Response;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Sends requests and / or notifications to a specified JSON-RPC 2.0 server
 * URL. The JSON-RPC 2.0 messages are dispatched by means of HTTP(S) POST.
 * This class is thread-safe.
 *
 * @author Vladimir Dzhuvinov
 * @author Mike Outland
 */
public class JSONRPC2Session {
    public static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    /**
     * The server URL, which protocol must be HTTP or HTTPS.
     *
     * <p>Example URL: "http://jsonrpc.example.com:8080"
     */
    private URL url;


    public JSONRPC2Session(final URL url) {

        if (!url.getProtocol().equalsIgnoreCase("http") &&
                !url.getProtocol().equalsIgnoreCase("https"))
            throw new IllegalArgumentException("The URL protocol must be HTTP or HTTPS");

        this.url = url;
    }


    /**
     * Gets the JSON-RPC 2.0 server URL.
     *
     * @return The server URL.
     */
    public URL getURL() {

        return url;
    }

    /**
     * Sets the JSON-RPC 2.0 server URL.
     *
     * @param url The server URL. Must not be {@code null}.
     */
    public void setURL(final URL url) {

        if (url == null)
            throw new IllegalArgumentException("The server URL must not be null");

        this.url = url;
    }


    /**
     * Sends a JSON-RPC 2.0 request using HTTP POST and returns the server
     * response.
     *
     * @param request The JSON-RPC 2.0 request to send. Must not be
     *                {@code null}.
     * @return The JSON-RPC 2.0 response returned by the server.
     * @throws JSONRPC2SessionException On a network error, unexpected HTTP
     *                                  response content type or invalid
     *                                  JSON-RPC 2.0 response.
     */
    public JSONRPC2Response send(final JSONRPC2Request request) throws JSONRPC2SessionException {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("jsonrpc", "2.0");
        bodyMap.put("method", request.getMethod());
        bodyMap.put("id", request.getID() == null ? UUID.randomUUID().toString() : request.getID());
        bodyMap.put("params", request.getParams());
        try {
            RequestBody body = RequestBody.create(getObjectMapper().writeValueAsString(bodyMap), JSON_MEDIA_TYPE);
            System.out.println(getObjectMapper().writeValueAsString(bodyMap));
            Request okRequest = new Request.Builder().post(body).url(this.url).build();
            Response response = okHttpClient.newCall(okRequest).execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException("JSON RPC error. Response is NOT successful." + response);
            }
            if (response.body() == null) {
                throw new JSONRPC2SessionException("Response body is null.");
            }
            return getObjectMapper().readValue(response.body().string(), JSONRPC2Response.class);
        } catch (IOException ioException) {
            throw new JSONRPC2SessionException("Send JSON RPC IO error.", ioException);
        }
    }

    private ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

//    /**
//     * Sends a JSON-RPC 2.0 notification using HTTP POST. Note that
//     * contrary to requests, notifications produce no server response.
//     *
//     * @param notification The JSON-RPC 2.0 notification to send. Must not
//     *                     be {@code null}.
//     * @throws JSONRPC2SessionException On a network error.
//     */
//    public void send(final JSONRPC2Notification notification)
//            throws JSONRPC2SessionException {
//    }

}

