package com.example.inmobiliarianovara.modelo;

import java.io.Serializable;

public class Inquilino implements Serializable {

    private int id;
    private String dni;
    private String nombre;
    private String lugarTrabajo;
    private String correo;
    private String telefono;
    private String nombreGarante;
    private String telefonoGarante;

    public Inquilino(int idInquilino, String dni, String nombre, String lugarTrabajo, String correo, String telefono) {
        this.id = idInquilino;
        this.dni = dni;
        this.nombre = nombre;
        this.lugarTrabajo = lugarTrabajo;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Inquilino(int idInquilino, String dni, String nombre, String lugarTrabajo, String correo, String telefono, String nombreGarante, String telefonoGarante) {
        this.id = idInquilino;
        this.dni = dni;
        this.nombre = nombre;
        this.lugarTrabajo = lugarTrabajo;
        this.correo = correo;
        this.telefono = telefono;
        this.nombreGarante = nombreGarante;
        this.telefonoGarante = telefonoGarante;
    }

    public int getIdInquilino() {
        return id;
    }

    public void setIdInquilino(int idInquilino) {
        this.id = idInquilino;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugarDeTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarDeTrabajo(String lugarDeTrabajo) {
        this.lugarTrabajo = lugarDeTrabajo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreGarante() {
        return nombreGarante;
    }

    public void setNombreGarante(String nombreGarante) {
        this.nombreGarante = nombreGarante;
    }

    public String getTelefonoGarante() {
        return telefonoGarante;
    }

    public void setTelefonoGarante(String telefonoGarante) {
        this.telefonoGarante = telefonoGarante;
    }
}
