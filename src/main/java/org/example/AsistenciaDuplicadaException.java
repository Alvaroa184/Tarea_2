package org.example;

/**
 * Excepción lanzada cuando se intenta la asistencia de un invitado que ya esta registrado
 */
public class AsistenciaDuplicadaException extends RuntimeException {
    /**
     * Construye la excepción con un mensaje de error
     * @param mensaje Texto que describe la causa del fallo
     */
    public AsistenciaDuplicadaException(String mensaje) {
        super(mensaje);
    }
}
