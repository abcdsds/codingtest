package programmers.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Case9 {

	private static String result = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String p = "()))((()";

		//System.out.println(reverseString("))(("));
		splitString(p);
		System.out.println(result);

	}

	public static void splitString(String p) {

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
				index = i;
				break;
			}
		}

		String rightString = p.substring(index + 1, p.length());
		String leftString = p.substring(0, index + 1);
		System.out.println(leftString);
		System.out.println(rightString);

		System.out.println(check(leftString));
		System.out.println(check(rightString));

		if (check(leftString) && check(rightString)) {
			result += leftString + rightString;
			return;
		}

		if (check(leftString) && !check(rightString)) {
			result += leftString;
			splitString(rightString);
		}

		if (!check(leftString)) {
			result += reverseString(leftString) + rightString;
		}
	}

	private static String reverseString(String leftString) {
		// TODO Auto-generated method stub

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
