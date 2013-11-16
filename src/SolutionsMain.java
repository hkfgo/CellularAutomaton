
public class SolutionsMain {
	/**
	to input data:
	Automata am= new AutoMata();
	am.setRule("10->1,"23->2" etc.) No input is needed if a rule sets a cell to 0 
	am.upDate("11100000",15) initial state with no spaces between characters, number of cycles
	 */
	public static void main(String[] args){
		AutoMata am= new AutoMata(false);
		/** Question number 1
		am.setRule("10->1", "01->1");
		System.out.println("State number 1: "+ "0110110110");
		am.setState("0110110110");
		am.upDate(am.initialState, 50)
		**/
		/** 3a
		am.setRule("10->1","01->1");
		am.setState("01110");
		am.upDate(am.initialState, 50);
		**/
		am.setRule("10->1","01->1");
		am.setState("0111111");
		am.upDate(am.initialState, 50);
	}
}
