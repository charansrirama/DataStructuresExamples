package com.test.examples;

class A {

	static int val = 10;
	final int finalVal = 9;

}

/*
 * static variables are inherited by sub class. If subclass changes the value of
 * parent class's static variable then the updated value will be seen in both
 * sub class and parent class also.
 * 
 * Final Variables are also inherited by sub class but the sub class cannot
 * change its value since it is final.
 */

public class Test extends A {

	public static void main(String[] args) {

		Test test = new Test();
		//test.finalVal = 10; // Compile Error

		System.out.println(A.val);
		System.out.println(Test.val);
		Test.val = 20;
		System.out.println(A.val);
		System.out.println(Test.val);
	}

}
