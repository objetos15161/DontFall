import greenfoot.*;
//import greenfoot.GreenfootImage.*;
/**

 * @author Claudo Daniel Espinosa Guzman
 * @version (a version number or a date)
 */

public class Menu extends World
{
   
    /*private BJugar jugar;
   private BCreditos cred;
   private BAyuda ayuda;
   private BSalir salir;
   private BRecords rec;
   */
  private Boton jugar;
  private Boton creditos;
  private Boton ayuda;
  private Boton salir;
  private Boton records;

     /**
     *En el constructor de la clase se crean los botones
     *y se les asigna una imagen.
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(650, 600, 1); 
        //en este constructor crea las variables de los botones
        
        jugar= new Boton();
        creditos=new Boton();
        ayuda=new Boton();
        salir=new Boton();
        records=new Boton();
        
        jugar.setImage("Jugar.png");
        creditos.setImage("Creditos1.png");
        ayuda.setImage("Ayuda.png");
        salir.setImage("Salir.png");
        records.setImage("Records.png");
        botones();//se agregan los botones
     
    }
    /**
     *En este metodo se agregan al mundo los botones
     *previamente inicializados en el constructor de la clase
     */
    public void botones()
    {
      this.addObject(jugar,325,100);
      this.addObject(ayuda,325,200);
      this.addObject(creditos,325,300);
      this.addObject(records,325,400);
      this.addObject(salir,325,500);
     
    }
    /**
     *El metodo act de la clase verifica si se presiona un objeto de la clase Boton
     */
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
    if(Greenfoot.getMouseInfo().getButton()==1&&Greenfoot.getMouseInfo().getActor()==creditos)
    {
    Greenfoot.setWorld(new Creditos());
    
    }
    if(Greenfoot.getMouseInfo().getButton()==1&&Greenfoot.getMouseInfo().getActor()==records)
    {
    Greenfoot.setWorld(new Records());
    
    }
    if(Greenfoot.getMouseInfo().getButton()==1&&Greenfoot.getMouseInfo().getActor()==salir)
    {
    Greenfoot.stop();
    
    }
    
    
    }
    
    
    }
    
}
