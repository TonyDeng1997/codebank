package com.webbertech.leetcode.design;
import java.util.HashMap;
/*
 * This code is not accurate, it is just a simulation of idea
 * */
public class Cache {
	public static int MAX_SIZE = 10;
	public Node head, tail;
	public int size = 0;
	public HashMap<String, Node> map;

	private class Node {
		public String[] results;
		public String query;

		public Node(String query, String[] results) {
			this.query = query;
			this.results = results;
		}
	}

	public Cache() {
		map = new HashMap<String, Node>();
	}

	public void moveToFront(Node node) {
	}

	public void moveToFront(String query) {
	}

	public void removeFromLinkedList(Node node) {
	}

	public String[] getResults(String query) {
		if (!map.containsKey(query))
			return null;

		Node node = map.get(query);
		moveToFront(node);
		return node.results;
	}

	// insert results to linkedlist
	public void insertResults(String query, String[] results) {
		if (map.containsKey(query)) {
			Node node = map.get(query);
			node.results = results;
			moveToFront(node);
			return;
		}

		Node node = new Node(query, results);
		moveToFront(node);
		map.put(query, node);

		if (size > MAX_SIZE) {
			map.remove(tail.query);
			removeFromLinkedList(tail);
		}
	}
}