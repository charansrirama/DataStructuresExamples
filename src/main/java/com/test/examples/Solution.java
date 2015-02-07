package com.test.examples;

class Solution {

	public static int[][] field = { { 2, 2, 3, 0 }, { 0, 3, 1, 1 },
			{ 1, 2, 2, 1 }, { 4, 1, 2, 2 } };

	public static int solution(int[][] array) {
		// write your code in Java SE 8
		if (array == null)
			return 0;

		if (array.length == 0 || array[0].length == 0)
			return 0;

		// no of rows
		final int noOfRows = array.length;
		// no of columns
		final int noOfColumns = array[0].length;
		// First Element
		final int firstElement = array[0][0];

		if (noOfRows == 1 && noOfColumns == 1)
			return firstElement;

		if (noOfColumns < noOfRows) {

			int[] dynmicProg = new int[noOfColumns];
			dynmicProg[noOfColumns - 1] = array[noOfRows - 1][noOfColumns - 1];

			for (int i = noOfColumns - 2; i >= 0; i--) {
				dynmicProg[i] = array[noOfRows - 1][i] + dynmicProg[i + 1];
			}

			for (int row = noOfRows - 2; row >= 0; row--) {
				for (int column = noOfColumns - 1; column >= 0; column--) {
					if (column == noOfColumns - 1) {
						dynmicProg[column] = dynmicProg[column]
								+ array[row][column];
					} else {
						dynmicProg[column] = array[row][column]
								+ Math.max(dynmicProg[column],
										dynmicProg[column + 1]);
					}
				}
			}
			return dynmicProg[0];
		}

		else {

			int[] dp = new int[noOfRows];
			dp[noOfRows - 1] = array[noOfRows - 1][noOfColumns - 1];
			for (int i = noOfRows - 2; i >= 0; i--) {
				dp[i] = array[i][noOfColumns - 1] + dp[i + 1];
			}
			for (int column = noOfColumns - 2; column >= 0; column--) {
				for (int row = noOfRows - 1; row >= 0; row--) {
					if (row == noOfRows - 1) {
						dp[row] += array[row][column];
					} else {
						dp[row] = array[row][column]
								+ Math.max(dp[row], dp[row + 1]);
					}
				}
			}
			return dp[0];
		}
	}

	public static int max(int r, int c) {
		// Base case
		if (r == 0 && c == 0) {
			return field[r][c];
		}
		// Assuming a positive number of strawberries in each plot, otherwise
		// this needs to be negative infinity
		int maxTop = -1, maxLeft = -1;

		// We can't come from the top if we're in the top row
		if (r != 0) {
			maxTop = field[r - 1][c];
		}

		// Similarly, we can't come from the left if we're in the left column
		if (c != 0) {
			maxLeft = field[r][c - 1];
		}
		// Take whichever gives you more and return..
		return Math.max(maxTop, maxLeft) + field[r][c] + max(r - 1, c - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[][] A2 = { { 2, 2, 3, 0 } };
		int[][] A3 = { { 2 }, { 0 }, { 1 }, { 4 } };
		int[][] A4 = { {} };
		System.out.println(solution(field));
		System.out.println(solution(A2));
		System.out.println(solution(A3));
		System.out.println(solution(A4));

		// Dynamic Programming technique
		int rows = field.length;
		int columns = field[0].length;
		int[][] maxValues = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 0 && j == 0) {
					maxValues[i][j] = field[i][j];
				} else if (i == 0) {
					maxValues[i][j] = maxValues[i][j - 1] + field[i][j];
				} else if (j == 0) {
					maxValues[i][j] = maxValues[i - 1][j] + field[i][j];
				} else {
					maxValues[i][j] = Math.max(maxValues[i][j - 1],
							maxValues[i - 1][j]) + field[i][j];
				}
			}
		}

		System.out.println("Dynamic Programming Technique: "
				+ maxValues[rows - 1][columns - 1]);

		System.out
				.println("Recursion Technique: " + max(rows - 1, columns - 1));

		int[] inputArr = { 1, 3, 5, 3, 7 };

		int[] sortedArr = { 1, 3, 3, 5, 7 };

		int noOfSwaps = 0;
		int b = 0;

		for (int i = 0; i < inputArr.length; i++) {

			if (inputArr[i] == sortedArr[b]) {
				b = b + 1;
			} else {
				noOfSwaps = noOfSwaps + 1;
				if (noOfSwaps > 2) {
					System.out.println("More Than one Swap Operation");
				}
			}
		}
	}
}