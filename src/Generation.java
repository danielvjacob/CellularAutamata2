import java.util.Arrays;

/**
 * The generation class where generation objects which are boolean arrays are constructed before they are turned into automatons and evolved
 * @author danieljacob
 *
 */
public class Generation {

	/**
	 * array of cells that are either designated with true or false symbols
	 */
	private boolean[] cellStates;
	
	
	/**
	 * Genaration constructor with given array
	 * 
	 * @param states the boolean of cell states that are used to construct a generation
	 */
	public Generation(boolean...states)
	{
		if (states == null || states.length == 0)
		{
			cellStates = new boolean[] {false};
		}
		else
		{
			
			cellStates = Arrays.copyOf(states, states.length);
		}
		
	}
	
	/**
	 * Generation constructor with given string and true Symbol
	 * 
	 * @param states a string representation of the symbols used to create a generation 
	 * @param trueSymbol the designated true Symbol for the generation and automaton
	 */
	public Generation(String states, char trueSymbol)
	{
		
		if (states == "" || states == null)
		{
			cellStates = new boolean[] {false};
		}
		
		else
		{
			cellStates = new boolean[states.length()];
			
			for (int i = 0; i < states.length(); ++i)
			{
			if (states.charAt(i) == trueSymbol)
			{
				cellStates[i] = true;
			}
			else
			{
				cellStates[i] = false;
			}
			}
		}
	}
	
	/**
	 * gets state of specified Index
	 * 
	 * @param idx the index of the wanted state as an int
	 * @return the state of chosen index
	 */
	public boolean getState(int idx)
	{
		return cellStates[idx];
	}
	
	/**
	 * gets all cell states
	 * 
	 * @return array of all states
	 */
	public boolean[] getStates()
	{
		return Arrays.copyOf(cellStates, cellStates.length);
	}
	
	/**
	 * Using false and true symbol gets all states in a string
	 * 
	 * @param falseSymbol the designated false Symbol for the generation and automaton
	 * @param trueSymbol the designated true Symbol for the generation and automaton
	 * @return string representation of states
	 */
	public String getStates(char falseSymbol, char trueSymbol)
	{
		String code = "";

		for (int i = 0; i < cellStates.length; ++i)
		{
			if (cellStates[i] == false)
			{
				code = code + falseSymbol;
			}
			else
			{
				code = code + trueSymbol;
			}
		}
		return code;
	}
	
	/**
	 * Gets the size of the generation object
	 * 
	 * @return length of cellStates
	 */
	public int size()
	{
		return cellStates.length;
	}

	
	
	
	
}
