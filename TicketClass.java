package TicketIssuing;

/**
 * The Ticket class stores variables relating to the information needed to issue a ticket.
 * object filmForTicket, object customerForTicket
 * Objects in this class are used in the CinemaTicketApplication to generate tickets for movies.
 *  A public class to be accessed in the main program to create new constructors and hold customer film information
 * @author Ashley C
 */

public class TicketClass {
	private Film filmForTicket;
	private CustomerClass customerForTicket;
	
	/**
	 * default constructor
	 */
	public TicketClass()
	{
		filmForTicket=null;
		customerForTicket=null;
	}
	
	/**
	 * information entered constructor with 3 input variables
	 * @param filmSelected
	 * @param customerSelected
	 */
	public TicketClass(Film filmSelected,CustomerClass customerSelected)
	{
		filmForTicket=filmSelected;
		customerForTicket=customerSelected;
	}
	
	/**
	 * A method which calculates the cost for a ticket based on the customer's age range and student status
	 * @return totalCost
	 */
	public double cost()
	{
		double totalCost=0.00;
		int customerAge=customerForTicket.getAge();
		boolean studentDiscount=customerForTicket.isStudent();
		
		//18 and over price
		if(customerAge>=18)
		{
			totalCost=10.00;
		}
		//under 18 price
		else if(customerAge<18)
		{
			totalCost=7.00;
		}
		
		//student discounts
		if(studentDiscount==true)
		{
			if(customerAge>=8&&customerAge<=20)
			{
				//%20 discount
				totalCost=totalCost*0.8;
			}
			else if(customerAge>25)
			{
				//%7 discount
				totalCost=totalCost*0.93;
			}
		}
		//seniors
		else if(studentDiscount==false&&customerAge>70)
		{
			//%5 discount
			totalCost=totalCost*0.95;
		}
		
		return totalCost;
	}
	
	/**
	 * Gets the selected film object
	 * @return filmForTicket
	 */
		public Film getFilmForTicket() {
		return filmForTicket;
	}

	/**
	 * set the film object with the selected film's variables
	 * @param filmForTicket
	 */
	public void setFilmForTicket(Film filmForTicket) {
		this.filmForTicket = filmForTicket;
	}
	
	/**
	 * Gets the customer object
	 * @return customerForTicket
	 */
	public CustomerClass getCustomerForTicket() {
		return customerForTicket;
	}

	/**
	 * sets the customer object with the customer's entered information variables
	 * @param customerForTicket
	 */
	public void setCustomerForTicket(CustomerClass customerForTicket) {
		this.customerForTicket = customerForTicket;
	}

	/**
	 * convert information into a string
	 */
	public String toString()
	{
		return "TOTAL COST: $"+String.format("%.2f",cost());
	}
}
