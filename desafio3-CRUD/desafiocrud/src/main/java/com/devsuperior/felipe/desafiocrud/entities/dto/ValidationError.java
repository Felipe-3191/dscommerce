package com.devsuperior.felipe.desafiocrud.entities.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationError extends CustomError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant moment, Integer status, String message, String path) {
        super(moment, status, message, path);
    }

    public List<FieldMessage> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public void addError(String field, String message) {
        errors.add(new FieldMessage(field, message));
    }

}
