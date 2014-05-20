package edu.hfu.refmo.impl;

import edu.hfu.refmo.model.Condition;
import edu.hfu.refmo.store.Match;
import edu.hfu.refmo.store.MatchGroup;
import edu.hfu.refmo.store.MatchSingle;

public class Transformer {
	
	public Transformer(){
		
	}

	public  edu.hfu.refmo.store.Rule tranfFluentToStoreStructure(
			edu.hfu.refmo.impl.Rule rule) {

		// new rule
		edu.hfu.refmo.store.Rule new_rule = new edu.hfu.refmo.store.Rule(
				rule.description, "" + rule.effect);

		if (rule.action_target != null) {
			if (rule.action_target.getCondition() != null) {

				new_rule.setAction_target(translate(
						rule.action_target.getCondition(), new_rule));

			}
		}

		if (rule.object_target != null) {
			if (rule.object_target != null) {
				if (rule.object_target.getCondition() != null) {

					new_rule.setObject_target(translate(
							rule.object_target.getCondition(), new_rule));

				}
			}

		}

		if (rule.subject_target != null) {
			if (rule.subject_target != null) {
				if (rule.subject_target.getCondition() != null) {

					new_rule.setSubject_target(translate(
							rule.subject_target.getCondition(), new_rule));

				}
			}

		}

		if (rule.environ_target != null) {
			if (rule.environ_target != null) {
				if (rule.environ_target.getCondition() != null) {

					new_rule.setEnviron_target(translate(
							rule.environ_target.getCondition(), new_rule));

				}
			}

		}

		return new_rule;
	}

	private MatchSingle getMatchSingle(ConditionImpl cond) {

		MatchSingle ms = new MatchSingle();
	
try {
			if (cond.attribute_source != null)
				ms.attributeName = cond.attribute_source.getValue();
			
			if (cond.attribute_compare != null){
				ms.attributeDesignator = cond.attribute_compare.getValue();
				if(((Attibute)cond.attribute_compare).getAttribute_datatype() !=null){
			ms.attributeDesignatorDataType = ((Attibute)cond.attribute_compare).getAttribute_datatype().getClass().getCanonicalName();
				}
				else{
					
					throw new AttributeDelegationException("No Datatype set for designator Attribute " + ms.attributeDesignator);
				  
				
				}
			}
			if (cond.compare_value != null) {
				//System.out.println(cond.compare_value);

				//System.out.println("VALUE: "
				//		+ cond.compare_value.getClass().getSimpleName());
				
				ms.attributeValueDataType = cond.compare_value.getClass().getCanonicalName();
				
				ms.attributeValue = cond.compare_value.toString();
			//	System.out.println("VALUE AFTER CONV: " +ms.attributeValue);
			}

			if (cond.att_function != null){
				ms.function = cond.att_function;
		     	ms.functionType = cond.att_function.nameToString();
		     	ms.functionClass = cond.att_function.getClass().getCanonicalName();
			}
           }
catch (AttributeDelegationException ex){
	
	ex.printStackTrace();
	
}
	
		// new MatchGroup();

		System.out.println(ms.attributeName);
		return ms;

	}

	private  MatchGroup translate(ConditionImpl root_cond,
			edu.hfu.refmo.store.Rule rule) {

		if (root_cond.compare_attribute == true
				&& root_cond.condition_leafs.size() == 0) {
			MatchGroup new_mg = new MatchGroup();
			new_mg.rule = rule;
			new_mg.match_basis = getMatchSingle(root_cond);
			new_mg.match_basis.rule = rule;

			return new_mg;
		} else {
			return transfFluentStructure(root_cond, rule, null);

		}

	}

	private MatchGroup transfFluentStructure(ConditionImpl root_cond,
			edu.hfu.refmo.store.Rule rule, MatchGroup p_parentMG) {

		MatchGroup last_match_group = null;
		// // einzelene Attribute Condition
		// if(root_cond.compare_attribute == true &&
		// root_cond.condition_leafs.size() == 0 ){
		// parent_mg.match_basis = getMatchSingle(root_cond);
		// }
		//
		// else {
		if (root_cond.getRootCondition() != null) {

			// Wenn es sich um ein Elternelement handelt
			if (root_cond.getRootCondition().isrootcondition == true) {

				ConditionImpl current_cond = root_cond.getRootCondition();
				if (current_cond.compare_attribute == true) {

					MatchGroup root_mg = new MatchGroup();
					MatchSingle new_match_single = getMatchSingle(current_cond);
					new_match_single.rule = rule;

					root_mg.rule = rule;
					root_mg.match_basis = new_match_single;

					// zu Beginn immer MatchSingle, da Attributvergleich
					MatchGroup last_match = root_mg;
					System.out.println("lastMG:" + last_match.toString());

					// Number of elements in list
					Integer nr_leaves = current_cond.condition_leafs.size();
					Integer cn_leaves = 0;

					for (ConditionImpl ie : current_cond.condition_leafs) {

						cn_leaves++;

						// MatchGroup Function
						last_match.function = ie.condition_function;
						last_match.functionType = ie.condition_function.nameToString();
						last_match.functionClass = ie.condition_function.getClass().getCanonicalName();

						if (((ConditionImpl) ie.child_condition).isrootcondition) {
							// direktes MatchSingle Element

							last_match.match_comp = getMatchSingle(((ConditionImpl) ie.child_condition));
							last_match.match_comp.rule = rule;
						} else {

							if (((ConditionImpl) ie.child_condition).root_condition != null) {

								last_match.match_comp = transfFluentStructure(
										((ConditionImpl) ie.child_condition),
										rule, last_match);
								last_match.match_comp.rule = rule;

							}

						}
						// wenn nicht letztes element
						if (cn_leaves < nr_leaves) {
							MatchGroup new_mg = new MatchGroup();
							new_mg.rule = rule;
							new_mg.match_basis = last_match;

							// für schleife aktuelle gruppe als übergeordnete
							// gruppe
							last_match = new_mg;
						}
						System.out.println("lastMG:" + last_match.toString());

					}

					last_match_group = last_match;
				}
			}
		}

		// }

		return last_match_group;

	}

}