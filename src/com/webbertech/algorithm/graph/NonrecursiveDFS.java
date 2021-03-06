package com.webbertech.algorithm.graph;


/******************************************************************************
*  Compilation:  javac NonrecursiveDFS.java
*  Execution:    java NonrecursiveDFS graph.txt s
*  Dependencies: Graph.java Queue.java Stack.java StdOut.java
*  Data files:   http://algs4.cs.princeton.edu/41graph/tinyCG.txt
*
*  Run nonrecurisve depth-first search on an undirected graph.
*  Runs in O(E + V) time.
*
*  Explores the vertices in exactly the same order as DepthFirstSearch.java.
*
*  %  java Graph tinyCG.txt
*  6 8
*  0: 2 1 5 
*  1: 0 2 
*  2: 0 1 3 4 
*  3: 5 4 2 
*  4: 3 2 
*  5: 3 0 
*
*  %  java NonrecursiveDFS tinyCG.txt 0
*  0 to 0 (0):  0
*  0 to 1 (1):  0-1
*  0 to 2 (1):  0-2
*  0 to 3 (2):  0-2-3
*  0 to 4 (2):  0-2-4
*  0 to 5 (1):  0-5
*
******************************************************************************/

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class NonrecursiveDFS {
    private boolean[] marked;  // marked[v] = is there an s-v path?
    /**
     * Computes the vertices connected to the source vertex <tt>s</tt> in the graph <tt>G</tt>.
     * @param G the graph
     * @param s the source vertex
     */
    public NonrecursiveDFS(Graph G, int s) {
        marked = new boolean[G.V()];

        // to be able to iterate over each adjacency list, keeping track of which
        // vertex in each adjacency list needs to be explored next
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
        for (int v = 0; v < G.V(); v++)
            adj[v] = G.adj(v).iterator();

        // depth-first search using an explicit stack
        Stack<Integer> stack = new Stack<Integer>();
        marked[s] = true;
        stack.push(s);
        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (adj[v].hasNext()) {
                int w = adj[v].next();
                // StdOut.printf("check %d\n", w);
                if (!marked[w]) {
                    // discovered vertex w for the first time
                    marked[w] = true;
                    // edgeTo[w] = v;
                    stack.push(w);
                    // StdOut.printf("dfs(%d)\n", w);
                }
            }
            else {
                // StdOut.printf("%d done\n", v);
                stack.pop();
            }
        }
    }

    /**
     * Is vertex <tt>v</tt> connected to the source vertex <tt>s</tt>?
     * @param v the vertex
     * @return <tt>true</tt> if vertex <tt>v</tt> is connected to the source vertex <tt>s</tt>,
     *    and <tt>false</tt> otherwise
     */
    public boolean marked(int v) {
        return marked[v];
    }

    /**
     * Unit tests the <tt>NonrecursiveDFS</tt> data type.
     * @throws IOException 
     */
 
    public static void main(String[] args) throws IOException {
      In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        NonrecursiveDFS dfs = new NonrecursiveDFS(G, s);
        for (int v = 0; v < G.V(); v++)
            if (dfs.marked(v))
                System.out.print(v + " ");
        System.out.println();
    }
  

}


