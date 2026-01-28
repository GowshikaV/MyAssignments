package week4.day1;

public abstract class MySqlConnection implements DatabaseConnection {

	@Override
	public void connect() {
		System.out.println("Parent MySqlConnection : Connect");
		
	}

	@Override
	public void disconnect() {
		System.out.println("Parent MySqlConnection : Disconnect");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("Parent MySqlConnection : ExecuteUpdate");
		
	}
	
	public abstract void executeQuery();

}
