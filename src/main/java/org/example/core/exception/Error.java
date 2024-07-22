package org.example.core.exception;

import lombok.Value;

@Value
public class Error {
    String message;
    public Error(String message){
        this.message = message;
    }
}
