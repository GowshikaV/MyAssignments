package week3.day1;

public class ReverseOddWords {

	public static void main(String[] args) {
		String test = "I am a software tester"; 
		String [] words = test.split(" ");
		
		String output = "";
		for (int i = 0; i < words.length; i++) {
			if (i%2!=0) {
				for (int j=words[i].length()-1; j>=0; j--) {
					 char letter = words[i].charAt(j);
					 output= output + letter;
				}			
			} 
			
			else {
				output= output + words[i];
				
			}
			
			output= output+ " ";
			
		} System.out.println(output.trim());

	}

}
