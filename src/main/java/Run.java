
import java.util.ArrayList;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {

	// NEW
	GUI gui;
	
	/** DEBUG	**/
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

	        /**	DEBUG	**/
	        debugGrid.setEnemyPosition(enemy);
	        debugGrid.setPosition(p);
	        debugGrid.setTreasurePosition(TREASURE);
	        
	        System.out.println("Hello " + p.getName());
	        System.out.println("Grid of size "+userGridSize+" x "+userGridSize+" created.");
	        
	        /**	TURN TRUE/FALSE FOR DEBUG	**/
	        if(!debug) {
	        	newGrid.printGrid();
	        } else {
		        debugGrid.printGrid();
	        }
	        

	        
	        // NEW
	        gui = new GUI(newGrid, gridSizeAsInt);
	        
	        // CHECK PLAYER DOESN'T SPAWN IN SAME SQ AS TREASURE
	        finished = checkGameEnds(p, TREASURE, enemy);
	        if(finished) {
	        	//Player has spawned in same sq as treasure or enemy
	        	runFinishSequence(p);
	        } else {
	        	//Game not finished
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
		        
		        // NEW
		        gui.update(newGrid);
		        
		        // Initiate GUI
		        // init_window(newGrid, gridSizeAsInt);
		        
		        // Display grid in console
		        newGrid.printGrid();
		        
		        //Don't check if just exiting
		        if(!move.toUpperCase().equals("X")) {
<<<<<<< HEAD
		        	//Check treasure
			        if(TREASURE.checkWin(p)) {
			        	System.out.println(winMessage);
			        	// Win Game Message
			        	gui.winGame(p.getName());
			        	finished = true;
			        } else if (enemy.checkWin(p)) {
			        	// CHECK PLAYER DOESN'T SPAWN IN SAME SQ AS ENEMY
			        	System.out.println(loseMessage);
			        	gui.setLoseGame(true);
			        	gui.update(debugGrid);
			        	finished = true;
=======
		        	//Check if game ends
		        	finished = checkGameEnds(p, TREASURE, enemy);
			        if(finished) {
			        	runFinishSequence(p);
>>>>>>> b54faa94c6100341f609a145645af6f22fc1dc43
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
		System.out.println(s);
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
    private void runFinishSequence(Player p) {
    	if(gameEnder!=null) {
    		if(gameEnder instanceof Treasure) {
	        	System.out.println(winMessage);
//	        	gui.winGame(p.getName());
    		} else {
    			//gameEnder must be instanceof Enemy
	        	System.out.println(loseMessage);
    		}
    	} else {
    		System.out.println("Something's gone wrong. Tell dev: gameEnder is null");
    	}
    }


}
