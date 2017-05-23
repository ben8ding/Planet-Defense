import java.util.ArrayList;

public class Boss extends Alien {


   
	
	public static int speed = 1;
	public static final int tSpeed = 1;
	private int mHealth;
	
	
    
    public Boss(int x, int y, int health) {
        super(x, y, health);
        this.mHealth = health;
       
        
        initAlien();
    }

    private void initAlien() {

        loadImage("boss2.gif");
        getImageDimensions();
    }
    
   
    

    public void move() {
        x -= speed;
    }
}