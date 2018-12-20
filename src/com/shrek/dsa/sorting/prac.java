package com.shrek.dsa.sorting;

public class prac {

	static void findRepeatCharacters(String a) {

	    char[] charArr=a.toCharArray();
	    int aLen = a.length();
	    char[] uniqueArr = new char[aLen];
	    int[] countArr = new int[aLen];    
	    for(int i=0;i<aLen;i++){
	        uniqueArr[i] = ' ';
	        countArr[i] = 0;
	    }
	    uniqueArr[0] = charArr[0]; 
	    countArr[0] = 1;
	    int len=1;
	    for(int i=1;i<aLen;i++){
	        int j=0;
	        for(j=0;j<len;j++){
	            //System.out.println(charArr[i]+" yolo  "+uniqueArr[j]);
	            if(charArr[i]==uniqueArr[j]){
	                countArr[j]++;
	                break;
	            }
	        }
	        if(j==len){
	//System.out.println(charArr[i]+" swag found  "+uniqueArr[j]);           
	            uniqueArr[j]=charArr[i];
	            countArr[j]++;
	            len++;
	        }        
	    }

	    // for(int i=0;i<aLen;i++){
	    //    System.out.println(charArr[i]+" Bello  ");
	    //}
	    
	    for(int i=0;i<len;i++){
	        if(countArr[i]>1){
	          System.out.println(uniqueArr[i]);  
	        }
	        //System.out.println(uniqueArr[i]+" Hello  "+countArr[i]);
	    }
	    
	}

	////



	
}
