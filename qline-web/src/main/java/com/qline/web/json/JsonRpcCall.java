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
 *         method: "methodName",
 *         params: null
 * }
 * </pre>
 */
public class JsonRpcCall<T> implements Serializable {

    private static final long serialVersionUID = -2701337566288725514L;

    public static final String DEFAULT_VERSION = "1.1";

    private String id;
    private String version = DEFAULT_VERSION;
    private String method;
    private T params;

    /**
     * Default constructor
     */
    public JsonRpcCall() {
    }

    /**
     * Overloaded constructor sets the params object
     *
     * @param params
     */
    public JsonRpcCall(T params) {
        this.params = params;
    }

    public JsonRpcCall(String method, T params) {
        this.method = method;
        this.params = params;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}
