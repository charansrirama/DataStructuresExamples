package com.test.examples;

public class SortingAlgos {

	static int array[] = { 5, 6, 4, 8, 3, 9, 1 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Bubble Sort
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length - 1; j++) {
				int temp = 0;
				if (array[j] > array[j + 1]) {

					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		// Selection Sort
		for (int i = 0; i < array.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < array.length; j++)
				if (array[j] < array[index])
					index = j;

			int smallerNumber = array[index];
			array[index] = array[i];
			array[i] = smallerNumber;
		}

		// Insertion Sort
		int temp;
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}

		// Quick Sort
		quickSort(0, array.length - 1);

		binarySearch(9);
		// binarySearch(11);

		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");

	}

	private static void quickSort(int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a
			 * number from right side which is less then the pivot value. Once
			 * the search is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}

	private static void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Binary Search
	private static void binarySearch(int element) {

		int first = 0;
		int last = array.length - 1;
		int middle = (first + last) / 2;

		while (first <= last) {

			if (array[middle] < element)
				first = middle + 1;

			else if (array[middle] > element)
				last = middle - 1;

			else if (array[middle] == element) {
				System.out.println(element + " found at location "
						+ (middle + 1) + ".");
				break;
			}

			middle = (first + last) / 2;
		}

		if (first > last)
			System.out.println(element + " is not present in the list.\n");
	}
}
