package com.rest.ppr.ws.validarPeriodos.model;

public class RespuestaError {
    private int numError;
    private String msjError;
    
    public RespuestaError(int numError, String msjError) {
        super();
        this.numError = numError;
        this.msjError = msjError;
    }
    
    public int getNumError() {
        return numError;
    }
    public void setNumError(int numError) {
        this.numError = numError;
    }
    public String getMsjError() {
        return msjError;
    }
    public void setMsjError(String msjError) {
        this.msjError = msjError;
    }
}
