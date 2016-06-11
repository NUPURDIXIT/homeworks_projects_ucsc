//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 31,2016
//Description: This program would generate 100 random integers between 0 and 9 and display the count
//			   for each number

package Homework5;

public class RandomNumberCount {

	public static void main(String[] args) {
		// Integer array to hold 100 random integers
		int[] randomNumbers=new int[100];
		
		//Integer array to hold individual occurrences of 0 to 9
		int[] counts=new int[10];
		
		//Initializing the count of 0 to 9 to zero
		for(int i=0;i<10;i++){
			counts[i]=0;
		}
		
		//list of generated random numbers
		for (int i=0;i<100;i++){
			randomNumbers[i]=(int)(Math.random()*10);
			System.out.println("Generated Random numbers are \n"+randomNumbers[i]);
		}
		
		//Run the loop from 0 to 99 and increase the count of respective indices as and when the number is encountered 
		for(int i=0;i<100;i++){
			switch(randomNumbers[i]){
				case 0:
					counts[0]++;
					break;
				case 1:
					counts[1]++;
					break;
				case 2:
					counts[2]++;
					break;
				case 3:
					counts[3]++;
					break;
				case 4:
					counts[4]++;
					break;
				case 5:
					counts[5]++;
					break;
				case 6:
					counts[6]++;
					break;
				case 7:
					counts[7]++;
					break;
				case 8:
					counts[8]++;
					break;
				case 9:
					counts[9]++;
					break;
			}
			
		}
			
		//Print the count of occurrences of each number from 0 to 9
		System.out.println("The count of 0's is: "+ counts[0]);
		System.out.println("The count of 1's is: "+ counts[1]);
		System.out.println("The count of 2's is: "+ counts[2]);
		System.out.println("The count of 3's is: "+ counts[3]);
		System.out.println("The count of 4's is: "+ counts[4]);
		System.out.println("The count of 5's is: "+ counts[5]);
		System.out.println("The count of 6's is: "+ counts[6]);
		System.out.println("The count of 7's is: "+ counts[7]);
		System.out.println("The count of 8's is: "+ counts[8]);
		System.out.println("The count of 9's is: "+ counts[9]);
		
	}

}
	