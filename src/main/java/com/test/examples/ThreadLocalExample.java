package com.test.examples;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalExample {
	private static final ThreadLocal formatter = new ThreadLocal() {

		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd HHmm");
		}
	};

	public String formatIt(Date date) {
		return ((DateFormat) formatter.get()).format(date);
	}
}