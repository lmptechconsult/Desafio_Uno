package com.previred.periodos.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.previred.periodos.model.Periodo;

public class Respuesta {
    int code;
    String message;
    Periodo periodo;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String toString() {
        Respuesta resp = new Respuesta();
        resp.setCode(getCode());
        resp.setMessage(getMessage());
        resp.setPeriodo(getPeriodo());
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(resp);
        } catch (JsonProcessingException e) {
           
            resp.setMessage(e.getMessage());
        }
        return null;
    }

}
