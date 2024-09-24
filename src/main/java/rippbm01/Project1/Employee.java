/*
NAME: Bennet Ripplinger

PROJECT: Project 1

COURSE: CS 26000

INSTRUCTOR: Beomijn Kim

CLASS TIME: TR 3:00-4:15 PM

DUE DATE: September 12th, 2024
*/

package rippbm01.Project1;

public class Employee {
	
	private String emp_id;
	
	private String last_name;
	
	private String first_name;
	
	private String position;
	
	private float salary;
	
	/**
	 * Constructor for Employee
	 * @param emp_id Employee ID to assign
	 * @param last_name Last name of Employee to assign
	 * @param first_name First name of Employee to assign
	 * @param position Position of Employee (Manager, Associate, Trainee, Programmer, Sales)
	 * @param salary Salary of Employee to assign
	 */
	public Employee(String emp_id, String last_name, String first_name, String position,float salary) {
		this.emp_id = emp_id;
		this.last_name = last_name;
		this.first_name = first_name;
		this.position = position;
		this.salary = salary;
	}
	
	/**
	 * Blank Constructor for Employee
	 */
	public Employee() {}
	
	/**
	 * @return the emp_id
	 */
	public String getEmp_id() {
		return emp_id;
	}

	/**
	 * @param emp_id the emp_id to set
	 */
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
}
