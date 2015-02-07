package com.puzzles.skiig;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

public class FileReader_Narkanda {

	static int input[][] = new int[][] { { 1, 2, 3, 4, 5 },
			{ 16, 17, 18, 19, 6 }, { 15, 24, 25, 20, 7 },
			{ 14, 23, 22, 21, 8 }, { 13, 12, 11, 10, 9 } };

	static int numRows = 5;
	static int numColumns = 5;
	static int result[][] = new int[100][100];
	static int resRowIndex = 0;
	static int resColumnIndex = 0;

	public static void main(String[] args) throws IOException,
			URISyntaxException {

		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				result[i][j] = -1;
			}
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

		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				System.out.print(result[i][j] + ", ");
			}
			System.out.println();
		}
	}

	private static void calculateLongestPath(int element, int rowIndex,
			int columnIndex) {

		int left = -1, right = -1, top = -1, bottom = -1;
		final Map<String, Integer> map = new HashMap<String, Integer>();
		// final List<Integer> eligibleElements = new ArrayList<Integer>();

		if (columnIndex + 1 < numColumns
				&& input[rowIndex][columnIndex + 1] < element) {
			right = input[rowIndex][columnIndex + 1];
			map.put("right", right);
			// eligibleElements.add(right);
		}

		if (rowIndex + 1 < numRows
				&& input[rowIndex + 1][columnIndex] < element) {
			bottom = input[rowIndex + 1][columnIndex];
			map.put("bottom", bottom);
			// eligibleElements.add(bottom);
		}

		if (columnIndex - 1 >= 0 && input[rowIndex][columnIndex - 1] < element) {
			left = input[rowIndex][columnIndex - 1];
			map.put("left", left);
			// eligibleElements.add(left);
		}

		if (rowIndex - 1 >= 0 && input[rowIndex - 1][columnIndex] < element) {
			top = input[rowIndex - 1][columnIndex];
			map.put("top", top);
			// eligibleElements.add(top);
		}

		// Do the recursion for every less element
		for (String direction : map.keySet()) {

			if (direction.equalsIgnoreCase("left")) {

				result[resRowIndex][resColumnIndex] = left;
				if (columnIndex - 1 >= 0) {
					resColumnIndex += 1;
					calculateLongestPath(left, rowIndex, columnIndex - 1);
				} else {
					resColumnIndex = 0;
					return;
				}

			} else if (direction.equalsIgnoreCase("right")) {

				result[resRowIndex][resColumnIndex] = right;
				if (columnIndex + 1 <= numColumns) {
					resColumnIndex += 1;
					calculateLongestPath(right, rowIndex, columnIndex + 1);
				} else {
					resColumnIndex = 0;
					return;
				}

			} else if (direction.equalsIgnoreCase("top")) {

				result[resRowIndex][resColumnIndex] = top;
				if (rowIndex - 1 >= 0) {
					resColumnIndex += 1;
					calculateLongestPath(top, rowIndex - 1, columnIndex);
				} else {
					resColumnIndex = 0;
					return;
				}

			} else if (direction.equalsIgnoreCase("bottom")) {

				result[resRowIndex][resColumnIndex] = bottom;
				if (rowIndex + 1 <= numRows) {
					resColumnIndex += 1;
					calculateLongestPath(bottom, rowIndex + 1, columnIndex);
				} else {
					resColumnIndex = 0;
					return;
				}
			} else {
				return;
			}
		}
	}

	private static int findMaxElement(int left, int right, int top, int bottom) {

		int array[] = new int[] { left, right, top, bottom };
		return NumberUtils.max(array);
	}

	private static int findMaxElementIndex(int left, int right, int top,
			int bottom) {

		int array[] = new int[] { left, right, top, bottom };
		int maxElement = array[0];
		int maxElementIndex = 0;

		for (int i = 1; i < array.length; i++) {
			if (maxElement > array[i]) {
				maxElement = array[i];
				maxElementIndex = i;
			}
		}
		return maxElementIndex;
	}
}
