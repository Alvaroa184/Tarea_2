package org.example;

/**
 * Excepción lanzada cuando se intenta invitar a una persona que ya esta invitada
 */
public class InvitacionDuplicadaException extends RuntimeException {
    /**
     * Construye la excepción con un mensaje de error
     * @param mensaje Texto que describe la causa del fallo
     */
    public InvitacionDuplicadaException(String mensaje) {
        super(mensaje);
    }
}
