package com.oscartran.hackerrank;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_Algorithm {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, ArrayList<Integer>[] edges, int s) {
    	ArrayList<Integer> path;
    	ArrayList<Boolean> visited;
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	path = new ArrayList<Integer>();
    	visited = new ArrayList<Boolean>();
    	
    	for (int i = 0; i < n; i++) {
    		visited.add(false);
    		path.add(-1);
    	}
    	visited.set(s, true);
    	q.add(s);
    	
    	while (q.isEmpty() == false) {
    		int u = (int)q.remove();
    		for (int i = 0; i < edges[u].size(); i++) {
    			int v = edges[u].get(i);
    			if (visited.get(v) == false) {
    				visited.set(v, true);
    				path.set(v, u);
    				q.add(v);
    			}
    		}
    	}
    	
		return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            ArrayList<Integer>[] edges = new ArrayList[n];
            
            for (int i = 0; i < n; i++) {
            	edges[i] = new ArrayList<>();
            }
            
            //ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                int r = Integer.parseInt(edgesRowItems[0]);
                int c = Integer.parseInt(edgesRowItems[1]);
                edges[r].add(c);
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}