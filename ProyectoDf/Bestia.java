import greenfoot.*;

/**
 * Write a description of class Bestia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bestia extends Enemigo
{
    private GifImage bestia= new GifImage("Blanka 7.gif");
    private int WtamX=650,WtamY=600;//TAMAÑO DEL MUNDO EN X y Y
    /**
     * Act - do whatever the Bestia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(bestia.getCurrentImage());
        move(-2);
        
    }    
     public void checaLimite()
    {
        if(getX()==0)
        {
            
         //  finalize();
        }                                                       
    }
}
