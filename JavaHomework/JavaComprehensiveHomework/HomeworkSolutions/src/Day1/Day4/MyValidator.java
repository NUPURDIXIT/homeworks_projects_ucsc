package Day4;

public class MyValidator extends OOValidator {
	
	public MyValidator(){
		super();
	}
	
	public String getRequiredString(String prompt){
		System.out.print(prompt);
		boolean flag=false;
		String s="";
		while (flag==false){
	       s = sc.nextLine();  // read user entry
	        //sc.nextLine();  // discard any other data entered on the line
	        if(s.equals("")){
	        	System.out.println("Error! This entry is requred. Try again");
	        }
	        else{
	        	flag=true;
	        }
		}
	    return s;
	}
	
	public String getChoiceString(String prompt,String s1,String s2){
		boolean flag=false;
    	String choice=null;
    	while(flag==false){
    		System.out.print(prompt);
	        choice = sc.next();  // read user entry
	        
	        sc.nextLine(); // discard any other data entered on the line
	        if(choice.equalsIgnoreCase(s1) || choice.equalsIgnoreCase(s2) ){
	        	flag=true;
	        }
	        else{
	        	System.out.println("Error! Entry must be '"+s1+"' or '"+s2+"'.Try again");
	        }
	       
    	}
        return choice;
	}
}
