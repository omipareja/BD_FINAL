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
public class marcaVO {
    
    
    private Integer id_marca;
    private String nombre_marca;
    private Integer id_concesionario;
    private String resultado;

    
    
    public String getResultado() {
        return resultado;
    }

    
    
    
    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public Integer getId_concesionario() {
        return id_concesionario;
    }

    public void setId_concesionario(Integer id_concesionario) {
        this.id_concesionario = id_concesionario;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return nombre_marca ;
    }
    
    
    
    
}
