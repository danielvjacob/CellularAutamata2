
public class Driver {

	public static void main(String[] args) {

//		totalistic rule table
//		String topRow = "";
//		for (int i = 5; i >= 0; --i)
//		{
//			if (i > 0)
//			{
//				topRow += Integer.toString(i) + " ";
//			}
//			else
//			{
//				topRow += Integer.toString(i);
//			}
//		
//		}
//		
//		String bottomRow = "";
//	
//		String binary = Integer.toBinaryString(22);
//		while (binary.length() <= 5)
//		{
//			binary = "0" + binary;
//		}
//		
//		for (int j = 0; j <= 5; ++j)
//		{
//			if (j < 5)
//			{
//				bottomRow += binary.charAt(j) + " ";
//			}
//			else
//			{
//				bottomRow += binary.charAt(j);
//			}
//		}
//		
//		bottomRow = bottomRow.replace('0', '*');
//		bottomRow = bottomRow.replace('1', '!');
//		
//		String table = topRow + System.lineSeparator() + bottomRow;
//		
//		
//		System.out.println(table);
//		
		
		//elementary rule table
		

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
		
		
	String rule = Integer.toBinaryString(22);
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
	
//	table = table.replace('0', '*');
//	table = table.replace('1', '!');
	
	System.out.println(table);
		
		
		

	}

}
