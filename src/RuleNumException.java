/**
 * Check if ruleNum is within possible rule range
 * 
 * @author danieljacob
 *
 */
public class RuleNumException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Will say that given rule num is outside of min and max range
	 * 
	 * @param min the lowest rule number that can be used for this automaton
	 * @param max the highest rule number that can be used for this automaton
	 */
	public RuleNumException(int min, int max) {
		super("ruleNum is outside the range " + "[" + min + ", " + max + "].");
	}
}
