package programmers.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Case7 {

	public static int solution(int[] numbers, int target) {

		int answer = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		q.offer(0);
		
		while (!q.isEmpty()) {
			int depth = q.poll();
			int value = q.poll();
			
			if (depth == numbers.length) {
				if (value == target) {
					answer++;
				}
			} else {
				
				q.offer(depth + 1);
				q.offer(value + numbers[depth]);
				
				q.offer(depth + 1);
				q.offer(value - numbers[depth]);
			}
		}
		
		System.out.println(answer);
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] numbers = {1,1,1,1,1};
		//int target = 3;
		
		//solution(numbers, target);
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		
		solution(begin, target , words);
	}
	
	public static int solution(String begin, String target, String[] words) {
		
		if (!Arrays.asList(words).contains(target)) {
			return 0;
		}
		
		int answer = 0;
		
		boolean[] visit = new boolean[words.length];
		Queue<String> q = new LinkedList<String>();
		q.offer(begin);
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			for (int j=0; j<size; j++) {
				String beginWord = q.poll();
				
				if (beginWord.equals(target)) {
					answer -= 1;
					break;
				}
				
				
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
				System.out.println("BIGINWORD = " + beginWord);
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
				
				
				for (int i=0; i<words.length; i++) {
					
					
					if(!visit[i] && check(words, beginWord, i)) {
						q.offer(words[i]);
						visit[i] = true;
					}
				}
			}
			answer += 1;
			
		}
		
		System.out.println("result = " + answer);
		
		return answer;
	}

	private static boolean check(String[] words, String beginWord, int i) {
		int similar = 0;
		char[] wordArray = words[i].toCharArray();
		char[] biginWordArray = beginWord.toCharArray();
		
		for (int j=0; j<wordArray.length; j++) {
			if (biginWordArray[j] == wordArray[j]) {
				similar++;
			}
		}
		return similar == beginWord.length() - 1;
	}

}
