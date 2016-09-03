package Misc;
/* to print
1
12
123
1234
12345
123456
*/

public class Patterns {

	
		public static void pattern1(){
			for (int i=1;i<=6;i++){
				for (int j=1;j<=i;j++){
				System.out.print(j);
				}
			System.out.println();
			}
		}
		public static void pattern2(){
			for (int i=1;i<=6;i++){
				for(int j=6;j>=1;j--){
					System.out.print(j<=i?j+" ":" "+" ");
				}
				System.out.println();
			}
		}
		public static void pattern3(){
			for (int i=6;i>=1;i--){
				for (int j=1;j<=i;j++){
					System.out.print(j);
				}
				System.out.println();
			}
		}
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			pattern1();
			pattern2();
			pattern3();
		}

}
