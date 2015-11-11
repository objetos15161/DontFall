import greenfoot.*;

/**
 * Write a description of class Gal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gal extends Actor
{
    private int x;
    private int y;
    private int vel=1;
    
    private Counter contPuntos;
    /*
     * Act - do whatever the Gal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Gal()//Constructor de la clase Gal
    {
        contPuntos= new Counter("Puntos ");
        contPuntos.setValue(0); 
    }

    public void act() 
    {
        // Add your action code here.
      
        checkKey();
        checkHit();
         checaFin();
        
    }    
    //objetos2223.github.io
    public void checkKey()
    {
        x=getX();
        y=getY();   
        setLocation(x,y+3);

        if(Greenfoot.isKeyDown("UP"))
        {
            setLocation(x,y-2);
        }
    }
    

    public void checkHit()
    {
        boolean hitByTrunk= isTouching(Troncos.class);
        boolean hitByBestia= isTouching(Bestia.class);
        boolean hitByCoin= isTouching(Moneda.class);
        boolean hitByApple= isTouching(Manzana.class);
        x=getX();
        y=getY();   
        if(hitByTrunk||hitByBestia)
        {

            //   Greenfoot.stop();

        }
        if(hitByCoin)
        {
            contPuntos.setValue(contPuntos.getValue()+1);
            DontWorld mundo=(DontWorld)getWorld();
            mundo.generaMoneda();
            removeTouching(Moneda.class);
        }
        if(hitByApple)
        {
            contPuntos.setValue(contPuntos.getValue()+1);//aqui se quita esto y se pone la velocidad mas alta 
            Greenfoot.setSpeed(vel+1);
            DontWorld mundo=(DontWorld)getWorld();
            mundo.generaManzana();
            removeTouching(Manzana.class);
        }

    }

    public void checaFin()
    {
        if(getY()==600)//getWorld().getHeight()
        {

            Gal jugador2=new Gal();// si se cae agrega un nuevo Gal en una posicion
            getWorld().addObject(jugador2,200,230);
            getWorld().removeObject(this);

        }
    }

    protected void addedToWorld(World mundo)
    {
        mundo.addObject(contPuntos,50,20);

    }
}
