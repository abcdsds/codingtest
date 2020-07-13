package programmers.skillcheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class skillcheck1 {

	public static int solution(int[] d, int budget) {
		int answer = 0;

		Arrays.sort(d);

		int copyBudget = budget;
		for (int i = 0; i < d.length; i++) {

			if ((copyBudget - d[i]) < 0) {
				break;
			}

			answer++;

			copyBudget = copyBudget - d[i];
		}

		return answer;
	}

	public static int solution(String dartResult) {
		
		String regexNumber = "[^0-9]";
		String regexString = "[0-9]";
		int tempResult = 0;
				
		String[] replaceAll = dartResult.replaceAll(regexNumber, " ").replace("  ", " ").split(" ");
		String[] replaceAll2 = dartResult.replaceAll(regexString, " ").replace("  ", " ").substring(1).split(" ");

		int[] result = new int[replaceAll.length];
		
		for (int i=0; i<replaceAll.length; i++) {
		
				int getNum = Integer.parseInt(replaceAll[i]);
				
				switch (replaceAll2[i].substring(0, 1)) {
				case "S" :
					if (replaceAll2[i].length() > 1) {
						if (replaceAll2[i].contains("*")) {
							result[i] = ((getNum * 1));
							int j = i-1 < 0 ? 0 : i-1;
							for (; j<=i; j++) {
								result[j] = result[j] * 2;
							}
						} else {
							result[i] = ((getNum * 1) * -1);
						}
					} else {
						result[i] = (getNum * 1);
					}
					break;
				case "D" :
					if (replaceAll2[i].length() > 1) {
						if (replaceAll2[i].contains("*")) {
							result[i] = ((getNum * getNum));
							int j = i-1 < 0 ? 0 : i-1;
							for (; j<=i; j++) {
								result[j] = result[j] * 2;
							}
						} else {
							result[i] = ((getNum * getNum) * -1);
						}
					} else {
						result[i] = (getNum * getNum);
					}
					break;
				case "T" :
					if (replaceAll2[i].length() > 1) {
						if (replaceAll2[i].contains("*")) {
							result[i] = (getNum * getNum * getNum);
							int j = i-1 < 0 ? 0 : i-1;
							for (; j<=i; j++) {
								result[j] = result[j] * 2;
							}
						} else {
							result[i] = ((getNum * getNum * getNum) * -1);
						}
					} else {
						result[i] = (getNum * getNum * getNum);
					}
					break;
				}
			
				
				
				System.out.println("getNum = " + getNum);
				System.out.println(replaceAll2[i]);
				System.out.println( "result = " + result[i]);
		}
		
		for (int i=0; i<result.length; i++) {
			System.out.println(result[i]);
			tempResult = tempResult + result[i];
		}
		
		System.out.println(tempResult);
		
		return 0;
	}

	public static void main(String[] args) {

//		int[] d = {2,2,3,3};
//		int budget = 10;
//		
//		solution(d , budget);

		String dartResult = "1S*2T*3S";

		solution(dartResult);
	}
}
