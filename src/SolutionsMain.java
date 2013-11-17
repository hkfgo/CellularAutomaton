
public class SolutionsMain {
	/**
	to input data:
	Automata am= new AutoMata();
	am.setRule("10->1,"23->2" etc.) No input is needed if a rule sets a cell to 0 
	am.upDate("11100000",15) initial state with no spaces between characters, number of cycles
	 */
	
	public static void main(String[] args){
		//Questions 1-4
		AutoMata am= new AutoMata(true);
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
		/**3b
		am.setRule("10->1","01->1");
		am.setState("0111111");
		am.upDate(am.initialState, 50);
		**/
		/**4(1)
		am.setRule("01->1","10->1","11->2","02->2","20->2","22->1");
		am.setState("0122101210");
		am.upDate(am.initialState, 50);
		**/
		/**4(2)
		am.setRule("01->3","10->3","11->2","02->2","20->2","22->1","12->1","21->2","03->2","30->1");
		am.setState("0123312301");
		am.upDate(am.initialState, 50);
		**/		
		
		//am.setRule("01->3","10->3","11->2","02->2","20->2","22->1","12->1","21->2","03->2","30->1");
		//am.setState("0123312301");
		//am.upDate(am.initialState, 50);
		//System.out.println(am.upDate(am.initialState, 50));
		
		//Questions 6-8
		am.setRule("01->1","11->1");
		am.setState("1111011110");
		am.upDate(am.initialState, 50);
		
		
	}
	
	
}
