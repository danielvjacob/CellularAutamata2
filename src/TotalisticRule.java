/**
 * 
 * @author danieljacob
 *
 */
public class TotalisticRule extends Rule {

	/**
	 * the neighborhood for this class has a radius of 2 so 5 elements
	 */
	private static final int RADIUS = 2;
	
	/**
	 * Totalistic Class Constructor that constructs only if rule is between 0 and 64
	 * 
	 * @param ruleNum the given rule num
	 * @throws RuleNumException is rule is less than 0 or greater than 64 then exeption is thrown
	 */
	protected TotalisticRule(int ruleNum) throws RuleNumException {
		super(ruleNum);
		
		if (ruleNum < 0 || ruleNum > 63 )
		{
			throw new RuleNumException(0,63);
		}
	}

	@Override
	public boolean[] getNeighborhood(int idx, Generation gen) {
		
		return getNeighborhoodByRadius(idx, RADIUS, gen);
		
	}

	@Override
	public boolean evolve(boolean[] neighborhood) {
		
		String binary = Integer.toBinaryString(super.getRuleNum());
		
		while (binary.length() <= 5)
		{
			binary = "0" + binary;
		}
		
		int trueCount = 0;
		for (int i = 0; i < neighborhood.length; ++i)
		{
			if (neighborhood[i] == true)
			{
				++trueCount;
			}
		}
			
		
			if (trueCount == 5)
			{
				if (binary.charAt(0) == '1')
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else if (trueCount == 4)
			{
				if (binary.charAt(1) == '1')
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else if (trueCount == 3)
			{
				if (binary.charAt(2) == '1')
				{
					return true;
				}
				else
				{
					return false;
				}
				
			}
			else if (trueCount == 2)
			{
				if (binary.charAt(3) == '1')
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else if (trueCount == 1)
			{
				if (binary.charAt(4) == '1')
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else 
			{
				if (binary.charAt(5) == '1')
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
	}

	@Override
	public String ruleTableString(char falseSymbol, char trueSymbol) {
		
		String topRow = "";
		for (int i = 5; i >= 0; --i)
		{
			if (i > 0)
			{
				topRow += Integer.toString(i) + " ";
			}
			else
			{
				topRow += Integer.toString(i);
			}
		
		}
		
		String bottomRow = "";
	
		String binary = Integer.toBinaryString(super.getRuleNum());
		while (binary.length() <= 5)
		{
			binary = "0" + binary;
		}
		
		for (int j = 0; j <= 5; ++j)
		{
			if (j < 5)
			{
				bottomRow += binary.charAt(j) + " ";
			}
			else
			{
				bottomRow += binary.charAt(j);
			}
		}
		
		char temp = '*';
		bottomRow = bottomRow.replace('0', temp);
		bottomRow = bottomRow.replace('1', trueSymbol);
		bottomRow = bottomRow.replace(temp, falseSymbol);
		
		String table = topRow + System.lineSeparator() + bottomRow;
		
		
		return table;
		
	}

}
