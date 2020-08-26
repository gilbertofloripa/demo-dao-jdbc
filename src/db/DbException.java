package db;

public class DbException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DbException(String msg) {
		super(msg); // devolve a mensagem de erro o runtime.
	}
}
