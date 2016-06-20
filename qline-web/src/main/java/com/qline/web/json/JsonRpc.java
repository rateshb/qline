package com.qline.web.json;

import java.io.Serializable;

/**
 * A JSO-RPC 1.1 Specification response object as outlined at
 * http://json-rpc.org/wd/JSON-RPC-1-1-WD-20060807.html
 * <pre>
 * Example:
 * {
 *         version: "1.1",
 *         id: null,
 *         result: "OK",
 *         error: null
 * }
 * </pre>
 */
public class JsonRpc<T> implements Serializable {

    private static final long serialVersionUID = -3319587787851102146L;

    public static final String DEFAULT_VERSION = "1.1";

    private String id;
    private String version = DEFAULT_VERSION;
    private T result;
    private JsonRpcError error;

    /**
     * Default constructor
     */
    public JsonRpc() {
    }

    /**
     * Overloaded constructor sets the result object 
     *
     * @param result
     */
    public JsonRpc(T result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public JsonRpcError getError() {
        return error;
    }

    public void setError(JsonRpcError error) {
        this.error = error;
    }

    public boolean getSuccess() {
        return this.error == null;
    }
}
