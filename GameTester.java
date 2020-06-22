import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GameTester extends JPanel implements KeyListener {

	private Cell theCell;
	private Virus theVirus;
	public static int max = 900;
	public static int min = 1;
	public static int range = max - min + 1;
	public static boolean gameover = false;
	
	
	public GameTester(JFrame theFrame) {

		setLayout(null);
		theCell = new Cell(200, 300, 50, 50, 100); 
		theVirus = new Virus(800, 300, 50, 50, 100);
	}

	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();

		if (c == 'd' || c == 'D') {
			theCell.moveRight();
			System.out.println("Pressed: d");
		}

		if (c == 'a' || c == 'A') {
			theCell.moveLeft();
			System.out.println("Pressed: a");
		}

		if (c == 'w' || c == 'W') {
			theCell.moveUp();
			System.out.println("Pressed: w");
		}

		if (c == 's' || c == 'S') {
			theCell.moveDown();
			System.out.println("Pressed: s");
		}

		if (c == 'l' || c == 'L') {
			theVirus.moveRight();
			System.out.println("Pressed: l");
		}

		if (c == 'j' || c == 'J') {
			theVirus.moveLeft();
			System.out.println("Pressed: j");
		}

		if (c == 'I' || c == 'i') {
			theVirus.moveUp(); 
			System.out.println("Pressed: i");
		}

		if (c == 'K' || c == 'k') {
			theVirus.moveDown();
			System.out.println("Pressed: k");
		}
		/////// ATTACKS///////
		if (c == 'q' || c == 'Q') {
			theCell.pull();
			System.out.println("Pressed: q");
		}
		if (c == 'e' || c == 'E') {
			theCell.attack();
			System.out.println("Pressed: e ");
		}
		if (c == 'u' || c == 'U') {
			theVirus.pull();
			System.out.println("Pressed: u");

		}
		if (c == 'o' || c == 'O') {
			theVirus.attack();
			System.out.println("Pressed: o");
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 1000);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.setColor(Color.RED);
		g.drawString("Cell: " + theVirus.getCellHealth(), 25, 140);
		g.setColor(Color.BLUE);
		g.drawString("Virus: " + theCell.getVirusHealth(), 25, 250);

		String message = "FIGHT COVID-19";
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString(message, 200, 75);
		((Graphics2D) g).setStroke(new BasicStroke(1));
		for (int x = 100; x <= 1800; x += 100) {
			g.drawLine(x, 0, x, 1000);
		}
		for (int y = 100; y <= 1800; y += 100) {
			g.drawLine(0, y, 1000, y);
		}
		
		
		theCell.paint(g);
		theVirus.paint(g);
	}

	public static void main(String[] args) {
		JFrame parent = new JFrame();

		JOptionPane.showMessageDialog(parent,
				"This is an entertaining two player game that shows a fight between a cell and coronavirus. This game is not supposed to be "
						+ "realistic and it's only for enterntainment. ENJOY! ");
		JFrame instructions = new JFrame();

		JOptionPane.showMessageDialog(instructions,
				"Controls for Cell:\n" + "Up- W\n Left - A \n Down - S\n Right - D \n Attack - Q \n Pull(Can only be used once) - E ");
		JFrame instructions2 = new JFrame();

		JOptionPane.showMessageDialog(instructions2,
				"Controls for Virus:\n" + "Up- I\n Left - J \n Down - K\n Right - L \n Attack - U \n Pull(Can only be used once) - O ");
		JFrame frame = new JFrame("");
		GameTester game = new GameTester(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(1000, 1020);
		frame.setLocation(0, 0);
		frame.addKeyListener(game);
		frame.getContentPane().add(game);
		frame.setVisible(true);
		frame.requestFocus();

		}

	

	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();

		repaint();
	}

	public void keyReleased(KeyEvent e) {
		char c = e.getKeyChar();

		repaint();
	}

}