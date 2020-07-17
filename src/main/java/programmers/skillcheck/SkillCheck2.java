package programmers.skillcheck;

import java.util.ArrayList;
import java.util.List;

public class SkillCheck2 {

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

	public static void main(String[] args) {

		int m = 6;
		int n = 6;
		String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };

		solution(m, n, board);
	}
}
