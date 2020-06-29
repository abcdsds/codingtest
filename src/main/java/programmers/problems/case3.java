package programmers.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class case3 {
	
	private static List<String> wordList;
	private static List<Integer> results = new ArrayList<Integer>();

	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        wordList = Arrays.asList(words);
        
        if (!wordList.contains(target)) {
        	return 0;
        }        
        List<String> usedList = new ArrayList<String>();
    	check(begin, target, usedList, 0);
    	
    	Collections.sort(results);
    	
    	System.out.println(results.get(0));
        return results.get(0);
    }
	
	public static void check(String begin, String target, List<String> usedList, int num) {
		
		
		
		if (begin.equals(target)){
			results.add(num);
			return;
		}
		
		System.out.println("========num======");
		System.out.println(num);
		char[] charArray = begin.toCharArray();


		for(int i=0; i<wordList.size(); i++) {
			
			int checkNum = 0;
			String word = wordList.get(i);
			System.out.println(num +" : " +i + " : " + begin + " : " + word);
			if (usedList.contains(word)) {
				System.out.println("ccccccccccccc");
				continue;
			}
			
			for (int j=0; j<word.toCharArray().length; j++) {
				
				if (charArray[j] == word.charAt(j)) {
					System.out.println(num + " find");
					System.out.println(begin +"  wordddddddddddddddddddddd   " +word);
					checkNum++;
					System.out.println(checkNum);
				}
			}
			
			
			
			if (checkNum == begin.length()-1) {
				List<String> newUserdList = new ArrayList<>();
				newUserdList.addAll(usedList);
				newUserdList.add(word);
				System.out.println("move " + checkNum + " : " +word);
				check(word, target, newUserdList, num+1);
			}
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot" , "dot" , "dog" , "lot" , "log" , "cog"};
		
		solution(begin, target, words);
	}

}
