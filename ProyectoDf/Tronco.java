import greenfoot.*;

/**
 * Write a description of class Troncos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tronco extends Actor
{
    private int WtamX=650,WtamY=600;//TAMAÑO DEL MUNDO EN X y Y
    private int vel=-2,x,y;
    private DontWorld mundo;
    
    /**
     * Act - do whatever the Troncos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    
    }    
  
    public void aumentaVel()
    {
        mundo=(DontWorld) getWorld();
if(mundo.getGal().getHitByApple()==true);
{
    vel=vel-1;
}        
    }
    
    public void muevete()
    { 
      
        x=getX();
        y=getY();
        
       setLocation(x+vel,y);
     // aumentaVel();
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
