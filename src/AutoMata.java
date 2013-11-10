import java.util.Hashtable;

//Interface for automatonss
public class AutoMata {
	int stateCount=2;
	static Hashtable rules;
	public AutoMata(){
		rules=new Hashtable<String,String>();
	}
	
	void setRule(String... ruleStrings ){
		for(String rule:ruleStrings){
			rules.put(rule.split("->")[0], rule.split("->")[1]);
		}
		System.out.println(rules.toString());
	}
	
	public void upDate(String state, int cycle){
		String endState="";
		if(cycle==1){
			System.out.println("end state: "+ endState);
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
		}
			
	}
	
	public String newNumber(String neighbors){
		String newNum="";
		return newNum;
		
	}

}
