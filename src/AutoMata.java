import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

//Interface for automatonss
public class AutoMata {
	int stateCount=2;
	int cycleLength;
	int initialStateCount;
	static Hashtable<String, String> rules;
	Hashtable<Integer,Integer> cycleAndStates;
	boolean testCycle; //whether to test cycles
	List<String> states;
	String initialState;
	public AutoMata(boolean cycle){
		rules=new Hashtable<String,String>();
		states= new ArrayList<String>();
		testCycle=cycle;
		cycleAndStates=new Hashtable<Integer,Integer>();
	}
	
	void setState(String state){
		initialState=""+state;
		System.out.println("State number 1: "+ initialState);
	}
	
	void setRule(String... ruleStrings ){
		System.out.println(Arrays.toString(ruleStrings));
		for(String rule:ruleStrings){
			rules.put(rule.split("->")[0], rule.split("->")[1]);
		}
		System.out.println(rules.toString());
	}
	
	public String upDate(String state, int cycle){
		state.replaceAll("\\s", "");
		
		String endState="";
		if(testCycle==true && states.contains(state) && states.size()>1){
			System.out.println("Cycle found");
			System.out.println("End state: "+ state);
			System.out.println("recurring state at: " + String.valueOf(states.indexOf(state)));
			System.out.println(states.get(states.indexOf(state)));
			cycleLength=stateCount-states.indexOf(state)-2;
			System.out.println("Cycle length: "+ String.valueOf(cycleLength));
			System.out.println("All states: "+ states.toString());
			return state;
			
		}
		states.add(state);
		if(cycle==1){
			System.out.println("end state: "+ state);
			System.out.println("All states: " + states.toString());
			System.out.println(String.valueOf(stateCount));
			if(testCycle==true){
				System.out.println("No cycles");
			}
			return state;
		}
		else{
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
			System.out.println("State Number "+ stateCount+  ": "+ endState);
			stateCount++;
			upDate(endState,cycle-1);
			return null;
		}			
	}
	
	
	public Hashtable cycleTest(){
		for(int s=0;s<256;s++){
			AutoMata Am= new AutoMata(true);
		}
		return cycleAndStates;
	}
	
	
	
	public Hashtable randomCycleTest(){
		return cycleAndStates;
	}

}
