import greenfoot.*;

/**
 * Write a description of class DontWorld here.
 * 
 * @author (Claudio Daniel Espinosa Guzman) 
 * @version (Semestre 2015-2016/I)
 */
public class DontWorld extends World
{
    public static final int XTAM=650;//variable que determina el tamaño del mundo en X
    public static final int YTAM=600;//Variable que determina el tamaño del mundo en Y   
    private int nivel=0;//band es una variable para saber en que nivel se esta jugando
    private int velTroncos=-2;
    private int R,arriba=0;//r y z son para generar numeros aleatorios, arriba es es bandera para verificar  que tronco sigue por pintarse   
    private int y;//variable para determinar de manera aleatoria la y de los objetos   
    private Gal jugador;//Variable para crear al jugador
    private Tronco tronco1,tronco2;//variable para los troncos de tamaño 1
    private Escenario escenario;

    private Moneda moneda;//variable para crear una moneda AMARILLA
    private MonedaVerde monedaVerde;//variable para crear una moneda VERDE
    //  private Bonificacion manzanaGus;
    // private Bonificacion moneda;
    // private Bonificacion manzana;
    //private Bonificacion monedaVerde;

    private Manzana manzana;//variable para crear una manzana
    private HealthBar healthbar= new HealthBar();//
    private Marciano mar1;
    private Bestia best1;
    private ManzanaGus manzanaGus;
    private Counter contNivel;
    private GreenfootSound mFondo;
    private SimpleTimer tiempo;
    private GuardaRecord records;

    /**
     * Constructor de la clase DontWorld inicializa los objetos iniciales del mundo
     * 
     */
    public DontWorld()//Constructor del mundo (inicializa los objetos en una posicion)
    {    
        // 
        super(XTAM,YTAM,1); 
        mFondo= new GreenfootSound("Airport.mid");
        mFondo.play();
        setPaintOrder(HealthBar.class,Counter.class,Gal.class,Enemigo.class,Bonificacion.class,Tronco.class);
        jugador= new Gal();//Principal Personaje
        this.addObject(jugador,150,250);//metodo para agregarlo al mundo
        //Troncos//////////// estas variables son para la entrada incial
        tronco1= new Tronco();//obstaculo
        
        tronco1.setImage("Tronco2.png");
        this.addObject(tronco1,250,YTAM-80);
        tronco2= new Tronco();//obstaculo de diferente tamaño
        
        tronco2.setImage("Tronco2.png");
        this.addObject(tronco2,460,80);

        //Bonificaciones///////
        Greenfoot.setWorld(new Menu());
        this.addObject(healthbar,450,20);

        contNivel= new Counter("Nivel ");//Contador para saber en que nivel esta
        contNivel.setValue(1);

        addObject(contNivel,356,20);
        records= new GuardaRecord();
        escenario= new Escenario();
        tiempo= new SimpleTimer();

    }

    /**
     * Este metodo retorna la barra de vida
     * para poder saber su estado
     * 
     */

    public HealthBar getHealthBar()
    {
        return healthbar;
    }

    /**
     * El metodo act crea los objetos que aparecen en el juego
     * - Monedas
     * - Manzanas 
     * Y checa el nivel.
     * 
     */
    public void act()
    {
        generaBonif();
        checkHitByApple();
        checaNivel();
    }

    /**
     * Este metodo genera un objeto de la clase Manzana
     * con otra imagen que representa una manzana con gusano
     * 
     */
    public void generaManzanaGus()
    {
        y=Greenfoot.getRandomNumber(600);
        // manzanaGus=new Bonificacion();
        //manzanaGus.setImage("Manzana11.png");
        manzanaGus= new ManzanaGus();

        this.addObject(manzanaGus,600,y);

    }

    /**
     * Este metodo genera una moneda y la agrega al mundo
     * 
     */
    public void generaMoneda()
    {
        y=Greenfoot.getRandomNumber(600);
        //  moneda= new Bonificacion();
        // moneda.setImage("bitcoin.png");
        moneda= new Moneda();

        this.addObject(moneda,600,y);

    }

    /**
     * Este metodo genera una Moneda verde al mundo y lo agrega al mundo.
     * 
     */
    public void generaMonedaVerde()
    {
        y=Greenfoot.getRandomNumber(600);
        // monedaVerde= new Bonificacion();
        // monedaVerde.setImage("bitcoinGreen.png");
        monedaVerde= new MonedaVerde();

        this.addObject(monedaVerde,600,y);

    }

    /**
     * Este metodo genera un objeto manzana y lo añade al mundo
     * 
     */
    public void generaManzana()
    {
        y=Greenfoot.getRandomNumber(600);
        // manzana= new Bonificacion();
        // manzana.setImage("Manzana1.png");
        manzana= new Manzana();
        this.addObject(manzana,600,y);

    }

    /**
     * Este metodo genera una manzana o moneda
     * dependiendo del valor de la variable z 
     * 
     */
    public void generaBonif()
    {
        int z;
        z=Greenfoot.getRandomNumber(200);       
        if(z<2)
        {
            generaMoneda(); 
        }else if(z==10)
        {
            generaManzana();

        }else if (z==30)
        {
            generaManzanaGus();
        }else if (z==15)
        {
            generaMonedaVerde();
        }
    }

