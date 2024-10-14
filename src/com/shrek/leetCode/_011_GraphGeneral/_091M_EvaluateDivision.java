package com.shrek.leetCode._011_GraphGeneral;

import java.lang.reflect.Array;
import java.util.*;

/**
 *
 * You are given an array of variable pairs equations
 * and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i]
 * represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries,
 * where queries[j] = [Cj, Dj] represents the jth query
 * where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries.
 * If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid.
 * You may assume that evaluating the queries
 * will not result in division by zero and
 * that there is no contradiction.
 *
 * Note:
 * The variables that do not occur in the list of equations are undefined,
 * so the answer cannot be determined for them.
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 *
 *
 * Example 2:
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 *
 *
 * Example 3:
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 *
 * Hint 1
 * Do you recognize this as a graph problem?
 *
 */

public class _091M_EvaluateDivision {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>(Arrays.asList(
                new ArrayList<String>(Arrays.asList("a","b")),
                new ArrayList<String>(Arrays.asList("b","c"))
        ));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>(Arrays.asList(
                new ArrayList<String>(Arrays.asList("a","c")),
                new ArrayList<String>(Arrays.asList("b","a")),
                new ArrayList<String>(Arrays.asList("a","e")),
                new ArrayList<String>(Arrays.asList("a","a")),
                new ArrayList<String>(Arrays.asList("x","x"))
        ));
        System.out.println("calcEquation for equations = "+equations.toString()+" , values = "+Arrays.toString(values)+", queries = "+queries.toString()+" , equals "+ Arrays.toString(calcEquation(equations, values, queries)));
        // [6.00000,0.50000,-1.00000,1.00000,-1.00000]
        System.out.println();

        equations = new ArrayList<>(Arrays.asList(
                new ArrayList<String>(Arrays.asList("a","b")),
                new ArrayList<String>(Arrays.asList("b","c")),
                new ArrayList<String>(Arrays.asList("bc","cd"))
        ));
        values = new double[]{1.5, 2.5, 5.0};
        queries = new ArrayList<>(Arrays.asList(
                new ArrayList<String>(Arrays.asList("a","c")),
                new ArrayList<String>(Arrays.asList("c","b")),
                new ArrayList<String>(Arrays.asList("bc","cd")),
                new ArrayList<String>(Arrays.asList("cd","bc"))
        ));
        System.out.println("calcEquation for equations = "+equations.toString()+" , values = "+Arrays.toString(values)+", queries = "+queries.toString()+" , equals "+ Arrays.toString(calcEquation(equations, values, queries)));
        //  [3.75000,0.40000,5.00000,0.20000]
        System.out.println();

        equations = new ArrayList<>(Arrays.asList(
                new ArrayList<String>(Arrays.asList("a","b"))
        ));
        values = new double[]{0.5};
        queries = new ArrayList<>(Arrays.asList(
                new ArrayList<String>(Arrays.asList("a","b")),
                new ArrayList<String>(Arrays.asList("b","a")),
                new ArrayList<String>(Arrays.asList("a","c")),
                new ArrayList<String>(Arrays.asList("x","y"))
        ));
        System.out.println("calcEquation for equations = "+equations.toString()+" , values = "+Arrays.toString(values)+", queries = "+queries.toString()+" , equals "+ Arrays.toString(calcEquation(equations, values, queries)));
        //  [0.50000,2.00000,-1.00000,-1.00000]
        System.out.println();

    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String divident, divisor;
        double quotient ,remainder;
        for(int i=0;i<equations.size();i++){
            List<String> equation = equations.get(i);
            divident = equation.get(0);
            divisor = equation.get(1);
            quotient = values[i];
            if(!graph.containsKey(divident)){
                graph.put(divident, new HashMap<String, Double>());
            }
            if(!graph.containsKey(divisor)){
                graph.put(divisor, new HashMap<>());
            }
            graph.get(divident).put(divisor, quotient);
            graph.get(divisor).put(divident, 1 / quotient);
        }
        double[] result =  new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            List<String> query = queries.get(i);
            divident = query.get(0);
            divisor = query.get(1);
            if(!graph.containsKey(divident)){
                result[i] = -1.0;
            } else if(!graph.containsKey(divisor)){
                result[i] = -1.0;
            } else if(divident==divisor){
                result[i] = -1.0;
            } else{
                Set<String> visited = new HashSet<>();
                result[i] = DFSCheck(graph, divident, divisor, 1, visited);
            }
        }
        return result;
    }

    public static double DFSCheck(Map<String, Map<String, Double>> graph,
                                  String currentNode,
                                  String targetNode,
                                  double prod,
                                  Set<String> visited){
        visited.add(currentNode);
        double out = -1.0;
        Map<String, Double> neighbours = graph.get(currentNode);

        if(neighbours.containsKey(targetNode)){
            return prod * neighbours.get(targetNode);
        } else{
            for(String nextNode:neighbours.keySet()) {
                if (!visited.contains(nextNode)) {
                    out = DFSCheck(graph, nextNode, targetNode, prod* neighbours.get(nextNode), visited);
                }
                if (out != -1.0) {
                    break;
                }
            }
        }
        visited.remove(currentNode);
        return out;
    }

}
