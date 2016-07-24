package Day3;

public class PairOfDice {
	Die objDice1;
	Die objDice2;
	int sumOfDice;
	int sides;
	
	
	
	public PairOfDice(){
		this.objDice1=new Die(6);
		this.objDice2=new Die(6);
		this.sides=6;
	}
	
	
	public PairOfDice(Die objDice1,Die objDice2,int sides){
		this.objDice1= objDice1;
		this.objDice2=objDice2;
		this.sides=sides;
	}
	
	public void roll(){
		objDice1.roll();
		objDice2.roll();
		
	}
	
	public int getValue1(){
		//System.out.println("PAIR OF DICE value 1 is:"+ objDice1.getValue());
		return objDice1.getValue();
	}
	
	public int getValue2(){
		//System.out.println("PAIR OF DICE value 2 is:"+ objDice2.getValue());
		return objDice2.getValue();
	}
	
	public int getSum(){
		
		sumOfDice=getValue1()+getValue2();
		return sumOfDice;
	}
}
