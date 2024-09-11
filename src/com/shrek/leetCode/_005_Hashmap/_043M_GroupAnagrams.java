package com.shrek.leetCode._005_Hashmap;

import java.util.*;

/**
 *
 * Given an array of strings strs, group the
 * anagrams
 *  together. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 *
 */

public class _043M_GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println("groupAnagrams for strs = " + Arrays.toString(strs) + " is " + groupAnagrams(strs));
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println("-------------- BREAK -----------------");

        strs = new String[]{""};
        System.out.println("groupAnagrams for strs = " + Arrays.toString(strs) + " is " + groupAnagrams(strs));
        // [[""]]
        System.out.println("-------------- BREAK -----------------");

        strs = new String[]{"a"};
        System.out.println("groupAnagrams for strs = " + Arrays.toString(strs) + " is " + groupAnagrams(strs));
        // [["a"]]
        System.out.println("-------------- BREAK -----------------");

        strs = new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        System.out.println("groupAnagrams for strs = " + Arrays.toString(strs) + " is " + groupAnagrams(strs));
        // [["max"],["buy"],["doc"],["may"],["ill"],["duh"],["tin"],["bar"],["pew"],["cab"]]
        System.out.println("-------------- BREAK -----------------");

        strs = new String[]{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        System.out.println("groupAnagrams for strs = " + Arrays.toString(strs) + " is " + groupAnagrams(strs));
        // [[aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa], [aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa]]
        System.out.println("-------------- BREAK -----------------");

        strs = new String[]{"tin","ram","zip","cry","pus","jon","zip","pyx"};
        System.out.println("groupAnagrams for strs = " + Arrays.toString(strs) + " is " + groupAnagrams(strs));
        // [[aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa], [aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa]]
        System.out.println("-------------- BREAK -----------------");
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> strToStrListMap = new HashMap<String, List<String>>();
        String str = "";
        char[] arr;
        int temp;
        String key;
        for(int i = 0;i<n;i++){
            str = strs[i];
            arr = str.toCharArray();
            int[] keyArr =  new int[27];
            Arrays.fill(keyArr, 0);
            System.out.println("Testing str = "+str);
            for(int j=0;j<arr.length;j++){
                temp = (int) arr[j] - 96;
                keyArr[ temp ] ++;
            }
            key = Arrays.toString(keyArr);
            List<String> list = strToStrListMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            strToStrListMap.put(key, list);
        }
        List<List<String>> ll = new ArrayList<>( strToStrListMap.values() );
        return ll;
    }

}
