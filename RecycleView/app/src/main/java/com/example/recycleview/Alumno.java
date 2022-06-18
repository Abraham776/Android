package com.example.recycleview;
import java.util.ArrayList;

public class Alumno {
    private String carrera, nombre, matricula;
    private int img;

    public Alumno(String carrera, String nombre, String matricula, int img) {
        this.carrera = carrera;
        this.nombre = nombre;
        this.matricula = matricula;
        this.img = img;
    }

    public Alumno() {
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public static ArrayList<Alumno> llenarAlumnos(){
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String carrera = "Ing. Tec. Informacion";

        alumnos.add(new Alumno(carrera, "JOKER FROM SUPER SMASH BROS ULTIMATE", "2019030365", R.drawable.a0));
        alumnos.add(new Alumno(carrera, "José Abraham Sánchez Plazola", "2019000000", R.drawable.a1));
        alumnos.add(new Alumno(carrera, "NESS FROM UNDERTALE", "20190303687", R.drawable.a2));
        alumnos.add(new Alumno(carrera, "El RM", "2004000001", R.drawable.a3));
        alumnos.add(new Alumno(carrera, "Diego Preciado Rodriguez", "2019489712", R.drawable.a4));
        alumnos.add(new Alumno(carrera, "SUPER SMASH BROS x DEAD OR ALIVE 5", "202400001", R.drawable.a5));

        return alumnos;
    }
}
