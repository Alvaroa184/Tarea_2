package org.example;

/**
 * Excepción lanzada cuando se intenta que una persona que no esta invitada entre a la reunion
 */
public class InvitadoNoinvitadoException extends RuntimeException {
    /**
     * Construye la excepción con un mensaje de error
     * @param mensaje Texto que describe la causa del fallo
     */
    public InvitadoNoinvitadoException(String mensaje) {
        super(mensaje);
    }
}
