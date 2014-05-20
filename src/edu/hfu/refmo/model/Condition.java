package edu.hfu.refmo.model;

public interface Condition {
	  

	// Zusammensetzen von Conditions
    Condition and(Condition condition);
    Condition andNot(Condition condition);
    Condition or(Condition condition);
    Condition orNot(Condition condition);
	void print_condition();
    
  }