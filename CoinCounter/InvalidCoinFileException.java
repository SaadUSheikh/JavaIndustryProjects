
/**
 * An exception that is thrown when the coin file we are working with has
 * an invalid format.
 * @author Dengke Sha
 *
 */
public class InvalidCoinFileException extends Exception {

	public InvalidCoinFileException() {
		super("The coin file was invalid.");
	}
	
	public InvalidCoinFileException( String message) {
		super(message);
	}
	
}
