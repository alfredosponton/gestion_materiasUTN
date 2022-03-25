package PbaTP2;

import java.util.*;

public class Asistencia {

    private String unaFecha;
    List<Alumno> alumnos = new ArrayList<Alumno>();

    public Asistencia() {
        this.unaFecha = " ";
    }

    public Asistencia(String unaFecha) {
        this.unaFecha = unaFecha;
    }

    public String getunaFecha() {
        return this.unaFecha;
    }

    public void setFechaActual(String unaFecha) {
        this.unaFecha = unaFecha;
    }

    public List<Alumno> getAlumnos() {
        return this.alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void registrarAsistencia(Alumno a) {
        this.alumnos.add(a);
        System.out.println("\n*ALUMNO PRESENTE*\n");
    }

    public int cantAlumnosAnotados() {
        return this.alumnos.size();
    }

}
