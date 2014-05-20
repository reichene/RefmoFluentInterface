package edu.hfu.refmo.impl;

import edu.hfu.refmo.model.OperationGet;
import edu.hfu.refmo.targets.SubjectTarget;
import edu.hfu.refmo.targets.Target;

public class Rule {
	
	public  Target action_target;
	public boolean returnPolicyId = false;
	public boolean returnCombinedDecision = false;
	public boolean effect;
	public Target environ_target;
	public  Target subject_target;
	public  Target object_target;
	public String description;

	private  final OperationGet get(long...i) {
		
		return new OperationGetImpl(this, i);
	}


	
	public final TargetCondition create(String description, boolean rpid, boolean rcd) {
		
		this.description = description;
		this.returnCombinedDecision = rcd;
		this.returnPolicyId = rpid;
	
		return new TargetConditionImpl(this);
	}



	public boolean isEffect() {
		return effect;
	}



	public void setEffect(boolean effect) {
		this.effect = effect;
	}



	public void printConditions() {
		
//		System.out.println(this.effect + " - " + this.returnCombinedDecision  + " - " + this.returnPolicyId);
//		try{
//		this.action_target.print_hierarchy();
//		this.subject_target.print_hierarchy();
//		this.object_target.print_hierarchy();
//		this.environ_target.print_hierarchy();
//		}
//		catch(Exception e){
//			
//		//	e.printStackTrace();
//		}
		
	}



	public Target getSubjectTarget() {
		return this.subject_target;
		// TODO Auto-generated method stub
		
	}
	
	public Target getObjectTarget() {
		return this.object_target;
		// TODO Auto-generated method stub
		
	}
	
	public Target getEnviTarget() {
		return this.environ_target;
		// TODO Auto-generated method stub
		
	}
	
	public Target getActionTarget() {
		return this.action_target;
		// TODO Auto-generated method stub
		
	}

}
