package week4.day1;

public class JavaConnection extends MySqlConnection {

	@Override
	public void executeQuery() {
		System.out.println("Child JavaConnection   : ExecuteQuery");
		
	}
	
	public static void main(String[] args) {
		JavaConnection java = new JavaConnection();
		java.connect();
		java.disconnect();
		java.executeUpdate();
		java.executeQuery();
	}

}
