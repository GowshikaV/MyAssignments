package week4.day1;

public class DatabaseAbstraction implements DatabaseConnection {

	@Override
	public void connect() {
		System.out.println("Connect Method");
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnect Method");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("ExecuteUpdate Method");
		
	}
	
	public static void main(String[] args) {
		DatabaseAbstraction db = new DatabaseAbstraction();
		db.connect();
		db.disconnect();
		db.executeUpdate();
	}

}
