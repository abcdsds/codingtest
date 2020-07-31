package programmers.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Case6 {

	public static int solution(int n, int[][] computers) {
		
		return 0;
	}
	public static void main(String[] args) {
		//int n = 3;
		//int[][] computers = {{1,1,0} , {1,1,0} , {0,0,1}};
		int n = 4;
		int[][] computers = {{1,0,0,1} , {0,1,1,0} , {0,1,1,0} , {1,1,0,1}};

		// 0 - 3
		// 3 - 1
		// 1 - 2
		// 2 - 1
		
		
		//int n = 6;
		//int[][] computers = {{1,0,0,1,0,0}, {0,1,1,1,0,0}, {0,1,1,0,0,0}, {1,1,0,1,0,0} , {0,0,0,0,1,1}, {0,0,0,0,1,1}};
		
		// 0 - 3
		// 1 - 2
		// 1 - 3
		// 2 - 1
		// 3 - 0
		// 3 - 1
		
		// 4 - 5
		// 5 - 4
		
		boolean[] visit = new boolean[n];
		int answer = 0;
		for (int i=0; i<n; i++) {
			
			if (visit[i] == false) {
				answer++;
				bfs(i, computers, n , visit);
			}
		}
		
		System.out.println("RESULT = " + answer);
		
	}
	
	public static void bfs (int k, int[][] computers , int n, boolean[] visit) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(k);
		
		while (!q.isEmpty()) {
			
			int x = q.poll();
			visit[x] = true;
			
			for (int i=0; i<n; i++) {
				
				if (computers[x][i] == 1 && !visit[i]) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}
