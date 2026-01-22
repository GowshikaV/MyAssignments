package week3.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		
		String str1 = "stops";
		String str2 = "potss";
		if (str1.length()==str2.length()) {
			
			char[] str3 =str1.toCharArray();
			char[] str4 =str2.toCharArray();
			 Arrays.sort(str3);
			 Arrays.sort(str4);
			 
			System.out.println(str3);
			System.out.println(str4);
			
			if (Arrays.equals(str3, str4)) {		
				System.out.println("The given string is an Anagram");
			}
			else {
				System.out.println("The given string is not an Anagram");
			}		
		}
		else {
			System.out.println("Length mismatch so its not an Anagram");
		}
	}
}
