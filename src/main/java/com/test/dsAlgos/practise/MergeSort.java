package com.test.dsAlgos.practise;

public class MergeSort {

	static int count;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 9, 10, 7, 8, 5, 6, 3, 2, 1, 4 };

		mergeSort(a);

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ", ");

		System.out.println();
		System.out.println("Count - "+count);

	}

	private static void mergeSort(int a[]) {

		count += 1;

		if (a.length < 2)
			return;

		int midIndex = a.length / 2;

		int leftArray[] = new int[midIndex];
		for (int i = 0; i < midIndex; i++)
			leftArray[i] = a[i];

		int rightArray[] = new int[a.length - midIndex];
		for (int i = midIndex; i < a.length; i++)
			rightArray[i - midIndex] = a[i];

		mergeSort(leftArray);
		mergeSort(rightArray);
		doMerge(leftArray, rightArray, a);

	}

	private static void doMerge(int leftArray[], int rightArray[], int array[]) {

		int i = 0, j = 0, k = 0;
		count+=1;

		int nL = leftArray.length;
		int nR = rightArray.length;
		int n = array.length;

		while (i < nL && j < nR) {

			if (leftArray[i] < rightArray[j]) {
				array[k] = leftArray[i];
				i++;
				k++;
			}

			else {
				array[k] = rightArray[j];
				j++;
				k++;
			}
		}

		while (i < nL) {
			array[k] = leftArray[i];
			k++;
			i++;
		}

		while (j < nR) {
			array[k] = rightArray[j];
			k++;
			j++;
		}
	}
}