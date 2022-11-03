
import java.util.ArrayList;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {

	Scanner inp = new Scanner(System.in);

    Enemy enemy;
    ArrayList<String> enemies = new ArrayList<>();
    int numOfEnemies;
   
	final String winMessage = "You've won the game!";
	final String loseMessage = "My G, you've bumped into a monster...and been eaten! Game over.";
	

    public Run() {
    	
    	boolean finished = false;
    	final Treasure TREASURE;
    	
        String userGridSize = getInput("Enter the grid size: ");
        int gridSizeAsInt = 0;
        
        try {
        	gridSizeAsInt = Integer.parseInt(userGridSize);
        } catch (Exception e) {
        	System.out.println("You did not enter an integer :( Try again.");
        }
        
        if(gridSizeAsInt != 0) {
	        // GENERATE GRID
	        GridController newGrid = new GridController(gridSizeAsInt);
	        // GENERATE TREASURE
	        TREASURE = new Treasure(gridSizeAsInt);
	        
	        //TODO
	        // GENERATE ENEMIES
	        enemy = new Enemy("Gerard", gridSizeAsInt);
//	        numOfEnemies = Integer.parseInt(userGridSize)*2; // E.G. grid size is 5x5 (= 25) so number of enemies = 10
	        
	        // ADD PLAYER
	        String playerName = getInput("What's your name?: ");
	        Player p = new Player(playerName, gridSizeAsInt);
	        newGrid.setPosition(p);
	        
	        System.out.println("Hello " + p.getName());
	        System.out.println("Grid of size "+userGridSize+" x "+userGridSize+" created.");
	        newGrid.printGrid();
	        
	        // CHECK PLAYER DOESN'T SPAWN IN SAME SQ AS TREASURE
	        if(TREASURE.checkWin(p)) {
	        	System.out.println(winMessage);
	        	// GUI Win Game message
	        	//winGame(p.getName());
	        	finished = true;
	        } else if (enemy.checkWin(p)) {
	        	// CHECK PLAYER DOESN'T SPAWN IN SAME SQ AS ENEMY
	        	System.out.println(loseMessage);
	        	finished = true;
	        } else {
	        	System.out.println("The treasure is somewhere...");
	        }
	        
	        // Create GUI Screen
	        // init_window(newGrid, gridSizeAsInt);
	        
	        // BEGIN PLAYER MOVES
	        while(!finished) {
	//	        System.out.println("Inside loop");
		        
	        	String move = getInput("Where do you want to go (U,D,L,R)? or press X to exit ");
		        
		        switch(move.toUpperCase()) {
			        case "U": p.moveUp(); break;
			        case "D": p.moveDown(); break;
			        case "L": p.moveLeft(); break;
			        case "R": p.moveRight(); break;
			        case "X": finished = true; break;
		        }
		        
		        newGrid.setPosition(p);
		        // Initiate GUI
		        // init_window(newGrid, gridSizeAsInt);
		        
		        // Display grid in console
		        newGrid.printGrid();
		        
		        //Don't check if just exiting
		        if(!move.toUpperCase().equals("X")) {
		        	//Check treasure
			        if(TREASURE.checkWin(p)) {
			        	System.out.println(winMessage);
			        	// GUI Win Game Message
			        	//winGame(p.getName());
			        	finished = true;
			        } else if (enemy.checkWin(p)) {
			        	// CHECK PLAYER DOESN'T SPAWN IN SAME SQ AS ENEMY
			        	System.out.println(loseMessage);
			        	finished = true;
			        } else {
			        	System.out.println(TREASURE.compareDistanceFromPrevious(p));
			        }
			        
		        }
	        }
	        
	        System.out.println(p.getName() + " has finished the game.");
	     
        } else {
        	System.out.println("Remember your grid size has to be greater than 0 :(");
        }
        

   }
	
	// input handler console
	private String getInput(String s) {
		System.out.println(s);
		// TODO - input validation
		String ans = inp.next();
		return ans;

	}
    



}
