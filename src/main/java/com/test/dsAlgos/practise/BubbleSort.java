package com.test.dsAlgos.practise;

public class BubbleSort {

	public static void main(String[] args) {

		int count = 0;

		int a[] = { 9, 10, 7, 8, 5, 6, 3, 2, 1, 4 };

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a.length - 1 - i; j++) {
				count += 1;
				int temp;
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ", ");

		System.out.println();
		System.out.println("No of Iterations - " + count);
	}
}
