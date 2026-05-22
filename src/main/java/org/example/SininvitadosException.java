package org.example;

/**
 * Excepción lanzada cuando se intenta las invitaciones estan vacias
 */
public class SininvitadosException extends RuntimeException {
    /**
     * Construye la excepción con un mensaje de error
     * @param mensaje Texto que describe la causa del fallo
     */
    public SininvitadosException(String mensaje) {
        super(mensaje);
    }
}
