package edu.hfu.refmo.logfunction;

import edu.hfu.refmo.model.Condition;
import edu.hfu.refmo.model.FunctionLog;


public class AndImpl implements FunctionLog {

	@Override
	public boolean check(Condition c1, Condition c2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String nameToString() {
		// TODO Auto-generated method stub
		return "AND";
	}

}
