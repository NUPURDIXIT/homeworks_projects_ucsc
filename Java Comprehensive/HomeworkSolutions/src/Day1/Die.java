
public class Die {
	private int sides;
	
	public Die(){
		sides=6;
	}
	
	public Die(int sides){
		this.sides=sides;
	}
	
	public void roll(){
		
		
	}
	
	public int getValue(){
		int value=(int) (Math.random()*sides);
			
		return value;
	}
}
