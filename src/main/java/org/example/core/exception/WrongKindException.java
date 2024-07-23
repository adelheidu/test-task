package org.example.core.exception;

public class WrongKindException extends RuntimeException{
    public WrongKindException(String message){
        super(message);
    }
}
