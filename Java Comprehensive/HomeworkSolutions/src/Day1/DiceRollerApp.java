import java.util.Scanner;

public class DiceRollerApp {
	String message;
	PairOfDice p=new PairOfDice();
	
	public void getMessage(){
		p.roll();
		
		System.out.println("sum is "+p.getSum());
		if(p.getSum()==7){
			message="Craps!";
		}
		
		else if(p.getValue1()==1 && p.getValue2()==1){
			message="Snake eyes!";
		}
		
		else if(p.getValue1()==6 && p.getValue2()==6){
			message="Box cars!";
		}
		else message="";
		
		System.out.println(p.getValue1()+"\n"+p.getValue2()+"\n"+message);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		DiceRollerApp objApp=new DiceRollerApp();
		String choice="";
		int count=0;
		System.out.println("Welcome to the Paradise Roller Application");
		System.out.println();
		choice=Validator.getChoice(sc, "Roll the dice? (y/n): ");
		while(choice.equalsIgnoreCase("y")){
			
			System.out.println("Roll"+ ++count);
			
			objApp.getMessage();
			choice=Validator.getChoice(sc, "Roll the dice? (y/n): ");
			System.out.println();
			
		}
	}

}
