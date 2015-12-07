import greenfoot.*;

/**
 * Esta es una subClase de actor que maneja los tipos de enemigos del juego 
 * 
 * @author (Claudio Daniel Espinosa Guzman) 
 * @version (a version number or a date)
 */
public class Enemigo extends Actor
{
   private int vel;
    public void act() 
    {
         
    }    
    public Enemigo()
    { 
        
    }
    /**
     * El metodo mueve los objetos a una velocidad 
     * la cual se obtiene mediante el metodo
     * getVel() del mundo
     */
   public void muevete()
   {
     DontWorld mundo=(DontWorld)getWorld();
     vel=mundo.getVel();
    move(vel);
    }
   
    
}
