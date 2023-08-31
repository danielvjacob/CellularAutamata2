import java.io.FileNotFoundException;

/**
 * Totalistic Automaton class extends Automaton in order to create automatons with different rules and structures
 * 
 * @author danieljacob
 *
 */
public class TotalisticAutomaton extends Automaton{

	protected TotalisticAutomaton(int ruleNum, Generation initial) throws RuleNumException {
		super(ruleNum, initial);
		
	}
	protected TotalisticAutomaton(String filename) throws FileNotFoundException, RuleNumException  {
		super(filename);
		
	}
	
	@Override
	protected Rule createRule(int ruleNum) throws RuleNumException {
		
		return new TotalisticRule(ruleNum);
	}

	

}
