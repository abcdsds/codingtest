package programmers.problems;

import java.util.Arrays;

public class case2 {

	public static int solution(int[] numbers, int target) {

		int result = 0;

		result += solutionAdd(0, numbers, target, 0);
		result += solutionMinus(0, numbers, target, 0);
		
		System.out.println("result = " + result);

		return 0;
	}

	public static int solutionAdd(int first, int[] numbers, int target, int result) {

		if (numbers.length > 0) {
			first = first + numbers[0];
			
			System.out.println("addfirst = " + first);
			System.out.println("addresult = " + result);
			System.out.println("addlength = " + numbers.length);
			
			if (first == target && numbers.length == 1) {

				System.out.println("AddResult 실행 1");
				result++;
				return result;
			}
			
			result = solutionAdd(first, Arrays.copyOfRange(numbers, 1, numbers.length), target, result)+solutionMinus(first, Arrays.copyOfRange(numbers, 1, numbers.length), target, result);

		}
		System.out.println("AddResult 실행 3");
		return result;
	}

	public static int solutionMinus(int first, int[] numbers, int target, int result) {
		if (numbers.length > 0) {
			
			first = first - numbers[0];
			
			System.out.println("Minusfirst = " + first);
			System.out.println("Minusresult = " + result);
			System.out.println("Minuslength = " + numbers.length);
			
			if (first == target && numbers.length == 1) {

				System.out.println("MinusResult 실행 1");
				result++;
				return result;
			}

			result = solutionAdd(first, Arrays.copyOfRange(numbers, 1, numbers.length), target, result)+solutionMinus(first, Arrays.copyOfRange(numbers, 1, numbers.length), target, result);
			
		}
		
		System.out.println("MinusAddResult 실행 3");
		return result;
	}

	public static void main(String[] args) {

		int[] numbers = { 1, 1, 1};
		int target = 3;

		solution(numbers, target);
	}
}
