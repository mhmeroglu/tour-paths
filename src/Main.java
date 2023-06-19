//-----------------------------------------------------
// Title: Q2 Main Class
// Author: Mehmet/Eroğlu
// ID: 37177526200
// Section: 3
// Assignment: 1
// Description: This class the Main class of Q2
//-----------------------------------------------------

import java.util.Scanner;

public class Main {
    // main method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // get values
        int n = scan.nextInt();

        // creating Graph
        Graph G = new Graph(n + 1);

        int m = scan.nextInt();

        // creating edges
        for (int i = 1; i <= m; i++) {
            // get edges
            int u = scan.nextInt();
            int v = scan.nextInt();
            G.addEdge(u, v);
        }

        // get start and end points
        int x = scan.nextInt();
        int y = scan.nextInt();

        DFS dfs = new DFS(G, x, y);

        // print result
        dfs.printCycle(dfs.toCycle(G));

    }
}
