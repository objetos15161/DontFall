import greenfoot.*;

/**
 * La clase records agrega al mundo una tabla para guardar puntajes
 * 
 * @autor (Claudio Daniel Espinosa Guzman) 
 * @versión (Semestre 2015-2016/I)
 */
public class Records extends World
{
 private ScoreBoard score;
 private Boton regresa;
    /**
     * El constructor agrega una nueva tabla de puntaje y un Boton para regresar
     * al Menu principal
     * 
     */
    public Records()
    {    
        // Crea un nuevo mundo de 600x400 celdas con un tamaño de celda de 1x1 pixeles.
        super(600, 650, 1);
        Greenfoot.setWorld(new Menu());
        
        score=new ScoreBoard(300, 400);
        addObject(score, getWidth()/2, getHeight()/2);
        regresa= new Boton();
        regresa.setImage("Regresar.png");
        addObject(regresa,500,550);
    }
    /**
     * EL metodo act checa si se presiona el Boton para regresar
     */
     public void act()
    {
        if(Greenfoot.getMouseInfo()!=null){
           
           if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor()==regresa){
               
                Greenfoot.setWorld(new Menu());
            }
            
        }   
    }
}
