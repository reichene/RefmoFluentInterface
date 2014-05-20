package edu.hfu.refmo.model;

public interface Function {
	
	boolean check(Field f1, Object o);
	boolean check(Field f1, Field f2);
	String nameToString();

}
