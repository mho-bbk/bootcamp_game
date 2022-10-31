
public class Player {
	private String name;
	private Coordinate currentPos = new Coordinate();
    private Coordinate previousPos;
	private char symbol = 'P';
	int gridSize;
	
	public Player(String name, int gridSize) {
		this.name = name;
		currentPos.randomise(gridSize);
		this.gridSize = gridSize;
	}
	
   public String getName() {
        return name;
    }

   public void setName(String name) {
        this.name = name;
    }
   
   public char getSymbol() {
	   return this.symbol;
   }
   
   public void setSymbol(char c) {
	   this.symbol = c;
   }
   
   public Coordinate getCurrentPosition() {
	   return this.currentPos;
   }
   
   public Coordinate getPreviousPosition() {
	   return this.previousPos;
   }
   
   public boolean moveRight() {
	   previousPos = new Coordinate(currentPos.getRow(), currentPos.getCol());
	   
	   if(currentPos.getCol()+1 < gridSize) {
		   currentPos.setCol(currentPos.getCol()+1);
		   return true;
	   } else {
		   return false;
	   }
   }
   
   public boolean moveLeft() {
	   previousPos = new Coordinate(currentPos.getRow(), currentPos.getCol());
	   
	   if(currentPos.getCol()-1 >= 0) {
		   currentPos.setCol(currentPos.getCol()-1);
		   return true;
	   } else {
		   return false;
	   }
   }
   
   public boolean moveUp() {
	   previousPos = new Coordinate(currentPos.getRow(), currentPos.getCol());
	   
	   if(currentPos.getRow()-1 >= 0) {
		   currentPos.setRow(currentPos.getRow()-1);
		   return true;
	   } else {
		   return false;
	   }
   }
   
   public boolean moveDown() {
	   previousPos = new Coordinate(currentPos.getRow(), currentPos.getCol());
	   
	   if(currentPos.getRow()+1 < gridSize) {
		   currentPos.setRow(currentPos.getRow()+1);
		   return true;
	   } else {
		   return false;
	   }
   }

}
