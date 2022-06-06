package com.example.inmobiliarianovara.modelo;

public class Garante
{
    private int idGarante;
    private String nombreGarante;
    private String dni;
    private String direccion;
    private String correo;
    private String telefonoGarante;

    public int getIdGarante() {
        return idGarante;
    }

    public void setIdGarante(int idGarante) {
        this.idGarante = idGarante;
    }

    public String getNombreGarante() {
        return nombreGarante;
    }

    public void setNombreGarante(String nombreGarante) {
        this.nombreGarante = nombreGarante;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefonoGarante() {
        return telefonoGarante;
    }

    public void setTelefonoGarante(String telefonoGarante) {
        this.telefonoGarante = telefonoGarante;
    }

    public Garante(int idGarante, String nombreGarante, String dni, String direccion, String correo, String telefonoGarante) {
        this.idGarante = idGarante;
        this.nombreGarante = nombreGarante;
        this.dni = dni;
        this.direccion = direccion;
        this.correo = correo;
        this.telefonoGarante = telefonoGarante;
    }


}
