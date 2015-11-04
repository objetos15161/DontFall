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
   
    int x=Greenfoot.getRandomNumber(600);
    int y=getY();
   move(-1);
   if(getX()==0)
   {
      Manzana man1= new Manzana();
       getWorld().addObject(man1, 650, 250);
       getWorld().removeObject(this);
       
     //aqui pongo otra boificacion diferete o un enemigo  
  //  setLocation(x, y);
    
    }
    
    }
    
}
