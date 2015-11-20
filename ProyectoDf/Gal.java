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
    private int vel=100;  
    private int puntos=0;
    private Counter contPuntos;
    private Counter contVidas;
    private Counter contMonedas;
 
    /*
     * Act - do whatever the Gal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Gal()//Constructor de la clase Gal
    {
        contPuntos= new Counter("Puntos ");//contador de puntos
        contPuntos.setValue(0); //El contador de puntos se inicializa en cero
        
        contMonedas= new Counter("Monedas ");//Contador de monedas 
        contMonedas.setValue(0);
        
        contVidas= new Counter("Vidas ");//Contador de vidas
        contVidas.setValue(3);
        
        

    }

    public void act() 
    {
        // Add your action code here.

        checkKey();
        checkHitPunt();
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

    public void checkHitPunt()//esta funcion checa si Gal golpea algo y ademas checa el puntaje
    {
        boolean hitByTrunk    = isTouching(Tronco.class);
        boolean hitByEnemigo  = isTouching(Enemigo.class);
        boolean hitByCoin     = isTouching(Moneda.class);
        boolean hitByApple    = isTouching(Manzana.class);
        boolean hitByAppleGus = isTouching(ManzanaGus.class);
        boolean hitByGreenCoin= isTouching(MonedaVerde.class);
        x=getX();
        y=getY();
        DontWorld mun= (DontWorld)getWorld();
        HealthBar healthbar = mun.getHealthBar();

        if(hitByTrunk||hitByEnemigo)
        {

            healthbar.loseHealth();//le da un mensaje a la barra para que baje un

            if(healthbar.getHealth()<=0)
            {
                //aqui se pone el gameover
                contVidas.setValue(contVidas.getValue()-1);
                Greenfoot.delay(20);
                healthbar.reiniciaHealth();
            }

            //   Greenfoot.stop();
            hitByTrunk=false;
        }
        if(hitByCoin)
        {
            Greenfoot.playSound("getcoin.wav");
            contPuntos.setValue(contPuntos.getValue()+100);//suma 100 al contador de puntos
            puntos+=100;
            if(contMonedas.getValue()%10==0)//este if agrega una vida cada que el jugador tiene un puntaje de 1000
            {
                //puntos+=1;
                contVidas.setValue(contVidas.getValue()+1);
            }

            DontWorld mundo=(DontWorld)getWorld();
            mundo.generaMoneda();
            removeTouching(Moneda.class);
            
            contMonedas.setValue(contMonedas.getValue()+1);

        }
        if(hitByApple)
        {
            // contPuntos.setValue(contPuntos.getValue()+1);//aqui se quita esto y se pone la velocidad mas alta 
            Tronco t= new Tronco();
            t.aumentaVel();
            

            DontWorld mundo=(DontWorld)getWorld();
            mundo.generaManzana();
            removeTouching(Manzana.class);
        }

        if(contVidas.getValue()<=0)//esta condicion es para que el contador de vidas no de valores negativos
        {
            Greenfoot.playSound("GameOver.wav");
            contVidas.setValue(0);
            Greenfoot.setWorld(new GameOver());
            Greenfoot.delay(200);
            Greenfoot.setWorld(new Menu());
        }
        if(puntos<=0)
        {
           puntos=0;
        contPuntos.setValue(0);
        }
        if(hitByAppleGus)
{
    
            DontWorld mundo=(DontWorld)getWorld();
            mundo.generaManzanaGus();
            removeTouching(ManzanaGus.class);
        }
        if(hitByGreenCoin)
        {
           Greenfoot.playSound("click2.wav");
            contPuntos.setValue(contPuntos.getValue()-100);//suma 100 al contador de puntos
            puntos-=100;
            

            DontWorld mundo=(DontWorld)getWorld();
            mundo.generaMoneda();
            removeTouching(MonedaVerde.class);

        }

    }

    public int getPuntos()
    {
        return puntos;
    }

    public void checaFin()
    {
        if(getY()>=550)//getWorld().getHeight()
        {
            contVidas.setValue(contVidas.getValue()-1);
            //Gal jugador2=new Gal();// si se cae agrega un nuevo Gal en una posicion
            // getWorld().addObject(jugador2,200,230);
            this.setLocation(200,220);
            //getWorld().removeObject(this);

        }
    }

    protected void addedToWorld(World mundo)
    {
        mundo.addObject(contPuntos,50,20);
        mundo.addObject(contVidas,150,20);
        mundo.addObject(contMonedas,250,20);
      
    }

}
