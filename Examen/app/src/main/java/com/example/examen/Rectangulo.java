package com.example.examen;

public class Rectangulo {
    private float base, altura;

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public Rectangulo() {
    }

    public float calcularArea(){
        return this.getAltura()*this.getBase();
    }
    public float calcularPerimetro(){
        return this.getAltura()*2 + this.getBase()*2;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
