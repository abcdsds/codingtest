package programmers.problems;

import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
	private static int[][] nodes;
	private static boolean[] visited;

	public static int solution(int n, int[][] computers) {
		nodes = computers;
		visited = new boolean[computers.length];
		return IntStream.range(0, n).map(i -> visited[i] ? 0 : dfs(i)).sum();
	}

	private static int dfs(int node) {
		if (visited[node])
			return 1;
		visited[node] = true;
		System.out.println("node : " + node);
		int asInt = IntStream.range(0, nodes[node].length).map(i -> nodes[node][i] == 1 ? dfs(i) : 0).max().getAsInt();
		System.out.println(asInt);
		
		return asInt;
	}

	public static void main(String[] args) {

		int[] numbers = { 1, 1, 1 };
		int target = 3;

		// solution(numbers, target);

		int n = 6;
		// int[][] computer = {{1,1,0}, {1,1,0}, {0,0,1}};
		// int[][] computer = {{1,1,0}, {1,1,1}, {0,1,1}};
		int[][] computer = { { 1, 0, 0, 1, 0, 0 }, { 0, 1, 1, 1, 0, 0 }, { 0, 1, 1, 0, 0, 0 }, { 1, 1, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 1, 1 } };

		// 0 - 3
		// 1 - 2
		// 1 - 3

		System.out.println("result = " + solution(n, computer));
	}

}