import greenfoot.*;

/**
 * Write a description of class Ayuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ayuda extends World
{

  public static final int XTAM=650;
  public static final int YTAM=600;  
  private Boton regresar;
    
    /**
     * En esta clase se pone la imagen de ayuda 
     * y un boton para regresar al menu principal
     * 
     */
    public Ayuda()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(XTAM,YTAM, 1); 
        regresar=new Boton();
        regresar.setImage("Regresar.png");
        
        this.addObject(regresar,XTAM-140,YTAM-30);//se adiciona el boton en la parte inferior derecha de la pantalla
        
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
