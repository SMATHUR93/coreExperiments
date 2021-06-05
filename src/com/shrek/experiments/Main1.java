package com.shrek.experiments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main1 {

    public static void main(String[] args) {
        char a = 'a';
        System.out.println((long)a);
        System.out.println(fact(4));
        towerOfHanoi(3, 'A', 'C', 'B');

        /*String str1 = "sam";
        String str2 = "shreymathur";
        int m = str1.length();
        int n = str2.length();
        boolean res = isSubSequence(str1, str2, m, n);
        if (res)
            System.out.println("Yes");
        else
            System.out.println("No");*/


        /*String str = "you got beautiful eyes";
        char[] arr = str.toCharArray(); // i amshrey mtu;
        System.out.println(arr);
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        StringBuffer ops = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey((Character) arr[i])){
                map.remove(arr[i]);
            } else{
                map.put((Character) arr[i], 1);
                ops.append(arr[i]);
            }
        }
        System.out.println(ops);*/

        /*int[] ip = {2,4,6,8};
        Arrays.sort(ip);
        System.out.println((ip[ip.length-1]-ip[0]));*/


    }

    static boolean isSubSequence(String str1, String str2, int m, int n){
        int j = 0;
        for (int i = 0; i < n && j < m; i++){
            System.out.println(str1.charAt(j) + " :: " + str2.charAt(i));
            if (str1.charAt(j) == str2.charAt(i)){
                j++;
            }
        }
        return (j == m);
    }

    static int towerOfHanoiStepsCount = 0;

    public static void towerOfHanoi(int n, char fromPeg, char toPeg, char auxPeg){
        if(n==1){
            towerOfHanoiStepsCount++;
            System.out.println(towerOfHanoiStepsCount + " : POM Moving disc 1 from "+ fromPeg + " to " + toPeg);
            return;
        }
        towerOfHanoi(n-1, fromPeg, auxPeg, toPeg);
        towerOfHanoiStepsCount++;
        System.out.println(towerOfHanoiStepsCount + " : Moving disc "+n+" from "+ fromPeg + " to " + toPeg);
        towerOfHanoi(n-1, auxPeg, toPeg, fromPeg);
    }

    public static int fact(int num){
        if(num>1){
            // System.out.println(num);
            return num * fact(num-1);
        } else{
            return 1;
        }
    }

}

class A{
    A(){}
    A(String name){

    }
}

class B extends A{
    B(){
        super();
    }
    B(String name, String name2){
        super();
    }
}

