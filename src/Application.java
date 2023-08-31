/**
 * Application class validates the user arguments and runs the program
 * @author danieljacob
 *
 */
public class Application {

	private static final int NUM_EXPECTED_ARGS = 6;

	private static final int IDX_CA = 0;
	private static final int IDX_RULE_NUM = 1;
	private static final int IDX_FALSE_SYMBOL = 2;
	private static final int IDX_TRUE_SYMBOL = 3;
	private static final int IDX_INITIAL_GENERATION = 4;
	private static final int IDX_NUM_EVOLVE = 5;

	private static final String ARG_NAMES = "ca rule-num false-symbol true-symbol initial-generation num-evolutions";
	
	// Source and class file names must match, so Application can be hard-coded
	private static final String USAGE_FMT_STRING_CLASS = "Usage: java Application " + ARG_NAMES;

	// The jar file may be renamed, so this will be varied
	private static final String USAGE_FMT_STRING_JAR = "Usage: java -jar %s " + ARG_NAMES;

	/**
	 * The String array that contains the user input for the application class
	 * 
	 */
	private String[] appArgs;
	
	/**
	 * Class Constructor for application class , validates the arguments as well
	 * 
	 * @param args String array of given user input for the application class
	 */
	public Application(String[] args)  {
		
		validateNumArgs(args);
		
		
	}
	
	/**
	 * Validates the Strings in the args array
	 * 
	 * @param args String array of given user input for the application class
	 */
	private void validateNumArgs(String[] args) {
		if (args.length != NUM_EXPECTED_ARGS)
		{
			throwRuntimeExceptionWithUsageMessage();
		}
		else
		{
			this.appArgs = args;
		}
	}

	/**
	 * Throws a RuntimeException with an appropriate usage string 
	 * 
	 */
	private void throwRuntimeExceptionWithUsageMessage() {
		// Implementation provided
		if (runningAsJar()) {
			// Get the path to the executing file
			String path = Application.class
					.getProtectionDomain()
					.getCodeSource()
					.getLocation()
					.getPath();
			// Only take path after last slash (to get file name).
			// A hard-coded slash is fine since Java URLs use /
			String file = path.substring(path.lastIndexOf("/") + 1);
			throw new RuntimeException(String.format(USAGE_FMT_STRING_JAR, file));
		} else {
			throw new RuntimeException(String.format(USAGE_FMT_STRING_CLASS));
		}
	}

	private boolean runningAsJar() {
		// Implementation provided
		return Application.class
				.getResource("Application.class")
				.toString()
				.startsWith("jar");
	}
	
	/**
	 * parses the String argument and constructs and Automaton
	 * 
	 * @param args String array of given user input for the application class
	 * @throws CellularAutomatonNotFoundException if CA is not found
	 * @throws RuleNumException if rule doesn't fit range
	 * @throws NumberFormatException if input number is formatted incorrectly
	 */
	private void parseArgs(String[] args) throws CellularAutomatonNotFoundException, RuleNumException, NumberFormatException{
		
	
			CellularAutomaton ca = CellularAutomaton.parse(args[IDX_CA]);
			int ruleNum = Integer.parseInt(args[IDX_RULE_NUM]);
			Generation initial = new Generation(args[IDX_INITIAL_GENERATION], args[IDX_TRUE_SYMBOL].charAt(0));
			Automaton auto = Automaton.createAutomaton(ca, ruleNum, initial);
			auto.trueSymbol = args[IDX_TRUE_SYMBOL].charAt(0);
			auto.falseSymbol = args[IDX_FALSE_SYMBOL].charAt(0);
			auto.evolve(Integer.parseInt(args[IDX_NUM_EVOLVE]));
			System.out.println(auto.toString());
			
		
		// TODO: Parse each of the six arguments, construct the appropriate 
		// Automaton, and print out the full evolution to System.out. 
		// Refer to the README for details on exception handling.
	}

	/**
	 * Calls the parsArgs method and catches any exceptions
	 * 
	 */
	public void run(){
	
		try {
		parseArgs(appArgs);
		}
		catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * the main method that calls run 
	 * 
	 * @param args the array of string arguments that are used to construct and evolve the automatons
	 */
	public static void main(String[] args) {
		
		try {
			Application app = new Application(args);
			app.run();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
}
