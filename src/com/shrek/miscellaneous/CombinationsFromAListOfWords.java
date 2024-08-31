package com.shrek.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsFromAListOfWords {

    public static void main(String[] args) {
        String[] words = new String[]{"foo","bar"};
        int len = 2;
        System.out.println("combinationsFromAListOfWords for words = "+words+" , for length = "+len+" == " + combinationsFromAListOfWords(words, len) );
        // [0,9]
        System.out.println("-------------- BREAK -----------------");
        words = new String[]{"par", "cat", "nil", "taz"};
        len = 2;
        System.out.println("combinationsFromAListOfWords for words = "+words+" , for length = "+len+" == " + combinationsFromAListOfWords(words, len) );
        // [6,9,12]
    }


    public static List<List<String>> combinationsFromAListOfWords(String[] words, int len) {
        int n = words.length;
        combinationSize = len;
        combinations.clear();
        currentCombination.clear();
        generateCombinations(Arrays.asList(words), len);
        return combinations;
    }

    public static List<List<String>> combinations = new ArrayList<>();
    public static List<String> currentCombination = new ArrayList<>();
    public static int combinationSize = 0;

    public static void generateCombinations(List<String> words, int len){
        System.out.println("Debugging, words = "+words+" , len = "+len+" , currentCombination = "+currentCombination+ ", combinations = "+combinations+" , combinations.size() = "+combinations.size());
        if(currentCombination.size()==len){
            combinations.add(new ArrayList<String>(currentCombination));
            return;
        }
        for(int i=0;i<words.size();i++){
            if(!currentCombination.contains(words.get(i))){
                currentCombination.add(words.get(i));
                generateCombinations(words, len);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

}
