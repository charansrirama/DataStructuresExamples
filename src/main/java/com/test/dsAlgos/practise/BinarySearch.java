package com.test.dsAlgos.practise;

public class BinarySearch {

	static int array[] = { 9, 10, 7, 8, 5, 6, 3, 2, 1, 4 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length - 1 - i; j++) {
				int temp;
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		
		binarySearch(8);

	}

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
