package com.puzzles.skiig;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.lang.math.NumberUtils;

public class FileReader_Manali {

	static int input[][] = new int[][] { { 56, 14, 51, 58, 88 },
			{ 26, 94, 24, 39, 41 }, { 24, 16, 8, 51, 51 },
			{ 76, 72, 77, 43, 10 }, { 38, 50, 59, 84, 81 },
			{ 5, 23, 37, 71, 77 }, { 96, 10, 93, 53, 82 },
			{ 94, 15, 96, 69, 9 }, { 74, 0, 62, 38, 96 },
			{ 37, 54, 55, 82, 38 } };

	static int numRows = 10;
	static int numColumns = 5;
	static int result[][] = new int[50][7];
	static int resRowIndex = 0;
	static int resColumnIndex = 0;

	public static void main(String[] args) throws IOException,
			URISyntaxException {

		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 7; j++)
				result[i][j] = -1;
		}

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {

				result[resRowIndex][resColumnIndex] = input[i][j];
				resColumnIndex += 1;
				calculateLongestPath(input[i][j], i, j);
				resRowIndex += 1;
				resColumnIndex = 0;
			}
		}

		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 7; j++)
				System.out.print(result[i][j] + ", ");
			System.out.println();
		}
	}

	private static void calculateLongestPath(int element, int rowIndex,
			int columnIndex) {

		int left = -1, right = -1, top = -1, bottom = -1;

		if (columnIndex + 1 < numColumns
				&& input[rowIndex][columnIndex + 1] < element)
			right = input[rowIndex][columnIndex + 1];

		if (rowIndex + 1 < numRows
				&& input[rowIndex + 1][columnIndex] < element)
			bottom = input[rowIndex + 1][columnIndex];

		if (columnIndex - 1 >= 0 && input[rowIndex][columnIndex - 1] < element)
			left = input[rowIndex][columnIndex - 1];

		if (rowIndex - 1 >= 0 && input[rowIndex - 1][columnIndex] < element)
			top = input[rowIndex - 1][columnIndex];

		int maxElement = findMaxElement(left, right, top, bottom);

		if (maxElement == -1)
			return;

		/*
		 * Same Elements exists either at right, left, top or bottom of current
		 * element then ignore the repeated element.
		 */
		if (element == right)
			right = -1;
		else if (element == left)
			left = -1;
		else if (element == top)
			top = -1;
		else if (element == bottom)
			bottom = -1;

		if (maxElement == left) {
			// push the maxElement to the result array
			result[resRowIndex][resColumnIndex] = maxElement;
			resColumnIndex += 1;
			calculateLongestPath(maxElement, rowIndex, columnIndex - 1);
		} else if (maxElement == right) {
			// push the maxElement to the result array
			result[resRowIndex][resColumnIndex] = maxElement;
			resColumnIndex += 1;
			calculateLongestPath(maxElement, rowIndex, columnIndex + 1);
		} else if (maxElement == top) {
			// push the maxElement to the result array
			result[resRowIndex][resColumnIndex] = maxElement;
			resColumnIndex += 1;
			calculateLongestPath(maxElement, rowIndex - 1, columnIndex);
		} else if (maxElement == bottom) {
			// push the maxElement to the result array
			result[resRowIndex][resColumnIndex] = maxElement;
			resColumnIndex += 1;
			calculateLongestPath(maxElement, rowIndex + 1, columnIndex);
		}
	}

	private static int findMaxElement(int left, int right, int top, int bottom) {

		int array[] = new int[] { left, right, top, bottom };
		return NumberUtils.max(array);
	}
}
