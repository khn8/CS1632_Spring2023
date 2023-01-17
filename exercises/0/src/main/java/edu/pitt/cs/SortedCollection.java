package edu.pitt.cs;

//TODO: Import libraries as needed
import java.util.NoSuchElementException;
import java.util.*;

public class SortedCollection {
	// TODO: Add member variables or methods as needed
	ArrayList<Integer> arr;

	public SortedCollection() {
		arr = new ArrayList<Integer>();
	}

	public SortedCollection(String[] strArr) {
		arr = arrToList(stringToInt(strArr));
	}

	public int[] stringToInt(String[] strArr) {
		int[] intArr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		return intArr;
	}

	public ArrayList<Integer> arrToList(int[] intArr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : intArr) {
			list.add(i);
		}
		Collections.sort(list);
		return list;
	}

	/**
	 * Adds the number n to the collection.
	 * 
	 * @param n the number to add to the collection
	 * @return always returns true
	 */
	public boolean add(int n) {
		// TODO: Implement
		arr.add(n);
		Collections.sort(arr);
		return true;
	}

	/**
	 * Removes the smallest number in the collection and returns it.
	 * If the collection is empty, throws a NoSuchElementException.
	 * 
	 * @return the smallest number in the collection
	 */
	public int remove() throws NoSuchElementException {
		// TODO: Implement
		if (arr.isEmpty())
			throw new NoSuchElementException("No elements in array!");

		int removed = arr.remove(0);
		Collections.sort(arr);

		return removed;

	}

	/**
	 * Prints usage information.
	 */
	public static void showUsage() {
		System.out.println("Usage: java SortedCollection [num1] [num2] [num3] ...");
	}

	/**
	 * Main method. Receives a list of numbers as commandline arguments and prints
	 * out the list in sorted order from smallest to largest.
	 * 
	 * @param args commandline arguments; see showUsage() for detailed information
	 */
	public static void main(String[] args) {
		SortedCollection collection = new SortedCollection();
		if (args.length == 0) {
			showUsage();
			return;
		}

		// TODO: add numbers in commandline arguments to collection using the add(int)
		// method.
		// If any commandline argument is not a number, call showUsage() and return.

		for (String arg : args) {
			for (char c : arg.toCharArray()) {
				if (!Character.isDigit(c) && c != '-') {

					showUsage();
					return;
				}

			}
			collection.add(Integer.parseInt(arg));
		}

		System.out.print("sorted: ");
		for (int i = 0; i < args.length; i++) {
			int num = collection.remove();
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
