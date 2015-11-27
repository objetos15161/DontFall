import greenfoot.*;

/**
 * Escribe una descrición de la clase Records aquí.
 * 
 * @autor (tu nombre) 
 * @versión (Un número de versión o una fecha)
 */
public class Records extends World
{
 private ScoreBoard score;
 private BRegresar regresa;
    /**
     * Constructor para objetos de clase Records.
     * 
     */
    public Records()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(600, 650, 1);
        Greenfoot.setWorld(new Menu());
        
        score=new ScoreBoard(300, 400);
        addObject(score, getWidth()/2, getHeight()/2);
        regresa=new BRegresar();
        addObject(regresa,500,550);
    }
    //Metodo act checa si el usuario quiere regresar
     public void act()
    {
        if(Greenfoot.getMouseInfo()!=null){
           
           if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor()==regresa){
               
                Greenfoot.setWorld(new Menu());
            }
            
        }   
    }
}
