package com.example.agenciaviajes;

public class Boleto {
    private int id, tipo;
    private String nombre, destino, fecha, fechaRegreso;
    private float precio;

    public Boleto(){
    }

    public Boleto(int id, int tipo, String nombre, String destino, String fecha, String fechaRegreso, float precio) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.destino = destino;
        this.fecha = fecha;
        this.fechaRegreso = fechaRegreso;
        this.precio = precio;
    }

    public Boleto(Boleto boleto) {
        this.id = boleto.id;
        this.tipo = boleto.tipo;
        this.nombre = boleto.nombre;
        this.destino = boleto.destino;
        this.fecha = boleto.fecha;
        this.precio = boleto.precio;
    }

    public float calcularPrecio() {
        if(this.getTipo() == 1)
            return this.getPrecio();

        return (float) (this.getPrecio() * 1.8);
    }

    public float calcularIVA() {
        return (float) (this.calcularPrecio() * 0.16);
    }

    public float calcularDescuento(int edad) {
        if(edad < 60)
            return 0;

        return (this.calcularPrecio() + this.calcularIVA()) / 2;
    }

    public float calcularTotal(int edad) {
        return this.calcularPrecio() + this.calcularIVA() - this.calcularDescuento(edad);
    }

    public void imprimirBoleto(int edad) {
        System.out.println("No. Boleto: " + this.getId() +
                "\nNombre cliente: " + this.getNombre() +
                "\nDestino: " + this.getDestino() +
                "\nTipo viaje: " + this.getTipo() +
                "\nPrecio: " + this.getPrecio() +
                "\nFecha: " + this.getFecha() +
                "\n ====================== Importe ====================== \n" +
                "Subtotal: " + this.calcularPrecio() +
                "Impuesto 16%: " + this.calcularIVA() +
                "Descuento: " + this.calcularDescuento(edad) +
                "Total a pagar: " + this.calcularTotal(edad));
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return this.tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}