package TicketIssuing;

import TicketIssuing.Rating;

/**
 * The film class stores variables relating to the film.
 * Title and rating
 * Objects in this class are used in the CinemaTicketApplication to generate tickets for movies.
 *  A public class to be accessed in the main program to create new constructors and hold film information
 * @author Ashley C
 */
public class Film{
	String title;
	Rating rating;
	
	/**
	 * default constructor
	 */
	public Film()
	{
		title="UNKNOWN";
		rating=Rating.UNKNOWN;
	}
	
	/**
	 * information entered constructor with 3 input variables
	 * @param filmTitle
	 * @param filmRating
	 */
	public Film(String filmTitle, Rating filmRating)
	{
		this.title=filmTitle;
		this.rating=filmRating;
	}
	
	/**
	 * convert information into a string
	 */
	public String toString()
	{
		return "FILM TICKET for: "+this.getTitle()+" rating:"+Rating.getSingleLetterRating(this.getRating());
	}
	
	/**
	 * Return's film title
	 * @return title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Set's the title of chosen film
	 * @param setTitle
	 */
	public void setTitle (String setTitle)
	{
		this.title= setTitle;
	}
	
	/**
	 * returns the film's rating
	 * @return rating
	 */
	public Rating getRating()
	{
		return rating;
	}
	
	/**
	 * set the rating to be that of the chosen film's
	 * @param setRating
	 */
	public void setRating(Rating setRating)
	{
		this.rating=setRating;
	}
}



