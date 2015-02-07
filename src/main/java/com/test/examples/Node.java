/**
 * 
 */
package com.test.examples;

/**
 * @author csriram2
 * 
 */
public class Node {

	Object data;
	Node next;

	public Node(Object data) {
		next = null;
		this.data = data;
	}

	public Node(Node next, Object data) {
		this.next = next;
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

}