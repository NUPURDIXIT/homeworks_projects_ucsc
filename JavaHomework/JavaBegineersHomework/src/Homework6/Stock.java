package Homework6;

public class Stock {
	private String stockSymbol;
	private String stockName;
	private double stockPrevDayPrice;
	private double stockCurrentDayPrice;
	
	Stock(String stockSymbol,String stockName,double stockPrevDayPrice){
		this.stockSymbol=stockSymbol;
		this.stockName=stockName;
		this.stockPrevDayPrice=stockPrevDayPrice;
	}
	
	public void setCurrentPrice(double stockCurrentDayPrice){
		this.stockCurrentDayPrice=stockCurrentDayPrice;
	}
	
	public double getChangePercent(){
		double percentChange=((stockCurrentDayPrice-stockPrevDayPrice)/stockPrevDayPrice)*100;
		percentChange=(int)(percentChange*100)/100.0;
		return percentChange;
	}

}
