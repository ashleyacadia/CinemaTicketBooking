package TicketIssuing;
/**
 * The rating enumeration class has set variable names relating to the film rating and the minimum age of each rating.
 * General - 0 - Parental Guidance - 12 - Mature - 16 - and unknown as the default.
 * minAge int variable
 * Objects in this class are used in the CinemaTicketApplication to generate tickets ratings for movies.
 *  A public class to be accessed.
 * @author Ashley C
 */

public enum Rating{
	GENERAL(0),
	PARENTALGUIDANCE(12),//>=12
	MATURE(16),//>=16
	UNKNOWN(0);//default
	int minAge;
	
	/**
	 * default constructor
	 */
	private Rating(int minAge)
	{
		this.minAge=minAge;
	}
	
	/**
	 * return's the age minimum for selected film's rating
	 * @return minAge
	 */
	public int getMinAge() {
		return minAge;
	}
	
	/**
	 * set the selected film's rating for the film object
	 * @param minAge
	 */
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	
	/**
	 * returns a set formatted string
	 */
	public String toString()
	{
		return this.name();
	}
	
	/**
	 * changed the enum to abbreviated versions in brackets
	 * @param string
	 * @return
	 */
	public static String getSingleLetterRating(Rating string) 
	{
		String rating="0";
		if(string==GENERAL)
		{
			rating ="(G)";
		}
		else if(string==PARENTALGUIDANCE)
		{
			rating="(PG)";
		}
		else if(string==MATURE)
		{
			rating="(M)";
		}
		
		return rating;
	}
};



