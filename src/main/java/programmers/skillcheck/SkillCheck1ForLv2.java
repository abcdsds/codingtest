package programmers.skillcheck;

public class SkillCheck1ForLv2 {

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		
		int[][] answer = new int[arr1.length][arr2[0].length];
				
		for (int i = 0; i < arr1.length; i++) {
			
			for (int j = 0; j < arr2[0].length; j++) {
				int resultNum = 0;
//				System.out.println(arr1[i][j]);
				//System.out.println(arr2[j][i]);
				for (int k =0; k < arr2[j].length; k++) {
					//System.out.println(j);
					System.out.println(arr2[k][j] + " : " + arr1[i][k]);
					resultNum += arr2[k][j] * arr1[i][k];
				}
				answer[i][j] = resultNum;
				//System.out.println("================");
			}
		}
		
		
		for (int[] i : answer) {
			System.out.println("================");
			System.out.println(i[0]);
			System.out.println(i[1]);
			//System.out.println(i[2]);
			System.out.println("================");
		}


		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[][] arr1 = { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } };
//		int[][] arr2 = { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } };
		int[][] arr1 = { { 1 ,4 }, { 3 , 2 }, { 4 ,1 } };
		int[][] arr2 = { { 3 , 3 }, { 3,3 } };
		solution(arr1, arr2);
	}

}
