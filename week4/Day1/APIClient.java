package week4.day1;

public class APIClient {
	
	public void sendRequest(String endpoint) {
		System.out.println("The endpoint: "+ endpoint);
	}
	
	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("The endpoint: "+endpoint+" The request body: "+requestBody+" Request Status: "+requestStatus);
	}
	
	public static void main(String[] args) {
		APIClient api = new APIClient();
		api.sendRequest("https://api.example.com");
		api.sendRequest("https://api.exapmle.com", "Information", true);
	}

}
