package org.example;

/**
 * Excepción lanzada cuando se intenta crear una reunion con un tiempo de duracion menor a 0
 */
public class DuracionInvalidaException extends RuntimeException {
    /**
     * Construye la excepción con un mensaje de error
     * @param mensaje Texto que describe la causa del fallo
     */
    public DuracionInvalidaException(String mensaje) {
        super(mensaje);
    }
}
