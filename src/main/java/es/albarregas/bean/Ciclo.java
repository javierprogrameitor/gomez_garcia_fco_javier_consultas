
package es.albarregas.bean;

import java.io.Serializable;

/**
 *
 * @author javier
 */
public class Ciclo implements Serializable{
    
    private String idCiclo;
    private String abreviatura;
    private int horasFCT;
    private String ley;
    private String nombre;

    public String getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public int getHorasFCT() {
        return horasFCT;
    }

    public void setHorasFCT(int horasFCT) {
        this.horasFCT = horasFCT;
    }

    public String getLey() {
        return ley;
    }

    public void setLey(String ley) {
        this.ley = ley;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
