package com.shrek.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Main06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> tree1 = new TreeSet<Integer>();
		TreeSet<Integer> tree2 = new TreeSet<Integer>();
		TreeSet<Integer> tree3 = new TreeSet<Integer>();
		int[] arr = new int[22];
		for (int i = 0; i <= 18; i++) {
			arr[i] = i;
		}
		for (int i : arr) {
			if (arr[i] % 2 == 0) {
				tree1.add(i);
			}
		}
		tree2 = (TreeSet<Integer>) tree1.subSet(2, true, 19, false);
		tree3 = (TreeSet<Integer>) tree2.subSet(6, true, 15, false);
		System.out.println(tree1);
		tree1.add(20);
		tree1.remove(10);
		System.out.println(tree1);
		System.out.println(tree2);
		System.out.println(tree3);
		
		System.out.println("-----------------------------------------------------------");
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(45);
		list.add(23);
		list.add(10);
		Collections.sort(list);
		System.out.println(list);
		list.add(13);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		
	}

}
