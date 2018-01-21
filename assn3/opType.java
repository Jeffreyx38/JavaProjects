// opType - just a pre-1.5 pattern for doing enumerations
//
// Kurt Schmidt
// 3/07
//
// EDITOR: tabstop=2, cols=80
//
// javac 1.6.0, on Linux version 2.6.18.6 (gcc version 3.4.6 (Gentoo
//		 3.4.6-r1, ssp-3.4.5-1.0, pie-8.7.9))
//
import java.io.*;


/**
 * change to enums to simplify the problem
 */
public enum opType {

	ADD("Add", "+"),
	SUB("Sub", "-"),
	MULT("Mult", "*"),
	DIV("Div", "/"),
	MOD("Mod", "%"),
	LPAR("LParen", "("),
	RPAR("RParen", ")");

	protected String name;
	protected String operation;


	opType( String n, String operation)
	{

		name = n;
		this.operation = operation;
	}

	/**
	 * this method help us to covert input to optype
	 *
	 * @param input
	 * @return
	 */
	public static opType convertToOpType(String input){
		//if ot equals input then it's a operator
		//if return null then it's a operand
		for (opType ot : opType.values()){
			if (ot.operation.equals(input)){
				return ot;
			}
		}//end for()
		return null;
	}//end opty()
}//end opty()



