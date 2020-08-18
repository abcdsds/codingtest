package programmers.problems;

import java.util.ArrayList;

public class Case8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		int stringLength = s.length();
		System.out.println(s.length());
		
		if (stringLength < 2) {
			System.out.println(stringLength);
			System.exit(0);
		}
		ArrayList<String> list = new ArrayList<String>();
		for (int i=1; i<=stringLength/2; i++) {
		//for (int i=3; i<=3; i++) {
			
			StringBuilder sb = new StringBuilder();
			
			String tempWord = s.substring(0, i);
			int tempCount = 0;
			
			for (int j=0; j<=stringLength; j+=i) {
					
				if (j == s.length()) {
					String result = tempCount > 1 ? tempCount+tempWord : tempWord;
					sb.append(result);
					break;
				}
				
				if (j+i > s.length()) {
					//System.out.println(j+i);
					String result = tempCount > 1 ? tempCount+tempWord : tempWord;
					sb.append(result+s.substring(j, stringLength));
					break;
				}
				
				//System.out.println(j);
				//System.out.println(s.substring(j, j+i));
				boolean equals = tempWord.equals(s.substring(j, j+i));
				
				if (equals) {
					//System.out.println(tempWord);
					tempCount++;
				} 
				
				if (!equals) {
					String result = tempCount > 1 ? tempCount+tempWord : tempWord;
					sb.append(result);
					tempCount = 1;
				}

				tempWord = s.substring(j, j+i);
				System.out.println(tempCount);
				//System.out.println(sb.toString());
			}

			//System.out.println(sb.toString());
			list.add(sb.toString());
			System.out.println("clear");
		}
		
		int result = list.stream().mapToInt(v -> v.length()).min().getAsInt();
		System.out.println("result = " + result);
		
		
		
//		for (int i=0; i<list.size(); i++) {
//			String v = list.get(i);
//			if (v.length() < 10) {
//				System.out.println(i);
//				System.out.println(v);
//			}
//		}
		
	}
	
	public static int solution(String s) {
        int answer = 0;
        return answer;
    }

}
