package programmers.skillcheck;

import java.util.Arrays;
import java.util.HashMap;

public class skillcheck1 {

	public static int solution(int[] d, int budget) {
		int answer = 0;

		Arrays.sort(d);

		int copyBudget = budget;
		for (int i = 0; i < d.length; i++) {

			if ((copyBudget - d[i]) < 0) {
				break;
			}

			answer++;

			copyBudget = copyBudget - d[i];
		}

		return answer;
	}

	public static int solution(String dartResult) {
		
		String regexNumber = "[^0-9]";
		String regexString = "[0-9]";
		int tempResult = 0;
				
		String[] replaceAll = dartResult.replaceAll(regexNumber, " ").replace("  ", " ").split(" ");
		String[] replaceAll2 = dartResult.replaceAll(regexString, " ").replace("  ", " ").substring(1).split(" ");

		int[] result = new int[replaceAll.length];
		
		for (int i=0; i<replaceAll.length; i++) {
		
				int getNum = Integer.parseInt(replaceAll[i]);
				
				switch (replaceAll2[i].substring(0, 1)) {
				case "S" :
					if (replaceAll2[i].length() > 1) {
						if (replaceAll2[i].contains("*")) {
							result[i] = ((getNum * 1));
							int j = i-1 < 0 ? 0 : i-1;
							for (; j<=i; j++) {
								result[j] = result[j] * 2;
							}
						} else {
							result[i] = ((getNum * 1) * -1);
						}
					} else {
						result[i] = (getNum * 1);
					}
					break;
				case "D" :
					if (replaceAll2[i].length() > 1) {
						if (replaceAll2[i].contains("*")) {
							result[i] = ((getNum * getNum));
							int j = i-1 < 0 ? 0 : i-1;
							for (; j<=i; j++) {
								result[j] = result[j] * 2;
							}
						} else {
							result[i] = ((getNum * getNum) * -1);
						}
					} else {
						result[i] = (getNum * getNum);
					}
					break;
				case "T" :
					if (replaceAll2[i].length() > 1) {
						if (replaceAll2[i].contains("*")) {
							result[i] = (getNum * getNum * getNum);
							int j = i-1 < 0 ? 0 : i-1;
							for (; j<=i; j++) {
								result[j] = result[j] * 2;
							}
						} else {
							result[i] = ((getNum * getNum * getNum) * -1);
						}
					} else {
						result[i] = (getNum * getNum * getNum);
					}
					break;
				}
			
				
				
				System.out.println("getNum = " + getNum);
				System.out.println(replaceAll2[i]);
				System.out.println( "result = " + result[i]);
		}
		
		for (int i=0; i<result.length; i++) {
			System.out.println(result[i]);
			tempResult = tempResult + result[i];
		}
		
		System.out.println(tempResult);
		
		return 0;
	}

	public static boolean solution2(String s) {
        boolean answer = true;

        String temp = s.toLowerCase();
        
        if (!temp.contains("p") && !temp.contains("y")) {
        	return false;
        }

        char[] charArray = temp.toCharArray();
        int tempP = 0;
        int tempY = 0;
        
        for (int i=0; i<charArray.length; i++) {
        	String valueOf = String.valueOf(charArray[i]);
        	
        	if (valueOf.equals("p")) {
        		tempP++;
        	}
        	
        	if (valueOf.equals("y")) {
        		tempY++;
        	}
        }
        
        if (tempP != tempY) {
        	return false;
        }
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        return answer;
    }
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        
        for (int i=0; i<participant.length; i++) {
        	String getString = participant[i];
        	
        	if (!result.containsKey(getString)) {
        		result.put(getString, 1);
        	} else {
        		result.replace(getString, result.get(getString) + 1);
        	}
        }
        
        for (int i=0; i<completion.length; i++) {
        	String getString = completion[i];
        	result.replace(getString, result.get(getString) - 1);
        }
        
        answer = result.entrySet().stream().filter(v -> v.getValue() == 1).findFirst().get().getKey();
        return answer;
    }
	
	public static void main(String[] args) {

//		int[] d = {2,2,3,3};
//		int budget = 10;
//		
//		solution(d , budget);

		//String dartResult = "1S*2T*3S";

		//solution(dartResult);
		
		String s = "pPoooyY";
		
		//System.out.println(solution2(s));
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		solution(participant, completion);
		
		
	}
	
}
