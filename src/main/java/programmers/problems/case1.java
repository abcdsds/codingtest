package programmers.problems;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class case1 {

	public static int[] solution(int[] array, int[][] commands) {

		int[] result = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {

			int[] temp = new int[(commands[i][1] - commands[i][0]) + 1];
			int y = 0;

			for (int j = commands[i][0]; j <= commands[i][1]; j++) {
				temp[y] = array[j - 1];
				y++;
			}

			Arrays.sort(temp);

			result[i] = temp[commands[i][2] - 1];

		}

		return result;
	}

	public static String solution(int[] numbers) {
		List<Integer> list = new ArrayList();

		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String str1 = o1.toString() + o2.toString();
				String str2 = o2.toString() + o1.toString();

				int a = Integer.parseInt(str1);
				int b = Integer.parseInt(str2);
				return b - a;
			}
		});

		String collect = list.get(0) == 0 ? "0" : list.stream().map(l -> l.toString()).collect(Collectors.joining());
		return collect;
	}

	public static int solution2(int[] citations) {

		int result = 0;

		for (int i = 1; i <= citations.length; i++) {

			int temp = 0;

			if (i > citations.length) {
				continue;
			}

			for (int j = 0; j < citations.length; j++) {

				if (i <= citations[j]) {
					temp++;
				}
			}

			if (i <= temp) {
				result = i > result ? i : result;
			}
		}

		return result;
	}

	public static int[] solution(int money) {

		int[] template = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
		int[] result = new int[9];

		int temp = money;

		for (int i = 0; i < template.length; i++) {

			result[i] = temp / template[i];
			temp = temp % template[i];
		}

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

		return null;
	}

	public static String solution(String word) {

		String[] result = new String[word.length()];
		String[] template = { "Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I",
				"H", "G", "F", "E", "D", "C", "B", "A" };

		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < template.length; j++) {

				if (!String.valueOf(word.charAt(i)).matches("[A-Za-z]")) {
					result[i] = String.valueOf(word.charAt(i));
					break;
				}

				if (String.valueOf(word.charAt(i)).equalsIgnoreCase((template[j]))) {

					if (!String.valueOf(word.charAt(i)).equals(template[j])) {
						result[i] = template[25 - j].toLowerCase();
					} else {
						result[i] = template[25 - j];
					}
				}
			}
		}

		String collect = Arrays.stream(result).collect(Collectors.joining());
		System.out.println(collect);
		return collect;
	}

	public static int solution(int[] poby, int[] crong) {

		if (!(poby[1] - poby[0] == 1) || !(crong[1] - crong[0] == 1)) {
			return -1;
		}

		int pobyLeftAdd = 0;
		int pobyRightAdd = 0;

		int pobyLeftMultiply = 1;
		int pobyRightMultiply = 1;

		String tempPobyLeft = String.valueOf(poby[0]);
		for (int j = 0; j < tempPobyLeft.length(); j++) {
			pobyLeftAdd += Integer.parseInt(String.valueOf(tempPobyLeft.charAt(j)));
			pobyLeftMultiply *= Integer.parseInt(String.valueOf(tempPobyLeft.charAt(j)));
		}

		String tempPobyRight = String.valueOf(poby[1]);
		for (int j = 0; j < tempPobyRight.length(); j++) {
			pobyRightAdd += Integer.parseInt(String.valueOf(tempPobyRight.charAt(j)));
			pobyRightMultiply *= Integer.parseInt(String.valueOf(tempPobyRight.charAt(j)));
		}

		int[] pobyPoint = { pobyLeftAdd, pobyRightAdd, pobyLeftMultiply, pobyRightMultiply };

		int crongLeftAdd = 0;
		int crongRightAdd = 0;

		int crongLeftMultiply = 1;
		int crongRightMultiply = 1;

		String tempCrongLeft = String.valueOf(crong[0]);
		for (int j = 0; j < tempCrongLeft.length(); j++) {
			crongLeftAdd += Integer.parseInt(String.valueOf(tempCrongLeft.charAt(j)));
			crongLeftMultiply *= Integer.parseInt(String.valueOf(tempCrongLeft.charAt(j)));
		}

		String tempCrongRight = String.valueOf(crong[1]);
		for (int j = 0; j < tempCrongRight.length(); j++) {
			crongRightAdd += Integer.parseInt(String.valueOf(tempCrongRight.charAt(j)));
			crongRightMultiply *= Integer.parseInt(String.valueOf(tempCrongRight.charAt(j)));
		}

		int[] crongPoint = { crongLeftAdd, crongRightAdd, crongLeftMultiply, crongRightMultiply };

		Arrays.sort(pobyPoint);
		Arrays.sort(crongPoint);
//		System.out.println(pobyPoint[pobyPoint.length-1]);
//		System.out.println(crongPoint[crongPoint.length-1]);
		return pobyPoint[pobyPoint.length - 1] > crongPoint[crongPoint.length - 1] ? 1
				: pobyPoint[pobyPoint.length - 1] < crongPoint[crongPoint.length - 1] ? 2 : 0;
	}

	public static int solution2(int numbers) {

		int claps = 0;

		for (int i = 1; i <= numbers; i++) {
			String value = String.valueOf(i);

			for (int j = 0; j < value.length(); j++) {

				String subValue = String.valueOf(value.charAt(j));

				if (subValue.contains("3") || subValue.contains("6") || subValue.contains("9")) {

					System.out.println(value);
					claps++;
				}

			}

		}

		return claps;
	}

	public static String[] solution(int totalTicket, String[] logs) {

		LocalDateTime temp = null;
		String tempName = "";
		String tempRequest = "";
		Set<String> result = new LinkedHashSet<>();
		
		for (int i=0; i<logs.length; i++) {
			String name = logs[i].split(" ")[0];
			String request = logs[i].split(" ")[1];
			LocalDateTime date = LocalDateTime.parse("2020 07 02 " + logs[i].split(" ")[2] , DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss"));
			
			if (request.equals("request")) {
				result.add(name);
				System.out.println("저장 " + name);
			}
			
			if (tempName.equals(name) && request.equals("leave")) {
				
				System.out.println(date);
				System.out.println(temp);
				
				if (date.minusMinutes(1).isBefore(temp)) {
					
					result.remove(name);
					//System.out.println("삭제1 : " + name);
					tempName = name;
					tempRequest = request;
					temp = date;
					
				} 
			}
			
			if (!tempName.equals(name) && i != 0 && request.equals("request")) {
				
				if (date.minusMinutes(1).isBefore(temp)) {
					result.remove(name);
	
				} else {
										
					tempName = name;
					tempRequest = request;
					temp = date;
				}
			}
			
			if (i == 0 || request.equals("leave")) {
				tempName = name;
				tempRequest = request;
				temp = date;
			}
					
		}
		
		TreeSet<String> tSet = new TreeSet<String>(result);
		tSet.forEach(r -> System.out.println(r));
		
		return null;
	}

	public static String solution2 (String cryptogram) {
		
		char temp = ' ';
		
		while(true) {
			List<Character> list = new ArrayList();
			int checked = 0;
			
			for (int i=0; i<cryptogram.length(); i++) {
				char nowCharacter = cryptogram.charAt(i);
				
				if (temp != nowCharacter) {
					list.add(nowCharacter);
				} else {
					checked++;
					if (list.size() > 0 ) {
						list.remove(list.size()-1);
					}
					temp = ' ';
				}
				temp = nowCharacter;
			}
			
			cryptogram = list.stream().map(c -> String.valueOf(c)).collect(Collectors.joining());
			if (checked == 0) {
				break;
			}
		}
		
		System.out.println(cryptogram);
		//list.forEach(r -> System.out.print(r));
		
		return " end";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 1, 5, 2, 6, 3, 7, 4 };
		int commands[][] = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		// solution(array, commands);

		int array2[] = { 6, 10, 2 };
		int array3[] = { 3, 30, 34, 5, 9 };
		int array4[] = { 0, 0, 0, 0 };

		// System.out.println(solution(array4));

		int array5[] = { 3, 0, 6, 1, 5 };
		int array6[] = { 5, 5, 5, 5 };
		// solution2(array6);

		// solution(5857456);

		// solution("가I love you");

//		int array7[] = { 97, 98 };
//		int array8[] = { 197, 198 };

//		int array7[] = { 131, 132 };
//		int array8[] = { 211, 212 };

		int array7[] = { 99, 102 };
		int array8[] = { 211, 212 };

//		System.out.println(solution(array7, array8));

		//System.out.println(solution2(9999));

		int totalTicket = 2000;
		String[] logs = { "woni request 09:12:29", "brown request 09:23:11", "brown leave 09:23:44",
				"jason request 09:33:51", "jun request 09:33:56", "cu request 09:34:02" };
		
		//solution(totalTicket, logs);
		
		System.out.println(solution2("browoanoommnaon"));
		System.out.println(solution2("zyelleyz"));
	}

}
