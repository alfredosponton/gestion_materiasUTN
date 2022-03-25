package PbaTP2;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        String idMateria=" ", nombreMateria = new String ();
        while (salir != true) {
            System.out.println("\n" + "MENÚ INICIO");
            System.out.println("==========================");
            System.out.println("1.-  Registrar  Materia" + "\n");
            System.out.println("9.-  Salir" + "\n");
            System.out.print("Ingrese una opción: ");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Id Materia (3 Siglas): ");
                    leer.nextLine();
                    while(idMateria.length()!=3){
                        idMateria = leer.nextLine();
                        if(idMateria.length()!=3){
                            System.out.print("Vuelva a ingresar Id Materia: ");
                        }
                    }
                    System.out.print("Nombre de la Materia: ");
                    nombreMateria = leer.nextLine();
                    gestionarMateria(new Materia(idMateria, nombreMateria));
                    break;
                case 9:
                    System.out.println("Salir.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta !");
            }
        }
    }

    public static void gestionarMateria(Materia unaMateria) {
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        int numeroLegajo;
        String apellido, nombre, fechaNacimiento, email, unaFecha = new String();
        while (salir != true) {
            System.out.println("\n" + "GESTIONAR MATERIA");
            System.out.println("==========================");
            System.out.println("1.-  Matricular  Alumno");
            System.out.println("2.-  Desmatricular Alumno");
            System.out.println("3.-  Gestionar  Asistencia");
            System.out.println(" -- Consultas");
            System.out.println("    4.-  Listado  de  Inscriptos");
            System.out.println("    5.-  Visualizar  Asistencia");
            System.out.println("\n" + "9.-  Salir" + "\n");
            System.out.print("Ingrese  una  opción: ");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Numero de Legajo: ");
                    numeroLegajo = leer.nextInt();
                    while (unaMateria.nroLegajoExite(numeroLegajo) == true) {
                        System.out.print("Ingresa otro Numero de Legajo: ");
                        numeroLegajo = leer.nextInt();
                    }
                    System.out.print("Apellido: ");
                    leer.nextLine();
                    apellido = leer.nextLine();
                    System.out.print("Nombre: ");
                    nombre = leer.nextLine();
                    System.out.print("Fecha de nacimiento(DD/MM/AAAA): ");
                    fechaNacimiento = leer.nextLine();
                    while(validarFecha(fechaNacimiento)==false){
                        System.out.print("Ingresa una Nueva Fecha de nacimiento(DD/MM/AAAA): ");
                        fechaNacimiento = leer.nextLine();
                    }
                    System.out.print("E-mail: ");
                    email = leer.nextLine();
                    unaMateria.matricularUnAlumno(new Alumno(numeroLegajo, apellido, nombre, fechaNacimiento, email));
                    break;
                case 2:
                    System.out.print("Numero de Legajo: ");
                    numeroLegajo = leer.nextInt();
                    unaMateria.desmatricularUnAlumno(numeroLegajo);
                    break;
                case 3:
                    System.out.print("Ingrese una Fecha(DD/MM/AAAA): ");
                    leer.nextLine();
                    unaFecha = leer.nextLine();
                    while((unaMateria.fechaRepetida(unaFecha)==true) || (validarFecha(unaFecha)==false)){
                        System.out.print("Ingrese una Nueva Fecha(DD/MM/AAAA): ");
                        unaFecha = leer.nextLine();
                    }
                    listaDeAsistencia(unaMateria, new Asistencia(unaFecha));
                    break;
                case 4:
                    mostrarListaDeInscriptos(unaMateria);
                    break;
                case 5:
                    System.out.print("Ingrese una Fecha(DD/MM/AAAA): ");
                    leer.nextLine();
                    unaFecha = leer.nextLine();
                    while(unaMateria.fechaRepetida(unaFecha)==false){
                        System.out.print("La Fecha No Existe-Ingrese una Nueva Fecha(DD/MM/AAAA): ");
                        unaFecha = leer.nextLine();
                    }
                    mostrarListaDeAsistencias(unaMateria, unaFecha);
                    break;
                case 9:
                    System.out.println("Salir.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta !");
            }
        }
    }

    public static void listaDeAsistencia(Materia unaMateria, Asistencia asistencias) {
        Scanner leer = new Scanner(System.in);
        boolean salida = false;
        String presente = new String();
        if(unaMateria.cantAlumnosInscriptos()!=0){
        for (int i = 0; i < unaMateria.cantAlumnosInscriptos(); i++) {
            System.out.println(unaMateria.getAlumnos().get(i));
            while (salida == false) {
                System.out.print("P:Presente/A:Ausente: ");
                presente = leer.nextLine();
                if (presente.toUpperCase().equals("P") || presente.toUpperCase().equals("PRESENTE")) {
                    asistencias.registrarAsistencia(unaMateria.getAlumnos().get(i));
                    salida = true;
                } else if (presente.toUpperCase().equals("A") || presente.toUpperCase().equals("AUSENTE")) {
                    System.out.println("\n*ALUMNO AUSENTE*\n");
                    salida = true;
                } else {
                    System.out.println("Opción no válida");
                    salida = false;
                }
            }
            salida=false;
        }
        unaMateria.listaDeAsistencias(asistencias);
        }
        else{
            System.out.println("NO EXISTE ALUMNOS REGISTRADOS PARA COMENZAR CON LA LISTA DE ASISTENCIAS");
        }
    }

    public static void mostrarListaDeInscriptos(Materia unaMateria) {
        boolean control = false;
        if (unaMateria.cantAlumnosInscriptos() != 0) {
            System.out.println("------------------------------------------------------------");
            System.out.println(unaMateria.getNombreMateria() + " - Alumnos Inscriptos 2021");
            System.out.println("------------------------------------------------------------");
            System.out.println("Legajo | Apellido, Nombres");
            System.out.println("------------------------------------------------------------");
            for (int i = 0; i < unaMateria.cantAlumnosInscriptos(); i++) {
                System.out.println(unaMateria.getAlumnos().get(i));
            }
            System.out.println("------------------------------------------------------------");
            System.out.println("Total inscriptos: " + unaMateria.cantAlumnosInscriptos());
            control = true;
        }
        if (control == false) {
            System.out.println("NO EXISTE UNA LISTA DE INSCRIPTOS PARA LA MATERIA: " + unaMateria.getNombreMateria());
        }
    }

    private static void mostrarListaDeAsistencias(Materia unaMateria, String unaFecha) {
        boolean control = false;
        if (unaMateria.cantListasAsistencias() != 0) {
            for (int i = 0; i < unaMateria.cantListasAsistencias(); i++) {
                if (unaMateria.getAsistencias().get(i).getunaFecha().equals(unaFecha)) {
                    System.out.println("------------------------------------------------------------");
                    System.out.println(unaMateria.getNombreMateria() + " - Asistencias: " + unaFecha);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Legajo | Apellido, Nombres");
                    System.out.println("------------------------------------------------------------");
                    for (int j = 0; j < unaMateria.getAsistencias().get(i).cantAlumnosAnotados(); j++) {
                        System.out.println(unaMateria.getAsistencias().get(i).getAlumnos().get(j));
                    }
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Total asistentes: " + unaMateria.getAsistencias().get(i).cantAlumnosAnotados());
                    System.out.println();
                    control = true;
                }
            }
        }
        if (control == false) {
            System.out.println("NO EXISTE LISTA DE ASISTENCIAS PARA LA FECHA: " + unaFecha);
        }
    }
    private static boolean validarFecha(String fecha) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;
        String date = fecha;
        boolean validarUno = false, validarDos = false;
        
        try {
            testDate = df.parse(date);
            //System.out.println("Ahora hemos creado un objeto date con la fecha indicada, " + testDate);
            validarUno = true; 
        } catch (Exception e) {
            //System.out.println("invalid format - Formato no valido");
        }
        
        if(validarUno == true){
            if (df.format(testDate).equals(date)) {
            //System.out.println("valid date - Fecha valida");
            validarDos=true;
            } else {
            //System.out.println("invalid date!! - Fecha no valida"); 
            }
        }
        return validarDos;
    }
}
