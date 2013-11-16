import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

//Interface for automatonss
public class AutoMata {
	int stateCount=2;
	static Hashtable<String, String> rules;
	boolean testCycle; //whether to test cycles
	List<String> states;
	String initialState;
	public AutoMata(boolean cycle){
		rules=new Hashtable<String,String>();
		states= new ArrayList<String>();
		testCycle=cycle;
	}
	
	void setState(String state){
		initialState=""+state;
		System.out.println("State number 1: "+ initialState);
		states.add(initialState);
	}
	void setRule(String... ruleStrings ){
		for(String rule:ruleStrings){
			rules.put(rule.split("->")[0], rule.split("->")[1]);
		}
		System.out.println(rules.toString());
	}
	
	public void upDate(String state, int cycle){
		state.replaceAll("\\s", "");
		
		String endState="";
		if(testCycle==true && states.indexOf(endState)!=-1){
			System.out.println("Cycle found");
			System.out.println("");
		}
		else if(cycle==1){
			System.out.println("end state: "+ state);
			System.out.println("All states: " + states.toString());
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
			states.add(endState);
			stateCount++;
			upDate(endState,cycle-1);
		}
			
	}
	

}
