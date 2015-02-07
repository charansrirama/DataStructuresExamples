package com.test.dsAlgos.practise;

public class SelectionSort {

	public static void main(String[] args) {

		int count = 0;

		int a[] = { 9, 10, 7, 8, 5, 6, 3, 2, 1, 4 };

		for (int i = 0; i < a.length; i++) {

			int smallIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				count += 1;
				if (a[j] < a[smallIndex])
					smallIndex = j;
			}

			int smallNum = a[smallIndex];
			a[smallIndex] = a[i];
			a[i] = smallNum;

		}

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ", ");

		System.out.println();
		System.out.println("No of Iterations - " + count);

	}

}
