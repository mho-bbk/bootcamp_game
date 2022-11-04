import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI {

	GridController grid;
	int gridSize;
	private boolean loseGame = false;

	JFrame window = new JFrame("Treasure Hunt");
	// String answer;

	public GUI(GridController grid, int gridSize) {
		this.grid = grid;
		this.gridSize = gridSize;
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(new Dimension(800, 800));
		window.setLayout(new GridLayout(gridSize, gridSize));
		window.setLocationRelativeTo(null);
		window.setAlwaysOnTop (true);
		update(grid);
	}

	public void winGame(String name, int gold) {
		System.out.println("IN METHOD");
		window.getContentPane().removeAll();
		window.repaint();
		
		JLabel win = new JLabel();
		win.setText("<html>" +name + " won. <br/>You have gained "+gold+" gold which can buy you " +gold/2+" cheeseburgers.</html>");
		win.setHorizontalAlignment(JLabel.CENTER);
		win.setVerticalAlignment(JLabel.CENTER);
		
		JLabel icon = new JLabel();
		ImageIcon img = new ImageIcon("C:\\Users\\Rizwan\\Documents\\BootCamp\\final_game\\bootcamp_game\\src\\main\\resources\\burger.png");
		icon.setIcon(img);
		
		JLabel iconEz = new JLabel();
		ImageIcon img2 = new ImageIcon("C:\\Users\\Rizwan\\Documents\\BootCamp\\final_game\\bootcamp_game\\src\\main\\resources\\2ez.jpg");
		ImageIcon img2Scaled = new ImageIcon(img2.getImage().getScaledInstance(250, 195, Image.SCALE_DEFAULT));
		iconEz.setIcon(img2Scaled);
		

		window.setLayout(new FlowLayout());
		window.add(icon);
		window.add(win);
		window.add(iconEz);
		window.pack();
		window.setVisible(true);
	}

	public void update(GridController grid) {
		window.getContentPane().removeAll();
		window.repaint();
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				JLabel label = addEntity(grid.grid[i][j], loseGame);
				window.add(label);
			}
		}
		window.pack();
		window.setVisible(true);
	}

	public JLabel addEntity(char c, boolean loseGame) {
		JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		// label.setPreferredSize(new Dimension(50, 50));
		switch (c) {
		case '•':
			label.setBackground(Color.decode("#def5e5"));
			break;
		case 'P':
			if (!loseGame) {
				label.setBackground(Color.decode("#ffd54f"));
			} else {
				label.setBackground(Color.decode("#FCAACF"));
				label.setText("<html>You Lose. Loser!<br/>Back to where you<br/>started!</html>");
			}
			break;
		case 'E':
			label.setBackground(Color.black);
			label.setForeground(Color.white);
			label.setText("Enemy");
			break;
		case 'T':
			label.setBackground(Color.decode("#FAD6A5"));
			label.setText("Treasure");
			break;
		}
		label.setOpaque(true);
		label.setBorder(BorderFactory.createLineBorder(Color.decode("#8EC3B0"), 2));
		return label;
	}

	public void setLoseGame(boolean val) {
		this.loseGame = val;
	}

}
