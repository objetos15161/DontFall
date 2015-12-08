import greenfoot.*;

/**
 * 
 * @author (Claudio Daniel Espinosa Guzman) 
 * @version (Semestre 2015-2016/I)
 */
public class Bonificacion extends Actor
{
    private int vel;
    /**
     * El constructor de la clase Bonificacion
     */
    public Bonificacion()
    {
    
    }
    /**
     * El metodo act genera un tipo de Bonificacion 
     */
    public void act() 
    {
       genera();
    }    
   /**
     *  En este metodo cada que un objeto de la clase Bonificacion esta en 
     *  x=0 se elimina del mundo y genera otro del lado contrario del mundo.
     *  
     */
     public void genera()
    {
    DontWorld mundo= (DontWorld)getWorld();    
    vel=mundo.getVel();   
    move(vel);
    if(getX()==0)
    {
    
    mundo.generaBonif();
    getWorld().removeObject(this);
    
    }
    
    
    }
}
