import greenfoot.*;

/**
 * Write a description of class Bonificacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bonificacion extends Actor
{
    private int vel;
    /**
     * Act - do whatever the Bonificacion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bonificacion()
    {
    
    }
    public void act() 
    {
        // Add your action code here.
    }    
   
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
