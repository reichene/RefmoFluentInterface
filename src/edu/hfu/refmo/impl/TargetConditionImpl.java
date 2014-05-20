package edu.hfu.refmo.impl;

import edu.hfu.refmo.model.Effect;
import edu.hfu.refmo.model.OperationCreate;
import edu.hfu.refmo.targets.ActionTarget;
import edu.hfu.refmo.targets.EnvironmentTarget;
import edu.hfu.refmo.targets.ObjectTarget;
import edu.hfu.refmo.targets.SubjectTarget;
import edu.hfu.refmo.targets.Target;

public class TargetConditionImpl implements TargetCondition {

	private Rule rule;

	public TargetConditionImpl(Rule rule2) {

		this.rule = rule2;
	}

	@Override
	public OperationCreate defineEffect(boolean i) {
		
		this.rule.setEffect(i);
		
		return new OperationCreateImpl(this.rule);
	}

	@Override
	public Effect setTargetConditionFor(Target... targets) {
		
		System.out.println("hellos");
		
		for (Target target : targets) {
			
			if(target instanceof ActionTarget ){ 
				this.rule.action_target = target;
			}
			else if(target instanceof ObjectTarget ) {
				this.rule.object_target = target;
			}
			else if(target instanceof SubjectTarget ) {
				this.rule.subject_target = target;
			}
			else if(target instanceof EnvironmentTarget ) {
				this.rule.environ_target = target;
			}
		}

		return new EffectImpl(this.rule);
	}

}
