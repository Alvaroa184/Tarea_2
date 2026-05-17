package org.example;

public enum TipoReunion {
    TECNICA("Técnica"),
    MARKETING("Marketing"),
    OTRO("Otro");

    private final String Tipo;

    TipoReunion(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getTipo() {
        return Tipo;
    }
}
