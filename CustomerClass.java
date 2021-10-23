package TicketIssuing;

/**
 * The customer class stores variables relating to the customer.
 * Name, age, and student status
 * Objects in this class are used in the CinemaTicketApplication to generate tickets for movies.
 *  A public class to be accessed in the main program to create new constructors and hold customer information
 * @author Ashley C
 */

public class CustomerClass {
	private String name;
	private int age;
	private boolean isStudent;
	
	/**
	 * default constructor
	 */
	public CustomerClass()
	{
		name="UNKNOWN";
		age='?';
		isStudent=false;
	}
	
	/**
	 * information entered constructor with 3 input variables
	 * @param cust_name
	 * @param cust_age
	 * @param student
	 */
	public CustomerClass(String cust_name, int cust_age, boolean student)
	{
		this.name=cust_name;
		this.age=cust_age;
		this.isStudent=student;
	}
	
	/**
	 * convert information into a string
	 */
	public String toString()
	{
		return "CUSTOMER DETAILS: "+this.getName()+" age: "+this.getAge()+" Student? "+this.isStudent();
	}
	
	/**
	 * get input of customer's name
	 * @return the customer's name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * set input of customers name into the constructor
	 * @param set_name
	 */
	public void setName(String set_name)
	{
		this.name=set_name;
	}
	
	/**
	 * get input of customer's age
	 * @return the customer's age
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * set input of customer's age into the constructor
	 * @param set_age
	 */
	public void setAge(int set_age)
	{
		this.age=set_age;
	}
	
	/**
	 * get input for student status of the customer
	 * @return boolean value of customer's student status
	 */
	public boolean isStudent()
	{
		return isStudent;
	}
	
	/**
	 * set input of customer's student status into the constructor
	 * @param set_student
	 */
	public void setStudent(boolean set_student)
	{
		this.isStudent=set_student;
	}
	
}
