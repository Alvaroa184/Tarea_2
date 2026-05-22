package org.example;

/**
 * Excepción lanzada cuando se intenta iniciar una reunion que ya fue iniciada
 */
public class ReunionYainiciadaException extends RuntimeException {
    /**
     * Construye la excepción con un mensaje de error
     * @param mensaje Texto que describe la causa del fallo
     */
    public ReunionYainiciadaException(String mensaje) {
        super(mensaje);
    }
}
