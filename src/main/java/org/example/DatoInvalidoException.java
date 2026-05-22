package org.example;

/**
 * Excepción lanzada cuando se intenta al registrar un empleado uno de los datos es incorrecto
 */
public class DatoInvalidoException extends RuntimeException {
    /**
     * Construye la excepción con un mensaje de error
     * @param mensaje Texto que describe la causa del fallo
     */
    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
