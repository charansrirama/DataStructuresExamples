package com.test.examples;

public class LinkedListImpl {

	Node header;
	int size;

	public LinkedListImpl() {
		header = null;
		size = 0;
	}

	public void add(Object data) {

		if (header == null) {
			header = new Node(data);
			size += 1;
			return;
		}

		Node current = header;

		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
		size += 1;
	}

	public void add(Object data, int index) {
		Node temp = new Node(data);
		Node current = header;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for (int i = 1; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}
		// set the new node's next-node reference to this node's next-node
		// reference
		temp.setNext(current.getNext());
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		size++;// increment the number of elements variable
	}

	public Object get(int index) {

		if (size < index)
			return null;
		else if (index == 0)
			return header.getData();

		Node current = header.getNext();
		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return null;

			current = current.getNext();
		}
		return current.getData();
	}

	public boolean remove(int index) {

		if (index < 0)
			return false;
		else if (index == 0) {
			header = header.next;
			return true;
		}

		Node current = header;

		for (int i = 1; i < index; i++) {
			if (current.getNext() == null)
				return false;

			current = current.getNext();
		}

		if (current.getNext().getNext() != null)
			current.setNext(current.getNext().getNext());
		else
			current.setNext(null);

		size -= 1;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedListImpl linkedListImpl = new LinkedListImpl();
		linkedListImpl.add(1);
		linkedListImpl.add(2);
		linkedListImpl.add(3);
		linkedListImpl.add(4);
		linkedListImpl.add(5);

		for (int i = 0; i < linkedListImpl.size; i++) {
			System.out.println(linkedListImpl.get(i));
		}

		System.out.println("----------------------------");
		linkedListImpl.reverseListIteratively(linkedListImpl);

		for (int i = 0; i < linkedListImpl.size; i++) {
			System.out.println(linkedListImpl.get(i));
		}

		// System.out.println(linkedListImpl.get(0));
		// System.out.println(linkedListImpl.size);
		// System.out.println(linkedListImpl.remove(0));
		// System.out.println(linkedListImpl.get(0));
		// System.out.println(linkedListImpl.size);

	}

	/*
	 * 
	 */
	public void reverseListIteratively(LinkedListImpl linkedListImpl) {
		
		Node head = linkedListImpl.header;
		if (head == null || head.next == null)
			return; // empty or just one node in list

		Node Second = head.next;

		// store third node before we change
		Node Third = Second.next;

		// Second's next pointer
		Second.next = head; // second now points to head
		head.next = null; // change head pointer to NULL

		// only two nodes, which we already reversed
		if (Third == null)
			return;

		Node CurrentNode = Third;

		Node PreviousNode = Second;

		while (CurrentNode != null) {
			
			Node NextNode = CurrentNode.next;
			CurrentNode.next = PreviousNode;

			/*
			 * repeat the process, but have to reset the PreviousNode and
			 * CurrentNode
			 */

			PreviousNode = CurrentNode;
			CurrentNode = NextNode;
		}

		head = PreviousNode; // reset the head node
		// head.next = null;
		linkedListImpl.header = head;
	}
}
