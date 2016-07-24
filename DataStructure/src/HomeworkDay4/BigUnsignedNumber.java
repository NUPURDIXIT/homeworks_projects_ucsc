package HomeworkDay4;
/**
 * File Name: BigUnsignedNumber.java 
 * Infinite capacity Unsigned Number
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
/*
 * To compile you require: BigUnsignedNumber.java CharArray.java Cstring IntUtil.java
 */

class BigUnsignedNumber {
  private Cstring d; //data
  static IntUtil u = new IntUtil();
  //Cannot add any more data fields
  
  //WRITE ALL FUNCTIONS SO THAT ALL TESTS WILL PASS
  
  //CANNOT CHANGE ANYTHING BELOW 
  
  
  private static void test1() {
    BigUnsignedNumber b = new BigUnsignedNumber(10);
  }
  
  private static void testBench() {
    System.out.println("------------test1---------------------");
    test1();
  }
  
  public static void main(String[] args) {
    System.out.println("BigUnsignedNumber.java");
    testBench();
    System.out.println("Done");
  } 
}
