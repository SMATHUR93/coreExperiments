package com.shrek.leetCode._014_Backtracking;

import java.util.*;

/**
 *
 * Given a string containing digits from 2-9 inclusive,
 * 2: {'a','b','c'}
 * 3: {'d','e','f'}
 * 4: {'g','h','i'}
 * 5: {'j','k','l'}
 * 6: {'m','n','o'}
 * 7: {'p','q','r','s'}
 * 8: {'t','u','v'}
 * 9: {'w','x','y','z'}
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Constraints:
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 */

public class _101M_LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {

        String digits;

        digits = "89";
        System.out.println("letterCombinations for digits = "+digits+", equals "+ letterCombinations(digits).toString());
        // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println();

        digits = "";
        System.out.println("letterCombinations for digits = "+digits+", equals "+ letterCombinations(digits).toString());
        // []
        System.out.println();

        digits = "2";
        System.out.println("letterCombinations for digits = "+digits+", equals "+ letterCombinations(digits).toString());
        // ["a","b","c"]
        System.out.println();
    }

    public static List<String> letterCombinations(String digits) {
        List<String> op = new ArrayList<>();
        if(digits.length()<=0){
            return op;
        }

        Map<Character, List<Character>> chars = new HashMap<>();

        chars.put('2', Arrays.asList('a','b','c'));
        chars.put('3', Arrays.asList('d','e','f'));
        chars.put('4', Arrays.asList('g','h','i'));
        chars.put('5', Arrays.asList('j','k','l'));
        chars.put('6', Arrays.asList('m','n','o'));
        chars.put('7', Arrays.asList('p','q','r','s'));
        chars.put('8', Arrays.asList('t','u','v'));
        chars.put('9', Arrays.asList('w','x','y','z'));

        genrateCombinations("", digits, op, chars, digits.length());

        return op;
    }

    public static void genrateCombinations(String str, String digits, List<String> op, Map<Character, List<Character>> chars, int n){
        if(str.length()==n){
            op.add(str);
            return;
        }
        for(int i=0;i<digits.length();i++){
            List<Character> list = chars.get(digits.charAt(i));
            for(char c: list){
                genrateCombinations(str+c, digits.substring(i+1), op, chars, n);
            }
        }
    }

}
