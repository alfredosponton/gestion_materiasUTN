package PbaTP2;

import java.util.*;

public class Materia {

    private String idMateria;
    private String nombreMateria;
    List<Alumno> alumnos = new ArrayList<Alumno>();
    List<Asistencia> asistencias = new ArrayList<Asistencia>();

    public Materia() {
        this.idMateria = " ";
        this.nombreMateria = " ";
    }

    public Materia(String idMateria, String nombreMateria) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
    }

    public String getIdMateria() {
        return this.idMateria;
    }

    public void setIdentificador(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return this.nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public List<Alumno> getAlumnos() {
        return this.alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Asistencia> getAsistencias() {
        return this.asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public void matricularUnAlumno(Alumno a) {
        this.alumnos.add(a);
        OrdenarAlumnos();
        System.out.println("\n*ALUMNO MATRICULADO*");
    }

    public boolean nroLegajoExite(int nroLegajo) {
        boolean resultado = false;
        for (int i = 0; i < this.cantAlumnosInscriptos(); i++) {
            if (this.getAlumnos().get(i).getNumeroLegajo() == nroLegajo) {
                resultado = true;
            }
        }
        return resultado;
    }

    public void desmatricularUnAlumno(int numLegajo) {
        for (int i = 0; i < this.cantAlumnosInscriptos(); i++) {
            if (this.getAlumnos().get(i).getNumeroLegajo() == numLegajo) {
                this.alumnos.remove(this.getAlumnos().get(i));
                System.out.println("\n*ALUMNO DESMATRICULADO*");
            }
        }
    }

    public int cantAlumnosInscriptos() {
        return this.alumnos.size();
    }

    private void OrdenarAlumnos() {
        this.alumnos.sort(null);
    }

    public void listaDeAsistencias(Asistencia a) {
        this.asistencias.add(a);
        System.out.println("\n*LISTA GUARDADA*");
    }

    public int cantListasAsistencias() {
        return this.asistencias.size();
    }
    
    public boolean fechaRepetida (String fecha){
        boolean salida = false;
        for(int i=0; i<this.cantListasAsistencias(); i++){
            if(this.getAsistencias().get(i).getunaFecha().equals(fecha)){
                salida = true;
            }
        }
        return salida;
    }

}
