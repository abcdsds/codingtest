package programmers.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


public class hash {

	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> collect = new HashMap();
        
        IntStream.range(0, participant.length).forEach(v -> {
        	collect.put(participant[v], collect.getOrDefault(participant[v], 0) + 1);
        });
        
//        collect.forEach((k,v) -> {
//        	System.out.println(k);
//        	System.out.println(v);
//        });
        
        IntStream.range(0, completion.length).forEach(v -> {
        	collect.replace(completion[v], collect.get(completion[v]) - 1);
        });
        
        String key = collect.entrySet().stream().filter(v -> v.getValue() == 1).findFirst().get().getKey();
        System.out.println(key);
        return answer;
    }
	
	public static void main(String[] args) {
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = 	{"stanko", "ana", "mislav"};
		solution(participant , completion);
	}
}
