package programmers.test;

public class Case5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 4;
		int[] table = {1 , 30 , 0 , 6 , 0 , 2 , 1 , 3};
		int[] result = new int[8];
		
		int firstTarget = target;
		int index = 0;
		while(true) {
			
			if (index == 8) {
				break;
			}
			
			int tempTarget = table[firstTarget];
			
			
			if (tempTarget == 1) {
				result[index] = tempTarget;
				result[index+1] = table[firstTarget+1];
				break;
			} else {
				
				result[index] = tempTarget;
				result[index+1] = index+2;
				firstTarget = table[firstTarget+1];
			}
			
			index += 2;
		}
		
		System.out.print(0+"; ");
		for (int i : result) {
			System.out.print(i+ " ");
		}
	}

}
