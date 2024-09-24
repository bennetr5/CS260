/*
NAME: Bennet Ripplinger

PROJECT: Project 1

COURSE: CS 26000

INSTRUCTOR: Beomijn Kim

CLASS TIME: TR 3:00-4:15 PM

DUE DATE: September 12th, 2024
*/

package rippbm01.Project1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {
	
	private String fileName;
	private EmployeeMap empMap;
	private EmployeeDictionary empDic;
	
	/**
	 * Constructor for FileIO
	 * @param fileName Name of file to read from
	 * @param empDic EmployeeDictionary Object to read/write from/to
	 * @param empMap EmployeeMap Object to read/write from/to
	 */
	public FileIO(String fileName, EmployeeDictionary empDic, EmployeeMap empMap) {
		this.fileName = fileName;
		this.empDic = empDic;
		this.empMap = empMap;
	}
	
	/**
	 * Reads from fileName and adds Employee info to EmployeeMap and EmployeeDictionary respectively
	 * @param fileName Name of file to read from
	 */
	public void readRecord(String fileName) {		
		try {
			File file = new File(fileName);
			Scanner reader = new Scanner(file);
			
			// Loop through until end of file and fill employeeMap and employeeDictionary
			while(reader.hasNextLine()) {
				Employee emp = new Employee();
				emp.setEmp_id(reader.next());
				emp.setLast_name(reader.next());
				emp.setFirst_name(reader.next());
				emp.setPosition(reader.next());
				emp.setSalary(reader.nextFloat());
				empDic.insert(emp, empDic.firstVacant());
				empMap.insert(emp);
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes to fileName from EmployeeMap
	 * @param fileName Name of file to write to 
	 */
	public void writeEmployeeMap(String fileName) throws IOException {
		FileOutputStream fstream = new FileOutputStream(fileName);
		DataOutputStream outputFile = new DataOutputStream(fstream);
		
		// Loops through employeeMap and writes to file
		for (int i = 0; i < empMap.getManyItem(); i++) {
			outputFile.writeUTF("Index: " + i + 
                    " Employee ID: " + empMap.getMap()[i].getEmp_id() + "\n");
		}
		outputFile.close();
	}
	
	/**
	 * Writes to fileName from EmployeeDictionary
	 * @param fileName Name of file to write to 
	 */
	public void writeEmployeeRecord(String fileName) throws IOException {
		FileOutputStream fstream = new FileOutputStream(fileName);
		DataOutputStream outputFile = new DataOutputStream(fstream);
		
		// Writes unsorted employeeDictonary to file
		for (int i = 0; i < empMap.getManyItem(); i++) {
			outputFile.writeUTF(empMap.getMap()[i].getEmp_id() + " " + empMap.getMap()[i].getLast_name() + " " +
								empMap.getMap()[i].getFirst_name() + " " + empMap.getMap()[i].getPosition() + " " + 
								empMap.getMap()[i].getSalary() + "\n");
		}
		
		outputFile.close();
	}
	
	/**
	 * Overloaded Method that writes a sorted EmployeeDictionary to fileName
	 * @param fileName Name of file to write to 
	 */
	public void writeEmployeeRecord(int[] all_index, String fileName) throws IOException {
		FileOutputStream fstream = new FileOutputStream(fileName);
		DataOutputStream outputFile = new DataOutputStream(fstream);
		
		//Writes sorted employeeDicitonary to file
		for (int i = 0; i < empMap.getManyItem(); i++) {
			outputFile.writeUTF(empMap.getMap()[all_index[i]].getEmp_id() + " " + empMap.getMap()[all_index[i]].getLast_name() + " " +
					empMap.getMap()[all_index[i]].getFirst_name() + " " + empMap.getMap()[all_index[i]].getPosition() + " " + 
					empMap.getMap()[all_index[i]].getSalary() + "\n");
		}
		
		outputFile.close();
	}

	/**
	 * 
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 
	 * @param filename the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
