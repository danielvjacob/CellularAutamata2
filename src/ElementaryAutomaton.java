import java.io.FileNotFoundException;

/**
 * The elementary Automaton class extends Automaton to create elementary version of automatons
 * 
 * @author danieljacob
 *
 */
public class ElementaryAutomaton extends Automaton {

	/**
	 * 
	 * @param ruleNum an int that is the rule number which designates the evolution rules 
	 * @param initial the initial generation object
	 * @throws RuleNumException is thrown if the rule number is not in proper range
	 */
	protected ElementaryAutomaton(int ruleNum, Generation initial) throws RuleNumException {
		super(ruleNum, initial);
		
	}

	/**
	 * overrides the parent method in order to create an elementary automaton
	 * 
	 * @param filename the file which the information for the automatons rule exist in
	 * @throws FileNotFoundException is thrown if the file is invalid or empty
	 * @throws RuleNumException is thrown if the rule is not within the valid range
	 */
	protected ElementaryAutomaton(String filename) throws FileNotFoundException, RuleNumException {
		super(filename);
		
	}

	@Override
	
	/**
	 * creates an elementary rule based of the given rule number
	 * 
	 * @param ruleNum the int that is rule will be made from
	 * @return the new elementary rule as a Rule object
	 * @throws RuleNumException if the rule is not within the valid range
	 * 
	 */
	protected Rule createRule(int ruleNum) throws RuleNumException {
		
		return new ElementaryRule(ruleNum);
	}

	

	
}
