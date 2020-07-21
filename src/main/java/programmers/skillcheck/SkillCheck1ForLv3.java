package programmers.skillcheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class SkillCheck1ForLv3 {

	private static int result;
	private static List<String[]> list = new ArrayList<String[]>();

	public static String[] solution(String[][] tickets) {

		result = tickets.length;

		for (int i = 0; i < tickets.length; i++) {
			String[] name = tickets[i];
			
			HashMap<String, Integer> maps = new LinkedHashMap<String, Integer>();
			maps.put(name[0]+" "+name[1], 1);
			checker(1 , tickets , maps , name);
			//System.out.println(name[0] + " : " + name[1]);
		}
			

		Collections.sort(list, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				String a = o1[0].split(" ")[0];
				String b = o2[0].split(" ")[0];
				
				if (a.equals(b)) {
					
					for (int i=0; i<o1.length; i++) {
						String c = o1[i].split(" ")[1];
						String d = o2[i].split(" ")[1];
						
						if (!c.equals(d)) {
							return c.compareToIgnoreCase(d);
						}
					}
				}
				
				return a.compareToIgnoreCase(b);
			}

		});
		
		
		String[] strings = list.get(0);
		String[] answer = new String[strings.length+1];
		for (int j = 0; j < strings.length; j++) {
			String string = strings[j];
			
			if (j != strings.length-1) {
				answer[j] = string.split(" ")[0];
			} else {
				answer[j] = string.split(" ")[0];
				answer[j+1] = string.split(" ")[1];
			}
		}
		
		for (String string2 : strings) {
			System.out.println(string2);
		}
		
		System.out.println("BOO".compareToIgnoreCase("COO"));
		
		return null;
	}

	public static void checker(int index, String[][] tickets, HashMap<String, Integer> usedTicket , String[] nowTicket) {
		
		
//		System.out.println("INDEX ====== " +index);
//		System.out.println("NOWTICKET ====== " +nowTicket[0] + " : " + nowTicket[1]);
//		System.out.println("USEDTICKET SIZE ========" + usedTicket.size());
		
		if (index == result) {
			String[] array = usedTicket.keySet().stream().map(v -> v.toString()).toArray(size -> new String[size]);
			
			for (int i=0; i<array.length; i++) {
				//System.out.println(array[i]);
			}
			
			System.out.println("===========================");
			if (!array[0].split(" ")[0].equals("ICN")) {
				return;
			}
			list.add(array);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			String[] name = tickets[i];
			
			if (usedTicket.containsKey(name[0]+" "+name[1])) {
			//if (usedTicket.get(name[0]+name[1]) != null && usedTicket.get(name[0]+name[1]).equals(name[1]) ) {
				//System.out.println("SKIP =" + index + " : " + i);
				continue;
			}
			
			if (name[0].equals(nowTicket[1])) {
				HashMap<String, Integer> copyUsedTicket = new LinkedHashMap<String, Integer>(usedTicket);	
				copyUsedTicket.put(name[0]+" "+name[1], index+1);
				checker(index+1 , tickets , copyUsedTicket, name);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };
		
		String[][] tickets2 = { { "ICN","BOO"}, { "ICN", "COO" }, { "COO", "DOO" }, {"DOO", "COO"}, { "BOO", "DOO"} ,{"DOO", "BOO"}, {"BOO", "ICN" }, {"COO", "BOO"} };
				
		solution(tickets2);
	}

}
