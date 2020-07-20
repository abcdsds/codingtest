package programmers.skillcheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SkillCheck3ForLv2 {

	private static List<Integer> result = new ArrayList<Integer>();
	
	public static int solution(int[] nums) {

        for (int i=0; i<nums.length-1; i++) {
        	add(Arrays.copyOfRange(nums, i+1, nums.length) , 0 , nums[i]);
        }

        return result.size();
    }
	
	public static void add(int[] nums,int depth, int num) {
		
		
		if (depth == 2) {
			
			boolean checker = true;
			for (int i=2; i<num; i++) {
				if (num % i < 1) {
					checker = false;
				}
			}
			
			if (checker) {
				System.out.println(num);
				result.add(num);
			}
			return;
		}
		
		if (nums.length == 0) {
			return;
		}
		
		for (int i=0; i<nums.length; i++) {
			//System.out.println(nums[i]);
			add(Arrays.copyOfRange(nums, i+1, nums.length) , depth + 1 , nums[i] + num);
		}
	}
	
	
	public static String solution2(int[] numbers) {
	
		List<Integer> collect = Arrays.stream(numbers).mapToObj(v -> v).collect(Collectors.toList());
		
		Collections.sort(collect, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				
				int p1 = Integer.parseInt(String.valueOf(o1) + String.valueOf(o2));
				int p2 = Integer.parseInt(String.valueOf(o2) + String.valueOf(o1));
				
			
				return p1 > p2 ? -1 : 1;
			}
		});
		
		String collect2 = collect.stream().map(v -> v.toString()).collect(Collectors.joining());
		
		System.out.println(collect2);
		
		
		
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] nums = {1,2,7,6,4};
//		solution(nums);
		
		int[] numbers = {0,0,0,0,0};
		
		solution2(numbers);
	}
	

}
