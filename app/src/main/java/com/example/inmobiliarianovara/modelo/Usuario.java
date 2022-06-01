package com.example.inmobiliarianovara.modelo;

public class Usuario
{
    public String getClave() {
        return Clave;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    private String Clave,Usuario;

    public Usuario(String usuario ,String clave) {

        Usuario = usuario;
        Clave = clave;
    }
}
