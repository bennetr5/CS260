/*
NAME: Bennet Ripplinger

PROJECT: Project 1

COURSE: CS 26000

INSTRUCTOR: Beomijn Kim

CLASS TIME: TR 3:00-4:15 PM

DUE DATE: September 12th, 2024
*/

package rippbm01.Project1;

//Class for an EmployeeDictionary that keeps a list of Employees
public class EmployeeDictionary implements Cloneable{
	
	// Array r of Employee objects of size 200
	private Employee[] r = new Employee[200];
	
	/**
	 * Constructor for EmployeeDictionary that initializes array given to null
	 * @param r An Array of type Employee that gets initialized to null
	 */
	public EmployeeDictionary(Employee[] r) {
		this.r = r;
		for (int i = 0; i < r.length; i++) { 
			r[i] = null;
		}
	}
	
	/**
	 * Adds given Employee e at given int index
	 * @param e Employee Object to add
	 * @param index The index to put the Employee at
	 * @return returns true if employee was successfully added, false otherwise
	 */
	public boolean insert(Employee e, int index) {
		try {
			if (index >= 0 && index < 200) {
				r[index] = e;
			}
		}
		catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	/**
	 * Removes Employee object at int index and shifts everything behind it up
	 * @param index The loctionn of the Employee to remove 
	 * @return Returns true if successfully removed, false otherwise
	 */
	public boolean remove(int index) {
		try {
			// Checks for array out of bounds and returns false if true
			if (r[index] == null && index >= 0 && index < r.length) {
				return false;
			}
			else {
				r[index] = null;
			}
			
			//Loops through indexes after removed employee
			for (int i = index+1; i < r.length; i++) {
				// Checks for vacant indexes to see if end is reached
				if (r[i] == null) {
					break;
				}
				else {
					//Shifts Employee up 1 index
					r[i-1] = r[i];
				}
			}
		}
		catch (Exception ex) {
			System.out.println("Failed to remove Employee Record\n");
			return false;
		}
		System.out.println("Successfully removed Employee Record.");
		return true;
	}
	
	/**
	 * Finds the first open position in EmployeeDIctionary
	 * @return Returns the first index that equals null
	 */
	public int firstVacant() {
		for (int i = 0; i < r.length; i++) {
			if (r[i] == null) {
				return i;
			}
		}
		System.out.println("No vacant spots.");
		return -1;
	}
	
	/**
	 * Checks if an Employee object is at int index
	 * @param The index Position to check
	 * @return Returns true if Employee object is found at index
	 */
	public boolean isPresent(int index) {
		if (r[index] == null) {
			System.out.println("No employee at specified location.");
			return false;
		}
		System.out.println("Employee found at specified location.");
		return true;
	}
	
	/**
	 * Sorts EmployeeDictionary based on Employee position (Most Valuable -> Least Valuable)
	 * @param sortedIndexes Array to store the sorted indexes of EmployeeDictionary
	 * @param r Array of Employees to sort
	 * @return Returns the sorted indexes of EmployeeDictionary
	 */
	public int[] sort(int[] sortedIndexes, Employee[] r) {
	    int counter = 0;
	    // Order of position from Most Valuable -> Least Valuable
	    char[] order = {'M', 'P', 'A', 'S', 'T'};
	    
	    // Loop Through each position
	    for (char position : order) {
	    	for (int i = 0; i < r.length; i++) {
	            // Checks for correct position at index and adds to sortedIndexes if true
	    		if (r[i] != null && r[i].getEmp_id().charAt(0) == position) {
	                sortedIndexes[counter] = i;
	                counter++;
	            }
	        }
	    }
	    
	    return sortedIndexes;
	}
	
	/**
	 * Creates a deep copy of the EmployeeDictionary and returns it
	 */
	public Object clone() {
		EmployeeDictionary dictionaryCopy;
		try {
			dictionaryCopy = (EmployeeDictionary) super.clone();
			dictionaryCopy.r = (Employee[]) r.clone();
		}
		catch (CloneNotSupportedException e) {
			throw new RuntimeException("Clone Not Suppported");
		}
		return dictionaryCopy;
	}
}
