/**
 * 
 */
package com.test.examples;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author csriram2
 * 
 */
public class WeakHashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		WeakHashMap<String, String> weakHashMap = new WeakHashMap<String, String>();
//
//		Map<String, String> hashMap = new HashMap<String, String>();
//
//		String keyHashMap = new String("keyHashMap");
//		String keyWeakHashMap = new String("keyWeakHashMap");
//
//		hashMap.put(keyHashMap, "Ankita");
//		weakHashMap.put(keyWeakHashMap, "Atul");
//		System.gc();
//		System.out.println("Before: hash map value:"
//				+ hashMap.get("keyHashMap") + " and weak hash map value:"
//				+ weakHashMap.get("keyWeakHashMap"));
//
//		keyHashMap = null;
//		keyWeakHashMap = null;
//
//		System.gc();
//
//		System.out.println("After: hash map value:" + hashMap.get("keyHashMap")
//				+ " and weak hash map value:"
//				+ weakHashMap.get("keyWeakHashMap"));

		Map identityMap = new IdentityHashMap();
		Map hashMap = new HashMap();
		identityMap.put("a", 1);
		identityMap.put(new String("a"), 2);
		identityMap.put("a", 3);
		identityMap.put(new String("a"), 3);
		
		hashMap.put("a", 1);
		hashMap.put(new String("a"), 2);
		hashMap.put("a", 3);

		System.out.println("Identity Map KeySet Size :: "
				+ identityMap.keySet().size());
		System.out
				.println("Hash Map KeySet Size :: " + hashMap.keySet().size());

	}

}
