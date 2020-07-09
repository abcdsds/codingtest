package programmers.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class case5 {

	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i=0; i<prices.length; i++) {
        	
        	int checkerNum = 0;
        	for (int j=i+1; j<prices.length; j++) {
        		if (prices[i] > prices[j]) {
        			System.out.println(prices[i] + " > " +prices[j] + " 크다");
        			checkerNum = j-i;
        			break;
        		}
        		
        		checkerNum++;
        	}
        	answer[i] = (checkerNum);
        }

        for (int k : answer) {
			System.out.println(k);
		}
        
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
        
        
        return answer;
    }
	
	public static void main (String[] args) {
		
		int[] prices = {1,2,3,2,3,1};
		solution(prices);
	}
}
