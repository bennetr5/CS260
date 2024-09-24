/*
NAME: Bennet Ripplinger

PROJECT: Project 1

COURSE: CS 26000

INSTRUCTOR: Beomijn Kim

CLASS TIME: TR 3:00-4:15 PM

DUE DATE: September 12th, 2024
*/

package rippbm01.Project1;

// Class for an EmployeeMap that keeps track of Employee's IDs and their Indexes
public class EmployeeMap implements Cloneable{
	
	// Array map used for storing Employees
	private Employee[] map = new Employee[200];
	
	// Tracks how many Employees are in map array
	private int manyItem;
	
	/**
	 * Constructor for EmployeeMap class
	 * @param map An Array of type Employee of size 200
	 * @param manyItem A Counter for how many Employee objects in map
	 */
	public EmployeeMap(Employee[] map, int manyItem) { 
		this.manyItem = manyItem;
		for (int i = 0; i < map.length; i++) {
			this.map[i] = null;
		}
	}

	/**
	 * Adds Employee e into EmployeeMap
	 * @param e Employee e to insert to map
	 * @return Returns -1 if Employee failed to insert
	 * 		   Returns 0 if Employee ID matches one already in map array, also replaces prev Employee
	 * 		   Returns 1 if Employee was inserted
	 */
	public int insert(Employee e) {
		if (manyItem == 0) {
			map[manyItem] = e;
			manyItem++;
			return 1;
		}
		
		// Replaces previous employee with same empID
		else if (manyItem > 0 && manyItem < 200) {
			for (int i = 0; i < manyItem; i++) {
				if (map[i].getEmp_id().equals(e.getEmp_id())) {
					map[i] = e;
					return 0;
				}
			}
			// Adds Employee to the end of the map if no matching empID was found
			map[manyItem] = e;
			manyItem++;
			return 1;
		}
		else {
			return -1;
		}
	}
	
	/**
	 * Removes Employee with emp_id "empID" from map
	 * @param empID String empID to be removed from map
	 */
	public void remove(String empID) {
		int index = findIndex(empID);
		try {
			if (index == -1) {
				System.out.println("ID not found.");
			}
			else {
				// Set index to remove to null
				map[index] = null;
				
				// Shifts all employees after removed employee up 1
				for (int i = index+1; i < manyItem; i++) {
					if (map[i] == null) {
						break;
					}
					else {
						map[i-1] = map[i];
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("Failed to remove ID");
		}
	}
	
	
	/**
	 * Searches for Employee with ID "empID" in map
	 * @param empID The emp_id of the Employee to search for
	 * @return Returns the index of the empID was, if not found returns -1
	 */
	public int findIndex(String empID) {
		for (int i = 0; i < manyItem; i++) {
			if (map[i].getEmp_id().equals(empID)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Searches for all Employees with the same position
	 * @param Position The Position of the Employee, First char in emp_id
	 * @return Returns all indexes of Employees that have the same position
	 */
	public int[] searchPosition(char Position) {
		int[] positionIndexes = new int[manyItem];
		int count = 0;
		
		// Loops through map manyItem times
		for (int i = 0; i < manyItem; i++) {
			// Checks if Employee position matches position given
			if (map[i].getEmp_id().charAt(0) == Position) {
				// Add to positionIndexes array and increment count
				positionIndexes[count] = i;
				count++;
			}
		}
		return positionIndexes;
	}
	
	/**
	 * 
	 * @return Gets the number of Employees in map
	 */
	public int getManyItem() {
		return manyItem;
	}
	
	/**
	 * 
	 * @return Gets the list of Employees in map
	 */
	public Employee[] getMap() {
		return map;
	}
	
	/**
	 * Creates a deep copy of the EmployeeMap and returns it
	 */
	public Object clone() {
		EmployeeMap mapCopy;
		try {
			mapCopy = (EmployeeMap) super.clone();
			mapCopy.map = (Employee[]) map.clone();
		}
		catch (CloneNotSupportedException e) {
			throw new RuntimeException("Clone Not Suppported");
		}
		return mapCopy;
	}
}
