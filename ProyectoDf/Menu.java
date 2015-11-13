import greenfoot.*;
//import greenfoot.GreenfootImage.*;
/**
 * aqui se colocan los botones de las 
 * diferentes opciones del menu
 * 
 * @author Claudo Daniel Espinosa Guzman
 * @version (a version number or a date)
 */

public class Menu extends World
{
   private BJugar jugar;
   private BCreditos cred;
   private BAyuda ayuda;
   private BSalir salir;
   private BRecords rec;
   
     
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(650, 600, 1); 
        //en este constructor crea las variables de los botones
        jugar = new BJugar();
        cred  = new BCreditos();
        ayuda = new BAyuda();
        salir = new BSalir();
        rec   = new BRecords();
        botones();//se agregan los botones
    }
    public void botones()
    {
      this.addObject(jugar,325,100);
      this.addObject(ayuda,325,200);
      this.addObject(cred,325,300);
      this.addObject(rec,325,400);
      this.addObject(salir,325,500);
     
    }
    public void act()
    {
    if(Greenfoot.getMouseInfo()!=null)
    {
    if(Greenfoot.getMouseInfo().getButton()==1&&Greenfoot.getMouseInfo().getActor()==jugar)
    {
    Greenfoot.setWorld(new DontWorld());
    
    }
    if(Greenfoot.getMouseInfo().getButton()==1&&Greenfoot.getMouseInfo().getActor()==ayuda)
    {
    Greenfoot.setWorld(new Ayuda());
    
    }
    if(Greenfoot.getMouseInfo().getButton()==1&&Greenfoot.getMouseInfo().getActor()==cred)
    {
    Greenfoot.setWorld(new Creditos());
    
    }
    if(Greenfoot.getMouseInfo().getButton()==1&&Greenfoot.getMouseInfo().getActor()==rec)
    {
    Greenfoot.setWorld(new DontWorld());
    
    }
    if(Greenfoot.getMouseInfo().getButton()==1&&Greenfoot.getMouseInfo().getActor()==salir)
    {
    Greenfoot.stop();
    
    }
    
    
    }
    
    
    }
    
}
