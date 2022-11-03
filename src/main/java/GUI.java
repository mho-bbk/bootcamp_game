import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
		update(grid);
	}

	public void winGame(String name) {
		window.getContentPane().removeAll();
		window.repaint();
		JLabel win = new JLabel();
		win.setText(name + " won. I love cheeseburgers.");
		win.setHorizontalAlignment(JLabel.CENTER);
		win.setVerticalAlignment(JLabel.CENTER);
		window.add(win);
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
