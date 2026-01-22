package week3.day1;

public class FindOccurance {

	public static void main(String[] args) {
		String input="TestLeaf";
		int output = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i)=='e') {
				output = output+1;
			}
		}
		System.out.println(output);
				

	}
}
