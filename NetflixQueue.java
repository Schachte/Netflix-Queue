import java.util.*;
public class NetflixQueue {
	/*
	 * Builds a hypothetical command line Netflix queue
	 * 
	 */
	
	public static void main(String[]args)
	{
		
	Scanner input = new Scanner(System.in);			 //Gather user input with scanner class and input object
	Queue<String> movies = new LinkedList<String>(); //Implement queue using a linked list to store users movie into a queue	
	
		
	System.out.println("******************************\nWELCOME TO THE NETFLIX QUEUE!\n******************************");
	printMenu();
	String option = input.nextLine();
	option = option.toLowerCase();
	boolean loop = true;
	while (loop)
	{
		switch (option)
		{
			case "a": //Add movie
				String movieAdd = addMovie();
				movies.add(movieAdd);
				System.out.println(movieAdd + " added to queue!");
				System.out.println("");
				System.out.println("Choose a new option: (E to print menu) ");
				
				option = input.nextLine();
				option = option.toLowerCase();
				break;
			case "b": //View queue
				viewQueue(movies);
				System.out.println("");
				System.out.println("Choose a new option: (E to print menu) ");
				
				option = input.nextLine();
				option = option.toLowerCase();
				
				break;
			case "c": //Search movie in queue
				
				System.out.println("What movie would you like to search for?");
				
				String movieToFind = input.nextLine();
				
				System.out.println(movieSearch(movieToFind, movies));
				
				System.out.println("");
				
				System.out.println("Choose a new option: (E to print menu) ");
				
				option = input.nextLine();
				option = option.toLowerCase();
			
				break;
			case "d": //Remove movie from queue
				System.out.println("What movie would you like to remove?");
				System.out.println("");
				String movieRemove = input.nextLine();
				movies = removeMovie(movies, movieRemove);
				System.out.println("");
				
				System.out.println("Choose a new option: (E to print menu) ");
				
				option = input.nextLine();
				option = option.toLowerCase();

				break;
			case "e": //Print program menu
				printMenu();
				System.out.println("");
				System.out.println("Choose a new option: (E to print menu) ");
				
				option = input.nextLine();
				option = option.toLowerCase();
				
				break;
			case "f": //Exit program
				System.out.println("Exiting Program, goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
		}
	}
	
	}
	
	public static String addMovie()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("What movie would you like to add to the queue?");
		System.out.println("");
		String movieAdd = input.nextLine();
		return movieAdd;
	}
	
	public static void viewQueue(Queue<String> movieList)
	{
		Iterator<String> iter = movieList.iterator();	//Iterate through the queue (moves to front of queue)
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
	
	public static Queue<String> removeMovie(Queue<String> movieList, String movieName)
	{
		
		Iterator<String> iter = movieList.iterator();
		

		int count = 0;
		
		if (movieList.size()==0)
		{
			System.out.println("List is empty!");
			
		}
		else if (movieList.size()!=0)
		{
		
		while (count < movieList.size())
		{

			if (iter.next().toString().equalsIgnoreCase(movieName))
			{
				iter.remove();
				System.out.println("");
				System.out.println(movieName + " was removed");
				System.out.println("");
				break;
			}

			else if (iter.hasNext())
			{
				count++;
			}
			else
				break;

		}
			
		}
		
		return movieList;
	}
	
	public static String movieSearch(String movie, Queue movieList)
	{
		
		ListIterator iter = ((AbstractList<String>) movieList).listIterator();
		int count = 1;
		String movieFound = "";
		boolean found = false;


		while (iter.hasNext())
		{

			if (iter.next().toString().equals(movie))
			{
				movieFound = movie + " was found at position " + count + "!";
				found = true;
				break;
			}
				count++;
		}
		

		if (!found)
		{
			movieFound = "Sorry, the movie " + movie + " was not found in the list.";
		}
		
		
		
		return movieFound;
	}
	
	public static void printMenu()
	{
		System.out.println("Would you like to:\n\tA: Add movie to queue\n\tB: View current queue\n\tC: Search movie in queue\n\tD: Remove movie from queue\n\tE: Print Menu\n\tF: Exit");
	}

}
