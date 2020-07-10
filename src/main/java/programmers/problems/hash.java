package programmers.problems;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class hash {

	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        

        
        List<String> collect = IntStream.range(0, participant.length).mapToObj(n -> participant[n]).collect(Collectors.toList());
        
                
        IntStream.range(0, completion.length).forEach(v -> {
        	collect.remove(completion[v]);
        });
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = 	{"stanko", "ana", "mislav"};
		solution(participant , completion);
	}
}
