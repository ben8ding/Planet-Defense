public class Boss2 extends Alien {


   
	
	public static int speed = 1;
	public static final int tSpeed = 1;
	int i = 0;
	private int mHealth;
	
    
    public Boss2(int x, int y, int health) {
        super(x, y, health);
        this.mHealth = health;
       
        
        initAlien();
    }

    private void initAlien() {

        loadImage("boss1.gif");
        getImageDimensions();
    }
    
   
    

    public void move() {
    i++;
    	if(i>=2)
    	{
    	x -= speed;
    	i=0;
    	}
    }
}