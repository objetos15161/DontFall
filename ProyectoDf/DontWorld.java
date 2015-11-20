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
    private int band=0;
    /**
     * Constructor for objects of class DontWorld.
     * 
     */
    public DontWorld()//Constructor del mundo (inicializa los objetos en una posicion)
    {    
        // 
        super(XTAM,YTAM,1); 
        jugador= new Gal();//Principal Personaje
        this.addObject(jugador,150,220);//metodo para agregarlo al mundo
        //Troncos//////////// estas variables son para la entrada incial
        tronco1= new Tronco1();//obstaculo
        this.addObject(tronco1,250,YTAM-80);
        tronco2= new Tronco2();//obstaculo de diferente tamaño
        this.addObject(tronco2,450,80);
        
        /**
        tronco3= new Tronco2();
        this.addObject(tronco3,600,YTAM-80);
        tronco4= new Tronco2();
        this.addObject(tronco4,600,80);

        tronco5= new Tronco3();
        this.addObject(tronco4,700,80);
        tronco6= new Tronco3();
        this.addObject(tronco3,700,YTAM-80);
        */
        //Bonificaciones///////
        Greenfoot.setWorld(new Menu());
        this.addObject(healthbar,500,20);
        
        contNivel= new Counter("Nivel ");//Contador para saber en que nivel esta
        contNivel.setValue(1);
        
        addObject(contNivel,350,20);

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
         z=Greenfoot.getRandomNumber(900);       
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
        
        if( jugador.getPuntos()>=0&jugador.getPuntos()>=1000)
        {
           
            
            if(band==0)
            {
             Greenfoot.playSound("Powerlvl1.wav");
             band=1;
            }
            nivel1();
        }
        if( jugador.getPuntos()>=2000&jugador.getPuntos()<=3000)
        {
            if(band==1)
            {
             Greenfoot.playSound("Powerlvl2.wav");
             band=2;
            }
             this.removeObjects(this.getObjects(Marciano.class));
            nivel2();
        }
        if( jugador.getPuntos()>=3500)
        {
            if(band==2)
            {
             Greenfoot.playSound("Powerlvl3.wav");
             band=3;
            }
            nivel3();
        }
        
        if( jugador.getPuntos()>=4000)
        {
            if(band==3)
            {
             Greenfoot.setWorld(new Win());
            }
            
        }
    }

    public void nivel1()
    {
        
         z=Greenfoot.getRandomNumber(1000);
         contNivel.setValue(2);
        if(z==200)
        {
            generaMarciano();
        }
    }

    public void nivel2()
    {
        
        z=Greenfoot.getRandomNumber(1000);
         contNivel.setValue(3);
        if(z==200)
        {
          
            generaBestia();
        }

    }

    public void nivel3()
    {
       
        z=Greenfoot.getRandomNumber(1000);
         contNivel.setValue(4);
        if(z==400)
        {
            generaBestia();
        }
        if(z==200)
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
    
    public Gal getGal()
    {
    return jugador;
    }
     

}
