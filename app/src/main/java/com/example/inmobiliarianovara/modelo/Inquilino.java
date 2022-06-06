package com.example.inmobiliarianovara.modelo;

import java.io.Serializable;

public class Inquilino implements Serializable {

    private int id;
    private String DNI;
    private String nombre;
    private String lugarTrabajo;
    private String email;
    private String telefono;
    private String nombreGarante;
    private String telefonoGarante;

    public Inquilino(int idInquilino, String DNI, String nombre, String lugarTrabajo, String email, String telefono) {
        this.id = idInquilino;
        this.DNI = DNI;
        this.nombre = nombre;
        this.lugarTrabajo = lugarTrabajo;
        this.email = email;
        this.telefono = telefono;
    }

    public Inquilino(int idInquilino, String DNI, String nombre, String lugarTrabajo, String email, String telefono, String nombreGarante, String telefonoGarante) {
        this.id = idInquilino;
        this.DNI = DNI;
        this.nombre = nombre;
        this.lugarTrabajo = lugarTrabajo;
        this.email = email;
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
