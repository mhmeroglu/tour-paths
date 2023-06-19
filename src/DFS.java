//-----------------------------------------------------
// Title: DFS Class
// Author: Mehmet/Eroğlu
// ID: 37177526200
// Section: 3
// Assignment: 1
// Description: this class helps find a cycle in a Graph
//-----------------------------------------------------

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
    private boolean[] marked;
    private int[] edgeTo;

    // for finding second number in cycle
    private int count;

    // for finding second number in cycle
    private int second;

    // source
    private int s;

    // destination
    private int d;

    // Constructor
    public DFS(Graph G, int s, int d) {
        this.s = s;
        this.d = d;

        // edge to list
        edgeTo = new int[G.V()];
        // marked array
        marked = new boolean[G.V()];

        // call dfs
        dfs(G, s);
    }

    //--------------------------------------------------------
    // Summary: Depth First Search Method.
    // Precondition: G is an Undirected Graph and v is an integer.
    // Postcondition: all vertices in G have been visited recursively.
    //--------------------------------------------------------
    private void dfs(Graph G, int v) {
        if (v == s)
            marked[v] = false;

        else
            marked[v] = true;

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                count++;

                Iterator iterator = G.adj(w).iterator();

                // checking and saving the 2nd element in the cycle.
                if (count == 1 && iterator.hasNext()) {
                    second = w;
                }

                edgeTo[w] = v;

                // call dfs
                dfs(G, w);
            }
        }
    }

    //--------------------------------------------------------
    // Summary: add elements in cycle to list.
    // Precondition: G is an Undirected Graph.
    // Postcondition: elements pushed to the cycle list.
    //--------------------------------------------------------
    public LinkedList toCycle(Graph G) {
        LinkedList<Integer> cycle = new LinkedList<Integer>();

        for (int x = d; x != s; x = edgeTo[x])
            cycle.push(x);

        cycle.push(second);
        cycle.push(s);

        Collections.sort(cycle);

        return cycle;
    }

    //--------------------------------------------------------
    // Summary: print the cycle.
    // Precondition: cycle is a Linked List.
    // Postcondition: printed the list.
    //--------------------------------------------------------
    public void printCycle(LinkedList<Integer> cycle) {
        cycle.forEach(s -> {
            System.out.print(s + " ");
        });
    }
}
