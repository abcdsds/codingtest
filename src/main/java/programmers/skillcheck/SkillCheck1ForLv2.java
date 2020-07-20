package programmers.skillcheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SkillCheck1ForLv2 {

	
	private static int result;
	private static StringBuilder resultString = new StringBuilder();
	
 	public static int[][] solution(int[][] arr1, int[][] arr2) {

		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < arr1.length; i++) {

			for (int j = 0; j < arr2[0].length; j++) {
				int resultNum = 0;
//				System.out.println(arr1[i][j]);
				// System.out.println(arr2[j][i]);
				for (int k = 0; k < arr2[j].length; k++) {
					// System.out.println(j);
					System.out.println(arr2[k][j] + " : " + arr1[i][k]);
					resultNum += arr2[k][j] * arr1[i][k];
				}
				answer[i][j] = resultNum;
				// System.out.println("================");
			}
		}

		for (int[] i : answer) {
			System.out.println("================");
			System.out.println(i[0]);
			System.out.println(i[1]);
			// System.out.println(i[2]);
			System.out.println("================");
		}

		return answer;
	}

	public static int[] solution(int brown, int yellow) {

		int[] answer = new int[2];

		List<Integer> list = new ArrayList<Integer>();
		int all = brown + yellow;

		for (int i = 2; i < all; i++) {
			// System.out.println(all % i);
			if ((all % i) == 0) {
				// System.out.println(i);
				list.add(i);
			}
		}

		// System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			int num = list.size() - 1;

			if (list.get(i) >= list.get(num - i)) {
				if (((list.get(i) - 2) * (list.get(num - i) - 2)) == yellow) {
					answer[0] = (list.get(i));
					answer[1] = (list.get(num - i));
				}
			}
		}

		System.out.println(answer[0]);
		System.out.println(answer[1]);

		return answer;
	}

	public static String solution(String number, int k) {
		String answer = "";
		result = number.length() - k;
		resultString.append("0");
		
		for (int i=0; i<number.length(); i++) {
			//System.out.println(number.substring(i, i+1));
			get(1 , new StringBuilder().append(number.substring(i, i+1)) , new StringBuilder().append(number.substring(i, number.length())));
		}
		
		String result = String.valueOf(Integer.parseInt(resultString.toString()));
		System.out.println(result);
		return answer;
	}
	
	public static void get(int index , StringBuilder nowNum ,  StringBuilder number) {
		
		if (nowNum.length() == result) {

			
			if (Integer.parseInt(nowNum.toString()) > Integer.parseInt(resultString.toString())) {
				System.out.println(nowNum.toString());
				resultString = nowNum;
			}
			return;
		}
		
		
		for (int i=index; i<number.length(); i++) {
			//System.out.println(nowNum + " : " + number.substring(i, number.length()));
			get(index , new StringBuilder().append(nowNum).append(number.substring(i, i+1)) , new StringBuilder().append(number.substring(i, number.length())));
		}
		
	}


	public static String solution2(String number, int k) {
		
		StringBuilder answer = new StringBuilder();
		int index = 0;
		char temp = '0';
		
		
		for(int i = 0; i < number.length() - k; i++) {
			temp = '0';
			for(int j = index; j <= k + i; j++) {
				if (temp < number.charAt(j)) {
					temp = number.charAt(j);
					index = j + 1;
					System.out.print(number.charAt(j));
				}
			}
			System.out.println();
			answer.append(temp);
		}
		
		System.out.println(answer.toString());
		return answer.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[][] arr1 = { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } };
//		int[][] arr2 = { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } };
//		int[][] arr1 = { { 1 ,4 }, { 3 , 2 }, { 4 ,1 } };
//		int[][] arr2 = { { 3 , 3 }, { 3,3 } };
//		solution(arr1, arr2);

//		int brown = 8;
//		int yellow = 1;
//		solution(brown, yellow);

		String number = "4177252841";
		int k = 4;

		solution2(number, k);
	}

}
