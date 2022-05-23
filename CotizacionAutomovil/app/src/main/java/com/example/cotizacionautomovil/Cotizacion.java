package com.example.cotizacionautomovil;

import java.io.Serializable;

public class Cotizacion implements Serializable {
    private int id, plazo;
    private String descripcion;
    private float precio, porcentaje_pago;

    public Cotizacion() {
    }

    public Cotizacion(int id, int plazo, String descripcion, float precio, float porcentaje_pago) {
        this.id = id;
        this.plazo = plazo;
        this.descripcion = descripcion;
        this.precio = precio;
        if(porcentaje_pago >= 1) {
            this.porcentaje_pago = porcentaje_pago/100;
        } else {
            this.porcentaje_pago = porcentaje_pago;
        }
    }

    public Cotizacion(Cotizacion cotizacion) {
        this.id = cotizacion.id;
        this.plazo = cotizacion.plazo;
        this.descripcion = cotizacion.descripcion;
        this.precio = cotizacion.precio;
        this.porcentaje_pago = cotizacion.porcentaje_pago;
    }

    public float calcularPagoInicial(){
        return this.getPrecio() * this.getPorcentaje_pago();
    }

    public float calcularTotal(){
        return this.getPrecio() - this.calcularPagoInicial();
    }

    public float calcularMensualidad(){
        return this.calcularTotal() / this.getPlazo();
    }

    public void imprimirCotizacion(){
        System.out.println("Número de cotización: " + this.getId() +
                "\nDescripción: " + this.getDescripcion() +
                "\nPrecio: " + this.getPrecio() +
                "\nPorcentaje Pago Inicial: " + this.getPorcentaje_pago() +
                "\nPlazo: " + this.getPlazo() +
                "\nPago Inicial: " + this.calcularPagoInicial() +
                "\nTotal a fin: " + this.calcularTotal() +
                "\nPago Mensual: " + this.calcularMensualidad());
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlazo() {
        return this.plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPorcentaje_pago() {
        return this.porcentaje_pago;
    }

    public void setPorcentaje_pago(float porcentaje_pago) {
        this.porcentaje_pago = porcentaje_pago;
    }

}