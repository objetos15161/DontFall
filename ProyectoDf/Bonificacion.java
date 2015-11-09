import greenfoot.*;

/**
 * Write a description of class Bonificacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bonificacion extends Actor
{
    private int vel=-1;
    /**
     * Act - do whatever the Bonificacion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public void aumentaVel()
    {
    vel=vel+1;
    }
     public void genera()
    {
        
    move(vel);
    if(getX()==0)
    {
    DontWorld mundo =(DontWorld)getWorld();
    mundo.generaBonif();
    getWorld().removeObject(this);
    
    }
    
    
    }
}
