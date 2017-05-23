public class Boss4 extends Alien {


   
	
	public static int speed = 1;
	public static final int tSpeed = 1;
	public int i = 0;
	private int mHealth;
    
    public Boss4(int x, int y, int health) {
        super(x, y, health);
        this.mHealth = health;
       
        
        initAlien();
    }

    private void initAlien() {

        loadImage("boss4.gif");
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