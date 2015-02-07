/**
 * 
 */
package com.test.dsAlgos.practise;

/**
 * @author csriram2
 * 
 */
public class QuickSort {

	static int a[] = { 9, 10, 7, 8, 5, 6, 3, 2, 1, 4 };
	static int count;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		quickSort(0, a.length - 1);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ", ");

		System.out.println();
		System.out.println("No Of Iterations - " + count);
	}

	private static void quickSort(int low, int high) {

		count += 1;

		int i = low;
		int j = high;

		int pivot = (low + high) / 2;

		while (i <= j) {

			count += 1;

			while (a[i] < a[pivot]) {
				count += 1;
				i++;
			}

			while (a[j] > a[pivot]) {
				count += 1;
				j--;
			}

			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;

				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(low, j);
		if (i < high)
			quickSort(i, high);
	}
}
