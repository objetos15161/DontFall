import greenfoot.*;

/**
 * Write a description of class DontWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DontWorld extends World
{
    public static final int XTAM=650;
    public static final int YTAM=600;   
    private int band=0;//band es una variable para saber en que nivel se esta jugando
    private int velTroncos=-2;
    private int z,R,arriba=0;//r y z son para generar numeros aleatorios, arriba es es bandera para verificar  que tronco sigue por pintarse   
    private int y;//variable para determinar de manera aleatoria la y de los objetos   
    private Gal jugador;//Variable para crear al jugador
    private Tronco1 tronco1;//variable para los troncos de tamaño 1
    private Tronco2 tronco2, tronco4;//variable para los troncos de tamaño 2
    private Tronco3 tronco5,tronco6;

    private Moneda coin1;//variable para crear una moneda AMARILLA
    private MonedaVerde coin2;//variable para crear una moneda VERDE
    private Manzana apple1;//variable para crear una manzana
    private HealthBar healthbar= new HealthBar();
    private Marciano mar1;
    private Bestia best1;
    private ManzanaGus manG;
    private Counter contNivel;
    private GreenfootSound mFondo;
    private SimpleTimer tiempo;
    private GuardaRecord records;

    /**
     * Constructor for objects of class DontWorld.
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
        this.addObject(jugador,150,220);//metodo para agregarlo al mundo
        //Troncos//////////// estas variables son para la entrada incial
        tronco1= new Tronco1();//obstaculo
        this.addObject(tronco1,250,YTAM-80);
        tronco2= new Tronco2();//obstaculo de diferente tamaño
        this.addObject(tronco2,460,80);

        //Bonificaciones///////
        Greenfoot.setWorld(new Menu());
        this.addObject(healthbar,450,20);

        contNivel= new Counter("Nivel ");//Contador para saber en que nivel esta
        contNivel.setValue(1);

        addObject(contNivel,356,20);
        records= new GuardaRecord();
        
        tiempo= new SimpleTimer();

    }
    public HealthBar getHealthBar()
    {
        return healthbar;
    }

    public void act()
    {
        generaBonif();
        checkHitByApple();
        checaNivel();
    }

    public void generaManzanaGus()
    {
        y=Greenfoot.getRandomNumber(600);
        ManzanaGus manGus=new ManzanaGus();

        this.addObject(manGus,600,y);

    }

    public void generaMoneda()
    {
        y=Greenfoot.getRandomNumber(600);
        Moneda coin1=new Moneda();

        this.addObject(coin1,600,y);

    }

    public void generaMonedaVerde()
    {
        y=Greenfoot.getRandomNumber(600);
        MonedaVerde coin2=new MonedaVerde();

        this.addObject(coin2,600,y);

    }

    public void generaManzana()
    {
        y=Greenfoot.getRandomNumber(600);
        Manzana apple1= new Manzana();
        this.addObject(apple1,600,y);

    }

    public void generaBonif()
    {
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
        R=Greenfoot.getRandomNumber(6);

        Tronco1  t1; 
        Tronco1  t2;   
        Tronco2  t3;  
        Tronco2  t4;      
        Tronco3  t5;  
        Tronco3  t6;  

        t1= new Tronco1();//obstaculo
        t2= new Tronco1();//obstaculo de diferente tamaño    
        t3= new Tronco2();
        t4= new Tronco2();    
        t5= new Tronco3(); 
        t6= new Tronco3();

        if(arriba==0)//agregara a la pareja num 1
        {

            this.addObject(t5,XTAM,80);
            arriba=1;
        }else if(arriba==1)
        {

            this.addObject(t1,XTAM,YTAM-80);
            arriba=0;
        }

    }
    public void checaNivel()
    {

        if( jugador.getPuntos()>1000) //
        {

            if(band==0)
            {
                 healthbar.reiniciaHealth();
                // Greenfoot.playSound("Powerlvl1.wav");
                Greenfoot.playSound("GameOver.wav");
                band=1;
            }
            nivel1();
        }
        if( jugador.getPuntos()>2000)
        {
            if(band==1)
            {
                  healthbar.reiniciaHealth();
                Greenfoot.playSound("Powerlvl2.wav");
                band=2;
            }
            this.removeObjects(this.getObjects(Marciano.class));
            nivel2();
        }
        if( jugador.getPuntos()>=3000)
        {
            if(band==2)
            {
                  healthbar.reiniciaHealth();
                Greenfoot.playSound("Powerlvl3.wav");
                band=3;
            }
            nivel3();
        }

        if( jugador.getPuntos()>=4000)
        {
            if(band==3)
            {
                stopMusic();
                Greenfoot.playSound("Win.mp3");
                Greenfoot.setWorld(new Win());
                guardaRecord();
                Greenfoot.delay(300);
                Greenfoot.setWorld(new Menu());
            }

        }
    }

    public void nivel1()
    {
       
        contNivel.setValue(2);
        if(tiempo.millisElapsed()>=3000)
        {
            generaMarciano();
            tiempo.mark();
        }
    }

    public void nivel2()
    {
       
      
        contNivel.setValue(3);
        if(tiempo.millisElapsed()>=2000)
        {
            generaBestia();
            tiempo.mark();
        }

    }

    public void nivel3()
    {
           
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

    public void generaMarciano()
    {
        int r=Greenfoot.getRandomNumber(260);
        mar1= new Marciano();
        this.addObject(mar1,650,r);

    }

    public void generaBestia()
    {
        int r=Greenfoot.getRandomNumber(300);
        best1= new Bestia();
        this.addObject(best1,0,r);

    }

    public Gal getGal()
    {
        return jugador;
    }

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

    public int getVel()
    {
        return velTroncos;
    }

    public void guardaRecord()
    {
        records.almacenaRecords(jugador.getPuntos());
    }

    public void stopMusic()
    {
        mFondo.stop();
    }
}