    public void generaTroncos()//genera troncos en parejas aleatorias
    {

        Tronco  t1;   
        t1= new Tronco();//obstaculo

        if(arriba==0)//agregara a la pareja num 1
        {
            t1.setImage("Tronco2.png");
            this.addObject(t1,XTAM,80);
            arriba=1;
        }else if(arriba==1)
        {
            t1.setImage("Tronco1.png");
            this.addObject(t1,XTAM,YTAM-80);
            arriba=0;
        }

    }

    /**
     * El metodo checaNivel regula el numero de puntos que debe 
     * tener el jugador para pasar de nivel
     * 
     */
    public void checaNivel()
    {

        if( jugador.getPuntos()>1000) //
        {

            if(nivel==0)
            {
                healthbar.reiniciaHealth();
                
                // Greenfoot.playSound("Powerlvl1.wav");
                Greenfoot.playSound("GameOver.wav");
                nivel=1;
            }
            nivel1();
        }
        if( jugador.getPuntos()>2000)
        {
            if(nivel==1)
            {
                healthbar.reiniciaHealth();
                 this.setBackground("Escenario2.jpg");
                Greenfoot.playSound("Powerlvl2.wav");
                nivel=2;
            }
            this.removeObjects(this.getObjects(Marciano.class));
            nivel2();
        }
        if( jugador.getPuntos()>=3000)
        {
            if(nivel==2)
            {
                healthbar.reiniciaHealth();
                 this.setBackground("Escenario3.jpg");
                Greenfoot.playSound("Powerlvl3.wav");
                nivel=3;
            }
            nivel3();
        }

        if( jugador.getPuntos()>=4000)
        {
            if(nivel==3)
            {
                stopMusic();
                Greenfoot.playSound("Win.mp3");
                //Greenfoot.setWorld(new Win());
                
                 escenario.setImage("nNsFFG6.jpg");
                setPaintOrder(Escenario.class,Tronco.class,Bonificacion.class);
                addObject(escenario,getWidth()/2,getHeight()/2);
                guardaRecord();
                Greenfoot.delay(300);
                Greenfoot.setWorld(new Menu());
            }

        }
    }

    /**
     * En este metodo se define el nivel 1
     * cada 3 segundos se genera un objeto marciano 
     * 
     */
    public void nivel1()
    {

        if(tiempo.millisElapsed()>=3000)
        {
            generaMarciano();
            tiempo.mark();
        }
    }

    /**
     * En este metodo se define el nivel 2 en el cual
     * se genera un objeto bestia cada 3 segundos
     * 
     */
    public void nivel2()
    {

        contNivel.setValue(3);
        if(tiempo.millisElapsed()>=3000)
        {
            generaBestia();
            tiempo.mark();
        }

    }

    /**
     * En este metodo se define el nivel 3 que el cual consta
     * de la generacion de objetos de las clases bestia y marciano
     * esto de manera aleatoria con ayuda de la variable z
     * 
     */
    public void nivel3()
    {
        int z;
        z=Greenfoot.getRandomNumber(500);
        contNivel.setValue(4);
        if(z==200)
        {
            generaBestia();

        }
        if(z==100)
        {
            generaMarciano();

        }
        tiempo.mark();

    }

    /**
     * En este metodo se crea y se agrega al mundo un objeto de la clase marciano
     * 
     */
    public void generaMarciano()
    {
        int r=Greenfoot.getRandomNumber(260);
        mar1= new Marciano();
        this.addObject(mar1,650,r);

    }

    /**
     * En este metodo se crea y se agrega al mundo un objeto de la clase bestia
     * 
     */
    public void generaBestia()
    {
        int r=Greenfoot.getRandomNumber(300);
        best1= new Bestia();
        this.addObject(best1,0,r);

    }

    /**
     * Metodo que retorna al jugador para poder acceder a sus variables internas
     * 
     */
    public Gal getGal()
    {
        return jugador;
    }

    public Bonificacion getManzana()
    {
        return manzana;
    }

    public Bonificacion getManzanaGus()
    {
        return manzanaGus;
    }

    public Bonificacion getMoneda()
    {
        return moneda;
    }

    public Bonificacion getMonedaVerde()
    {
        return monedaVerde;
    }

    /**
     * En este metodo se checa si algun objeto de la clase Manzana es tocado por el jugador
     * para subir o bajar la velocidad del scroll del mundo
     * 
     */
    public void checkHitByApple()
    {
        if(jugador.getHitByApple())
        {
            velTroncos-=1;
        }else if(jugador.getHitByAppleGus())
        {
            velTroncos+=1;
        }
        if(velTroncos>-2)
        {
            velTroncos=-2;
        }
        if(velTroncos<=-8)
        {
            velTroncos=-8;
        }
    }

    /**
     * Este metodo retorna la variable de velocidad del scroll
     * 
     */
    public int getVel()
    {
        return velTroncos;
    }

    /**
     * Este metodo almacena la puntuacion mas alta
     * registrada en el juego
     * 
     */
    public void guardaRecord()
    {
        records.almacenaRecords(jugador.getPuntos());
    }

    /**
     * Este metodo detiene la musica cuando el juego termina o 
     * se pierde.
     * 
     */
    public void stopMusic()
    {
        mFondo.stop();
    }

}
