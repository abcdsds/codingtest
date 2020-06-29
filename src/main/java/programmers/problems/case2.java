package programmers.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;


public class case2 {

	
	private static boolean[] checked;
	
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

	
	public static int solution(int n, int[][] computers) {
		
		HashMap<Integer, HashSet> tempMap = new HashMap<Integer, HashSet>();
		checked = new boolean[computers.length];
		
		int temp = 0;
		tempMap.put(temp, new HashSet<Integer>());
		tempMap.get(temp).add(0);
		
		for (int i=0; i<computers.length; i++) {
			
			for(int j=0; j<computers[i].length; j++) {
				
				if (i == j) {
					continue;
				}
												
				if (computers[i][j] == 1) {
					
					if (tempMap.get(temp).contains(i)) {
						checked[i] = true;
					}
					
					tempMap.get(temp).add(i);
					tempMap.get(temp).add(j);

				}
			}
		}
		
		int sum = (int) IntStream.range(0, checked.length).filter(i -> checked[i] == false).count();
		
		//IntStream.range(0, breaks.length).forEach(a -> System.out.println("breaks : " + breaks[a]));
		//IntStream.range(0, checked.length).forEach(a -> System.out.println("checked : " + checked[a]));

		System.out.println(sum+1);
		
		return sum+1;
	}
		
	public static void main(String[] args) {

		int[] numbers = { 1, 1, 1};
		int target = 3;

		//solution(numbers, target);
		
		int n = 3;
		//int[][] computer = {{1,1,0}, {1,1,0}, {0,0,1}};
		//int[][] computer = {{1,1,0}, {1,1,1}, {0,1,1}};
		int[][] computer = {{1,0,0,1,0,0}, {0,1,1,1,0,0}, {0,1,1,0,0,0}, {1,1,0,1,0,0} , {0,0,0,0,1,1}, {0,0,0,0,1,1}};
		
		// 0 - 3
		// 1 - 2
		// 1 - 3
		
		
		solution(n, computer);
	}
}
