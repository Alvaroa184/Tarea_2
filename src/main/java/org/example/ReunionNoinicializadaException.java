package org.example;

/**
 * Excepción lanzada cuando se intenta calcular el tiempo real de duracion antes de que empiece la reunion
 */
public class ReunionNoinicializadaException extends RuntimeException {
    /**
     * Construye la excepción con un mensaje de error
     * @param mensaje Texto que describe la causa del fallo
     */
    public ReunionNoinicializadaException(String mensaje) {
        super(mensaje);
    }
}
