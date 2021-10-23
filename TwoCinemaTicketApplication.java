package TicketIssuing;
import java.util.Scanner;

/**
 * This program prompts user information and creates an object from it. 
 * It also prompts for a film selection and creates another object for that.
 * The program them issues a ticket based on whether or not the customer's age is in range for the rating.
 * If so the programmed generates the price based on age and student status, prints out the ticket information,
 * them prompts if the user would like another ticket.
 * @author Ashley C
 */

public class TwoCinemaTicketApplication {

	static final Scanner keyboard = new Scanner(System.in);	

	public static void main(String[] args) {
		
		final int NUMBER_OF_FILMS=4;
		Film film[]=new Film[NUMBER_OF_FILMS];
		
		/**
		 * Initializing film array
		 */
		film[0]= new Film();
		film[0].rating=Rating.GENERAL;
		film[0].title="Ant-Man";
		
		film[1]=new Film();
		film[1].rating=Rating.PARENTALGUIDANCE;
		film[1].title="Minions";
		
		film[2]= new Film();
		film[2].rating=Rating.MATURE;
		film[2].title="Jurassic World";
		
		film[3]= new Film();
		film[3].rating=Rating.GENERAL;
		film[3].title="Inside Out";
		
		/**
		 * Setting a boolean to loop to run the program while set to 'true' another ticket will be initialized
		 */
		boolean ticketSelection=true;
		while(ticketSelection==true)
		{
		System.out.println("Welcome to the Cinema Purchasing System");
		
		/**
		 * creating customer class
		 */
		CustomerClass newCustomer= new CustomerClass();
		newCustomer=customerDetailInput();
		
		/**
		 * Prompt for film selection
		 */
		Film moviePicked= new Film();
		moviePicked=filmSelection(film);
				
		/**
		 * issuing a ticket
		 */
		TicketClass giveTicket=new TicketClass();
		giveTicket=issueTicket(newCustomer, moviePicked);
		if(giveTicket==null)
		{
			System.out.println("Sorry, cannot issue ticket for age restricted film.");
		}
		else if(giveTicket!=null)
		{
			System.out.println("Your ticket is ready to be collected!");
			System.out.println("------------------------------------------------------------------");
			System.out.println(moviePicked);
			System.out.println(newCustomer);
			System.out.println(giveTicket);
			System.out.println("------------------------------------------------------------------");
		}
		System.out.println("Issue another ticket? (y/n)");
		char answer=keyboard.next().charAt(0);
		
		int input=0;
		while(input==0)
		{
			if(answer=='y'||answer=='Y')
			{
				ticketSelection=true;
				input=1;
			}
			else if (answer=='n'||answer=='N')
			{
				ticketSelection=false;
				input=1;
			}
			else
			{
				System.out.println("Incorrect input please enter again: (y/n)");
				answer=keyboard.next().charAt(0);
			}
		}
		keyboard.nextLine();
		}	
		keyboard.close();
	}
	
	/**
	 * Method to gather customer details
	 * @return customer instance
	 */
	private static CustomerClass customerDetailInput()
	{
		CustomerClass c1=new CustomerClass();
	
		/**
		 * entering and setting name;
		 */
		System.out.println("Please enter in your name:");
		c1.setName(keyboard.nextLine());
				
		/**
		 * entering and setting age
		 */
		System.out.println("Please enter in your age:");
		
		/**
		 * checking input
		 */
		int checkInput = 0;
		while(checkInput==0)
		{
			int age = keyboard.nextInt();
			if(age<=0||age>=120)
			{
				System.out.println("Please input a valid age: ");
			}
			else 
			{
				c1.setAge(age);
				checkInput=1;
			}
		}
				
		/**
		 * entering and setting student status
		 */
		System.out.println("Are you a student?(y/n):");
		boolean status=false;
		
		/**
		 * checking for correct input
		 */
		int checkInputTwo=0;
		while(checkInputTwo==0)
		{
			char student=(keyboard.next().charAt(0));
			
			if(student=='y'||student=='Y')
			{
				checkInputTwo=1;
				status=true;
			}
			else if(student=='n'||student=='N')
			{
				checkInputTwo=1;
				status=false;
			}
			else
			{
				System.out.println("Incorrect input.Please enter in again (y/n)");
			}
		
			c1.setStudent(status);
		}
		
		return c1;
	}
	
	/**
	 * Method for customer to select a movie
	 * @param films
	 * @return filmSelected
	 */
	private static Film filmSelection(Film films[])
	{
		System.out.println("Please enter the number corresponding with the film you would like to watch:");
		
		for(int x=0; x<4; x++)
		{
			System.out.println(x+1+")"+films[x].getTitle()+" rating:"+Rating.getSingleLetterRating(films[x].getRating()));
		}
		
		int movieSelected=keyboard.nextInt();
		
		/**
		 * check for valid input
		 */
		while(movieSelected>4||movieSelected<1)
		{
			System.out.println("Input invalid");
			movieSelected=keyboard.nextInt();
		}
		
		Film filmSelected=new Film();
		filmSelected.setTitle(films[movieSelected-1].title);
		filmSelected.setRating(films[movieSelected-1].rating);

		return filmSelected;
	}
	
	/**
	 * Method to set ticket class and check age for selected movie
	 * @param aCustomer
	 * @param aFilm
	 * @return returningTicket
	 */
	public static TicketClass issueTicket(CustomerClass aCustomer, Film aFilm)
	{
		int customerAge=aCustomer.getAge();
	 Rating audienceAge= aFilm.getRating();
	
	//checking customer's age againstmovie's rating
		int outcome = 0;
		
		if(audienceAge==Rating.GENERAL&&customerAge>audienceAge.getMinAge())
		{
			outcome=1;
		}
		else if(audienceAge==Rating.PARENTALGUIDANCE&&customerAge>audienceAge.getMinAge())
		{	
			outcome=1;	
		}
		else if(audienceAge==Rating.MATURE&&customerAge>audienceAge.getMinAge())
		{
				outcome=1;
		}
		
	 TicketClass returningTicket=new TicketClass();
	 if(outcome==1)
	 {
		returningTicket.setCustomerForTicket(aCustomer);
		returningTicket.setFilmForTicket(aFilm);
	 }
	 else if (outcome==0)
	 {
		 returningTicket=null;
	 }
	 
		return returningTicket;
	}
	
}
