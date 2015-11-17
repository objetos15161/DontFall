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
    private int z;   
    private  int y;//variable para determinar de manera aleatoria la y de los objetos   
    private Gal jugador;//Variable para crear al jugador
    private Tronco1 tronco1, tronco2;//variable para los troncos de tamaño 1
    private Tronco2 tronco3, tronco4;//variable para los troncos de tamaño 2
    private Tronco3 tronco5,tronco6;
    private Moneda coin1;//variable para crear una moneda AMARILLA
    private MonedaVerde coin2;//variable para crear una moneda VERDE
    private Manzana apple1;//variable para crear una manzana
    private HealthBar healthbar= new HealthBar();
    private Marciano mar1;
    private Bestia best1;
    private ManzanaGus manG;
    /**
     * Constructor for objects of class DontWorld.
     * 
     */
    public DontWorld()//Constructor del mundo (inicializa los objetos en una posicion)
    {    
        // 
        super(XTAM,YTAM,1); 
        jugador= new Gal();//Principal Personaje
        this.addObject(jugador,200,220);//metodo para agregarlo al mundo
        //Troncos//////////// estas variables son para la entrada incial
        tronco1= new Tronco1();//obstaculo
        this.addObject(tronco1,200,YTAM-85);
        tronco2= new Tronco1();//obstaculo de diferente tamaño
        this.addObject(tronco2,200,85);
        tronco3= new Tronco2();
        this.addObject(tronco3,450,YTAM-85);
        tronco4= new Tronco2();
        this.addObject(tronco4,450,85);

        tronco5= new Tronco3();
        this.addObject(tronco4,650,85);
        tronco6= new Tronco3();
        this.addObject(tronco3,650,YTAM-85);
        //Bonificaciones///////
        Greenfoot.setWorld(new Menu());
        this.addObject(healthbar,300,20);

    }
    public HealthBar getHealthBar()
    {
        return healthbar;
    }

    public void act()
    {
        generaBonif();
        checaNivel();
    }

    public void generaManzanaGus()
    {
        y=Greenfoot.getRandomNumber(250);
        ManzanaGus manGus=new ManzanaGus();

        this.addObject(manGus,600,y);

    }

    public void generaMoneda()
    {
        y=Greenfoot.getRandomNumber(250);
        Moneda coin1=new Moneda();

        this.addObject(coin1,600,y);

    }
    public void generaMonedaVerde()
    {
        y=Greenfoot.getRandomNumber(250);
        MonedaVerde coin2=new MonedaVerde();

        this.addObject(coin2,600,y);

    }
    public void generaManzana()
    {
        y=Greenfoot.getRandomNumber(250);
        Manzana apple1= new Manzana();
        this.addObject(apple1,600,y);

    }

    public void generaBonif()
    {
        int z=Greenfoot.getRandomNumber(900);       
        if(z==0)
        {
            generaMoneda(); 
        }else if(z==1)
        {
            generaManzana();

        }else if (z==3)
        {
        generaManzanaGus();
        }else if (z==15)
        {
        generaMonedaVerde();
        }
    }

    public void generaTroncos()//genera troncos en parejas aleatorias
    {
        int R=Greenfoot.getRandomNumber(6);

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

        if(R==0)//agregara a la pareja num 1
        {
            this.addObject(t1,XTAM,YTAM-85);
            this.addObject(t5,XTAM,85);
        }
        if(R==1)
        {
            this.addObject(t2,XTAM,85);
            this.addObject(t5,XTAM,YTAM-85);
        }
        if(R==2)
        {
            this.addObject(t3,XTAM,YTAM-85);
            this.addObject(t1,XTAM,85);
        }
        if(R==3)
        {
            this.addObject(t6,XTAM,YTAM-85);
            this.addObject(t4,XTAM,85);
        }
        if(R==4)
        {

        }
        if(R==5)
        {

        }

    }

    public void checaNivel()
    {
        if( jugador.getPuntos()>=0&jugador.getPuntos()>=1000)
        {
            nivel1();
        }
        if( jugador.getPuntos()>=2000&jugador.getPuntos()<=3500)
        {
             this.removeObjects(this.getObjects(Marciano.class));
            nivel2();
        }
        if( jugador.getPuntos()>=3500)
        {
            nivel3();
        }
    }

    public void nivel1()
    {
        int z=Greenfoot.getRandomNumber(400);
        if(z==100)
        {
            generaMarciano();
        }
    }

    public void nivel2()
    {
        int z=Greenfoot.getRandomNumber(400);
        if(z==1)
        {
          
            generaBestia();
        }

    }

    public void nivel3()
    {
        z=Greenfoot.getRandomNumber(900);
        if(z==1)
        {
            generaBestia();
        }
        if(z==2)
        {
            generaMarciano();
        }

    }

    public void generaMarciano()
    {
        int r=Greenfoot.getRandomNumber(250);
        mar1= new Marciano();
        this.addObject(mar1,650,r);

    }

    public void generaBestia()
    {
        int r=Greenfoot.getRandomNumber(250);
        best1= new Bestia();
        this.addObject(best1,0,r);

    }

}
