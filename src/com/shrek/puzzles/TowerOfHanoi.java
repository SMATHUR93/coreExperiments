package com.shrek.puzzles;

public class TowerOfHanoi {

    public static void main(String[] args) {
        towerOfHanoi(3, 'A', 'C', 'B');
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

}
