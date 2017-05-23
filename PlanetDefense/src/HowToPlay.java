import javax.swing.*;
import java.awt.*;
 

public class HowToPlay extends JFrame {
	public HowToPlay(){
		setResizable(false);
		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int mode = JOptionPane.showOptionDialog(null, "Your Instructions are as follows:\nYou are a spaceship driver trying to defend your green planet from aliens.\nYour controls are:\nArrow keys to move around\nZ to shoot forward (primary fire)\nX to shoot to the side (secondary/alt fire)\nESC to pause and unpause ", "Ready", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, new String[] {"Play"}, null);
		
		if(mode == 0){
			CollisionEx ex = new CollisionEx();
			ex.setVisible(true);
		}
	}
}
