package week4.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListStringSorting {

	public static void main(String[] args) {
		
		String [] array =  {"HCL", "Wipro", "Aspire Systems", "CTS"};
		List <String> list = new ArrayList <String> (Arrays.asList(array));
		Collections.sort(list);
		List <String> newlist = new ArrayList <String>();
		//System.out.println(list);
		
		for (int i=list.size()-1; i>=0;  i--) {
			newlist.add(list.get(i));
		}
		
		System.out.println(newlist);

	} 

}
