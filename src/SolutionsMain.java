import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Xi Chen
 * Language: Java 1.7
 * Dvelopment framework used: Eclipse
 *
 */
public class SolutionsMain {
	/**
	to input data:
	Automata am= new AutoMata();
	am.setRule("10->1,"23->2" etc.) No input is needed if a rule sets a cell to 0 
	am.upDate("11100000",15) initial state with no spaces between characters, number of cycles
	am.closeFile(); close the file output stream
	 */
	
	//NOTE: some outputs are stored in a text file
	
	//NOTE: only run one automaton at a time and comment out the rest of the code
	static BufferedWriter writer;
	static PrintWriter out;
	
	public static void main(String[] args){
		//Questions 1-4
		//true if testing cycles, false if not. It should be set to false for questions 1-4,true for the rest
		AutoMata am= new AutoMata(false);
		// Question number 1
		/**
		am.setRule("10->1", "01->1");
		System.out.println("State number 1: "+ "0110110110");
		am.setState("0110110110");
		am.upDate(am.initialState, 50);
		am.closeFile();
		**/
		/**3a
		am.setRule("10->1","01->1");
		am.setState("01110");
		am.upDate(am.initialState, 50);
		am.closeFile();
		**/
		
		/**3b
		am.setRule("10->1","01->1");
		am.setState("0111111");
		am.upDate(am.initialState, 50);
		am.closeFile();
		**/
		/**4(1)
		am.setRule("01->1","10->1","11->2","02->2","20->2","22->1");
		am.setState("0122101210");
		am.upDate(am.initialState, 50);
		am.closeFile();
		**/
		/**4(2)
		
		am.setRule("01->3","10->3","11->2","02->2","20->2","22->1","12->1","21->2","03->2","30->1");
		am.setState("0123312301");
		am.upDate(am.initialState, 50);
		am.closeFile();
		**/
		
		//Questions 6-8
		//am= new AutoMata(true);
		/**6(1)
		am.setRule("00->1","01->2","02->1");
		am.setState("0010101010");
		am.upDate(am.initialState, 1000);
		am.closeFile();
		**/
		/**testing
		am.setRule("01->1","11->1");
		am.setState("1111011110");
		am.upDate(am.initialState, 1000);
		am.closeFile();
		**/
		
		/**6(2)
		am.setRule("00->2","01->1","02->2","11->1","12->3","13->1","20->2","22->1","23->3","31->1","32->3","33->2");
		am.setState("0123312301");
		am.upDate(am.initialState, 1000);
		am.closeFile();
		**/
		
		//Question 7
		//System.out.println("Cycles: "+ am.cycleTest().toString());
		/**test
		am.setRule("00->2","01->1","02->2","11->1","12->3","13->1","20->2","22->1","23->3","31->1","32->3","33->2");
		am.setState("3333");
		am.upDate(am.initialState, 100);
		am.closeFile();
		**/
		//Question 8
		/**
		for(int i=0;i<100;i++){
			AutoMata automaton=new AutoMata(true);
			automaton.setState(automaton.generateState(20));
			automaton.setRule((automaton.generateRule()));
			automaton.upDate(automaton.initialState, 1000);
		}
		System.out.println("Cycles: "+AutoMata.cycleAndStates.toString());
		AutoMata.out.close();
		 **/
		//System.out.println(am.generateState(7));
		
		//Question 9 How does the length of the cycle n affect the length of the cycle of an automaton? 
		
		//Starting from length n=4, end with n=8 randomly generate 100 states of the length n, record their cycles

		//Writing the results to a text file
			try {
				writer=new BufferedWriter(new FileWriter("cycles2.txt"));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		/**Question 9
		for(int n=4;n<10;n++){
			System.out.println("Length: "+String.valueOf(n));
			try {
				Thread.sleep(2000);
				for(int c=0;c<100;c++){
					AutoMata amCycle=new AutoMata(true); 
					amCycle.generateState(n);
					amCycle.setRule("01->1","10->1","11->2","02->2","20->1","22->1");
					amCycle.upDate(amCycle.generateThreeState(n), 1000);					
				}
				writer.write("Cycles for length "+ String.valueOf(n)+ ": "+ AutoMata.cycleAndStates.toString());
				writer.newLine();
				AutoMata.cycleAndStates.clear();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			writer.close();
			System.out.println("finished");
		} catch (IOException e) {
			e.printStackTrace();
		}
		**/
		
		
		
		
		
		
	}
	
	
}
