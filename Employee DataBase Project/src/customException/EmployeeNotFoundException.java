package customException;

public class EmployeeNotFoundException  extends RuntimeException{
	private String message;

	public EmployeeNotFoundException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}
