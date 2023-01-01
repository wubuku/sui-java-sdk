package org.starcoin.jsonrpc;


import java.util.List;
import java.util.Map;


/**
 * Represents a JSON-RPC 2.0 request.
 *
 * <p>A request carries four pieces of data:
 * <ul>
 *     <li>{@code method} The name of the remote method to call.
 *     <li>{@code params} The required method parameters (if any), which can
 *         be packed into a JSON array or object.
 *     <li>{@code id} An identifier which is echoed back to the client with
 *         the response.
 *     <li>{@code jsonrpc} A string indicating the JSON-RPC protocol version
 *         set to "2.0".
 * </ul>
 *
 * <p>Here is a sample JSON-RPC 2.0 request string:
 *
 * <pre>
 * {
 *    "method"  : "makePayment",
 *    "params"  : { "recipient" : "Penny Adams", "amount":175.05 },
 *    "id"      : "0001",
 *    "jsonrpc" : "2.0"
 * }
 * </pre>
 *
 * @author Vladimir Dzhuvinov
 */
public class JSONRPC2Request {


    /**
     * The method name.
     */
    private String method;


    /**
     * The positional parameters, {@code null} if none.
     */
    private List<Object> positionalParams;


    /**
     * The named parameters, {@code null} if none.
     */
    private Map<String, Object> namedParams;


    /**
     * The request identifier.
     */
    private Object id;


    /**
     * Constructs a new JSON-RPC 2.0 request with no parameters.
     *
     * @param method The name of the requested method. Must not be
     *               {@code null}.
     * @param id     The request identifier echoed back to the caller.
     *               The value must <a href="#map">map</a> to a JSON
     *               scalar ({@code null} and fractions, however, should
     *               be avoided).
     */
    public JSONRPC2Request(final String method, final Object id) {

        setMethod(method);
        setID(id);
    }


    /**
     * Constructs a new JSON-RPC 2.0 request with positional (JSON array)
     * parameters.
     *
     * @param method           The name of the requested method. Must not
     *                         be {@code null}.
     * @param positionalParams The positional (JSON array) parameters,
     *                         {@code null} if none.
     * @param id               The request identifier echoed back to the
     *                         caller. The value must <a href="#map">map</a>
     *                         to a JSON scalar ({@code null} and
     *                         fractions, however, should be avoided).
     */
    public JSONRPC2Request(final String method,
                           final List<Object> positionalParams,
                           final Object id) {

        setMethod(method);
        setPositionalParams(positionalParams);
        setID(id);
    }


    /**
     * Constructs a new JSON-RPC 2.0 request with named (JSON object)
     * parameters.
     *
     * @param method      The name of the requested method.
     * @param namedParams The named (JSON object) parameters, {@code null}
     *                    if none.
     * @param id          The request identifier echoed back to the caller.
     *                    The value must <a href="#map">map</a> to a JSON
     *                    scalar ({@code null} and fractions, however,
     *                    should be avoided).
     */
    public JSONRPC2Request(final String method,
                           final Map<String, Object> namedParams,
                           final Object id) {

        setMethod(method);
        setNamedParams(namedParams);
        setID(id);
    }


    /**
     * Gets the name of the requested method.
     *
     * @return The method name.
     */
    public String getMethod() {

        return method;
    }


    /**
     * Sets the name of the requested method.
     *
     * @param method The method name. Must not be {@code null}.
     */
    public void setMethod(final String method) {

        // The method name is mandatory
        if (method == null)
            throw new IllegalArgumentException("The method name must not be null");

        this.method = method;
    }


    /**
     * Gets the parameters type ({@link JSONRPC2ParamsType#ARRAY positional},
     * {@link JSONRPC2ParamsType#OBJECT named} or
     * {@link JSONRPC2ParamsType#NO_PARAMS none}).
     *
     * @return The parameters type.
     */
    public JSONRPC2ParamsType getParamsType() {

        if (positionalParams == null && namedParams == null)
            return JSONRPC2ParamsType.NO_PARAMS;

        if (positionalParams != null)
            return JSONRPC2ParamsType.ARRAY;

        if (namedParams != null)
            return JSONRPC2ParamsType.OBJECT;

        else
            return JSONRPC2ParamsType.NO_PARAMS;
    }


    /**
     * Gets the request parameters.
     *
     * <p>This method was deprecated in version 1.30. Use
     * {@link #getPositionalParams} or {@link #getNamedParams} instead.
     *
     * @return The parameters as {@code List&lt;Object&gt;} for positional
     * (JSON array), {@code Map&lt;String,Object&gt;} for named
     * (JSON object), or {@code null} if none.
     */
    //@Deprecated
    public Object getParams() {

        switch (getParamsType()) {

            case ARRAY:
                return positionalParams;

            case OBJECT:
                return namedParams;

            default:
                return null;
        }
    }

    /**
     * Sets the request parameters.
     *
     * <p>This method was deprecated in version 1.30. Use
     * {@link #setPositionalParams} or {@link #setNamedParams} instead.
     *
     * @param params The parameters. For positional (JSON array) pass a
     *               {@code List&lt;Object&gt;}. For named (JSON object)
     *               pass a {@code Map&lt;String,Object&gt;}. If there are
     *               no parameters pass {@code null}.
     */
    @Deprecated
    @SuppressWarnings("unchecked")
    public void setParams(final Object params) {

        if (params == null) {
            positionalParams = null;
            namedParams = null;
        } else if (params instanceof List) {
            positionalParams = (List<Object>) params;
        } else if (params instanceof Map) {
            namedParams = (Map<String, Object>) params;
        } else {
            throw new IllegalArgumentException("The request parameters must be of type List, Map or null");
        }
    }

    /**
     * Gets the positional (JSON array) parameters.
     *
     * @return The positional (JSON array) parameters, {@code null} if none
     * or named.
     * @since 1.30
     */
    public List<Object> getPositionalParams() {

        return positionalParams;
    }

    /**
     * Sets the positional (JSON array) request parameters.
     *
     * @param positionalParams The positional (JSON array) request
     *                         parameters, {@code null} if none.
     * @since 1.30
     */
    public void setPositionalParams(final List<Object> positionalParams) {

        if (positionalParams == null)
            return;

        this.positionalParams = positionalParams;
    }

    /**
     * Gets the named parameters.
     *
     * @return The named (JSON object) parameters, {@code null} if none or
     * positional.
     * @since 1.30
     */
    public Map<String, Object> getNamedParams() {

        return namedParams;
    }

    /**
     * Sets the named (JSON object) request parameters.
     *
     * @param namedParams The named (JSON object) request parameters,
     *                    {@code null} if none.
     * @since 1.30
     */
    public void setNamedParams(final Map<String, Object> namedParams) {

        if (namedParams == null)
            return;

        this.namedParams = namedParams;
    }


    /**
     * Gets the request identifier.
     *
     * @return The request identifier ({@code Number}, {@code Boolean},
     * {@code String}) or {@code null}.
     */
    public Object getID() {

        return id;
    }


    /**
     * Sets the request identifier (ID).
     *
     * @param id The request identifier echoed back to the caller.
     *           The value must <a href="#map">map</a> to a JSON
     *           scalar ({@code null} and fractions, however, should
     *           be avoided).
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

    @Override
    public String toString() {
        return "JSONRPC2Request{" +
                "method='" + method + '\'' +
                ", params=" + getParams() +
                ", id=" + id +
                '}';
    }
}
