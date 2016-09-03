package Day6;
/**
 * 
 */


/**
 * @author bineetsharma
 *
 */
/**
 * @author bineetsharma
 *
 */
public class FancyOOPBox extends OOPBox {
	private String fillStr = " "; 
	
	/**
	 * default constructor
	 */
	public FancyOOPBox() {
	}

	/**
	 * @param fillStr
	 */
	public FancyOOPBox(String fillStr) {
		super();
		this.fillStr = fillStr;
	}

	/**
	 * @param vSize
	 * @param hSize
	 * @param hStr
	 * @param vStr
	 * @param fillStr
	 */
	public FancyOOPBox(int vSize, int hSize, String hStr, 
			        String vStr, String fillStr) {
		super(vSize, hSize, hStr, vStr); //send it to super
		this.fillStr = fillStr;
	}
	/**
	 * @return the fillStr
	 */
	public String getFillStr() {
		return fillStr;
	}

	/**
	 * @param fillStr the fillStr to set
	 */
	public void setFillStr(String fillStr) {
		this.fillStr = fillStr;
	}
	
	//drawFilledVLine has a parameter passed to it, instead of using
	//instance variable fillStr  
	//In this case, it is done 'by design'.  Because, the method is public
	//and it can be called by the user to draw a filled vertical like without
	//setting the fill character first.
	public void drawFilledVLine(String fillStr) {
		//must preserve hSize
		int temphSize = gethSize();
		sethSize(temphSize-2); //reduce by two for two outer surrounding characters

		//must preserve the vStr of base class
		String tempVString = getvStr();
		String tempHString = gethStr();
		sethStr(fillStr); 		// set the hStr of base class 
		int i = 0;
		while (i++ < getvSize() - 2) {
			System.out.print(tempVString);
			drawHLine();
			System.out.println(tempVString);
		}
		setvStr(tempVString); 	// now that all done, reset the base
		sethStr(tempHString); 	// now that all done, reset the base
		sethSize(temphSize); 	//reduce by two for two outer surrounding characters
	}

	//Overrides the drawYourself of OOPBox
	public void drawYourself() {
		drawHLine();             //uses the drawHLine of OOPBox
		System.out.printf("\n"); //new line is not drawn by drawHLine
		//now comes the trick of using filled string
		drawFilledVLine(fillStr); //don't call the OOPBox method, call yours
		drawHLine();
		System.out.printf("\n");
	}
	
	//it super size proportionately, does not alter the size;
	public void drawSuperSize(double howBig) {
		int tempvSize = getvSize ();
		int temphSize = gethSize();
		setvSize((int)(getvSize () * howBig));
		sethSize((int)(gethSize () * howBig));
		drawYourself();
		//reset them
		setvSize(tempvSize);
		sethSize(temphSize);
	}

	//by default draws double the old size
	public void drawSuperSize() {
		drawSuperSize(2);
	}
/**
 * @param args
 */
public static void main(String[] args) {
	FancyOOPBox fBox = new FancyOOPBox(13, 5, "+", "%", "$");
	fBox.drawYourself();

	FancyOOPBox fb = new FancyOOPBox ("$");
	fb.drawYourself();	
	
	fb.drawFilledVLine("#");
}	
}