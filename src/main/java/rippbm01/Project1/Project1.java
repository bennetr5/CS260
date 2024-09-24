/*
NAME: Bennet Ripplinger

PROJECT: Project 1

COURSE: CS 26000

INSTRUCTOR: Beomijn Kim

CLASS TIME: TR 3:00-4:15 PM

DUE DATE: September 12th, 2024
*/

package rippbm01.Project1;


import java.io.IOException;

public class Project1 {

	public static void main(String[] args) throws IOException {
		
		// Initializing Variables and Objects
		int manyItems = 0;
		String fileName = "/Users/bennetr/Desktop/Data Struct Projects/Project1/src/main/empRecord.dat";
		Employee[] records = new Employee[200];
		Employee[] map = new Employee[200];
		int[] sortedIndexes = new int[200];
		
		EmployeeDictionary empD = new EmployeeDictionary(records);
		EmployeeMap empM = new EmployeeMap(map, manyItems);
		
		FileIO file = new FileIO(fileName, empD, empM);
		
		// Reads Employee data from fileName
		file.readRecord(fileName);
		
		// Sorts Employee data in records and stores sorted indexs in sortedIndexes
		empD.sort(sortedIndexes, records);
		
		// Writes EmployeeMap to a file named empMap.out
		file.writeEmployeeMap("empMap.out");
		// Writes sorted employee records to a file named empRecord.out
		file.writeEmployeeRecord(sortedIndexes, "empRecord.out");
	}
	
	
}
