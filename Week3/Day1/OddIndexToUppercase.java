package week3.day1;

public class OddIndexToUppercase {

	public static void main(String[] args) {
		String test = "changeme";
		char[] chararray = test.toCharArray();
		
		for (int i = 0; i < chararray.length; i++) {
			if (i % 2 == 1) {
				chararray [i] = Character.toUpperCase(chararray[i]);
			}
		}
		System.out.println(chararray);

	}

}
