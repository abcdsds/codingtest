package programmers.skillcheck;

import java.util.stream.IntStream;

public class SkillCheck2ForLv3 {

	private static int max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		solution2(triangle);
	}

	public static int solution(int[][] triangle) {
		
		checker(0 , triangle , 1 ,  triangle[0][0]);
		System.out.println(max);
		return max;
	}
	
	public static void checker(int index , int[][] triangle , int depth , int now ) {
		
		System.out.println("INDEX === " + index);
		System.out.println("DEPTH === " + depth);
		System.out.println("NOW === " + now);
		
		if (depth == 5) {
			if (max < now) {
				max = now;
			}
			System.out.println("+++++++++++++++++++++++END+++++++++++++++++++++++");
			return;
		}
		
		int lastIndex = triangle[depth].length-1 <= index+1 ?  triangle[depth].length-1 : index+1; 
		for (int i=index; i <= lastIndex; i++) {
			int[] j = triangle[depth];
//			System.out.println(index + " : " + (triangle[depth].length-1));
//			System.out.println("lastIndex" + lastIndex);
//			System.out.println("depth = " + depth);
//			System.out.println("aaaaaaaa" + i);
			System.out.println("==============" + j[i]);
			checker(i , triangle , depth+1 , now + j[i]);
		}
	}

	public static int solution2(int[][] triangle) {
		
		int top = 0;
		for (int i = 1; i < triangle.length; i++) {
			//System.out.println(i);
			int[] j = triangle[i];
			for (int k = 0; k < j.length; k++) {
				int l = j[k];
				if (k == 0) {
					triangle[i][k] = triangle[i][k] + triangle[i-1][k];
				} else if (k == j.length-1) {
					if (i == 1) {
						triangle[i][k] = triangle[i][k] + triangle[i-1][0];
					} else {
						triangle[i][k] = triangle[i][k] + triangle[i-1][k-1];
					}
					
				} else {

					triangle[i][k] = triangle[i][k] + Math.max(triangle[i-1][k-1],triangle[i-1][k]);
				}
			}
			
			final int[] temp = triangle[i];
			
			top = (IntStream.range(0, triangle[i].length).map(v -> temp[v]).max().getAsInt());
		}
		
		System.out.println(top);
		
		return max;
	}
}
