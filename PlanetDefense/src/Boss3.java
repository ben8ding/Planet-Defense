public class Boss3 extends Alien {


   
	
	public static int speed = 1;
	public static final int tSpeed = 1;
	public int i = 0;
	public int mHealth;
    
    public Boss3(int x, int y, int health) {
        super(x, y, health);
        this.mHealth = health;
       
        
        initAlien();
    }

    private void initAlien() {

        loadImage("boss5.gif");
        getImageDimensions();
    }
    
   
    

    public void move() {
        i++;
        	if(i>=4)
        	{
        	x -= speed;
        	i=0;
        	}
        }
}