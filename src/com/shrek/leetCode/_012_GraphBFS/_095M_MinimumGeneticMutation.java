package com.shrek.leetCode._012_GraphBFS;

import java.util.*;

/**
 *
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 *
 * Suppose we need to investigate a mutation from a gene string startGene
 * to a gene string endGene where one mutation is defined as one single character changed in the gene string.
 *
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 *
 * There is also a gene bank bank that records all the valid gene mutations.
 * A gene must be in bank to make it a valid gene string.
 *
 * Given the two gene strings startGene and endGene and the gene bank bank,
 * return the minimum number of mutations needed to mutate from startGene to endGene.
 * If there is no such a mutation, return -1.
 *
 * Note that the starting point is assumed to be valid,
 * so it might not be included in the bank.
 *
 * Example 1:
 * Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
 * Output: 1
 *
 * Example 2:
 * Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * Output: 2
 *
 * Constraints:
 * 0 <= bank.length <= 10
 * startGene.length == endGene.length == bank[i].length == 8
 * startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
 *
 */

public class _095M_MinimumGeneticMutation {

    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String[] bank = new String[]{"AACCGGTA"};
        System.out.println("minMutation for startGene = "+ startGene+" endGene = "+ endGene+" bank = "+ Arrays.toString(bank)+", equals "+ minMutation(startGene, endGene, bank));
        // 1
        System.out.println();


        startGene = "AACCGGTT";
        endGene = "AAACGGTA";
        bank = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println("minMutation for startGene = "+ startGene+" endGene = "+ endGene+" bank = "+ Arrays.toString(bank)+", equals "+ minMutation(startGene, endGene, bank));
        // 2
        System.out.println();
    }

    public static int minMutation(String startGene, String endGene, String[] bank) {
        // if end Gene is not in bank
        if(Arrays.asList(bank).contains(endGene)!=true){
            return -1;
        }

        char[] chars = new char[]{'A', 'C', 'G', 'T'};

        Set<String> visited =  new HashSet<>();
        Queue<String> queue =  new LinkedList<>();
        queue.add(startGene);
        visited.add(startGene);

        int noOfSteps = 0;

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0; i< queueSize; i++){
                String node = queue.poll();
                System.out.println("Debugging queue string, node = "+node);
                if(node.equals(endGene)){
                    return noOfSteps;
                }
                for(char c: chars){
                    for(int j=0;j<node.length();j++){
                        String nextNodeGenerated = node.substring(0, j) + c + node.substring(j+1);
                        if(!visited.contains(nextNodeGenerated) && Arrays.asList(bank).contains(nextNodeGenerated)){
                            System.out.println("Debugging generated String, nextNodeGenerated = "+nextNodeGenerated);
                            queue.add(nextNodeGenerated);
                            visited.add(nextNodeGenerated);
                        }
                    }
                }
            }
            noOfSteps++;
            System.out.println("Debugging point of INC no of steps, noOfSteps = "+noOfSteps);
        }
        return -1;
    }

}
