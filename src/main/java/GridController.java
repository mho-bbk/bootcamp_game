
public class GridController {
	
	 //Assume square grid
    private int gridSize;
    public char[][] grid;
    
    public GridController(int size) {
        this.gridSize = size;
        grid = new char[gridSize][gridSize];
        fillGrid();
    }

   public void fillGrid() {
       int i,j=1;
       char k = '•';

       for(i=0;i<gridSize;i++) {
            for(j=0;j<gridSize;j++) {
                grid[i][j]=k;
            }
        }
    }
    
    public int getGridSize() {
        return gridSize;
    }

   public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }
   
   public void setPosition(Player player) {
	   if(player.getPreviousPosition() != null) {
		   
		   int oldRow = player.getPreviousPosition().getRow();
		   int oldCol = player.getPreviousPosition().getCol();
		   
//		   System.out.println(oldRow + ", " + oldCol);
		   
		   grid[oldRow][oldCol] = '•';
	   }
	   
	   int playerRowPos = player.getCurrentPosition().getRow();
	   int playerColPos = player.getCurrentPosition().getCol();
	   
	   grid[playerRowPos][playerColPos] = player.getSymbol();
   }
   
   public void printGrid() {
       for(char[] row : grid) { 
	        for (char c : row) {
	            System.out.print(c);
	            System.out.print("\t");
	        }
	        System.out.println();
	    }
   }
   
   public void setPosition(GameEnder gameEnder) {
	   grid[gameEnder.getPosition().getRow()][gameEnder.getPosition().getCol()] = gameEnder.getSymbol();
   }
}
