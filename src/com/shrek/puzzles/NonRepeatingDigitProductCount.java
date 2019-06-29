package com.shrek.puzzles;

import java.io.IOException;

public class NonRepeatingDigitProductCount {

    // Complete the nonRepeatingDigitProductCount function below.
    static int nonRepeatingDigitProductCount(int x, int y, int z) {
    	int repeatingDigitProductCount = 0;
    	for(int i=y;i<=z;i++) {
    		int prod = Math.abs(x*i);
    		String prodStr = Integer.toString(prod);
    		String iStr = Integer.toString(Math.abs(i));
    		System.out.println(prodStr+"====="+iStr);
    		char[] multipleCharArray = Integer.toString(i).toCharArray();
    		for(int j=0;j<multipleCharArray.length;j++) {
    			if(prodStr.indexOf(multipleCharArray[j])!=-1) {
    				System.out.println("CATCH AT "+prodStr.indexOf(multipleCharArray[j]));
    				repeatingDigitProductCount++;
    				break;
    			}
    		}
    	}
    	return (((z-y)+1)-repeatingDigitProductCount);
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int x = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int y = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int z = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int res = nonRepeatingDigitProductCount(x, y, z);
//
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    	
    	int x = -2;
        int y = -2;
        int z = 2;
        int res = nonRepeatingDigitProductCount(x, y, z);
        System.out.println(res);
    }
}