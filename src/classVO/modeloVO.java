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
public class modeloVO {
    
    
 private   Integer id_modelo;
  private  Integer id_marca;
  private  String caballos_fuerza;
   private  String nombre_modelo;
  private  String resultado;

    public String getNombre_modelo() {
        return nombre_modelo;
    }

    public void setNombre_modelo(String nombre_modelo) {
        this.nombre_modelo = nombre_modelo;
    }

  
  
  
    public Integer getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(Integer id_modelo) {
        this.id_modelo = id_modelo;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getCaballos_fuerza() {
        return caballos_fuerza;
    }

    public void setCaballos_fuerza(String caballos_fuerza) {
        this.caballos_fuerza = caballos_fuerza;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
    
    
    
}
