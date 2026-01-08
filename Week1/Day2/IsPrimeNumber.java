package week1.day2;

public class IsPrimeNumber {

	public static void main(String[] args) {
		int n = 7;
		int count = 0;
		for (int i = 2; i <= n-1; i++) {
			if (n%i==0) {
				count=count+1;						
			} 
		}
		if (count>=1) {
			System.out.println(n+" is not a prime Number");
		} 
		else {
			System.out.println(n+" is a Prime Number");
		}

	}

}


