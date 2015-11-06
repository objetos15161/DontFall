import greenfoot.*;

/**
 * Write a description of class Moneda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moneda extends Bonificacion
{
   
    /**
     * Act - do whatever the Moneda wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        genera();
       
   }   
    
    public void Moneda()
    {
   
    }
    public void genera()//genera monedas y las pone en el mundo depe
    {
    int y=getY();
   move(-1);
   
   if(getX()==0)
   {
     DontWorld mundo=(DontWorld)getWorld();
     mundo.generaMoneda();
     
     
       
     //aqui pongo otra boificacion diferete o un enemigo  
  //  se le da un mensaje al mundo para que cree un nuevo tipo de bonificacion 
   
    }
    
}
   
    
    
    }
    
    
    

