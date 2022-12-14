
import java.util.ArrayList;

import java.util.Scanner;

public class Run {

	GUI gui;
	
	/** DEBUG **/
	boolean debug=false;
	
	Scanner inp = new Scanner(System.in);

    public Enemy enemy;
    ArrayList<String> enemies = new ArrayList<>();
    int numOfEnemies;
    
    GameEnder gameEnder;
   
	final String winMessage = "You've won the game!";
	final String loseMessage = "My G, you've bumped into a monster...and been eaten! Game over.";
	

    public Run() {
    	
    	if(getInput("Would you like to run in debug mode? t/f: ").equalsIgnoreCase("t")) {
    		debug=true;
    		System.out.println("DEBUG MODE ENABLED");
    	} else {
    		System.out.println("GAME MODE");
    	}
    	
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
	        
	        /**	DEBUG	**/
	        GridController debugGrid = new GridController(gridSizeAsInt);
	        
	        // GENERATE ENTITIES
	        TREASURE = new Treasure(gridSizeAsInt);
	        enemy = new Enemy("Gerard", gridSizeAsInt);
	        
	        //TODO - Future features
	        //numOfEnemies = Integer.parseInt(userGridSize)*2; // E.G. grid size is 5x5 (= 25) so number of enemies = 10
	        
	        // ADD PLAYER TO GRID
	        String playerName = getInput("What's your name?: ");
	        Player p = new Player(playerName, gridSizeAsInt);
	        newGrid.setPosition(p);

	        /**	DEBUG	**/
	        debugGrid.setPosition(enemy);
	        debugGrid.setPosition(p);
	        debugGrid.setPosition(TREASURE);
	        
	        System.out.println("Hello " + p.getName());
	        System.out.println("Grid of size "+userGridSize+" x "+userGridSize+" created.");
	        
	        /**	TURN TRUE/FALSE FOR DEBUG MODE	**/
	        if(!debug) {
	        	newGrid.printGrid();
	        } else {
		        debugGrid.printGrid();
	        }
	        
	        // CREATE GUI WINDOW
	        gui = new GUI(newGrid, gridSizeAsInt);
	        
	        // CHECK PLAYER DOESN'T SPAWN IN SAME SQ AS TREASURE
	        finished = checkGameEnds(p, TREASURE, enemy);
	        if(finished) {
	        	//Player has spawned in same sq as treasure or enemy
	        	runFinishSequence(p, debugGrid, TREASURE);
	        } else {
	        	//Game not finished
	        	System.out.println("The treasure is somewhere...");
	        }
	        
	        // BEGIN PLAYER MOVES
	        while(!finished) {
	        	String move = getInput("Where do you want to go (U,D,L,R)? or press X to exit ");
		        
		        switch(move.toUpperCase()) {
			        case "U": p.moveUp(); break;
			        case "D": p.moveDown(); break;
			        case "L": p.moveLeft(); break;
			        case "R": p.moveRight(); break;
			        case "X": finished = true; break;
		        }
		        
		        // UPDATE PLAYER POSITION ON GRID
		        newGrid.setPosition(p);

		        // RE-RENDER GUI
		        gui.update(newGrid);
		        
		        // Display grid in console
		        if(!debug) {
		        	newGrid.printGrid();
		        } else {
		        	//debugGrid.printGrid();
		        }
		        
		        //Don't check if just exiting
		        if(!move.toUpperCase().equals("X")) {
		        	//Check if game ends
		        	finished = checkGameEnds(p, TREASURE, enemy);
			        if(finished) {
			        	runFinishSequence(p, debugGrid, TREASURE);
			        } else {
			        	//Game not finished; give clue towards treasure  
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
		System.out.print(s);
		// TODO - input validation
		String ans = inp.next();
		return ans;

	}
    
    //TODO - make more extensible eg if more than one enemy/more than one treasure
    public boolean checkGameEnds(Player p, Treasure t, Enemy e) {
        if(t.checkWin(p)) {
        	gameEnder = t;
        	return true;
        } else if (e.checkWin(p)) {
        	gameEnder = e;
        	return true;
        } else {
        	return false;
        }
    }
    
    /**
     * Checks what has ended the game (treasure or enemy) then prints end msg to console.
     * @param p personalises endMessage in GUI for player
     */
    private void runFinishSequence(Player p, GridController debugGrid, Treasure t) {
    	if(gameEnder!=null) {
    		if(gameEnder instanceof Treasure) {
	        	System.out.println(winMessage);
	        	gui.winGame(p.getName(), t.getGold());
    		} else {
    			//gameEnder must be instanceof Enemy
    			gui.setLoseGame(true);
	        	gui.update(debugGrid);
	        	System.out.println(loseMessage);
    		}
    	} else {
    		System.out.println("Something's gone wrong. Tell dev: gameEnder is null");
    	}
    }
}
