package com.example.parcial2;

public class Usuario {

    String nombre;
    String cedula;
    String estrato;
    String salario;
    String educacion;

    public Usuario(String nombre, String cedula, String estrato, String salario, String educacion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.estrato = estrato;
        this.salario = salario;
        this.educacion = educacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getEducacion() {
        return educacion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", estrato='" + estrato + '\'' +
                ", salario='" + salario + '\'' +
                ", educacion='" + educacion + '\'' +
                '}';
    }
}
