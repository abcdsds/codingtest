package programmers.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class case3 {

	private static List<String> wordList;
	private static List<Integer> results = new ArrayList<Integer>();
	private static List<List<String[]>> resultList = new ArrayList<List<String[]>>();

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

		if (begin.equals(target)) {
			results.add(num);
			return;
		}

		System.out.println("========num======");
		System.out.println(num);
		char[] charArray = begin.toCharArray();

		for (int i = 0; i < wordList.size(); i++) {

			int checkNum = 0;
			String word = wordList.get(i);
			System.out.println(num + " : " + i + " : " + begin + " : " + word);
			if (usedList.contains(word)) {
				System.out.println("ccccccccccccc");
				continue;
			}

			for (int j = 0; j < word.toCharArray().length; j++) {

				if (charArray[j] == word.charAt(j)) {
					System.out.println(num + " find");
					System.out.println(begin + "  wordddddddddddddddddddddd   " + word);
					checkNum++;
					System.out.println(checkNum);
				}
			}

			if (checkNum == begin.length() - 1) {
				List<String> newUserdList = new ArrayList<>();
				newUserdList.addAll(usedList);
				newUserdList.add(word);
				System.out.println("move " + checkNum + " : " + word);
				check(word, target, newUserdList, num + 1);
			}
		}
	}

	public static String[] solution(String[][] tickets) {

		List<String[]> strings = new ArrayList<String[]>();
		
		for(int i=0; i<tickets.length; i++) {
			if("ICN".equals(tickets[i][0])) {
				check(tickets[i], tickets, strings);
			}
		}
		System.out.println("===============" + resultList.size());
		
		Collections.sort(resultList, new Comparator<List<String[]>>() {

			@Override
			public int compare(List<String[]> o1, List<String[]> o2) {
				// TODO Auto-generated method stub
				
				for (int i=0; i<o1.size(); i++) {
					if (!o1.get(i)[0].equals(o2.get(i)[0])) {
						return o1.get(i)[0].compareToIgnoreCase(o2.get(i)[0]);
					}
				}
				
				return o1.get(0)[0].compareToIgnoreCase(o2.get(0)[0]);
			}
			
		});
		
		
		resultList.get(0).forEach(v -> {
			System.out.println(v[0] + " : " + v[1]);
		});
		
		String[] res = new String[tickets.length+1];
		List<String[]> list = resultList.get(0);
		for (int i=0; i<list.size(); i++) {
			res[i] = list.get(i)[0];
			
			if (i == list.size()-1) {
				res[i+1] = list.get(i)[1];
			}
		}

		return res;
	}
	
	public static void check(String[] arr , String[][] tickets, List<String[]> strings) {
		
		//System.out.println(tickets.length);
		
//		maps.forEach((k, v) -> {
//			System.out.println(k  + " : " + v);
//		});
		
		
		List<String[]> tempStrings = new ArrayList<>();
		tempStrings.addAll(strings);
		
		tempStrings.add(arr);
		System.out.println("========== SIZE 2============" + tempStrings.size());
		
		if (tempStrings.size() == tickets.length) {
			resultList.add(tempStrings);
			
			tempStrings.forEach(v -> {
				System.out.println(v[0]  + " : " + v[1]);
			});
			
			//System.out.println(arr[0] + " : " + arr[1] + " result");
			return;
		}

		//ICN ATL , ATL ICN , ATL SFO
		//ATL ICN
		for(int i=0; i<tickets.length; i++) {
			
			if(tempStrings.contains(tickets[i])) {
				continue;
			}

			if (tickets[i][0].equals(arr[1])) {
//				System.out.println(tickets[i][0]);
//				System.out.println(tickets[i][1]);
//				System.out.println(arr[1]);
				
				//tempStrings.add(tickets[i]);	
				check(tickets[i], tickets, tempStrings);
			} 
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String begin = "hit";
//		String target = "cog";
//		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
//
//		solution(begin, target, words);

		//String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		//String[][] tickets = {{"ICN","BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, {"DOO", "COO"}, { "BOO", "DOO"} ,{"DOO", "BOO"}, {"BOO", "ICN" }, {"COO", "BOO"}};
		solution(tickets);
	}

}
