import greenfoot.*;

/**
 * Write a description of class Troncos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Troncos extends Actor
{
    private int WtamX=650,WtamY=600;//TAMAÑO DEL MUNDO EN X y Y
    private int vel=-2;
    /**
     * Act - do whatever the Troncos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
    }    
    public void aumentaVel()
    {
    vel=vel+1;
    }

    public void muevete()
    {
        move(vel);
    }
    
    public void checaLimite()
    {
        if(getX()==0)
        {
         DontWorld mundo= (DontWorld)getWorld();
         mundo.generaTroncos();
         getWorld().removeObject(this);
        }                                                       
    }
}
