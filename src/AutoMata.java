import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

//Interface for automatons
public class AutoMata {
	int stateCount=2;
	int cycleLength;
	int initialStateCount;
	static Hashtable<String, String> rules;
	static Hashtable<Integer,Integer> cycleAndStates=new Hashtable<Integer,Integer>();
	boolean testCycle; //whether to test cycles
	List<String> states;
	String initialState;
	static PrintWriter out;
	public AutoMata(boolean cycle){
		rules=new Hashtable<String,String>();
		states= new ArrayList<String>();
		testCycle=cycle;
		try {
			out=new PrintWriter("cycles.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void setState(String state){
		initialState=""+state;
		out.println("State number 1: "+ initialState);
	}
	
	void setRule(String... ruleStrings ){
		out.println(Arrays.toString(ruleStrings));
		for(String rule:ruleStrings){
			rules.put(rule.split("->")[0], rule.split("->")[1]);
		}
		out.println(rules.toString());
	}
	
	public String upDate(String state, int cycle){
		state.replaceAll("\\s", "");
		
		String endState="";
		
		if(cycle==1){
			out.println("end state: "+ state);
			out.println(String.valueOf(stateCount));
			if(testCycle==true){
				System.out.println("No cycles");
			}
			return state;
		}
		else if(testCycle==true && states.contains(state) && states.size()>1&&stateCount<=1000){
			System.out.println("Cycle found");
			System.out.println("End state: "+ state);
			System.out.println("recurring state at: " + String.valueOf(states.indexOf(state)+1));
			System.out.println(states.get(states.indexOf(state)));
			cycleLength=stateCount-states.indexOf(state)-2;
			out.println("Cycle length: "+ String.valueOf(cycleLength));
			out.println("All states: "+ states.toString());
			
			//if the cycle length is already recorded
			if(cycleAndStates.containsKey(cycleLength)){
				AutoMata.cycleAndStates.put(cycleLength, cycleAndStates.get(cycleLength)+1);
			}
			else{
				AutoMata.cycleAndStates.put(cycleLength, 1);
			}
			return state;
			
		}
		states.add(state);
		if(cycle!=1){
			for(int i=0;i<state.length();i++){
				String neighbors="";
				//if it is the leftmost cell
				if(i==state.length()-1){
					neighbors=neighbors+ state.charAt(i)+ state.charAt(0);
				}
				else{
					neighbors=neighbors+ state.charAt(i)+state.charAt(i+1);
				}
				//System.out.println(neighbors);
				if(rules.containsKey(neighbors)){
					endState=endState+rules.get(neighbors);
				}
				else{
					endState=endState+"0";
				}
			}
			out.println("State Number "+ stateCount+  ": "+ endState);
			stateCount++;
			upDate(endState,cycle-1);
			return null;
		}
		return endState;			
	}
	
	
	public Hashtable<Integer,Integer> cycleTest(){
		//For an alphabet of 0,1,2,3 and length 4, there's a total of 4^4=256 combinations
		for(int s=0;s<256;s++){
			AutoMata am= new AutoMata(true);
			am.setRule("00->2","01->1","02->2","11->1","12->3","13->1","20->2","22->1","23->3","31->1","32->3","33->2");
			//Takes the base 10 number and convert it to base 4
			String state=Integer.toString(s,4);
			//must be 4 digits, add in omitted digits with 0 
			if(state.length()==1){
				state="000"+state;
			}
			else if(state.length()==2){
				state="00"+state;
			}
			else if(state.length()==3){
				state="0"+state;
			}
			System.out.println("Initial state: "+ state);
			am.upDate(state, 1000);
		}
		out.println(AutoMata.cycleAndStates.toString());
		return AutoMata.cycleAndStates;
	}
	
	
	
	public Hashtable<Integer,Integer> randomCycleTest(){
		return cycleAndStates;
	}
	
	public String[] generateRule(){
		ArrayList<String> randomRules=new ArrayList<String>();
		Random rn=new Random();
		String[] currentCellState={"0","1","2","3"};
		String[] neighborCellState={"0","1","2","3"};
		for(String state:currentCellState){
			for(String nState:neighborCellState){
				randomRules.add(state+nState+"->"+Integer.toString(rn.nextInt(4)));
			}
		}
		System.out.println(randomRules.toString());
		String[] rRules=(String[]) randomRules.toArray(new String[randomRules.size()]);
		return rRules;
	}
	
	public String generateState(int length){
		String rState="";
		Random rn= new Random();
		//generate 20 digits
		for(int x=0;x<length;x++){
			rState=rState+Integer.valueOf(rn.nextInt(4));
		}
		return rState;
	}
	
	public String generateThreeState(int length){
		String rState="";
		Random rn= new Random();
		//generate 20 digits
		for(int x=0;x<length;x++){
			rState=rState+Integer.valueOf(rn.nextInt(3));
		}
		return rState;
	}
	
	void closeFile(){
		out.close();
	}

}
