import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Circle {

	private double radius;
	static int objectCount;
	
	public Circle(){
		radius=0.0;
	}
	public Circle(double radius){
		this.radius=radius;
	}
	
	public double getCircumference(){
		double circumference=0.0;
		circumference=2*Math.PI*radius;
		return circumference;
		
	}
	
	public String getFormattedCircumference(){
		DecimalFormat formattedCircumference=new DecimalFormat("#.00");
		return formattedCircumference.format(this.getCircumference());
	}
	
	public double getArea(){
		double area=0.0;
		area=Math.PI*radius*radius;
		return area;
	}
	
	public String getFormattedArea(){
		DecimalFormat formattedArea=new DecimalFormat("#.00");
		return formattedArea.format(this.getArea());
	}
	
	public static int getObjectCount(){
		objectCount++;
		return objectCount;
	}
	
	
}
