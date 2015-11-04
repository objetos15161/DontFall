import greenfoot.*;

/**
 * Write a description of class Manzana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Manzana extends Bonificacion
{
    /**
     * Act - do whatever the Manzana wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        genera();
    }    
    
    public void genera()
    {
    move(-2);
    if(getX()==0)
    {
    Moneda mon1= new Moneda();
    getWorld().addObject(mon1,650,250);
    getWorld().removeObject(this);
    }
    
    
    }
}
