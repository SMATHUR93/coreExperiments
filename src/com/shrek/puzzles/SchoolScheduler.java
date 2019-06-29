package com.shrek.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SchoolScheduler {

	//Sample Input
	//	10
	//	Physics (11)
	//	Chemistry (12)
	//	Maths (13)
	//	English (13)
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line = in.readLine();
		int numberOfDays = Integer.parseInt(line);
		int numberOfPeriodsPerDay = 5;
		int numberOfSubjects = 4;
		int numberOfTeachingDays = 6;
		Map<String, Integer> subjectDataMap = new TreeMap<String, Integer>();
		int totalPeriodsAsPerSyllabus = 0;
		String subjectName;
		Integer sylabbusRequiredPeriods;
		String subjectInputLine;
		int counter = numberOfSubjects;
		while (counter-->0) {
			subjectInputLine = in.readLine();
			int indexOfBraces = subjectInputLine.indexOf("(");
			subjectName =  subjectInputLine.substring(0, indexOfBraces-1);
			sylabbusRequiredPeriods = Integer.parseInt(subjectInputLine.substring(indexOfBraces+1, subjectInputLine.length()-1));
			totalPeriodsAsPerSyllabus+=(int)sylabbusRequiredPeriods;
			subjectDataMap.put(subjectName, sylabbusRequiredPeriods);
		}
		//System.out.println("-----------------");
		//System.out.println("Total number of Days are " + numberOfDays);
		//System.out.println("Total Periods As Per Syllabus are " + totalPeriodsAsPerSyllabus);
		//System.out.println("-----------------");
		Set<String> subjectKeyset = subjectDataMap.keySet();
		String[] subjectsNameArray = new String[numberOfSubjects];
		int[] subjectsPeriodsArray = new int[numberOfSubjects];
		int index = 0;
		Iterator<String> itr = subjectKeyset.iterator();
		while(itr.hasNext()) {
			subjectName =  itr.next();
			sylabbusRequiredPeriods = subjectDataMap.get(subjectName);
			subjectsNameArray[index] = subjectName;
			subjectsPeriodsArray[index] = sylabbusRequiredPeriods;
			index++;
		}
		int totalNumberOfAvailablePeriods = numberOfDays * numberOfPeriodsPerDay;
		if(totalPeriodsAsPerSyllabus >= totalNumberOfAvailablePeriods) {
			System.out.println("We have less days as required by syllabus.");
		} else {
			System.out.println("Scheduler can be made !!");
		}
		String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
		"Saturday"};
		int rotationIndex = 0;
		int revIndex = 0;
		StringBuffer timeTableLine = new StringBuffer();
		for(int i=0;i<numberOfDays;i++) {
			timeTableLine = new StringBuffer();
			String weekday = weekdays[revIndex];
			timeTableLine.append(weekday + " : ");
			for(int j=0;j<numberOfPeriodsPerDay;j++) {
				timeTableLine.append("T"+(j+1)+"(");
				if(subjectsPeriodsArray[rotationIndex]>0) {
					timeTableLine.append(subjectsNameArray[rotationIndex]);
					subjectsPeriodsArray[rotationIndex]--;
				} else {
					timeTableLine.append("FREE SLOT");
				}
				timeTableLine.append(") ");
				if(rotationIndex==(numberOfSubjects-1)) {
					rotationIndex = 0;
				} else{
					rotationIndex++;
				}
			}
			System.out.println(timeTableLine);
			if(revIndex==(numberOfTeachingDays-1)) {
				revIndex = 0;
			} else {
				revIndex++;
			}
		}
	}
}
