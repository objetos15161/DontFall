import greenfoot.*;

/**
 * Write a description of class Marcianos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Marciano extends Enemigo
{
    private GifImage marciano = new GifImage("Takuma.gif");
    
    
    /**
     * Act - do whatever the Marcianos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(marciano.getCurrentImage());  
        checaLimite();
      move(-2);
    } 
     public void checaLimite()
    {
        if(getX()==0)
        {
         DontWorld mundo= (DontWorld)getWorld();
         mundo.generaMarciano();
         getWorld().removeObject(this);
        }                                                       
    }
      public void checkHit()
    {
     boolean hitByGal=isTouching(Gal.class);
     if(hitByGal)
     {
       DontWorld mundo = (DontWorld)getWorld();
       mundo.generaMarciano();
       getWorld().removeObject(this);
        }
     
    }
}
