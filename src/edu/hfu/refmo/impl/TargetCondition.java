package edu.hfu.refmo.impl;

import edu.hfu.refmo.model.Effect;
import edu.hfu.refmo.targets.Target;

public interface TargetCondition extends Effect{
	

	Effect setTargetConditionFor(Target...targets);




}
