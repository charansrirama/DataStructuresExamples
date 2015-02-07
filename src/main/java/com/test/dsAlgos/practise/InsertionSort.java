/**
 * 
 */
package com.test.dsAlgos.practise;

/**
 * @author csriram2
 * 
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int count = 0;

		int a[] = { 9, 10, 7, 8, 5, 6, 3, 2, 1, 4 };

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				count += 1;
				if (a[j] < a[j - 1]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ", ");

		System.out.println();
		System.out.println("No of Iterations - " + count);

	}

}
