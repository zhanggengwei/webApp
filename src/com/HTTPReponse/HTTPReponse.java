package com.HTTPReponse;

/**
 * Created by vd on 2017/7/30.
 */
public class HTTPReponse {

    private int code;
    private String message;
    private Object obj;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
