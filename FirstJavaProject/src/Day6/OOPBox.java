package Day6;

public class OOPBox {

	//instance variables, must be private
	private int 		vSize = 10;
	private int 		hSize = 20;
	private String 	hStr = "*";
	private String 	vStr = "*";
	private String  myName = "I am a Box"; 
	
	/**
	 * @return the myName
	 * Concatenates the name of IShape
	 */
	public String getMyName() {
		return myName + " ";
	}

	/**
	 * @param myName the myName to set
	 */
	public void setMyName(String myName) {
		this.myName = myName;
	}

	/**
	 * Must provide a default constructor so that we can make a call like this
	 * OOPBox oopBox = new OOPBox();
	 */
	public OOPBox() {
		super();
	}

	/**
	 * @param vSize
	 */
	public OOPBox(int vSize) {
		super();
		this.vSize = vSize;
	}
	/**
	 * @param vSize
	 * @param hSize
	 */
	public OOPBox(int vSize, int hSize) {
		super();
		this.vSize = vSize;
		this.hSize = hSize;
	}

	/**
	 * @param hStr
	 * @param vStr
	 */
	public OOPBox(String hStr, String vStr) {
		super();
		this.hStr = hStr;
		this.vStr = vStr;
	}

	/**
	 * @param vSize
	 * @param hSize
	 * @param hStr
	 * @param vStr
	 */
	public OOPBox(int vSize, int hSize, String hStr, String vStr) {
		super();
		this.vSize = vSize;
		this.hSize = hSize;
		this.hStr = hStr;
		this.vStr = vStr;
	}

	public OOPBox(int vSize, int hSize, String hStr, String vStr, String name) {
		super();
		this.vSize = vSize;
		this.hSize = hSize;
		this.hStr = hStr;
		this.vStr = vStr;
		this.myName = name;
	}
	public String toString() {
		return "OOPBox [name = " + getMyName() + ", vSize=" + vSize + ", hSize=" + hSize + ", hStr=" + hStr
				+ ", vStr=" + vStr + "]";
	}

	/**
	 * @return the vSize
	 */
	public int getvSize() {
		return vSize;
	}
	/**
	 * @param vSize the vSize to set
	 */
	public void setvSize(int vSize) {
		this.vSize = vSize;
	}
	/**
	 * @return the hSize
	 */
	public int gethSize() {
		return hSize;
	}
	/**
	 * @param hSize the hSize to set
	 */
	public void sethSize(int hSize) {
		this.hSize = hSize;
	}
	/**
	 * @return the hStr
	 */
	public String gethStr() {
		return hStr;
	}
	/**
	 * @param hStr the hStr to set
	 */
	public void sethStr(String hStr) {
		this.hStr = hStr;
	}
	/**
	 * @return the vStr
	 */
	public String getvStr() {
		return vStr;
	}
	/**
	 * @param vStr the vStr to set
	 */
	
	public void setvStr(String vStr) {
		this.vStr = vStr;
	}
	
	//hStr and hSize is private variables, you can directly use them
	public void drawHLine() {
		int i = 0;
		while (i++  < hSize)
			System.out.print(hStr);
	}

	//vSize, vStr, hStr are private, can use directly
	public void drawVLine() {
		int i = 0;
		//trick is to use drawHLine to draw inner hSize-2 spaces
		//problem is drawhLine uses hSize private variable, which should not be changed
		//so, you save hSize in a temp variable and reset when drawLine is done
		int temphSize = hSize;
		hSize = hSize-2; //reduce by two for two outer surrounding characters
		//  *          *
		//also in this case the drawHLine, really needs to draw a 
		//horizontal line with spaces, so, we need to do set the hStr as well
		String temphStr = hStr;
		hStr = " ";
		while (i++ < vSize - 2) {
			System.out.print(vStr);
			drawHLine();
			System.out.println(vStr);
		}
		//make sure to reset back the hSize an hStr;
		hSize = temphSize;
		hStr  = temphStr;
	}

	//The algorithm to drawYourself for Box is drawing a horizontal line first
	//followed by many vertical lines
	//then surround by last horizontal line
	public void drawYourself() {
		drawHLine();
		System.out.printf("\n"); //new line is not drawn by drawHLine
		drawVLine();
		drawHLine();
		System.out.printf("\n");
	}
}
