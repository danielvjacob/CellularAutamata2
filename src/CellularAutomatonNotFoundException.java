/**
 * CellularAutomatonNotFoundException extends the exception class and is used to throw illegal automaton issues
 * 
 * @author danieljacob
 *
 */
public class CellularAutomatonNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * If an unknown Automaton is given then exception will be thrown
	 * 
	 * @param s the string input that is decided is an illegal input for automatons
	 */
	public CellularAutomatonNotFoundException(String s) {
		super("Unknown cellular automaton type " + s);
	}
}
