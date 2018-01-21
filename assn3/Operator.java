// Operator.java - operator token (+ - * / ( ) %)
//
// Kurt Schmidt
// 3/07
//
// javac 1.6.0, on Linux version 2.6.18.6 (gcc version 3.4.6 (Gentoo
//		 3.4.6-r1, ssp-3.4.5-1.0, pie-8.7.9))
//
// EDITOR:  tabstop=2, cols=80
//
// NOTES:
// 	Tokens come in 2 flavors:
// 		operands (only integers here)
// 		operators (just +, -, *, /, %, parenthesis)
// 
//	This is so you can have a single container (Vector, ArrayList, whatever)
//	that holds an entire expression (Token).
//

public class Operator extends Token {

	protected opType val;


	public boolean isOperator() { return true; }
	public boolean isOperand() { return false; }

	/**
	 *
	 * helper method, returns (assigns) precedence for operators
	 * @param tk
	 * @return
	 */
	protected int getPrec(String tk)
	{

		switch (tk){
			case "+":
			case "-":
				return 1;
			case "*":
			case "/":
				return 2;
		}
		return -1;
	}


	public opType getVal() { return val; }

	public Operator( opType v ) { val = v; }

	@Override
	public String toString() {
		return val.operation;
	}
}	// class Operator

