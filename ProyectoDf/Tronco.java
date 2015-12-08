import greenfoot.*;

/**
 * La clase representa a un obstaculo Tronco en el mundo
 * 
 * @author (Claudio Daniel Espinosa Guzman) 
 * @version (Semestre 2015-2016/I)
 */
public class Tronco extends Actor
{
    private int WtamX=650,WtamY=600;//TAMAÑO DEL MUNDO EN X y Y
    private int vel,x,y;
    private DontWorld mundo;
    
    /**
     *El metodo act mueve el objeto y checa cuando toca en x=0
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
