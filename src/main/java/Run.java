
import java.util.ArrayList;
import java.util.Scanner;
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

public class Run {

	JFrame window = new JFrame("Treasure Hunt");
	final JTextField visual_input = new JTextField(2);
	JButton enter = new JButton("Enter");
	String answer;

	Scanner inp = new Scanner(System.in);

	final String winMessage = "You've won the game!";

	ArrayList<String> enemies = new ArrayList<>();
	int numOfEnemies;

	public Run() {

		boolean finished = false;
		final Treasure TREASURE;

		String userGridSize = getInput("Enter the grid size: ");
		int gridSizeAsInt = 0;

		// 0 grid size causes IllegalArgumentException
		try {
			gridSizeAsInt = Integer.parseInt(userGridSize);
		} catch (Exception e) {
			System.out.println("You did not enter an integer :( Try again.");
		}

		if (gridSizeAsInt != 0) {
			// GENERATE GRID
			GridController newGrid = new GridController(gridSizeAsInt);
			// GENERATE TREASURE
			TREASURE = new Treasure(gridSizeAsInt);
			// TODO
			// GENERATE ENEMIES
			numOfEnemies = Integer.parseInt(userGridSize) * 2; // E.G. grid size is 5x5 (= 25) so number of enemies = 10

			// ADD PLAYER
			String playerName = getInput("What's your name?: ");
			Player p = new Player(playerName, gridSizeAsInt);
			newGrid.setPosition(p);

			System.out.println("Hello " + p.getName());
			System.out.println("Grid of size " + userGridSize + " x " + userGridSize + " created.");
			newGrid.printGrid();

			// CHECK PLAYER DOESN'T SPAWN IN SAME SQ AS TREASURE
			if (TREASURE.checkWin(p)) {
				System.out.println(winMessage);
				finished = true;
			} else {
				System.out.println("The treasure is somewhere...");
			}
			
			init_window(newGrid, gridSizeAsInt);
			

			// BEGIN PLAYER MOVES
			while (!finished) {
				// System.out.println("Inside loop");

				String move = getGUIInput("Where do you want to go (U,D,L,R)? or press X to exit ");

				switch (move.toUpperCase()) {
				case "U":
					p.moveUp();
					break;
				case "D":
					p.moveDown();
					break;
				case "L":
					p.moveLeft();
					break;
				case "R":
					p.moveRight();
					break;
				case "X":
					finished = true;
					break;
				}

				newGrid.setPosition(p);
				//newGrid.printGrid();
		        update(newGrid, gridSizeAsInt);

				// Check treasure
				if (TREASURE.checkWin(p)) {
					System.out.println(winMessage);
					finished = true;
				} else {
					System.out.println(TREASURE.compareDistanceFromPrevious(p));
				}
			}

			//System.out.println(p.getName() + " has finished the game.");
			winGame(p.getName());
			

		} else {
			System.out.println("Remember your grid size has to be greater than 0 :(");
		}

	}
	
	public void winGame(String name) {
		window.getContentPane().removeAll();
		window.repaint();
		JLabel win = new JLabel();
		win.setText(name + " won. He loves cheeseburgers.");
		window.add(win);
		window.pack();
		window.setVisible(true);
	}

	// GUI Handler
	public void init_window(GridController grid, int gridSize) {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(gridSize+1, gridSize));
		window.setLocationRelativeTo(null);
		window.getContentPane().removeAll();
		window.repaint();
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				JLabel label = addEntity(grid.grid[i][j]);
				window.add(label);
			}
		}
		window.add(visual_input);
		window.add(enter);
		window.pack();
		window.setVisible(true);
	}

	public void update(GridController grid, int gridSize) {
		window.getContentPane().removeAll();
		window.repaint();
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				JLabel label = addEntity(grid.grid[i][j]);
				window.add(label);
			}
		}
		window.pack();
		window.setVisible(true);
	}

	public JLabel addEntity(char c) {
		JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setPreferredSize(new Dimension(50, 50));
		switch (c) {
		case '•':
			label.setBackground(Color.CYAN);
			break;
		case 'P':
			label.setBackground(Color.black);
		}
		label.setOpaque(true);
		label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		return label;
	}
	
	// input handler gui
	private String getGUIInput(String s) {
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = visual_input.getText();
			}
		});
		
		return this.answer;

	}

	// input handler console
	private String getInput(String s) {
		System.out.println(s);
		// TODO - input validation
		String ans = inp.next();
		return ans;

	}

}
