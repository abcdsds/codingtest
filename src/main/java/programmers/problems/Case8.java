package programmers.problems;

import java.util.ArrayList;

public class Case8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcabcabcdededededede";
		int stringLength = s.length();
		System.out.println(s.length());
		
		ArrayList<String> list = new ArrayList<String>();
		int resultSize = 0;
		//for (int i=9; i<=stringLength/2; i++) {
		for (int i=1; i<=12; i++) {
			
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
					sb.append(tempWord+s.substring(j, stringLength));
					break;
				}
				
				//System.out.println(j);
				//System.out.println(s.substring(j, j+i));
				boolean equals = tempWord.equals(s.substring(j, j+i));
				
				if (equals) {
					System.out.println(tempWord);
					tempCount++;
				} 
				
				if (!equals) {
					String result = tempCount > 1 ? tempCount+tempWord : tempWord;
					sb.append(result);
					tempCount = 1;
				}

				tempWord = s.substring(j, j+i);
				
				//System.out.println(sb.toString());
			}

			//System.out.println(sb.toString());
			list.add(sb.toString());
			System.out.println("clear");
		}
		int result = list.stream().mapToInt(v -> v.length()).min().getAsInt();
		System.out.println(result);
		//System.out.println(s.length()/2);
		
		//for (int i=1; i<=s.length()/2; i++) {
//		for (int i=1; i<=1; i++) {
//			
//			String result = "";
//			int tempCount = 1;
//			String tempWord = "";
//			
//			for (int j=0; j<s.length(); j++) {
//			
//				if (split[j].equals(split[j+i])) {
//					
//				}
//			}
//		}
		
	}
	
	public static int solution(String s) {
        int answer = 0;
        return answer;
    }

}
