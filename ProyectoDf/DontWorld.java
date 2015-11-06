import greenfoot.*;

/**
 * Write a description of class DontWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DontWorld extends World
{
 private Gal jugador;
 private Tronco tronco1, tronco2;
 private Tronco2 tronco3, tronco4;
 private Moneda coin1;
 private int WtamX=650,WtamY=600;//TAMAÑO DEL MUNDO EN X y Y
    /**
     * Constructor for objects of class DontWorld.
     * 
     */
    public DontWorld()//Constructor del mundo (inicializa los objetos en una posicion)
    {    
        // 
        super(650,600, 1); 
        jugador= new Gal();//Principal Personaje
        addObject(jugador,200,200);//metodo para agregarlo al mundo
        //Troncos////////////
        tronco1= new Tronco();//obstaculo
        addObject(tronco1,200,WtamY-85);
        tronco2= new Tronco();//obstaculo de diferente tamaño
        addObject(tronco2,200,85);
        tronco3= new Tronco2();
        addObject(tronco3,450,WtamY-85);
        tronco4= new Tronco2();
        addObject(tronco4,450,85);
        //Bonificaciones////////
        coin1= new Moneda();
        addObject(coin1,600,230);
        
        
    }
    public void generaMoneda()
    {
        int y=Greenfoot.getRandomNumber(250);
        Moneda mon1=new Moneda();
    
      this.addObject(mon1,600,y);
    
    
    }
}
