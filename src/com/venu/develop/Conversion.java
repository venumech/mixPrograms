package com.venu.develop;

public class Conversion {

	  private static char[] digits;

	/**
	    * Convert a base-10 integer to an 8-bit two's complement binary number, 
	    * and  return the binary number.
	 * @throws Exception 
	   */
	/*
	 * There is a limitation for 8bit binary representation. 
	 * The range of decimal numbers which can be converted to 8bits is (2e+8 -1) to -2e+8
	 */

	  static int maxValue = 255; //allowed max decimal
	  static int minValue = -256;//allowed min decimal
	  
	  /* 
	   * Handling positive decimal numbers.
	   */	 
	  public String base10to2(int n) throws Exception {

		 // int n = Integer.valueOf(base10);
		  
		  if (n < 0 || n > maxValue)
			  throw new Exception ("the input number exceeds the allowable limits");
	    
		  String binaryStr = Integer.toBinaryString(n);
	    
	    //pad the above string to make it to 8 bits representation
	    //if positive number, the most significant bit is 0, else 1
	    if (n>0)
	    	binaryStr= String.format("%8s", binaryStr).replace(' ', '0');
	    else{
	    	binaryStr = Integer.toBinaryString((-1)*n);
	    	
	    	binaryStr= String.format("%8s", binaryStr).replace(' ', '0');
	    	binaryStr = get2sComplement(binaryStr);
	    }
	    return binaryStr;
	   }
	  
	  /* 
	   * Handling negative decimal numbers.
	   */	  
	  public  String negBase2(int n) throws Exception {
		  String binaryStr="";

		  int minValue = -256;//allowed min decimal
		// donot allow positive numbers and make sure the 
		// input number is > allowed min value for 8 bit representation
		  if (n>0 || n < minValue) 
			  throw new Exception ("the input number exceeds the allowable limits");
			  
		  binaryStr = Integer.toBinaryString((-1)*n);
	    	
	    	binaryStr= String.format("%8s", binaryStr).replace(' ', '0');
	    	binaryStr = get2sComplement(binaryStr);
		  return binaryStr;
	  }
	  /*
	   * 2's complement for a given binary number is its negative counterpart
	   */
	public  String get2sComplement(String binaryVal) {
		String onesComp = new String();
		String twosComp = new String();
		char carry = '0';
		int i;
		// finding one's complement--------------------------------
		for (i = 0; i < binaryVal.length(); i++) {
			if (binaryVal.charAt(i) == '0')
				onesComp = onesComp + "1";
			else
				onesComp = onesComp + "0";
		} 
		
		//finding the 2's complement. adding '1' to the binary(which is 1's complement)
		char lsb = onesComp.charAt(onesComp.length() - 1);
		if (lsb == '1') {
			twosComp = "0" + twosComp;
			carry = '1';
		} else
			twosComp = "1" + twosComp;
		for (i = onesComp.length() - 2; i >= 0; i--) {
			char digit = onesComp.charAt(i);
			if (carry == '0' && digit == '0')
				twosComp = "0" + twosComp;
			else if (carry == '0' && digit == '1')
				twosComp = "1" + twosComp;
			else if (carry == '1' && digit == '0') {
				twosComp = "1" + twosComp;
				carry = '0';
			} else {
				twosComp = "0" + twosComp;
				carry = '1';
			}
		}
		return twosComp;
		  }

	 	
	public static void main(String[] args) throws Exception {
		
		if (args.length != 1) {
			System.out.println("provide at least 1 valid number in the range of 255 to -256");
			System.exit(0);
		}
		
		String input = args[0];
		int n = 0;
		if (input.trim() ==""){
			System.out.println("provide at least 1 valid number in the range of 255 to -256");
			System.exit(0);
		} else {
			try{
				n=Integer.parseInt(input);
			}catch (NumberFormatException e){
						System.out.println(input +", It is not a valid number. exiting!");
						System.exit(0);
					}
		}
		
		  if (n < minValue || n > maxValue)
			  throw new Exception ("the input number exceeds the allowable limits");
		
		Conversion c = new Conversion();
		try{
			String binaryStr = "";
			if (n>=0)
				binaryStr = c.base10to2(n);
			else
				binaryStr = c.negBase2(n);

			System.out.printf("binaryStr of %d =  %s \n" ,n, binaryStr);
		} catch (Exception e){
			System.out.println( e.toString());
		}
		
	}

}
