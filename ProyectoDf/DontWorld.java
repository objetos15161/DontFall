import greenfoot.*;

/**
 * Write a description of class DontWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DontWorld extends World
{
 private  int y;//variable para determinar de manera aleatoria la y de los objetos   
 private Gal jugador;//Variable para crear al jugador
 private Tronco1 tronco1, tronco2;//variable para los troncos de tamaño 1
 private Tronco2 tronco3, tronco4;//variable para los troncos de tamaño 2
 private Tronco3 tronco5,tronco6;
 private Moneda coin1;//variable para crear una moneda
 private Manzana apple1;//variable para crear una manzana
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
        this.addObject(jugador,200,200);//metodo para agregarlo al mundo
        //Troncos//////////// estas variables son para la entrada incial
        tronco1= new Tronco1();//obstaculo
        this.addObject(tronco1,200,WtamY-85);
        tronco2= new Tronco1();//obstaculo de diferente tamaño
        this.addObject(tronco2,200,85);
        tronco3= new Tronco2();
        this.addObject(tronco3,450,WtamY-85);
        tronco4= new Tronco2();
        this.addObject(tronco4,450,85);
        
        tronco5= new Tronco3();
        this.addObject(tronco4,650,85);
        tronco6= new Tronco3();
        this.addObject(tronco3,650,WtamY-85);
        //Bonificaciones////////
       
        
       
        
        
    }
    public void act()
    {
    generaBonif();
    
    }
    
    public void generaMoneda()
    {
       y=Greenfoot.getRandomNumber(250);
        Moneda coin1=new Moneda();
    
      this.addObject(coin1,600,y);
    
    
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
    this.addObject(t1,WtamX,WtamY-85);
    this.addObject(t5,WtamX,85);
    }
    if(R==1)
    {
     this.addObject(t2,WtamX,85);
     this.addObject(t5,WtamX,WtamY-85);
    }
    if(R==2)
    {
    this.addObject(t3,WtamX,WtamY-85);
    this.addObject(t1,WtamX,85);
    }
    if(R==3)
    {
    this.addObject(t6,WtamX,WtamY-85);
    this.addObject(t4,WtamX,85);
    }
    if(R==4)
    {
    
    }
    if(R==5)
    {
    
    }

}


}
