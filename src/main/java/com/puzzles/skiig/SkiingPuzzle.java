package com.puzzles.skiig;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.math.NumberUtils;

public class SkiingPuzzle {

	static int input[][];
	static int result[][];

	static int numRows;
	static int numColumns;
	static int resRowIndex = 0;
	static int resColumnIndex = 0;

	public static void main(String[] args) throws IOException,
			URISyntaxException {

		List<String> inputFileData = FileUtils.readLines(new File(
				SkiingPuzzle.class.getClassLoader()
						.getResource("himalayas/input.txt").toURI()));
		Map<String, Integer> longestPaths = new HashMap<String, Integer>();

		final int numTestCases = Integer.parseInt(inputFileData.get(0).trim());
		inputFileData.remove(0);
		int recordLineNumber = 0;

		for (int i = 0; i < numTestCases; i++) {

			String str = inputFileData.get(recordLineNumber);
			String[] metadata = str.split(" ");
			final String city = metadata[0];
			final int numRows = Integer.parseInt(metadata[1].trim());
			final int numColumns = Integer.parseInt(metadata[2].trim());
			final List<String> recordData = new ArrayList<String>();
			for (int j = 1; j <= numRows; j++) {
				recordData.add(inputFileData.get(j + recordLineNumber));
			}
			recordLineNumber += numRows + 1;
			final int longestSteps = findLongestPath(city, numRows, numColumns,
					recordData);
			System.out.println(city + ": " + longestSteps);
			longestPaths.put(city, longestSteps);
		}
		System.out.println("--------------------------");
		for (String city : longestPaths.keySet()) {
			System.out.println(city + ": " + longestPaths.get(city));
		}
	}

	private static int findLongestPath(String city, int rows, int columns,
			List<String> recordData) {

		int longestSteps = 0;

		numRows = rows;
		numColumns = columns;

		resRowIndex = 0;
		resColumnIndex = 0;

		input = new int[numRows][numColumns];
		result = new int[numRows * numColumns][numRows * 10];

		for (int i = 0; i < numRows * numColumns; i++) {
			for (int j = 0; j < numRows * 10; j++) {
				result[i][j] = -1;
			}
		}

		for (int i = 0; i < numRows; i++) {
			String[] record = recordData.get(i).split(" ");
			for (int j = 0; j < numColumns; j++) {
				input[i][j] = Integer.parseInt(record[j]);
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

		List<Integer> counters = new ArrayList<Integer>();
		for (int i = 0; i < numRows * numColumns; i++) {
			int noOfPeaksInPath = 0;
			for (int j = 0; j < numRows * 10; j++) {
				if (result[i][j] == -1)
					break;
				noOfPeaksInPath += 1;
			}
			counters.add(noOfPeaksInPath);
		}

		Collections.sort(counters);

		if (counters.size() > 1)
			longestSteps = counters.get(counters.size() - 1);

		return longestSteps;
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

		final int maxElement = findMaxElement(left, right, top, bottom);

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
