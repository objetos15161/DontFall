import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    private int health = 50;
    private int healthBarWidth = 100;
    private int healthBarHeight = 15;
    private int pixelsPerHealthPoint = (int)healthBarWidth/health;
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HealthBar()
    {
    update();
    
    }
    public int getHealth()
    {
        return health;
    }
    public void act() 
    {
      update();
    }    
    public void update()
    {
    setImage(new GreenfootImage(healthBarWidth+2,healthBarHeight+2));
    GreenfootImage myImage = getImage();
    myImage.setColor(Color.WHITE);
    myImage.drawRect(0,0,healthBarWidth+1,healthBarHeight+1);
    myImage.setColor(Color.CYAN);
    myImage.fillRect(1,1,health*pixelsPerHealthPoint,healthBarHeight);
    }
    
    public void loseHealth()
    {
    health--;
    }
    public void winHealth()
    {
        health++;
    }
    public void reiniciaHealth()
    {
    health=20;
    }
}

