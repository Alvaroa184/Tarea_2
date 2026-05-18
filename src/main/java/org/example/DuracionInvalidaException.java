package org.example;

public class DuracionInvalidaException extends RuntimeException {
    public DuracionInvalidaException(String mensaje) {
        super(mensaje);
    }
}
