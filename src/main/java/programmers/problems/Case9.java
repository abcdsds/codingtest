package programmers.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Case9 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String p = "))(()(";
		//System.out.println(reverseString("))(("));
		System.out.println(splitString(p));

	}

	public static String splitString(String p) {

		if (p.isEmpty()) return p;
		String[] split = p.split("");

		int leftCount = 0;
		int rightCount = 0;
		int index = 0;

		for (int i = 0; i < split.length; i++) {
			String string = split[i];

			if (string.equals("(")) {

				leftCount++;
			}

			if (string.equals(")")) {
				rightCount++;
			}

			if (leftCount == rightCount) {
				System.out.println(i);
				System.out.println(leftCount);
				System.out.println(rightCount);
				index = i+1;
				break;
			}
		}

		String leftString = p.substring(0, index);
		String rightString = p.substring(index, p.length());

		System.out.println(check(leftString));
		System.out.println(check(rightString));

		if (check(leftString)) {
			return leftString+splitString(rightString);
		}

		System.out.println("====================");
		String answer = "("+splitString(rightString)+")";
		
		String resultString = leftString.substring(1, leftString.length());
		if (resultString.length() - 1 == 0) {
			resultString = "";
		} else {
			resultString = resultString.substring(0, leftString.length() - 2);
		}

		answer += reverseString(resultString);
		
		return answer;
	}

	private static String reverseString(String leftString) {
		// TODO Auto-generated method stub
		if (leftString.isEmpty()) {
			return "";
		}
		String[] split = leftString.split("");
		for (int i = 0; i < split.length; i++) {
			String string = split[i];
			if (string.equals("(")) {
				split[i] = ")";
			}

			if (string.equals(")")) {
				split[i] = "(";
			}
		}

		return Arrays.stream(split).collect(Collectors.joining()).toString();
	}

	public static boolean check(String p) {

		int right = 0;
		int left = 0;

		String[] split = p.split("");

		for (int i = 0; i < split.length; i++) {
			String string = split[i];

			if (string.equals("(")) {
				left++;
			}

			if (string.equals(")")) {
				right++;
			}

			if (right > left) {
				return false;
			}
		}

		return true;
	}

}
