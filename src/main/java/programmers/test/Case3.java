package programmers.test;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Case3 {

	public static void main(String[] args) {
		String a = "우리 우리 우리 하나 우리 국민 삼성 농협 농협 농협 국민 저축";
		String[] split = a.split(" ");
		
		Stack<String> stack = new Stack<String>();
				
		for (int i=0; i<split.length; i++) {
			for (int j=0; j<i+1; j++) {
				String string = split[j];
				stack.push(string);
			}
			
			Set<String> listBox = new LinkedHashSet<>();
			while(!stack.isEmpty()) {
				//System.out.print(" " + stack.peek());
				if (listBox.size() == 5) {
					break;
				}
				listBox.add(stack.pop());
				
			}
			
			listBox.forEach(v -> {
				System.out.print(v);
			});
			
			System.out.println();
		}
	}
}
