package programmers.skillcheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkillCheck2 {

	private static int max = 0;
	private static int limit;
	
 	public static int solution(int m, int n, String[] board) {
		int answer = 0;

		while (true) {
			boolean mainChecker = true;
			List<int[]> tempList = new ArrayList<int[]>();
			for (int i = 1; i < board.length; i++) {
				String[] split = board[i].split("");
				String[] beforeSplit = board[i - 1].split("");
				for (int j = 0; j < split.length; j++) {
					if (i > 0 && j < split.length - 1) {

						if (beforeSplit[j].equals(beforeSplit[j + 1]) && beforeSplit[j].equals(split[j])
								&& beforeSplit[j].equals(split[j + 1]) && !beforeSplit[j].equals("@")) {

							System.out.println(beforeSplit[j]);
							System.out.println(beforeSplit[j + 1]);
							System.out.println(split[j]);
							System.out.println(split[j + 1]);

							tempList.add(new int[] { i - 1, j });
							tempList.add(new int[] { i - 1, j + 1 });
							tempList.add(new int[] { i, j });
							tempList.add(new int[] { i, j + 1 });
							mainChecker = false;
						}
					}
				}
			}

			for (int i = 0; i < tempList.size(); i++) {
				int[] tempArrayInList = tempList.get(i);
				String[] split = board[tempArrayInList[0]].split("");
				split[tempArrayInList[1]] = "@";
				board[tempArrayInList[0]] = String.join("", split);
			}

			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

			while (true) {

				boolean orderChecker = true;

				for (int i = 1; i < board.length; i++) {
					String[] split = board[i].split("");
					String[] beforeSplit = board[i - 1].split("");
					for (int j = 0; j < split.length; j++) {
						if (i > 0 && split[j].equals("@") && !beforeSplit[j].equals("@")) {
							System.out.println(i + " : " + j);
							System.out.println(split[j]);
							System.out.println(beforeSplit[j]);

							split[j] = beforeSplit[j];
							beforeSplit[j] = "@";
							orderChecker = false;
						}
					}

					board[i - 1] = String.join("", beforeSplit);
					board[i] = String.join("", split);
				}

				if (orderChecker) {
					break;
				}
			}

			if (mainChecker) {

				System.out.println("breaker");

				System.out.println("================");
				System.out.println(board[0]);
				System.out.println(board[1]);
				System.out.println(board[2]);
				System.out.println(board[3]);
				System.out.println(board[4]);
				System.out.println(board[5]);
				System.out.println("================");

				for (int i = 0; i < board.length; i++) {
					String regex = "[A-Z]";
					board[i] = board[i].replaceAll(regex, "");
					System.out.println(board[i]);
					if (board[i].contains("@")) {
						String[] split = board[i].split("");
						answer += split.length;
						System.out.println(answer);
					}
				}

				break;
			}
		}

		System.out.println(answer);
		return answer;
	}

	public static int solution(int[][] land) {
		
		int result = 0;
		limit = land.length;
				
		for(int i=0; i<land.length; i++) {
			
			add(land , 0 , -1, 5);
		}
		
		System.out.println("max");
		System.out.println(max);
		return result;
	}
	
	public static void add(int[][] list, int temp, int index, int lastIndex) {
		
		index++;
		
		if (index == limit) {
			if (max < temp) {
				max = temp;
			}
			return;
		}
		
		int tempIndex = 5;
		
		
		for(int j=0; j<list[index].length; j++) {
			if (lastIndex != j) {
				tempIndex = j;
				add(list , temp + list[index][j] , index, tempIndex);
			} 
		}
		
	}
	
	
	public static int solution2(int[][] land) {
		
		int result = 0;
				
		for(int i=0; i<land.length-1; i++) {
			land[i+1][0] += Math.max(land[i][1], Math.max(land[i][2], land[i][3])); 
			land[i+1][1] += Math.max(land[i][0], Math.max(land[i][2], land[i][3]));
			land[i+1][2] += Math.max(land[i][0], Math.max(land[i][1], land[i][3]));
			land[i+1][3] += Math.max(land[i][0], Math.max(land[i][1], land[i][2]));
		}

		
		System.out.println(Arrays.stream(land[land.length-1]).max().getAsInt());
		
//		
//		System.out.println("max");
//		System.out.println(max);
		return result;
	}

	public static void main(String[] args) {

//		int m = 6;
//		int n = 6;
//		String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };
//
//		solution(m, n, board);

		int[][] rand = {{1, 2, 3, 5}, {5, 6, 7, 100}, {4, 3, 2, 1}, {12,10,11,9}};
		//int[][] rand = {{1,1,1,1}, {2,2,2,2}, {3,4,3,4}, {5,5,6,6}};
		
		//int[][] rand = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
		System.out.println(solution2(rand));
	}
}
