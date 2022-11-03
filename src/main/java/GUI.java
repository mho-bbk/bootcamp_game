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

	
	JFrame window = new JFrame("Treasure Hunt");
	final JTextField visual_input = new JTextField(2);
	JButton enter = new JButton("Enter");
	String answer;
	
	//init_window(newGrid, gridSizeAsInt);
	
	
    public void winGame(String name) {
        window.getContentPane().removeAll();
        window.repaint();
        JLabel win = new JLabel();
        win.setText(name + " won. I love cheeseburgers.");
        window.add(win);
        window.pack();
        window.setVisible(true);
    }

   // GUI Handler
    public void init_window(GridController grid, int gridSize) {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(gridSize, gridSize));
        window.setLocationRelativeTo(null);
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


    public void update(GridController grid, int gridSize) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                JLabel label = addEntity(grid.grid[i][j]);
                window.add(label);
            }
        }
        window.repaint();
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

}
