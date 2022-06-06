package com.example.inmobiliarianovara.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Contrato implements Serializable {

    private int idContrato;
    private String fechaInicio;
    private String fechaFinal;
    private double montoAlquiler;
    private Inquilino inquilino;
    private Inmueble inmueble;
    private Garante garante;

    public Contrato(int idContrato, String fechaInicio, String fechaFin, double montoAlquiler, Inquilino inquilino, Inmueble inmueble,Garante garante) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFin;
        this.montoAlquiler = montoAlquiler;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
        this.garante = garante;
    }

    public Contrato(int idContrato, String fechaInicio, String fechaFin, double montoAlquiler, Inquilino inquilino, Inmueble inmueble) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFin;
        this.montoAlquiler = montoAlquiler;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }

    public Contrato() {

    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFin) {
        this.fechaFinal = fechaFinal;
    }

    public double getMontoAlquiler() {
        return montoAlquiler;
    }

    public void setMontoAlquiler(double montoAlquiler) {
        this.montoAlquiler = montoAlquiler;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Garante getGarante() { return garante; }

    public void setGarante(Garante garante) { this.garante = garante; }

    public String getFechaInicioCorta()
    {
        String año = getFechaInicio().substring(0,4);
        String mes = getFechaInicio().substring(5,7);
        String dia = getFechaInicio().substring(8,10);
        return dia +"/"+mes+"/"+año;
    }

    public String getFechaFinalCorta()
    {
        String año = getFechaFinal().substring(0,4);
        String mes = getFechaFinal().substring(5,7);
        String dia = getFechaFinal().substring(8,10);
        return dia +"/"+mes+"/"+año;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return idContrato == contrato.idContrato;
    }


    @Override
    public int hashCode() {
        return Objects.hash(idContrato);
    }
}
