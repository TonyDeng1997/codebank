package com.webbertech.algorithm.graph;

import java.util.ArrayDeque;
import java.util.Deque;

//this is my graph

//output: S->A ->D ->B -> C

public class MyGraph {

	static class Vertex {
		char label;
		boolean visited;
		
		public Vertex(char label, boolean visited) {
			this.label = label;
			this.visited = visited;
		}
	}
	
	private int vertexCount;
	private Vertex[] list;
	private int[][] adjMatrix;
	
	MyGraph(int size) {
		list = new Vertex[size];
		adjMatrix = new int[size][size];
	}
	
	void addVertex(char label) {
		list[vertexCount] = new Vertex(label, false);
		vertexCount++;
	}

	void addEdge(int start, int end) {
	     adjMatrix[start][end] = 1;
	     adjMatrix[end][start] = 1;
	}
	
	void displayVertex(int vertexIndex) {
		System.out.println(list[vertexIndex].label);
	}
	
	int getAdjUnvisitedVertex(int vertexIndex) {
		for(int i= 0; i< vertexCount; i++) {
			if (adjMatrix[vertexIndex][i] == 1 && list[i].visited == false) {
				return i;
			}
		}
		return -1;
	}
	
	void createGraph1() {
		addVertex('S');
		addVertex('A');
		addVertex('B');
		addVertex('C');
		addVertex('D');
		
		addEdge(0,1);
		addEdge(0,2);
		addEdge(0,3);
		addEdge(1,4);
		addEdge(2,4);
		addEdge(3,4);
	}
	
	int getVertexCount() {
		return this.vertexCount;
	}
	
	int[][] getAdjMatrix() {
		return this.adjMatrix;
	}
	
    void DFS() {
    	 displayVertex(0);
    	 list[0].visited= true;
    	 Deque<Integer> stack = new ArrayDeque<>();
    	 //push the index of the vertex list
    	 stack.push(0);
    	 
    	 while(stack.size()!=0) {
    		 int unvisitedVertex = getAdjUnvisitedVertex(stack.peek());
    		 
    		 //if no adjacent vertex found
    		 if (unvisitedVertex ==-1) {
    			 System.out.println("poping" + stack.pop());
    			 
    		 } else {
    			 list[unvisitedVertex].visited = true;
    			 //print out which node it traverses
    			 displayVertex(unvisitedVertex);
    			 stack.push(unvisitedVertex);
    		 }
    	 }
    	 
    	 for(int i=0;i< vertexCount;i++) {
    		 list[i].visited = false;
    	 }
    }	
    
    //this graph is used for BFS
    private void createGraph2() {
		// TODO Auto-generated method stub
		addVertex('S');
		addVertex('A');
		addVertex('B');
		addVertex('C');
		addVertex('D');
		addVertex('E');
		addVertex('F');
		addVertex('G');
		
		addEdge(0,1);
		addEdge(0,2);
		addEdge(0,3);
		addEdge(1,4);
		addEdge(2,5);
		addEdge(3,6);
		addEdge(4,7);
		addEdge(5,7);
		addEdge(6,7);
	}
    
    //use queue
    void BSF() {
    	Deque<Integer> queue = new ArrayDeque<>();
    	list[0].visited = true;
    	this.displayVertex(0);
    	queue.addLast(0);
    	
    	while(queue.size()!=0) {
    		int unvisitedVertex;
    		while( (unvisitedVertex= this.getAdjUnvisitedVertex(queue.peekFirst())) != -1) {
    			list[unvisitedVertex].visited = true;
    			this.displayVertex(unvisitedVertex);
    			queue.addLast(unvisitedVertex);
    		}
    		
    		//remove that vertex that has no adjacent vertex from the queue
    		queue.removeFirst();
    		
    	}
    }
    
    public static void main(String[] args) {
    	MyGraph graph = new MyGraph(5);
    	graph.createGraph1();
  
    	System.out.println("graph vertexes:\n");
    	
    	 for(int i=0;i< graph.getVertexCount();i++) {
    		 graph.displayVertex(i);
    	 }
    	 
    	 System.out.println("Show adjacent matrix:\n");
    	 int[][] matrix = graph.getAdjMatrix();
    	 for (int i = 0; i< 5 ; i++) {
    		 for (int j=0;j< 5; j++) {
    			 System.out.print(matrix[i][j] + " ");
    		 }
    		 System.out.println();
    	 }
    	
    	
    	graph.DFS();
    	
    	System.out.println("\nThe following is BFS test");
    	
    	//test bfs
    	MyGraph graph2 = new MyGraph(8);
    	graph2.createGraph2();
    	
     	 for(int i=0;i< graph2.getVertexCount();i++) {
    		 graph2.displayVertex(i);
    	 }
    	 
    	 System.out.println("\nShow adjacent matrix:\n");
    	 matrix = graph2.getAdjMatrix();
    	 for (int i = 0; i< 8 ; i++) {
    		 for (int j=0;j< 8; j++) {
    			 System.out.print(matrix[i][j] + " ");
    		 }
    		 System.out.println();
    	 }
    	
    	 graph2.BSF(); 
    }

	
}
