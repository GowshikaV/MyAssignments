package week3.day1;

public class ReverseString {

	public static void main(String[] args) {
		
		String string = "TestLeaf";
		char[] name = string.toCharArray();
		//System.out.println(name.length); //8
		
		for (int i= name.length-1; i>=0 ; i-- ) {
			System.out.print(name[i]);
		}

	}

}
