package com.devsuperior.felipe.desafiocrud.entities.dto;

import java.time.Instant;

public class CustomError {

    private Instant moment;
    private Integer status;
    private String message;
    private String path;

    public CustomError(Instant moment, Integer status, String message, String path) {
        this.moment = moment;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public Instant getMoment() {
        return moment;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
