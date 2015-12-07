import greenfoot.*;
import java.awt.Color;
/**
 * La clase HealthBar representa una barra de vida
 * 
 * @author (Claudio Daniel Espinosa Guzman) 
 * @version (Semestre 2015-2016/I)
 */
public class HealthBar extends Actor
{
    private int health =90;
    private int healthBarWidth = 90;
    private int healthBarHeight = 20;
    private int pixelsPerHealthPoint = (int)healthBarWidth/health;
    /**
     * El constructor le da el estado inicial a la barra de vida.
     */
  
    public HealthBar()
    {
    update();
    
    }
    /**
     * Este metodo regresa la variable health para saber su estado cuando se requiere
     */
    public int getHealth()
    {
        return health;
    }
    /**
     * El metodo actualiza la barra (si se perdio o gano health)
     */
    public void act() 
    {
      update();
    }    
    /**
     * El metodo dibuja un rectangulo y lo rellena
     */
    public void update()
    {
    setImage(new GreenfootImage(healthBarWidth+2,healthBarHeight+2));
    GreenfootImage myImage = getImage();
    myImage.setColor(Color.WHITE);
    myImage.drawRect(0,0,healthBarWidth+1,healthBarHeight+1);
    myImage.setColor(Color.BLUE);
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
    /**
     * El metodo reinicia la barra de vida 
     * a su valor original
     */
    public void reiniciaHealth()
    {
    health=90;
    }
}

