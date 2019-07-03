package cs143;

import java.util.ArrayList;
import java.util.Random;

public class Searcher {

	/**
	 * Returns the number of comparisons needed to find the item in the list. This
	 * method requires the list is sorted low to high
	 *
	 * @param find
	 *            the id of the item to find
	 * @param The
	 *            list to search for the item.
	 * @return The number of comparisons needed to find the itemL
	 */
	public static int binarySearch(String IdToFind, ArrayList<Employee> sortMe) {
		int count = 1;

		int min = 0;
		int max = sortMe.size() - 1;
		int check = (max + min) / 2;
		int compared = sortMe.get(check).getID().compareTo(IdToFind);
		while (compared != 0) {

			if (compared > 0) {
				max = check - 1;
				

			} else if (compared < 0) {
				min = check + 1;
			
			}
			else if (max == min)
			{
			    count++;
				return count;
			}
			 check = (max + min) / 2;
			 compared = sortMe.get(check).getID().compareTo(IdToFind);
			 count++;
			
		}
	
		return count;

	}

	/**
	 * Returns the number of comparisons needed to find the item in the list. This
	 * method requires the list is sorted low to high
	 *
	 * @param find
	 *            the id of the item to find
	 * @param The
	 *            list to search for the item.
	 * @return The number of comparisons needed to find the itemL
	 */
	public static int linearSearch(String IdToFind, ArrayList<Employee> sortMe) {
		int count = -1;
		for (int i = 0; i < sortMe.size(); i++) {

			if (sortMe.get(i).getID().equals(IdToFind)) {
				count = i;
				break;
			}

		}

		return count;

	}
}
