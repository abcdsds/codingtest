package programmers.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class case4 {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		int answer = 0;

		Stack<Integer> wait = new Stack<Integer>();
		
		for (int i=truck_weights.length-1; i>=0; i--) {
			wait.push(truck_weights[i]);
		}

		Queue<Integer> moving = new LinkedList<Integer>();

		Stack<Integer> destination = new Stack<Integer>();

		Queue<Integer> count = new LinkedList<Integer>();

		Integer pop = wait.pop();
		moving.offer(pop);
		count.offer(1);
		int leftCount = weight - pop;
		
		while (true) {

			answer++;
			
			if (count.peek().intValue() > bridge_length) {
				System.out.println("push " + moving.peek());
				System.out.println("push current count " + answer);
				Integer poll = moving.poll();
				destination.push(count.poll());
				leftCount += poll.intValue();
				
				if (wait.isEmpty() && moving.isEmpty()) {
					break;
				}
				//break;
			}

			if (!wait.isEmpty()) { 
				
				if (!moving.isEmpty()) {
					
					if (leftCount >= wait.peek().intValue()) {
						System.out.println("leftCount " + leftCount);
						System.out.println("current wait" + wait.peek());
						System.out.println( "count  " + answer);
						pop = wait.pop();
						moving.offer(pop);
						count.offer(1);
						leftCount -= pop.intValue();

					}
				} else {
					pop = wait.pop();
					moving.offer(pop);
					count.offer(1);
					leftCount -= pop.intValue();
				}
				
			}
						
			for (int i = 0; i < count.size(); i++) {
				
				Integer popCount = count.poll();
				popCount++;
				count.offer(popCount);
			}

		}

		System.out.println(destination);
		System.out.println(answer);
		
		return answer;
	}

	public static void main(String[] args) {

//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = { 7, 4, 5, 6 };

//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = { 10 };
		
		//int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

		int bridge_length = 4;
		int weight = 2;
		int[] truck_weights = { 1,1,1,1 };
		
		solution(bridge_length, weight, truck_weights);

	}
}
