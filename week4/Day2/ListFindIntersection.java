package week4.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFindIntersection {

	public static void main(String[] args) {
		
		Integer[] array1 = {3, 2, 11, 4, 6, 7};
		Integer[] array2 = {1, 2, 8, 4, 9, 7};
		
		//Array to List conversion
		List <Integer> list1 = new ArrayList <Integer> (Arrays.asList(array1));
		List <Integer> list2 = new ArrayList <Integer> (Arrays.asList(array2)); 
		
		//Keeps only the elements that are common in both
		list1.retainAll(list2);
		
		System.out.println("Duplicate Values: "+list1);
		
		

	}

}
