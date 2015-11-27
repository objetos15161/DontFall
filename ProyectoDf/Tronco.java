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
    private int vel,x,y;
    private DontWorld mundo;
    
    /**
     * Act - do whatever the Troncos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    
    }    
    public Tronco()
    {
    
    
    }
  
   /* public void aumentaVel()
    {
        DontWorld mundo = (DontWorld)getWorld();
        if(mundo.getGal().getHitByApple())
       {
    vel=vel-1;
       }
    }
    public void disminuyeVel()
    {
    DontWorld mundo = (DontWorld)getWorld();
        if(mundo.getGal().getHitByAppleGus())
       {
    vel=vel+1;
       }
    }
    */
    public void muevete()
    { 
        DontWorld mundo=(DontWorld)getWorld();
        vel=mundo.getVel();
        this.removeTouching(Marciano.class);
        x=getX();
        y=getY();
        
       setLocation(x+vel,y);
    
    }
    
    public void checaLimite()
    {
        
        if(getX()==0)
        {
         DontWorld mundo= (DontWorld)getWorld();
         mundo.generaTroncos();
         mundo.generaBonif();
         getWorld().removeObject(this);
        }                                                       
    }
}
