
import java.util.ArrayList;
import java.util.Scanner;

public class Run {

	Scanner inp = new Scanner(System.in);
	
	final Treasure TREASURE;
	final String winMessage = "You've won the game!";
	
    ArrayList<String> enemies = new ArrayList<>();
    int numOfEnemies;
    
    public Run() {
    	
    	boolean finished = false;
        
        String userGridSize = getInput("Enter the grid size: ");
        int gridSizeAsInt = Integer.parseInt(userGridSize);
        
        // GENERATE GRID
        GridController newGrid = new GridController(gridSizeAsInt);
        // GENERATE TREASURE
        TREASURE = new Treasure(gridSizeAsInt);
        
        // ADD PLAYER
        String playerName = getInput("What's your name?: ");
        Player p = new Player(playerName, gridSizeAsInt);
        newGrid.setPosition(p);
        
        System.out.println("Hello " + p.getName());
        System.out.println("Grid of size "+userGridSize+" x "+userGridSize+" created.");
        newGrid.printGrid();
        
        if(TREASURE.checkWin(p)) {
        	System.out.println(winMessage);
        } else {
        	System.out.println("The treasure is somewhere...");
        }
        
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
	        newGrid.printGrid();
	        
	        //Check treasure
	        if(TREASURE.checkWin(p)) {
	        	System.out.println(winMessage);
	        	finished = true;
	        } else {
	        	System.out.println(TREASURE.compareDistanceFromPrevious(p));
	        }
        }
        
        System.out.println(p.getName() + " has finished the game.");
      
       
        //TODO - implement below
        // GENERATE MONSTERS
        numOfEnemies = Integer.parseInt(userGridSize)*2; // E.G. grid size is 5x5 (= 25) so number of enemies = 10
        

   }
    
    
    // input handler
    private String getInput(String s) {
        System.out.println(s);
        //TODO - input validation
        String ans = inp.next();
        return ans;
        
    }

}
