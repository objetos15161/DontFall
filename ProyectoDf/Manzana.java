import greenfoot.*;

/**
 * Write a description of class Manzana here.
 * 
 * @author (Claudio Daniel Espinosa Guzman) 
 * @version (Semestre 2015-2016/I)
 */
public class Manzana extends Bonificacion
{
    private boolean hitByGal;
    /**
     * El metodo act manda llamar al metodo genera 
     * el cual hereda de la clase Bonificacion.
     */
    public void act() 
    {
        // Add your action code here.
       
       genera();
        
    }    
    
   
}
