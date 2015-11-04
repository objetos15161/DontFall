import greenfoot.*;

/**
 * Write a description of class Tronco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tronco extends Actor
{
    private int WtamX=650,WtamY=600;//TAMAÑO DEL MUNDO EN X y Y
    /**
     * Act - do whatever the Tronco wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        muevete();
        checaLimite();
    }    

    public void muevete()
    {
        move(-2);
    }

    public void checaLimite()
    {
        if(getX()==0)
        {
            Tronco unTronco= new Tronco();
            Tronco unTronco2= new Tronco();
            getWorld().addObject(unTronco,WtamX,(WtamY-85));//agregar el nuevo tronco en el filo del mundo (derecha)
            getWorld().addObject(unTronco2,WtamX,85);
            getWorld().removeObject(this);
        }                                                       
    }
}
