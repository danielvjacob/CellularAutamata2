import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * abstract automaton class too create either elementary or totalistic automatons
 * 
 * @author danieljacob
 *
 */
public abstract class Automaton{

	/**
	 * the Rule object that contains the needed rule 
	 */
	private Rule rule;
	
	/**
	 * an arrayList that holds generation objects
	 */
	private ArrayList<Generation> generations = new ArrayList<Generation>();

	/**
	 * a char that represents the chosen false Symbol
	 */
	public char falseSymbol = 0;
	
	/**
	 * a char that represents the chosen true Symbol
	 */
	public char trueSymbol = 1;
	
	/**
	 * abstract class constructor that uses ruleNum and initial generation object is called in subclasses
	 * 
	 * @param ruleNum given rule number
	 * @param initial the initial generation of the automaton
	 * @throws RuleNumException if rule is not within in specified range
	 */
	protected Automaton(int ruleNum, Generation initial) throws RuleNumException {
		
		this.rule = createRule(ruleNum);

		generations.add(initial);
		falseSymbol = '0';
		trueSymbol = '1';
}
	/**
	 * abstract class constructor using file that is called in subclasses
	 * 
	 * @param filename file that is read into
	 * @throws FileNotFoundException if file is unable to be read or incorrect format
	 * @throws RuleNumException if rule number in the file is outside range
	 */
	protected Automaton(String filename) throws FileNotFoundException, RuleNumException {

		Scanner scan = new Scanner(new File(filename));

		rule = createRule(scan.nextInt());

		scan.nextLine();

		falseSymbol = scan.next().charAt(0);
		trueSymbol = scan.next().charAt(0);

		scan.nextLine();

		String stringGeneration = scan.next();

		Generation gen = new Generation(stringGeneration, trueSymbol);
		generations.add(gen);

	}
	
	/**
	 * evolves the automaton a given number of steps
	 * 
	 * @param numSteps the amount of times a automaton wants to be evolves
	 * @return the number of times the automaton was evolved
	 */
	public int evolve(int numSteps) {
		if (numSteps <= 0) {
			return 0;
		} else {
			for (int i = 1; i <= numSteps; ++i) {
				generations.add(rule.evolve(generations.get(generations.size() - 1)));

			}
		}
		return numSteps;
	}
	
	/**
	 * Gets the generation object of a certain step number
	 * 
	 * @param stepNum the amount of times that has been evolved
	 * @return the generation object (array) of a certain evolved generation
	 */
	public Generation getGeneration(int stepNum) {
		if (stepNum >= generations.size()) {
			evolve(stepNum - (generations.size() - 1));
		}

		return generations.get(stepNum);
	}
	
	/**
	 * Gets the current Generation of the Automaton
	 * 
	 * @return the current evolved generation object
	 */
	public Generation getCurrentGeneration() {
		return getGeneration(generations.size() - 1);
	}
	
	/**
	 * Get the the current rule number being used
	 * 
	 * @return the rule number of the automaton as an int
	 */
	public int getRuleNum() {
		return rule.getRuleNum();
	}
	
	/**
	 * gets the number of steps that the Automaton evolves
	 * 
	 * @return an int of the number of times evolved
	 */
	public int getTotalSteps() {
		return generations.size() - 1;
	}
	
	/**
	 * Save the evolved automaton to a file
	 * 
	 * @param filename the file that the automaton is being read into 
	 * @throws IOException if the file cannot be found then exception is thrown
	 */
	public void saveEvolution(String filename) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

		writer.write(this.toString());

		writer.close();
	}
	
	/**
	 * Presents the Automaton and all its generations into a string
	 * 
	 * @return the string representation of the automaton
	 */
	public String toString() {

		String eachLine = "";

		eachLine = generations.get(0).getStates(falseSymbol, trueSymbol);
		for (int i = 1; i < generations.size(); ++i) {
			eachLine += System.lineSeparator() + generations.get(i).getStates(falseSymbol, trueSymbol);
		}

		return eachLine;
	}
	
	/**
	 * returns the rule Table
	 * 
	 * @return a string representation of the rule table
	 */
	public String ruleTableString() {
		return rule.ruleTableString(falseSymbol, trueSymbol);
		
		
	}
	
	/**
	 * Creates either a elementary or totalistic rule object
	 * 
	 * @param ruleNum the rule number that is given by user
	 * @return either a elementary rule or totalistic rule which is designated in sublasses
	 * @throws RuleNumException
	 */
	protected abstract Rule createRule(int ruleNum) throws RuleNumException;
	
	
	/**
	 * Class constructor for Automaton which will either be elementary or totalistic depending on passed in ca
	 * 
	 * @param ca the cellular automaton given (either ECA or TCA)
	 * @param ruleNum the given rule number
	 * @param initial the initial generation of the automaton
	 * @return an automaton object that is either elementary or totalistic
	 * @throws RuleNumException if rule number is not in range or is not correct input then this is thrown
	 */
	public static Automaton createAutomaton(CellularAutomaton ca, int ruleNum, Generation initial) throws RuleNumException
	
	{
//		if (ca == null)
//		{
//		return null;
//		}
//		else if (ca == CellularAutomaton.ECA)
//		{
//			return new ElementaryAutomaton(ruleNum, initial);
//		}
//		else
//		{
//			return new TotalisticAutomaton(ruleNum, initial);
//		}
		
		if (ca != null) {
			switch(ca) {
			case ECA:
				return new ElementaryAutomaton(ruleNum, initial);
		
			case TCA:
				return new TotalisticAutomaton(ruleNum, initial);
		
			}
		}
		return null;
		
		
	}
	
}