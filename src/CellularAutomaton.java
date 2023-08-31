/**
 * Enumeration class where string input is designated ECA or TCA
 * 
 * @author danieljacob
 *
 */
public enum CellularAutomaton {

	/**
	 * and elementary Automaton
	 */
	ECA,
	
	/**
	 * a totalistic Automaton
	 */
	TCA;
	
	/**
	 * 
	 * @param s the string that is a string input that is either an ECA or TCA
	 * @return returns either a cellularAutomaton that is ECA or TCA
	 * @throws CellularAutomatonNotFoundException if no Automaton is found or incorrect format for automaton then this is thrown
	 */
	public static CellularAutomaton parse(String s) throws CellularAutomatonNotFoundException {
		if (s.equalsIgnoreCase("ECA")) { 
			return ECA;
		}
		else if (s.equalsIgnoreCase("TCA")) {
			return TCA;
		}
		else {
			throw new CellularAutomatonNotFoundException(s);
		}
	}
}
