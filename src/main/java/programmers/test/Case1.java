package programmers.test;

public class Case1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "121";
		String[] split = a.split("");
		boolean status = false;
		for (int i = 0; i < split.length; i++) {
			String string = split[i];
			if (string.equals("1") && i != split.length-1) {
				if (split[i+1].equals("2")) {
					status = (true);
				} else {
					status = (false);
					break;
				}
			}
			
			if (i == split.length-1) {
				if (string.equals("1")) {
					status = false;
				} 
			}
		}
		
		System.out.println(status);
		
	}

}
