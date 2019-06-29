package com.shrek.puzzles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LongestSubArrayOfSize {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int money = 5;
		List<Integer> outfits = new ArrayList<Integer>();
		outfits.add(2);
		outfits.add(3);
		outfits.add(5);
		outfits.add(1);
		outfits.add(1);
		outfits.add(2);
		outfits.add(1);
        Iterator<Integer> itr = outfits.iterator();
        int[] ip = new int[outfits.size()];
        int a = 0;
        while (itr.hasNext()) {
            ip[a] = itr.next();
            a++;
        }
        int maxStreak = 0;
        int currentSum = 0;
        int currentStreak = 0;
        for (int i = 0; i < ip.length; i++) {
            currentSum = 0;
            currentStreak = 0;
            System.out.println("===== Checking for "+ip[i]);
            if(ip[i]<money){
                //currentSum = ip[i];
                for(int j=i;j<ip.length;j++){
                	System.out.println(currentSum);
                    if(money<(currentSum+ip[j])){
                        break;
                    } else{
                        currentSum+=ip[j];
                        currentStreak++;
                    }
                }
            } else{
                if(ip[i]==money){
                    currentStreak = 1;
                }
            }
            if(currentStreak>maxStreak){
                maxStreak = currentStreak;
            }
            //System.out.println(ip[i]);
        }
        System.out.println("==================");
        System.out.println(maxStreak);
		
	}
	/*
	 * public static void main(String[] args) throws IOException { BufferedReader
	 * bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	 * BufferedWriter bufferedWriter = new BufferedWriter(new
	 * FileWriter(System.getenv("OUTPUT_PATH")));
	 * 
	 * int outfitsCount = Integer.parseInt(bufferedReader.readLine().trim());
	 * 
	 * List<Integer> outfits = IntStream.range(0, outfitsCount).mapToObj(i -> { try
	 * { return bufferedReader.readLine().replaceAll("\\s+$", ""); } catch
	 * (IOException ex) { throw new RuntimeException(ex); }
	 * }).map(String::trim).map(Integer::parseInt).collect(toList());
	 * 
	 * int money = Integer.parseInt(bufferedReader.readLine().trim());
	 * 
	 * int result = Result.getMaximumOutfits(outfits, money);
	 * 
	 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
	 * 
	 * bufferedReader.close(); bufferedWriter.close(); }
	 */
}