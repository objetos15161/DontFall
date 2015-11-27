import greenfoot.*;

/**
 * Write a description of class Bestia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bestia extends Enemigo
{
    private GifImage bestia= new GifImage("Blanka 7.gif");

    private int vel;
    /**
     * Act - do whatever the Bestia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
      
     
       move(2);
       setImage(bestia.getCurrentImage());
        checaLimite();
        //  mueve();
       
        
            }    
      public void checaLimite()
    {
        if(getX()==getWorld().getWidth()-40)
        {
         DontWorld mundo= (DontWorld)getWorld();
         mundo.generaBonif();
    //     mundo.generaBestia();
         getWorld().removeObject(this);
        }   
   
    }
   public void mueve()
        {
     DontWorld mundo=(DontWorld)getWorld();
     vel=mundo.getVel();
     vel=-vel;
       move(vel);
        }
        
                                        
    
}
