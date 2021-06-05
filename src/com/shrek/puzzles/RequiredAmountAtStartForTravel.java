package com.shrek.puzzles;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
/*import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;*/
/*import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;*/

public class RequiredAmountAtStartForTravel {

	 /*
     * Complete the 'requiredAmountAtStart' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY netSaving as parameter.
     */

    public static int requiredAmountAtStart(List<Integer> netSaving) {
    	int requiredAmountAtStart = 0;
    	Iterator<Integer> itr = netSaving.iterator();
    	int sum = 0;
    	while(itr.hasNext()) {
    		int i = itr.next();
    		sum += i;
    	}
    	if(sum>0) {
    		requiredAmountAtStart = 0;
    	} else{
    		if(sum==0) {
    			requiredAmountAtStart = 1;
    		} else{
    			requiredAmountAtStart = ((-(sum)) + 1);
    		}
    	}
    	return requiredAmountAtStart;
    	
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int netSavingCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> netSaving = IntStream.range(0, netSavingCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());

    	List<Integer> netSaving = new ArrayList<Integer>();
    	// test case 1
//    	netSaving.add(4);
//    	netSaving.add(2);
//    	netSaving.add(-3);
    	// test case 2
//    	netSaving.add(-1);
//    	netSaving.add(-2);
//    	netSaving.add(-3);
//    	netSaving.add(+1);
//    	netSaving.add(-5);
    	//test case 3
    	netSaving.add(0);
    	netSaving.add(0);
    	netSaving.add(0);
        int result = requiredAmountAtStart(netSaving);
        System.out.println(result);
        
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}