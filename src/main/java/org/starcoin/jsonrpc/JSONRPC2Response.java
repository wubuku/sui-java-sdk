package org.starcoin.jsonrpc;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a JSON-RPC 2.0 response.
 *
 * <p>A response is returned to the caller after a JSON-RPC 2.0 request has
 * been processed (notifications, however, don't produce a response). The
 * response can take two different forms depending on the outcome:
 *
 * <ul>
 *     <li>The request was successful. The corresponding response returns
 *         a JSON object with the following information:
 *         <ul>
 *             <li>{@code result} The result, which can be of any JSON type
 *                 - a number, a boolean value, a string, an array, an object
 *                 or null.
 *             <li>{@code id} The request identifier which is echoed back back
 *                 to the caller.
 *             <li>{@code jsonrpc} A string indicating the JSON-RPC protocol
 *                 version set to "2.0".
 *         </ul>
 *     <li>The request failed. The returned JSON object contains:
 *         <ul>
 *             <li>{@code error} An object with:
 *                 <ul>
 *                     <li>{@code code} An integer indicating the error type.
 *                     <li>{@code message} A brief error messsage.
 *                     <li>{@code data} Optional error data.
 *                 </ul>
 *             <li>{@code id} The request identifier. If it couldn't be
 *                 determined, e.g. due to a request parse error, the ID is
 *                 set to {@code null}.
 *             <li>{@code jsonrpc} A string indicating the JSON-RPC protocol
 *                 version set to "2.0".
 *         </ul>
 * </ul>
 *
 * <p>Here is an example JSON-RPC 2.0 response string where the request
 * has succeeded:
 *
 * <pre>
 * {
 *    "result"  : true,
 *    "id"      : "req-002",
 *    "jsonrpc" : "2.0"
 * }
 * </pre>
 *
 *
 * <p>And here is an example JSON-RPC 2.0 response string indicating a failure:
 *
 * <pre>
 * {
 *    "error"   : { "code" : -32601, "message" : "Method not found" },
 *    "id"      : "req-003",
 *    "jsonrpc" : "2.0"
 * }
 * </pre>
 *
 * @author Vladimir Dzhuvinov
 */
public class JSONRPC2Response {

    @JsonProperty("jsonrpc")
    private String jsonRPCVersion;

    /**
     * The result.
     */
    private Object result = null;

    /**
     * The error.
     */
    private JSONRPC2Error error = null;

    /**
     * The echoed request identifier.
     */
    private Object id = null;

    public JSONRPC2Response() {

    }


    /**
     * Creates a new JSON-RPC 2.0 response to a successful request.
     *
     * @param result The result. The value can <a href="#map">map</a>
     *               to any JSON type. May be {@code null}.
     * @param id     The request identifier echoed back to the caller. May
     *               be {@code null} though not recommended.
     */
    public JSONRPC2Response(final Object result, final Object id) {

        setResult(result);
        setID(id);
    }


    /**
     * Creates a new JSON-RPC 2.0 response to a successful request which
     * result is {@code null}.
     *
     * @param id The request identifier echoed back to the caller. May be
     *           {@code null} though not recommended.
     */
    public JSONRPC2Response(final Object id) {

        setResult(null);
        setID(id);
    }


    /**
     * Creates a new JSON-RPC 2.0 response to a failed request.
     *
     * @param error A JSON-RPC 2.0 error instance indicating the
     *              cause of the failure. Must not be {@code null}.
     * @param id    The request identifier echoed back to the caller.
     *              Pass a {@code null} if the request identifier couldn't
     *              be determined (e.g. due to a parse error).
     */
    public JSONRPC2Response(final JSONRPC2Error error, final Object id) {

        setError(error);
        setID(id);
    }

    /**
     * Gets the result of the request. The returned value has meaning
     * only if the request was successful. Use the
     * {@link #getError getError} method to check this.
     *
     * @return The result.
     */
    public Object getResult() {

        return result;
    }

    /**
     * Indicates a successful JSON-RPC 2.0 request and sets the result.
     * Note that if the response was previously indicating failure this
     * will turn it into a response indicating success. Any previously set
     * error data will be invalidated.
     *
     * @param result The result. The value can <a href="#map">map</a> to
     *               any JSON type. May be {@code null}.
     */
    public void setResult(final Object result) {

        // result and error are mutually exclusive
        this.result = result;
        this.error = null;
    }

    /**
     * Gets the error object indicating the cause of the request failure.
     * If a {@code null} is returned, the request succeeded and there was
     * no error.
     *
     * @return A JSON-RPC 2.0 error object, {@code null} if the response
     * indicates success.
     */
    public JSONRPC2Error getError() {

        return error;
    }

    /**
     * Indicates a failed JSON-RPC 2.0 request and sets the error details.
     * Note that if the response was previously indicating success this
     * will turn it into a response indicating failure. Any previously set
     * result data will be invalidated.
     *
     * @param error A JSON-RPC 2.0 error instance indicating the cause of
     *              the failure. Must not be {@code null}.
     */
    public void setError(final JSONRPC2Error error) {

        if (error == null)
            throw new IllegalArgumentException("The error object cannot be null");

        // result and error are mutually exclusive
        this.error = error;
        this.result = null;
    }

    /**
     * A convinience method to check if the response indicates success or
     * failure of the request. Alternatively, you can use the
     * {@code #getError} method for this purpose.
     *
     * @return {@code true} if the request succeeded, {@code false} if
     * there was an error.
     */
    public boolean indicatesSuccess() {

        return error == null;
    }

    /**
     * Gets the request identifier that is echoed back to the caller.
     *
     * @return The request identifier. If there was an error during the
     * the request retrieval (e.g. parse error) and the identifier
     * couldn't be determined, the value will be {@code null}.
     */
    public Object getID() {

        return id;
    }

    /**
     * Sets the request identifier echoed back to the caller.
     *
     * @param id The value must <a href="#map">map</a> to a JSON scalar.
     *           Pass a {@code null} if the request identifier couldn't
     *           be determined (e.g. due to a parse error).
     */
    public void setID(final Object id) {

        if (id == null ||
                id instanceof Boolean ||
                id instanceof Number ||
                id instanceof String
        ) {
            this.id = id;
        } else {
            this.id = id.toString();
        }
    }


    public String getJsonRPCVersion() {
        return jsonRPCVersion;
    }

    public void setJsonRPCVersion(String jsonRPCVersion) {
        this.jsonRPCVersion = jsonRPCVersion;
    }

    @Override
    public String toString() {
        return "JSONRPC2Response{" +
                "jsonrpc='" + jsonRPCVersion + '\'' +
                ", result=" + result +
                ", error=" + error +
                ", id=" + id +
                '}';
    }

}
