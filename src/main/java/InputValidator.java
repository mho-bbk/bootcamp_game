

public class InputValidator {
	
	public InputValidator() {
		//empty
	}
	
	/**
	 * Method used to check the grid size is valid.
	 * According to game rules, grid has to be:
	 * + Convertible to integer AND
	 * + > 0 
	 * There is no max gridSize.
	 * @param str 
	 */
	public static boolean checkValidGridSize(String str) {
		boolean valid = false;
		int gridSize = 0;
		
        // 1.Check that str is convertible to int
		try {
        	gridSize = Integer.parseInt(str);
        } catch (Exception e) {
        	//do nothing
        }
        
        // 2.Check > 0
        if(gridSize > 0) {
        	valid = true;
        } 
        
		return valid;
	}
	
	/**
	 * Check that the user's move is valid.
	 * According to game rules, user can only input:
	 * + U - to go up
	 * + D - to go down
	 * + L - to go left
	 * + R - to go right
	 * + X - to exit
	 * @param str
	 * @return
	 */
	public static boolean checkValidMove(String str) {
		//TODO
		return false;
	}

}
