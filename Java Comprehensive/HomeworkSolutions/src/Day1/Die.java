
public class Die {
	private int sides;
	private int value;
	public Die(){
		sides=6;
	}
	
	public Die(int sides){
		this.sides=sides;
	}
	
	public void roll(){
		
		value=(int) (Math.random()*sides+1);
		
	}
	
	public int getValue(){
		
		return value;
	}
}
