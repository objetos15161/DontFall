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
    /*
     * Act - do whatever the Gal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        checkKey();
        //checkHit();
        checaFin();
    }    

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
        boolean hitByTrunk= isTouching(Tronco.class);
        boolean hitByBestia= isTouching(Bestia.class);
        if(hitByTrunk||hitByBestia)
        {

            Greenfoot.stop();

        }

    }

    public void checaFin()
    {
        if(getY()==500)//getWorld().getHeight()
        {

            Gal jugador2=new Gal();// si se cae agrega un nuevo Gal en una posicion
            getWorld().addObject(jugador2,200,230);
            getWorld().removeObject(this);

        }
    }
}
