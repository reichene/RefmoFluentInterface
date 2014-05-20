package edu.hfu.refmo.impl;

import java.util.ArrayList;
import java.util.List;

import edu.hfu.refmo.logfunction.AndImpl;
import edu.hfu.refmo.logfunction.AndNotImpl;
import edu.hfu.refmo.logfunction.OrImpl;
import edu.hfu.refmo.logfunction.OrNot;
import edu.hfu.refmo.model.Condition;
import edu.hfu.refmo.model.Field;
import edu.hfu.refmo.model.Function;
import edu.hfu.refmo.model.FunctionLog;

public class ConditionImpl implements Condition {

	
	public Field attribute_source; 
	public Field attribute_compare;
	public Object compare_value;
	public Function att_function;
	
	public ConditionImpl root_condition;
	
	public FunctionLog condition_function;
	public List<ConditionImpl>condition_leafs = new ArrayList<ConditionImpl>();
	public Condition parent_condition;
	public Condition condition_compare;
	public boolean isConditionGroup;
	public boolean isrootcondition = false;
	public Condition child_condition;
	public boolean compare_attribute = false;
	
	public ConditionImpl(Field attribute, Function function, Object obj) {

		this.attribute_source = attribute;
		this.att_function = function;
		this.compare_value = obj;
		
		
		this.isrootcondition  = true;
		this.compare_attribute = true;
		this.root_condition = this;
		this.isConditionGroup = false;
		
	}
	
	public ConditionImpl(Field attribute, Function function, Field field) {

		this.attribute_source = attribute;
		this.att_function = function;
		this.attribute_compare = field;
		
		this.isrootcondition  = true;
		this.compare_attribute = true;
		this.root_condition = this;
		this.isConditionGroup = false;
		
	}

	public ConditionImpl(ConditionImpl root_condition2,
			Condition parentImpl, FunctionLog functionImpl, Condition condition_compare) {
	this.root_condition = root_condition2;
	
	// parentCondition.function(condition_compare);
	this.parent_condition = parentImpl;
	this.condition_function = functionImpl; 
	this.child_condition = condition_compare;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Condition and(Condition condition) {
		
		
		
		ConditionImpl coimp = new ConditionImpl(this.root_condition, this, new AndImpl(), condition);
		coimp.setConditionGroup(true);
		
//		this.condition_function = new AndImpl();
//		this.condition_compare = condition;
		this.root_condition.condition_leafs.add(coimp);
		return coimp;
	}

	public void setConditionGroup(boolean b) {
	
			this.isConditionGroup = b;
		
	}

	@Override
	public Condition andNot(Condition condition) {
		ConditionImpl coimp = new ConditionImpl(this.root_condition, this, new AndNotImpl(), condition);
		coimp.setConditionGroup(true);
		
//		this.condition_function = new AndNotImpl();
//		this.condition_compare = condition;
		this.root_condition.condition_leafs.add(coimp);
		return coimp;
	}

	@Override
	public Condition or(Condition condition) {
		ConditionImpl coimp = new ConditionImpl(this.root_condition, this, new OrImpl(), condition);
		coimp.setConditionGroup(true);
		
	/*	this.condition_function = new OrImpl();
		this.condition_compare = condition;
	*/	this.root_condition.condition_leafs.add(coimp);
		return coimp;
	}

	@Override
	public Condition orNot(Condition condition) {
		ConditionImpl coimp = new ConditionImpl(this.root_condition, this, new OrNot(), condition);
		coimp.setConditionGroup(true);
		
//		this.condition_function = new OrNot();
//		this.condition_compare = condition;
		this.root_condition.condition_leafs.add(coimp);
		return coimp;
	}

	public ConditionImpl getRootCondition(){
		
		return this.root_condition;
	}
	@Override
	public void print_condition() {
	

	}
}
