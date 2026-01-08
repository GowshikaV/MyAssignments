package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		int n = 1221;
		int rem = 0;
		int out = 0;
		
		for (int i=n; i > 0; i=i/10) {        	//1221,  122,         12,             1			
			rem = i % 10;         				//1 ,     2,          2,              1
			out = out * 10+rem;   				//1 ,   1*10+2=12 , 12*10+2=122 , 122*10+1=1221
			System.out.println(out);
		}
			if (n==out) {
			System.out.println(out+" is a Palindrome");
			}else {
			System.out.println(out+" is not a Palindrome");
		}
	}

}