package edu.hfu.refmo.model;

public interface Field {

	    // Erstellen von Conditions
	    Condition eq(Field field);
	    Condition eq(Object value);
	    Condition ne(Field field);
	    Condition ne(Object value);
	    Condition ge(Field field);
	    Condition ge(Object value);
	    Condition gt(Field field);
	    Condition gt(Object value);
	    Condition le(Field field);
	    Condition le(Object value);
	    Condition lt(Field field);
	    Condition lt(Object value);
		String getValue();



	}