package Homework6;
public class TestStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock objStock=new Stock("ORCL","Oracle Corporation",34.5);
		objStock.setCurrentPrice(36.56);
		System.out.print("Percent change in the stockprice is :"+objStock.getChangePercent()+"%");
		
		}

}
