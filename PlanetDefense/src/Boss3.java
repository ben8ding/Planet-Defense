public class Boss3 extends Alien {


   
	
	public static int speed = 1;
	
	
    
    public Boss3(int x, int y, int health) {
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