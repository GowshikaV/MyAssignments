package week4.day1;

public class Amazon extends CanaraBank {

	@Override
	public void cashOnDelivery() {
		System.out.println("Cash On Delivery");
		
	}

	@Override
	public void upiPayments() {
		System.out.println("upi Payments");
		
	}

	@Override
	public void cardPayments() {
		System.out.println("card Payments");
		
	}

	@Override
	public void internetBanking() {
		System.out.println("internetBanking");
		
	}

	@Override
	public void recordPaymentDetails() {
		System.out.println("recordPaymentDetails");
		
	}
	
	public static void main(String[] args) {
		Amazon obj = new Amazon();
		obj.cashOnDelivery();
		obj.upiPayments();
		obj.cardPayments();
		obj.internetBanking();
		obj.recordPaymentDetails();
	}

}
