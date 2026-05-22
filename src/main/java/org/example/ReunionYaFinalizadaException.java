package org.example;

/**
 * Excepción lanzada cuando se intenta finalizar una reunion que ya se finalizo
 */
public class ReunionYaFinalizadaException extends RuntimeException {
    /**
     * Construye la excepción con un mensaje de error
     * @param mensaje Texto que describe la causa del fallo
     */
    public ReunionYaFinalizadaException(String mensaje) {
        super(mensaje);
    }
}
