package org.example;

/**
 * Excepción lanzada cuando se intenta calcular el tiempo real de duracion antes de que termine la reunion
 */
public class ReunionNoFinalizadaException extends RuntimeException {
    /**
     * Construye la excepción con un mensaje de error
     * @param mensaje Texto que describe la causa del fallo
     */
    public ReunionNoFinalizadaException(String mensaje) {
        super(mensaje);
    }
}
