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
     *
     */
    public void act() 
    {
    muevete();
    checaLimite();
    }    
    public Tronco()
    {
    
    
    }
   /**
     *Este metodo mueve un objeto Tronco hacia la izquierda
     *para simular un scroll.
     */
    public void muevete()
    { 
        DontWorld mundo=(DontWorld)getWorld();
        vel=mundo.getVel();
       
        x=getX();
        y=getY();
        
       setLocation(x+vel,y);
    
    }
    /**
     *Este metodo checa si el objeto Tronco esta 
     *en x=0 del mundo.
     */
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
