package com.oscartran.spoj;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

class CAM5 {
	static ArrayList<Boolean> visited;
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<Integer> path;
	static Stack<Integer> stack;

	public static void main(String[] args) {
		try {
			Reader sc = new Reader();
			int t = sc.nextInt();
			ArrayList<Integer> res = new ArrayList<Integer>();

			for (int i = 0; i < t; i++) {
				graph = new ArrayList<ArrayList<Integer>>();
				path = new ArrayList<Integer>();
				visited = new ArrayList<Boolean>();
				stack = new Stack<Integer>();
				int N, e;
				N = sc.nextInt();
				e = sc.nextInt();

				for (int j = 0; j < N; j++) {
					graph.add(new ArrayList<Integer>());
					visited.add(false);
					path.add(-1);
				}

				for (int j = 0; j < e; j++) {
					int x, y;
					x = sc.nextInt();
					y = sc.nextInt();
					graph.get(x).add(y);
					graph.get(y).add(x);
				}
				int count = 0;
				for (int j = 0; j < N; j++) {
					if (visited.get(j) == false) {
						count++;
						dfs(j);
					}
				}
				res.add(count);
			}
			sc.close();
			for (Integer i : res) {
				System.out.println(i);
			}
			return;
		} catch (Exception e) {
			return;
		}
	}

	private static void dfs(int s) {
		stack.push(s);
		visited.set(s, true);

		while (!stack.isEmpty()) {
			int t = stack.pop();
			for (int i = 0; i < graph.get(t).size(); i++) {
				int curNode = graph.get(t).get(i);
				if (!visited.get(curNode)) {
					visited.set(curNode, true);
					stack.push(curNode);
					path.set(curNode, t);
				}
			}
		}
	}

	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
}
