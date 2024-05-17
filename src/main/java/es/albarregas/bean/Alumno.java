
package es.albarregas.bean;

import java.io.Serializable;

/**
 *
 * @author javier
 */
public class Alumno implements Serializable{
      
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String genero;
    private int idUsuario;
    private String ciclo;
    private int numAlumnosMatriculados;
    private int edad;
    private int edadMaxima;
    private int edadMinima;
    private int edadMedia;
    private int sumaEdades;
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getNumAlumnosMatriculados() {
        return numAlumnosMatriculados;
    }

    public void setNumAlumnosMatriculados(int numAlumnosMatriculados) {
        this.numAlumnosMatriculados = numAlumnosMatriculados;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(int edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public int getEdadMedia() {
        return edadMedia;
    }

    public void setEdadMedia(int edadMedia) {
        this.edadMedia = edadMedia;
    }

    public int getSumaEdades() {
        return sumaEdades;
    }

    public void setSumaEdades(int sumaEdades) {
        this.sumaEdades = sumaEdades;
    }
    
    
    
    
}
