
public class SalesReport {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] salesFigures=new double[4][4];
		double salesByRegion1=0;
		double salesByRegion2=0;
		double salesByRegion3=0;
		double salesByRegion4=0;
		salesFigures[0][0]=1540;salesFigures[0][1]=2010;salesFigures[0][2]=2450;salesFigures[0][3]=1845;
		salesFigures[1][0]=1130;salesFigures[1][1]=1168;salesFigures[1][2]=1847;salesFigures[1][3]=1491;
		salesFigures[2][0]=1580;salesFigures[2][1]=2305;salesFigures[2][2]=2710;salesFigures[2][3]=1284;
		salesFigures[3][0]=1105;salesFigures[3][1]=4102;salesFigures[3][2]=2391;salesFigures[3][3]=1576;
		for(int i=0;i<salesFigures.length;i++){
			for(int j=0;j<salesFigures[i].length;j++){
				salesByRegion1+=salesFigures[0][j];
				if(i>0)break;
				
			}
		}
		for(int i=1;i<salesFigures.length;i++){
			for(int j=0;j<salesFigures[i].length;j++){
				
				salesByRegion2+=salesFigures[1][j];
				if(i>1)break;
				
			}
		}
		for(int i=2;i<salesFigures.length;i++){
			for(int j=0;j<salesFigures[i].length;j++){
				
				salesByRegion3+=salesFigures[2][j];
				if(i>2)break;
			
			}
		}
		for(int i=3;i<salesFigures.length;i++){
			for(int j=0;j<salesFigures[i].length;j++){
			
				salesByRegion4+=salesFigures[3][j];
				if(i>3)break;
			}
		}
		System.out.println("Sales by rgion is");
		System.out.println("Region 1: "+salesByRegion1);
		System.out.println("Region 2: "+salesByRegion2);
		System.out.println("Region 3: "+salesByRegion3);
		System.out.println("Region 4: "+salesByRegion4);
		

	}

}
