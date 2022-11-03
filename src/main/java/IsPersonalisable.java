

class IsPersonalisable {
	public char symbol;
	String name;
	String message = "";
	
	public IsPersonalisable() {
		//empty constructor
	}
	
	public IsPersonalisable(String name, char sym) {
		setName(name);
		setSymbol(sym);
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
   
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
