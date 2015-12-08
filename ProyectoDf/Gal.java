import greenfoot.*;

/**
 * La clase Gal es donde se describen las caracteristicas
 * del jugador, ademas del comportamiento y las condicciones
 * con las cuales interactua con el mundo.
 * 
 * @author (Claudio Daniel Espinosa Guzman) 
 * @version (Semestre 2015-2016/I)
 */
public class Gal extends Actor
{

    private int puntos=0;
    private Counter contPuntos;
    private Counter contVidas;
    private Counter contMonedas;
    private boolean hitByTrunk;
    private boolean hitByEnemigo; 
    private boolean hitByCoin ;    
    private boolean hitByApple ; 
    private boolean hitByAppleGus;
    private boolean hitByGreenCoin; 
    private Escenario escenario;
    private boolean hitByBonificacion;

    /**
     * Constructor de la clase Gal
     * inicializa los contadores de Puntos, Monedas y Vidas
     */
    public Gal()//Constructor de la clase Gal
    {
        contPuntos= new Counter("Puntos ");//contador de puntos
        contPuntos.setValue(0); //El contador de puntos se inicializa en cero

        contMonedas= new Counter("Monedas ");//Contador de monedas 
        contMonedas.setValue(0);

        contVidas= new Counter("Vidas ");//Contador de vidas
        contVidas.setValue(3);
        escenario= new Escenario();

    }

    /**
     * El metodo act manda llamar a los metodos para
     * checar si se presiono una tecla
     * checar si choca con los demas objetos que estan en el mundo
     * checar si se perdio el juego
     */
    public void act() 
    {
        // Add your action code here.

        checkKey();
        checkHitPunt();
        checaFin();

    }    
    //objetos2223.github.io
    /**
     * El metodo checa si se presiona algunas de las felchas
     * del teclado
     */
    public void checkKey()
    {
        int x,y;
        x=getX();
        y=getY();   
        setLocation(x,y-3);

        if(Greenfoot.isKeyDown("DOWN"))
        {
            setLocation(x,y+2);
        }
        if(Greenfoot.isKeyDown("RIGHT"))
        {
            setLocation(x+2,y);
        }
        if(Greenfoot.isKeyDown("LEFT"))
        {
            setLocation(x-2,y);
        }

    }

    /**
     * Este metodo evalua las variables booleanas 
     * para checar si el jugador toco algun objeto que este en el mundo
     * ademas acumula o resta los puntos.
     */
    public void checkHitPunt()//esta funcion checa si Gal golpea algo y ademas checa el puntaje
    {
        int x,y;
        DontWorld mun= (DontWorld)getWorld();
        hitByTrunk    = isTouching(Tronco.class);
        hitByEnemigo  = isTouching(Enemigo.class);
        // hitByBonificacion=intersects(mun.getManzana());

        hitByCoin     = isTouching(Moneda.class);
        hitByApple    = isTouching(Manzana.class);
        hitByAppleGus = isTouching(ManzanaGus.class);
        hitByGreenCoin= isTouching(MonedaVerde.class);

        x=getX();
        y=getY();

        HealthBar healthbar = mun.getHealthBar();

        if(hitByTrunk||hitByEnemigo)
        {

            healthbar.loseHealth();
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

            //  DontWorld mundo=(DontWorld)getWorld();
            mun.generaMoneda();
            removeTouching(Moneda.class);

            contMonedas.setValue(contMonedas.getValue()+1);

        }

        if(hitByApple)
        {

            mun.generaManzana();
            removeTouching(Manzana.class);

            mun.generaBonif();

        }

        if(contVidas.getValue()<=0)//esta condicion es para que el contador de vidas no de valores negativos
        {
           mun.stopMusic();
            Greenfoot.playSound("GameOver.wav");
            contVidas.setValue(0);
          //  Greenfoot.setWorld(new GameOver());+
            escenario.setImage("game-over.jpg");
            mun.setPaintOrder(Menu.class,Escenario.class,Tronco.class,Bonificacion.class);
            mun.addObject(escenario,mun.getWidth()/2,mun.getHeight()/2);
            mun.guardaRecord();
            Greenfoot.delay(200);
            Greenfoot.setWorld(new Menu());
            mun.removeObject(escenario);

        }
        if(puntos<=0)
        {
            puntos=0;
            contPuntos.setValue(0);
        }
        if(hitByAppleGus)
        {

            mun.generaManzanaGus();
            removeTouching(ManzanaGus.class);
        }
        if(hitByGreenCoin)
        {
            Greenfoot.playSound("click2.wav");
            contPuntos.setValue(contPuntos.getValue()-100);//suma 100 al contador de puntos
            puntos-=100;
            mun.generaBonif();
            removeTouching(MonedaVerde.class);

        }
        if(contMonedas.getValue()==1)
        {
            contVidas.setValue(3);
        }

    }

    /**
     *Este metodo retorna la variable entera 
     *de los puntos para poder saber cuando cambiar de nivel
     */
    public int getPuntos()
    {
        return puntos;
    }

    /**
     * El metodo checa si el jugador llego a el margen permitido en Y
     */
    public void checaFin()
    {
        if(getY()==0)//getWorld().getHeight()
        {
            contVidas.setValue(contVidas.getValue()-1);
            //Gal jugador2=new Gal();// si se cae agrega un nuevo Gal en una posicion
            // getWorld().addObject(jugador2,200,230);
            this.setLocation(200,220);
            //getWorld().removeObject(this);

        }
    }

    /**
     * Este metodo agrega los contadores al mundo
     * cuando el jugador es creado
     */
    protected void addedToWorld(World mundo)
    {
        mundo.addObject(contPuntos,50,20);
        mundo.addObject(contVidas,152,20);
        mundo.addObject(contMonedas,255,20);

    }

    /**
     * Este Metodo retorna una Bandera para
     * saber si el jugador toca un objeto Manzana
     */
    public boolean getHitByApple()
    {
        return hitByApple;
    }

    public boolean getHitByAppleGus()
    {
        return hitByAppleGus;
    }

}
