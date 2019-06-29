package com.shrek.puzzles;

import java.util.Arrays;
import java.util.Scanner;

class Processor  implements Comparable<Processor>{
	char name;
	int timeToExecute;
	int runTime;
	int jobsExecuted;
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	public int getTimeToExecute() {
		return timeToExecute;
	}
	public void setTimeToExecute(int timeToExecute) {
		this.timeToExecute = timeToExecute;
	}
	public int getRunTime() {
		return runTime;
	}
	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}
	public int getJobsExecuted() {
		return jobsExecuted;
	}
	public void setJobsExecuted(int jobsExecuted) {
		this.jobsExecuted = jobsExecuted;
	}
	public Processor(char name, int timeToExecute) {
		super();
		this.name = name;
		this.timeToExecute = timeToExecute;
		this.runTime = 0;
		this.jobsExecuted = 0;
	}
	public int compareTo(Processor p) {		
		// TODO Auto-generated method stub
		Integer time1 = this.getTimeToExecute();
		Integer time2 = p.getTimeToExecute();
		return time1.compareTo(time2);
	}
}

public class ExecutionTimePuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of Jobs");
		int numberOfJobs;
		numberOfJobs = input.nextInt();
		int numberOfJobsCompleted = 0;
		int systemTime = 0;
		char[] threadCodes = {'a','b','c','d','e','f','g','h','i','j'};
		
		int numberOfProcessors;
		System.out.println("Enter number of Processors");
		numberOfProcessors = input.nextInt();
		Processor[] processorArray = new Processor[numberOfProcessors];
		for(int i=0;i<numberOfProcessors;i++){
			System.out.println("Enter timeToExecute for processor number "+(i+1));
			processorArray[i] = new Processor(threadCodes[i], input.nextInt());
		}
		
		
		Arrays.sort(processorArray);
		
		for(int i=1;i<=numberOfJobs;i++){
			Processor currentProcessor = null;
			for(int j=0;j<numberOfProcessors;j++) {
				
				currentProcessor = processorArray[j];
				
				if((j+1)>=(numberOfProcessors)) {
					// No slower processor
					System.out.println("last processor condition");
					systemTime = currentProcessor.getRunTime() + currentProcessor.getTimeToExecute();
					currentProcessor.setRunTime(  systemTime  );
					currentProcessor.setJobsExecuted(currentProcessor.getJobsExecuted()+1);
					numberOfJobsCompleted++;
					System.out.println("Broke at j "+j);
					break;
				} else {
					Processor nextProcessor = processorArray[j+1];
					if( ( systemTime + currentProcessor.getTimeToExecute() ) <= ( nextProcessor.getRunTime() + nextProcessor.getTimeToExecute() ) ) {
						systemTime = currentProcessor.getRunTime() + currentProcessor.getTimeToExecute();
						currentProcessor.setRunTime(  systemTime  );
						currentProcessor.setJobsExecuted(currentProcessor.getJobsExecuted()+1);
						numberOfJobsCompleted++;
						System.out.println("Broke at j "+j);
						break;
					}
				}
				
			}
			System.out.println("numberOfJobsCompleted = "+numberOfJobsCompleted+" || "+"currentProcessor.getName() = "+currentProcessor.getName()+" || "+"systemTime = "+systemTime+" || ");
		}
		
		System.out.println("Total Time to execute is "+systemTime);
		
	}

}
