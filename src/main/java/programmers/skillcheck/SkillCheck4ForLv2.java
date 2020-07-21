package programmers.skillcheck;

import java.util.Arrays;
import java.util.HashMap;

public class SkillCheck4ForLv2 {

	private static int count = 0;
	
	public static int solution(int[] nums) {
        int answer = -1;

        for (int i = 0; i < nums.length; i++) {
			int j = nums[i];
			checker(1 , Arrays.copyOfRange(nums, i, nums.length) , j);
		}

        System.out.println(count);
        return answer;
    }
	
	public static void checker(int index , int[] nums , int addedNum) {
		
		
		if (index == 3) {
			
			for (int i = 2; i < addedNum; i++) {
				if (addedNum % i == 0) {
					return;
				}
			}
			count++;
			return;
		}
		
		for (int i = 1; i < nums.length; i++) {
			int j = nums[i];
			checker(index + 1 , Arrays.copyOfRange(nums, i, nums.length) , addedNum + j);
		}
	}
	
	
	public static String[] solution(String[] record) {
        HashMap<String,String> map = new HashMap<String,String>();
        
//        for (int i = 0; i < record.length; i++) {
//			String string = record[i];
//			String[] split = string.split(" ");
//			if (string.contains("Change")) {
//				String userId = split[1];
//				String changeNM = split[2];
//				
//				for (int j=0; j< i; j++) {
//					String unChanged = record[j];
//					String[] splitUnChanged = unChanged.split(" ");
//					
//					if (splitUnChanged[1].equals(userId)) {
//						record[j] = splitUnChanged[0]+" "+splitUnChanged[1] +" " +changeNM;
//					}
//				}
//			}
//		}
        
        int count = 0;
        for (int i = 0; i < record.length; i++) {
        	String string = record[i];
        	String[] split = string.split(" ");
        	String userId = split[1];
    		
        	if (!string.contains("Change")) {
        		count++;
        	}
        	
        	if (string.contains("Enter") || string.contains("Change") ) {
        		
        		String changeNM = split[2];
        		if (!map.containsKey(userId)) { 
        			map.put(userId, changeNM);
        		} else {
        			map.replace(userId, changeNM);
        		}
        	}
        }
        
        String[] answer = new String[count];
        int index = 0;
        for (int i = 0; i < record.length; i++) {
        	
        	
        	String string = record[i];
        	
        	if (!string.contains("Change")) {
	        	String[] split = string.split(" ");
	        	String userId = split[1];
	    		
	    		//record[i] = split[0] + " " + userId + " " + map.get(userId);
	    		answer[index] = map.get(userId) + "님이 " + (split[0].equals("Enter") ? "들어왔습니다." : "나갔습니다.");
	    		System.out.println(answer[index]);
	    		index++;
        	}
        }
        
        
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {1,2,7,6,4};
		//solution(nums);

		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", 
								"Enter uid1234 Prodo", "Change uid4567 Ryan", "Enter uid4444 Man"};
		solution(record);
		
	}

}
