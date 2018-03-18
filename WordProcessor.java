//import classes for file input - scanner etc.
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordProcessor 
{
	private static <E> String displaySet(Set<E> inputSet)
	{
		//implement this static method to create a
		// String representation of set - 5 comma separated elements per line
		// assume that type E has a toString method

		return ""; // placeholder
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FileReader reader;
		Scanner in;
		String w;  

		Set<String> wordSet = new TreeSet<String>();
		Set<CountedElement<String>> countedWordSet = new TreeSet<CountedElement<String>>();

		for (String fileName: args) 
		{	
			try 
			{	
				reader = new FileReader(fileName);
				in = new Scanner (reader);

				while (in.hasNextLine()) 
				{
					w = in.nextLine();

					boolean found = false; 	
					for (CountedElement<String> countedElement: countedWordSet) 	
					{
						if(countedElement.getElement().equals(w)) {
							int c = countedElement.getCount(); 
							countedElement.setCount(c++);
							found = true;
							break;
						}
					}

					if (!found)
					{
						wordSet.add(w);
						CountedElement<String> cElement = new CountedElement<String>(w);

						wordSet.add(w);
						countedWordSet.add(cElement);
					}

				}

				in.close(); 
			}

			catch (FileNotFoundException e) {
				System.out.println("File not found");
			}

		}

		System.out.println(displaySet(countedWordSet));

	}
}