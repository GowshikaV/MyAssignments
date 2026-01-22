package week3.day1;

import java.util.Arrays;

public class MissingElementArray {

	public static void main(String[] args) {
		int num[] = {1,4,3,2,8,6,7};
		Arrays.sort(num);
		
		for (int i = 0; i < num.length; i++) {
			if (num[i]!=i+1) {
				System.out.println(num[i]-1);
				break;
			}
			
		}

	}

}
