import greenfoot.*;

/**
 * Esta es una subClase de actor que maneja los tipos de enemigos del juego 
 * 
 * @author (your name) 
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
    
   public void muevete()
   {
     DontWorld mundo=(DontWorld)getWorld();
     vel=mundo.getVel();
    move(vel);
    }
   
    
}
