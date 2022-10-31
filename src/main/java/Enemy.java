
public class Enemy extends Player {
	private String message;
	private char symbol = 'X';

	public Enemy(String name, int gridSize) {
		super(name, gridSize);
	}

	public String getName() {
		return super.getName();
	}

	public void setName(String name) {
		super.setName(name);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
