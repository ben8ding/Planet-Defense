import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.*;

public class CollisionEx extends JFrame {

	public CollisionEx() {

		initUI();
	}

	private void initUI() {

		add(new Board());

		setResizable(false);
		pack();

		setTitle("Collision");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		int mode = JOptionPane.showOptionDialog(null, "", "Game Mode Select", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, new String[] {"Play", "How to Play"}, null);
		if (mode == 0){
			EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				CollisionEx ex = new CollisionEx();
				ex.setVisible(true);
			}
		});
		}
		if (mode == 1){
		//	HowToPlay a = new HowToPlay();
		//	a.setVisible(true);
		}
	}
}