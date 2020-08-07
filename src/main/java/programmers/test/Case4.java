package programmers.test;

public class Case4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] kim = {100,300,10, 0,40, 0,  0,70,65};
		int[] lee = { 40,300,20,10,10,20,100,10, 0};
		int[] result = new int[kim.length];
		
		
		int resultKim = 0;

		for (int i=0; i<kim.length; i++) {
			int tempKim = kim[i] - lee[i];
			
			if (tempKim >= 0) {
				resultKim += tempKim;
				result[i] = resultKim > 0 ? resultKim : 0;
			}
			
			if (tempKim < 0) {
				resultKim += tempKim;
				result[i] = 0;
			}
			
			if (resultKim > 0) {
				resultKim = 0;
			}
			
		}
	}

}
