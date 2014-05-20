package edu.hfu.refmo.impl;

import edu.hfu.refmo.model.OperationCreate;

public class OperationCreateImpl implements OperationCreate {
	
	private Rule rule;

	public OperationCreateImpl(Rule rule) {
		
		this.rule = rule;
	}

	@Override
	public void save() {

	
		@SuppressWarnings("unused")
		edu.hfu.refmo.store.Rule rule= new Transformer().tranfFluentToStoreStructure(this.rule);
		
		System.out.println(this.rule.toString());

		
	}

	private edu.hfu.refmo.store.Rule tranfFluentToStoreStructure(Rule rule2) {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		return rule.toString();
	}

	@Override
	public void to_xml() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void to_json() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

}
