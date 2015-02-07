package com.test.examples;

import java.util.HashMap;

public class ClimbingStairs {
	
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) {

		int nofSteps = 5;

		System.out.println(possibleSteps(nofSteps));
		System.out.println(f(nofSteps));
		System.out.println(climbStairs(nofSteps));

	}

	public static int climbStairs(int n) {
		map.put(0, 1);
		map.put(1, 1);
		if (map.containsKey(n))
			return map.get(n);
		map.put(n, climbStairs(n - 1) + climbStairs(n - 2));

		return map.get(n);
	}

	/*
	 * Iteration
	 */
	public static int possibleSteps(int n) {
		if (n <= 2) {
			return n;
		}
		int first = 1, second = 2;
		int third = 0;
		for (int i = 3; i <= n; i++) {
			third = first + second;
			first = second;
			second = third;
		}
		return third;
	}

	/*
	 * recursion
	 */
	public static int f(int n) {
		if (n <= 2)
			return n;
		int x = f(n - 1) + f(n - 2);
		return x;
	}
}
