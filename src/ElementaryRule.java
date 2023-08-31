/**
 * Elementary Rule class extends Rule to create Rule objects that are elementary
 * 
 * @author danieljacob
 *
 */
public class ElementaryRule extends Rule {

	/**
	 * a radius of 1 means that a neighborhood consists of 3 cells
	 * 
	 */
	private static final int RADIUS = 1;
	
	/**
	 * Elementary class constructor 
	 * 
	 * @param ruleNum given by user
	 * @throws RuleNumException if ruleNum is less than 0 or greater than 255
	 */
	protected ElementaryRule(int ruleNum) throws RuleNumException {
		
		super(ruleNum);
		
		if (ruleNum < 0 || ruleNum > 255 )
		{
			throw new RuleNumException(0,255);
		}
		
	}
	
	
	@Override
	/**
	 * 
	 */
	public boolean[] getNeighborhood(int idx, Generation gen) {
		
		return getNeighborhoodByRadius(idx, RADIUS, gen);
	}

	@Override
	public boolean evolve(boolean[] neighborhood) {
		
		
		String binary = Integer.toBinaryString(super.getRuleNum());
		
		while (binary.length() < 8)
		{
			binary = "0" + binary;
		}
			if (neighborhood[0] == true && neighborhood[1] == true && neighborhood[2] == true)
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
			else if (neighborhood[0] == true && neighborhood[1] == true && neighborhood[2] == false)
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
			else if (neighborhood[0] == true && neighborhood[1] == false && neighborhood[2] == true)
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
			else if (neighborhood[0] == true && neighborhood[1] == false && neighborhood[2] == false)
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
			else if (neighborhood[0] == false && neighborhood[1] == true && neighborhood[2] == true)
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
			else if (neighborhood[0] == false && neighborhood[1] == true && neighborhood[2] == false)
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
			else if (neighborhood[0] == false && neighborhood[1] == false && neighborhood[2] == true)
			{
				if (binary.charAt(6) == '1')
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
				if (binary.charAt(7) == '1')
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
		for (int i = 7; i >=0; --i)
		{
		String binary = Integer.toBinaryString(i);
		
			while (binary.length() < 3)
			{
				binary = "0" + binary;
			}
			if (i < 7)
			{
				topRow += " ";
			}
			topRow += binary;
		}
		
		
	String rule = Integer.toBinaryString(getRuleNum());
	while (rule.length() < 8)
	{
		rule = "0" + rule;
	}
	
	String bottomRow = "";
	for (int i = 0; i < 8; ++i)
	{
	if (i > 0)
	{
		bottomRow += " ";
	}
	bottomRow += " " + rule.charAt(i) + " ";
	
	}
	String table = topRow + System.lineSeparator() + bottomRow;
	
	char temp = '*';
	table = table.replace('0', temp);

	table = table.replace('1', trueSymbol);
	
	table = table.replace(temp, falseSymbol);
	
	return table;
	
	
		
	}

}
