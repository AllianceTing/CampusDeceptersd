package com.Customer.Exception;


public class RespRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String id;

    public RespRuntimeException(String id, String message) {
        super(message);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
