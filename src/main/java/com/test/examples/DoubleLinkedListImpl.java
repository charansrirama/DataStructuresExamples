package com.test.examples;

class NodeInDLL {
	public int iData;
	public NodeInDLL next;
	public NodeInDLL previous;

	public NodeInDLL(int id) {
		iData = id;
	}

	public String toString() {
		return "{" + iData + "} ";
	}
}

class DoublyLinkedList {
	private NodeInDLL first;
	private NodeInDLL last;

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int data) {
		NodeInDLL newLink = new NodeInDLL(data);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(int dd) {
		NodeInDLL newLink = new NodeInDLL(dd);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}

	public NodeInDLL deleteFirst() {
		NodeInDLL temp = first;
		if (first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}

	public NodeInDLL deleteLast() {
		NodeInDLL temp = last;
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}

	public boolean insertAfter(int key, int dd) {
		NodeInDLL current = first;
		while (current.iData != key) {
			current = current.next;
			if (current == null) {
				return false;
			}
		}
		NodeInDLL newLink = new NodeInDLL(dd);

		if (current == last) {
			newLink.next = null;
			last = newLink;
		} else {
			newLink.next = current.next;

			current.next.previous = newLink;
		}
		newLink.previous = current;
		current.next = newLink;
		return true;
	}

	public NodeInDLL deleteKey(int key) {
		NodeInDLL current = first;
		while (current.iData != key) {
			current = current.next;
			if (current == null)
				return null;
		}
		if (current == first) {
			first = current.next;
		} else {
			current.previous.next = current.next;
		}

		if (current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}
		return current;
	}

	public String toString() {
		String str = "List (first-->last): ";
		NodeInDLL current = first;
		while (current != null) {
			str += current.toString();
			current = current.next;
		}
		System.out.println("");
		System.out.print("List (last-->first): ");

		current = last;
		while (current != null) {
			str += current.toString();
			current = current.previous;
		}
		return str;
	}
}

public class DoubleLinkedListImpl {
	public static void main(String[] args) {
		DoublyLinkedList theList = new DoublyLinkedList();

		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);

		theList.insertLast(11);
		theList.insertLast(33);
		theList.insertLast(55);

		System.out.println(theList);

		theList.deleteFirst();
		theList.deleteLast();
		theList.deleteKey(11);

		System.out.println(theList);

		theList.insertAfter(22, 77);
		theList.insertAfter(33, 88);

		System.out.println(theList);
	}
}