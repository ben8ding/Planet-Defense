import java.util.ArrayList;

public class Boss extends Alien {


   
	
	public static int speed = 1;
	
	
    
    public Boss(int x, int y, int health) {
        super(x, y, health);

       
        
        initAlien();
    }

    private void initAlien() {

        loadImage("boss1.gif");
        getImageDimensions();
    }
    
   
    

    public void move() {
        x -= speed;
    }
}