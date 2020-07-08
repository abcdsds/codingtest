package programmers.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class case4 {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		int answer = 0;
		int leftCount = weight;
		Stack<Integer> wait = new Stack<Integer>();
		Queue<Integer> moving = new LinkedList<Integer>();
		Queue<Integer> count = new LinkedList<Integer>();

		for (int i = truck_weights.length - 1; i >= 0; i--) {
			wait.push(truck_weights[i]);
		}

		while (true) {

			answer++;

			if (count.size() > 0 && count.peek().intValue() > bridge_length) {
				Integer poll = moving.poll();
				count.poll();
				leftCount += poll.intValue();

				if (wait.isEmpty() && moving.isEmpty()) {
					break;
				}
			}

			if (!wait.isEmpty()) {
				if ((!moving.isEmpty() && leftCount >= wait.peek().intValue()) || moving.isEmpty()) {
					Integer pop = wait.pop();
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

		return answer;
	}

	public static int[] solution(int[] heights) {

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stackResult = new Stack<Integer>();
		// Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < heights.length; i++) {
			stack.push(heights[i]);
		}

		while (true) {

			if (stack.size() == 0) {
				break;
			}

			int size = stackResult.size();

			for (int i = stack.size() - 1; i > -1; i--) {

				int intValue = stack.peek().intValue();
				if (intValue < heights[i]) {
					System.out.println("=========== height");
					System.out.println(heights[i]);
					stackResult.push(i + 1);
					break;
				}

			}

			if (size == stackResult.size()) {
				stackResult.push(0);
			}

			stack.pop();
		}

		System.out.println(stackResult.size());

		System.out.println("=====R E S U L T==========");

		int[] array = IntStream.range(0, stackResult.size()).map(v -> stackResult.pop()).toArray();

		IntStream.range(0, array.length).forEach(v -> {
			System.out.println(array[v]);
		});
		System.out.println(array[0]);
		return array;
	}

	public static int[] solution(int[] progresses, int[] speeds) {


		List<Integer> list = new ArrayList<Integer>();

		int tempValue = 0;
		
		for (int i = 0; i < progresses.length; i++) {
			int rest = 100 - progresses[i];
			//Double ceil = Math.ceil(rest / speeds[i]);
			Integer ceil = rest % speeds[i] > 0 ? (rest / speeds[i])+1 : rest / speeds[i];
			System.out.println("=========================");
			System.out.println(ceil);
			
			if (tempValue > ceil) {
				list.set(list.size()-1, list.get(list.size()-1) +1);
			} else {
				tempValue = ceil;
				list.add(1);
			}
			
			System.out.println("=========================");
		}
		
		System.out.println("=========================");
		list.forEach(v -> {
			System.out.println(v);
		});
//		System.out.println("=========================");
		
//		Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(v -> v, Collectors.counting()));
//
//		int[] answer = collect.values().stream().mapToInt(v -> v.intValue()).toArray();
//		IntStream.range(0, answer.length).forEach(v -> {
//			System.out.println(answer[v]);
//		});
		
		return null;
	}

	public static int[] solution2(int[] progresses, int[] speeds) {
		int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
                System.out.println("=========");
                System.out.println(day);
                System.out.println("=========");
            }
            dayOfend[day]++;
            System.out.println("=========2");
            System.out.println(dayOfend[day]);
            System.out.println("=========2");
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
		
	}
	
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		//2 1 3 2 클수록 우선순위가 높다.
		// 2,2,2,1,3,4
		Queue<int[]> tempQueue = new LinkedList<int[]>();
		Queue<int[]> resultQueue = new LinkedList<int[]>();
		
		for (int i=0; i<priorities.length; i++) {
			tempQueue.offer(new int[]{i,priorities[i]});
		}
				
		while (true) {
			
			if (resultQueue.size() == priorities.length) {
				break;
			}
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.addAll(tempQueue);
			
			int[] temp = tempQueue.peek();
			boolean check = true;
			for (int i=0; i<tempQueue.size(); i++) {
				int m = queue.peek()[0];
				int l = queue.poll()[1];
				if (temp[1] < l) {
					System.out.println("=================");
					//System.out.println(temp[0]);
					System.out.println(temp[1]);
					//System.out.println(m);
					System.out.println(l);
					System.out.println("=================");
					for (int j=0; j<i; j++) {
						int[] poll = tempQueue.poll();
						tempQueue.offer(poll);
					}
					check = false;
					break;
				}
			}
			
			if (check) {
				int[] poll = tempQueue.poll();
				System.out.println("Result Added = " +poll[1]);
				resultQueue.offer(poll);
				System.out.println(tempQueue.size());
				System.out.println(resultQueue.size());
			} else {
				System.out.println("rest size " + queue.size());
			}

			System.out.println(check);
		}
		

		//System.out.println("result QSize " + resultQueue.size());
		
		//System.out.println(tempQueue.peek()[0] + " : " + tempQueue.poll()[1]);
		

		int tempSize = tempQueue.size();
		
		for (int i=0; i<tempSize; i++) {
			//System.out.println("temp " + tempQueue.peek()[0] + " : " + tempQueue.poll()[1]);
			resultQueue.offer(tempQueue.poll());
		}
		
		int resultSize = resultQueue.size();
		
		for (int i=0; i<resultSize; i++) {
			System.out.println("result " + resultQueue.peek()[0] + " : " + resultQueue.poll()[1]);
//			if (resultQueue.poll()[0] == location) {
//				answer = (i+1);
//			}
		}
		
//		List<int[]> stack = new ArrayList<int[]>();
//		
//		for (int i=0; i<priorities.length; i++) {
//			stack.add(new int[]{i,priorities[i]});
//		}	
//		
//		
//		Collections.sort(stack, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// TODO Auto-generated method stub
//				
//				int i = o1[1];
//				int j = o2[1];
//				
//				if (i == j) {
//					int k = o1[0];
//					int l = o2[0];
//					
//					return l - k;
//				} 
//				
//				return j - i;
//			}
//			
//		});
//		
//		for (int[] j : stack) {
//			System.out.println(j[0] + " : " + j[1]);
//		}
//		
//		int asInt2 = IntStream.range(0, stack.size()).filter(v -> stack.get(v)[0] == location).map(v -> v).min().getAsInt();
//		System.out.println(asInt2+1);
		
//		for (int[] j : stack) {
//			System.out.println(j[0] + " : " + j[1]);
//		}
		
//		for (int i=0; i<priorities.length; i++) {
//			int intValue = stack.peek().intValue();
//			priorities[i] > 
//		}
		
		
		
		
		
		
		System.out.println("answer" + answer);
        return answer;
    }
	
	public static void main(String[] args) {

//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = { 7, 4, 5, 6 };

//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = { 10 };

		// int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

//		int bridge_length = 4;
//		int weight = 2;
//		int[] truck_weights = { 1,1,1,1 };

		// System.out.println(solution(bridge_length, weight, truck_weights));

		// int[] heights = {3,9,9,3,5,7,2};

//		int[] progress = {40, 93, 30, 55, 60, 65};
//		int[] speeds = {60, 1, 30, 5 , 10, 7};
//
//		solution(progress, speeds);
		
//		int[] solution2 = solution2(progress, speeds);
//		
//		System.out.println("========= 2 Result ==========");
//		IntStream.range(0, solution2.length).forEach(v -> {
//			System.out.println(solution2[v]);
//		});
		
//		int[] priorities = {2,1,3,2};
//		int location = 2;
		
//		int[] priorities = {1, 1, 9, 1, 1, 1};
//		int location = 0;
//		
//		int[] priorities = {2,2,2,1,3,4};
		//4,1,2,2,2,1,3
		//
//		int location = 3;

		int[] priorities = {1 , 2 , 3 , 4};
		int location = 2;
		
		
		solution(priorities, location);

	}
}
