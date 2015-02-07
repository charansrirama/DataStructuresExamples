package com.test.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestHashMap {

	public static void main(String[] args) {
		Map<TestKey, Integer> map = new HashMap<TestKey, Integer>();

		System.out.println(1344102076 & 15);
		System.out.println(1083851990 & 15);

		TestKey key1 = new TestKey(24, 239654);
		TestKey key2 = new TestKey(25, 894025);

		map.put(key1, 1);
		map.put(key2, 2);
		map.put(new TestKey(25, 894025), 3);
		map.put(new TestKey(25, 894025), 4);
		map.put(new TestKey(25, 894025), 5);
		map.put(new TestKey(25, 894025), 6);
		map.put(new TestKey(25, 894025), 7);
		map.put(new TestKey(25, 894025), 8);
		map.put(new TestKey(25, 894025), 9);
		map.put(new TestKey(25, 894025), 10);
		map.put(new TestKey(25, 894025), 11);
		map.put(new TestKey(25, 894025), 12);
		map.put(new TestKey(25, 894025), 13);
		map.put(new TestKey(25, 894025), 14);
		// map.put(new TestKey(25, 894025), 3);
		// map.put(new TestKey(25, 894025), 3);
		// map.put(new TestKey(25, 894025), 3);
		// map.put(new TestKey(25, 894025), 3);
		// map.put(new TestKey(25, 894025), 3);
		// map.put(new TestKey(25, 894025), 3);
		// map.put(new TestKey(25, 894025), 3);
		// map.put(new TestKey(25, 894025), 3);
		// map.put(new TestKey(25, 894025), 3);

		for (TestKey testKey : map.keySet()) {
			System.out.println("Key: " + testKey + ", Value: "
					+ map.get(testKey));
			System.out.println(testKey.hashCode());
		}

		for (Map.Entry<TestKey, Integer> entry : map.entrySet()) {
			System.out.println("Entry Key: " + entry.getKey()
					+ ", Entry Value:" + entry.getValue());
		}

		key1.setAge(30);
		// map.put(key1, 3);

		System.out.println("-----------------------");

		for (TestKey testKey : map.keySet()) {
			System.out.println("Key: " + testKey + ", Value: "
					+ map.get(testKey));
			System.out.println(testKey.hashCode());
		}

		for (Map.Entry<TestKey, Integer> entry : map.entrySet()) {
			System.out.println("Entry Key: " + entry.getKey()
					+ ", Entry Value:" + entry.getValue());
		}
		
		int i =0;
		i ^= 10;
        i ^= i >>> 20 ^ i >>> 12;
        System.out.println(i ^ i >>> 7 ^ i >>> 4);

	}
}
