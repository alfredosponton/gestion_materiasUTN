package PbaTP2;

public class Alumno implements Comparable<Alumno> {

    private int numeroLegajo;
    private String apellido;
    private String nombre;
    private String fechaNacimiento;
    private String email;

    public Alumno() {
        this.numeroLegajo = 0;
        this.apellido = " ";
        this.apellido = " ";
        this.fechaNacimiento = " ";
        this.email = " ";
    }

    public Alumno(int numeroLegajo, String apellido, String nombre, String fechaNacimiento, String email) {
        this.numeroLegajo = numeroLegajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public int getNumeroLegajo() {
        return this.numeroLegajo;
    }

    public void setNumeroLegajo(int numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.getNumeroLegajo() + " | " + this.getApellido() + ", " + this.getNombre();
    }

    @Override
    public int compareTo(Alumno o) {
        int resultado = 0;
        int compararApellidos = this.getApellido().compareTo(o.getApellido());
        int compararNombres = this.getNombre().compareTo(o.getNombre());
        if (compararApellidos != 0) {
            resultado = compararApellidos;
        } else {
            resultado = compararNombres;
        }
        return resultado;
    }

}
