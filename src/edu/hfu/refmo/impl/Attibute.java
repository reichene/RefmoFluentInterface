package edu.hfu.refmo.impl;

import edu.hfu.refmo.function.EqualImpl;
import edu.hfu.refmo.function.GreaterEqual;
import edu.hfu.refmo.function.GreaterThan;
import edu.hfu.refmo.function.LargerEqual;
import edu.hfu.refmo.function.LargerThan;
import edu.hfu.refmo.function.NeEqualImpl;
import edu.hfu.refmo.model.Condition;
import edu.hfu.refmo.model.Field;

public class Attibute implements Field {
	
	private String attribute_id;
	private Object attribute_datatype;

	public Attibute(String attribute_id) {
		this.attribute_id = attribute_id;

	}

	public Attibute(String  attribute_id, Object datatype) {

		this.attribute_id = attribute_id;
		this.attribute_datatype = datatype;
	}

	public Object getAttribute_datatype() {
		return attribute_datatype;
	}

	public void setAttribute_datatype(Object attribute_datatype) {
		this.attribute_datatype = attribute_datatype;
	}

	@Override
	public Condition eq(Field field) {
		return new ConditionImpl(this, new EqualImpl(), field);
	}

	@Override
	public Condition eq(Object value) {
		return new ConditionImpl(this, new EqualImpl(), value);

	}

	@Override
	public Condition ne(Field field) {
		return new ConditionImpl(this, new NeEqualImpl(), field);
	}

	@Override
	public Condition ne(Object value) {
		return new ConditionImpl(this, new NeEqualImpl(), value);
	}

	@Override
	public Condition ge(Field field) {
		return new ConditionImpl(this, new GreaterEqual(), field);

	}

	@Override
	public Condition ge(Object value) {
		return new ConditionImpl(this, new GreaterEqual(), value);
	}

	@Override
	public Condition gt(Field field) {
		return new ConditionImpl(this, new GreaterThan(), field);
	}

	@Override
	public Condition gt(Object value) {
		return new ConditionImpl(this, new GreaterThan(), value);
	}

	@Override
	public Condition le(Field field) {
		return new ConditionImpl(this, new LargerEqual(), field);
	}

	@Override
	public Condition le(Object value) {
		return new ConditionImpl(this, new LargerEqual(), value);
	}

	@Override
	public Condition lt(Field field) {
		return new ConditionImpl(this, new LargerThan(), field);
	}

	@Override
	public Condition lt(Object value) {
		return new ConditionImpl(this, new LargerThan(), value);
	}

	@Override
	public String getValue() {
		return attribute_id;


		
	}



}
