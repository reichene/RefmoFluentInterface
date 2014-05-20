package edu.hfu.refmo.example;

import java.math.BigDecimal;

import edu.hfu.refmo.impl.Attibute;
import edu.hfu.refmo.impl.Rule;
import edu.hfu.refmo.targets.ActionTarget;
import edu.hfu.refmo.targets.EnvironmentTarget;
import edu.hfu.refmo.targets.ObjectTarget;
import edu.hfu.refmo.targets.SubjectTarget;

public class Try {
	
	public void test_try(){
		
/*
		new Rule().get(1, 2, 3).to_json();
		new Rule().get(1, 2, 3).to_xml();	
		new Rule().get(1, 2, 3).save();
		new Rule().get(1, 2, 3).validate();
		
		new Rule().create("Description", true, false).defineEffect(true).validate();
		new Rule().create("Description", true, false).defineEffect(true).save();
		new Rule().create("Description", true, false);
		
		new Rule().create("Description", true, false)
		.setTargetConditionFor(
				new SubjectTarget().setTerms(
							new Attibute("A").eq("Z")
							.or(new Attibute("B").ne(new Attibute("O")))
							.or(new Attibute("C").lt(9))
					       .and(new Attibute("E").gt(20)
					    		   .or(new Attibute("G").ne(3))
					    		   .or(new Attibute("Z").le("22"))
					    		)
					    	)).defineEffect(true).save();
		
		*/
		new Rule().create("Description", true, false)
			.setTargetConditionFor(
					new SubjectTarget().setTerms(
								new Attibute("A").eq("C")
								.or(new Attibute("B", new String()).ne(new Attibute("O", new String())))
								.or(new Attibute("C").lt(9))
						        .and(new Attibute("E").gt(20)
						    		   .or(new Attibute("G").ne(3))
						    		   .or(new Attibute("Z").le("22"))
						    		)
						        .and(new Attibute("E").gt(20)
						    		   .or(new Attibute("G").ne(3))
						    		   .or(new Attibute("Z").le("22"))
						    		)
						    	),
					new ObjectTarget().setTerms(
								new Attibute("A").eq("Z")
								.or(new Attibute("B").ne(new Attibute("O",  new Integer(0))))
								.or(new Attibute("C").lt(9))
						        .and(new Attibute("E").gt(20)
						    		   .or(new Attibute("G").ne(3))
						    		   .or(new Attibute("Z").le("22"))
						    		)
					    		),
					new EnvironmentTarget().setTerms(
								new Attibute("A").eq("Z")
								.or(new Attibute("B").ne(new Attibute("O", new Long(0))))
								.or(new Attibute("C").lt(9))
								),
					new ActionTarget().setTerms(
								new Attibute("A").eq("Z")
								.or(new Attibute("B").ne(new Attibute("O", new BigDecimal(1))))
								.or(new Attibute("C").lt(9))
								)				
					)
			.defineEffect(true)
			.save();
		
	}
	
	public static void main(String args[]){
		
		new Try().test_try();
	}

}
