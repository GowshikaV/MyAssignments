package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSecondLargestNumber {

	public static void main(String[] args) {

		Integer[] array = { 3, 2, 11, 4, 6, 7 };
		List<Integer> list = new ArrayList<Integer>();

// Or else use direct Arrays.asList function to convert Arrays to List
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);

		}
		
		Collections.sort(list);
		System.out.println(list);
		System.out.println("Second largest Number is: "+ list.get(4));

	}

}
