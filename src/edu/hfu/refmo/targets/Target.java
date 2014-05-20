package edu.hfu.refmo.targets;

import edu.hfu.refmo.impl.ConditionImpl;
import edu.hfu.refmo.model.Condition;

public class Target {
	
	
	private Condition root_condition;

	public Target() {
		
		
	}

	
	public Target setTerms(Condition condition) {	
		
		this.root_condition = condition;
		return this;
	}
	
	public ConditionImpl getCondition(){
		return (ConditionImpl) this.root_condition;
		
		
	}




}
