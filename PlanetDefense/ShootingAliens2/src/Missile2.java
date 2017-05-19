public class Missile2 extends Missile {

    private final int BOARD_WIDTH = Missile.BOARD_WIDTH;
    

    public Missile2(int x, int y) {
        super(x, y);

        initMissile();
    }
    
    private void initMissile() {
        
        loadImage("laser2.png");
        getImageDimensions();        
    }

    public void move() {
        
        x += MISSILE_SPEED;
        y += MISSILE_SPEED/4;
        
        if (x > BOARD_WIDTH)
            vis = false;
    }
}