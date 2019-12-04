/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classVO;

/**
 *
 * @author JUAN MANUEL
 */
public class concesionarioVO {
    
    private Integer id_concesionario ;
    private String  direccion_concesionario;
    private String nombre_concesionario;
    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    

    public Integer getId_concesionario() {
        return id_concesionario;
    }

    public void setId_concesionario(Integer id_concesionario) {
        this.id_concesionario = id_concesionario;
    }

    public String getDireccion_concesionario() {
        return direccion_concesionario;
    }

    public void setDireccion_concesionario(String direccion_concesionario) {
        this.direccion_concesionario = direccion_concesionario;
    }

    public String getNombre_concesionario() {
        return nombre_concesionario;
    }

    public void setNombre_concesionario(String nombre_concesionario) {
        this.nombre_concesionario = nombre_concesionario;
    }

    @Override
    public String toString() {
        return  nombre_concesionario ;
    }
    
    
    
}
