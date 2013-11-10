
public class SolutionsMain {
	/**
	to input data:
	Automata am= new AutoMata();
	am.setState("State as a string");
	am.run(c) c is the number of cycles in integer 
	 */
	public static void main(String[] args){
		AutoMata am= new AutoMata();
		am.setRule("10->1", "01->1");
		System.out.println("State number 1: "+ "0110110110");
		am.upDate("0110110110", 20);
	}
}
