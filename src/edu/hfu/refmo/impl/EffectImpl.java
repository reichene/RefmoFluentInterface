package edu.hfu.refmo.impl;

import edu.hfu.refmo.model.Effect;
import edu.hfu.refmo.model.OperationCreate;

public class EffectImpl implements Effect {
	
	private Rule rule;

	public EffectImpl(Rule rule) {
		
		this.rule = rule;
	}

	@Override
	public OperationCreate defineEffect(boolean i) {

		return new OperationCreateImpl(this.rule);
	}

}
