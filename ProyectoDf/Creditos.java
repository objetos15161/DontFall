import greenfoot.*;

/**
 * Write a description of class Creditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditos extends World
{
 private BRegresar2 regresar;
 public static final int XTAM=650;
 public static final int YTAM=600; 
    /**
     * Constructor for objects of class Creditos.
     * 
     */
    public Creditos()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       super(XTAM,YTAM, 1); 
        regresar= new BRegresar2();
        
        this.addObject(regresar,XTAM-140,YTAM-50);//se adiciona el boton en la parte inferior derecha de la pantalla 
    }
     public void act()
    {
    if(Greenfoot.getMouseInfo()!=null)
    {
    if(Greenfoot.getMouseInfo().getButton()==1&&Greenfoot.getMouseInfo().getActor()==regresar)
    {
    Greenfoot.setWorld(new Menu());
    }
    
    }
   
}
}
