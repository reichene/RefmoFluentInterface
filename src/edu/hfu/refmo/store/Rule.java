package edu.hfu.refmo.store;

import java.util.ArrayList;


public class Rule {
	
	private Integer idRule;
	private String effect;
	private String description;
	
    private MatchGroup subject_target;
    public Integer getIdRule() {
		return idRule;
	}




	public void setIdRule(Integer idRule) {
		this.idRule = idRule;
	}




	public String getEffect() {
		return effect;
	}




	public void setEffect(String effect) {
		this.effect = effect;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public MatchGroup getSubject_target() {
		return subject_target;
	}




	public void setSubject_target(MatchGroup subject_target) {
		this.subject_target = subject_target;
	}




	public MatchGroup getAction_target() {
		return action_target;
	}




	public void setAction_target(MatchGroup action_target) {
		this.action_target = action_target;
	}




	public MatchGroup getObject_target() {
		return object_target;
	}




	public void setObject_target(MatchGroup object_target) {
		this.object_target = object_target;
	}




	public MatchGroup getEnviron_target() {
		return environ_target;
	}




	public void setEnviron_target(MatchGroup environ_target) {
		this.environ_target = environ_target;
	}
	private MatchGroup action_target;
    private MatchGroup object_target;
    private MatchGroup environ_target;

	
	public Rule() {
		
		
	}
	
	

	
	 public Rule( String description, String effect) {
		// TODO Auto-generated constructor stub
		 
		
		 this.description = description;
		 this.effect = effect;
	
	}
	 public Rule(Integer idRule, String description, String effect) {
		// TODO Auto-generated constructor stub
		 
		 this.idRule = idRule;
		 this.description = description;
		 this.effect = effect;
	
	}
	public Rule(Integer idRule, String effect) {

		this.effect = effect;
		this.idRule = idRule;
		
	}

	
	
	

}
