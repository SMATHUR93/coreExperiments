package com.shrek.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsFromAListOfWords {

    public static void main(String[] args) {
        String[] words = new String[]{"foo","bar"};
        System.out.println("PermutationsFromAListOfWords for words = "+words+" == " + permutationsFromAListOfWords(words) );
        // [0,9]
        System.out.println("-------------- BREAK -----------------");
        words = new String[]{"par", "cat", "nil", "taz"};
        System.out.println("PermutationsFromAListOfWords for words = "+words+" == " + permutationsFromAListOfWords(words) );
        // [6,9,12]
    }


    public static List<List<String>> permutationsFromAListOfWords(String[] words) {
        int n = words.length;
        permutations.clear();
        currentPermutation.clear();
        generatePermutations(Arrays.asList(words));
        return permutations;
    }

    public static List<List<String>> permutations = new ArrayList<>();
    public static List<String> currentPermutation = new ArrayList<>();

    public static void generatePermutations(List<String> words){
        if(currentPermutation.size()==words.size()){
            permutations.add(new ArrayList<String>(currentPermutation));
            // System.out.println("Debugging, words = "+words+" , currentPermutation = "+currentPermutation+ ", permutations = "+permutations+" , permutations.size() = "+permutations.size());
            return;
        }
        for(int i=0;i<words.size();i++){
            if(!currentPermutation.contains(words.get(i))){
                currentPermutation.add(words.get(i));
                generatePermutations(words);
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }

}
