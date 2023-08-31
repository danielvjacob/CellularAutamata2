/**
 * 
 * @author danieljacob
 *
 */
public abstract class Rule {

	/**
	 * current rule number variable
	 */
	private int ruleNum;
	
	/**
	 * Class Constructor.
	 * 
	 * @param ruleNum that is given by user
	 */
	protected Rule(int ruleNum)
	{
		this.ruleNum = ruleNum;
	}
	
	/**
	 * getter for the ruleNum.
	 * 
	 * @return ruleNum that is chosen
	 */
	public int getRuleNum()
	{
		return ruleNum;
	}
	
	/**
	 * gets the neighborhood of cells that are asked for.
	 * 
	 * @param idx of the generation object's array
	 * @param gen generation object given
	 * @return a boolean array of the neighboring cells
	 */
	public  abstract boolean[] getNeighborhood(int idx, Generation gen);
	
	/**
	 * evolves a given neighborhood of cells.
	 * 
	 * @param neighborhood the surrounds cells of an individual cell state
	 * @return the next state of a cell in a neighborhood with the given states
	 */
	public abstract boolean evolve(boolean[] neighborhood);
	
	/**
	 * Evolves a generation object.
	 * 
	 * @param gen the generation object which is an array that is to be evolved
	 * @return Generation object that has been evolved
	 */
	public Generation evolve(Generation gen) 
	{
		boolean[] states = new boolean[gen.size()];

		for (int i = 0; i < gen.size(); ++i)
		{
			states[i] = evolve(getNeighborhood(i, gen));
		}
		 return new Generation(states);
	}
	
	/**
	 * shows the table with a specific rule using given characters to represent true and false.
	 * 
	 * @param falseSymbol the designated falseSymbol for the automaton
	 * @param trueSymbol the designated trueSymbol for the automaton
	 * @return a string representation of the rule table with it's future state as the bottom row
	 */
	public abstract String ruleTableString(char falseSymbol, char trueSymbol);
	
	/**
	 * Will get neighborhood with different radius that are specified.
	 * 
	 * @param index the chosen cell state
	 * @param radius how many neighbors to the left and right are wanted 
	 * @param gen the generation object which is an array that the neighbors are being taken from
	 * @return array that is neighborhood with a given radius and index
	 */
	public static boolean[] getNeighborhoodByRadius(int index, int radius, Generation gen)
	{
		int length = gen.size();
		int numToReturn = (2 * radius) + 1;
		boolean[] result = new boolean[numToReturn];
		int curr = 0;
		for (int i = radius; i >= (-1 * radius); i--) {
			int val = Math.floorMod(index - i, length);
			result[curr] = gen.getState(val);
			curr++;
		}
		return result;
	}
	
	
}

