package com.bs.core.parser;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String str = "if ( ''>='2010-05-01'&&''<='2010-10-01'|| 0!=0 ) {1*1*2;}"
					+ "elseif ( '2010-09-21 00:00:00.0'>='2010-05-01'&& '2010-09-21 01:00:00.0'<='2010-09-21'&& 19795.92!=0 ) {19795.92*1*2;} "
					+ "elseif ( ''>='2010-05-01'&& ''<='2010-10-01'&& !=0 ) {*1*2;} "
					+ "elseif ( 0!=0 ) { 0*1;} "
					+ "elseif ( 19795.92!=0 ) { 19795.92*1; } else { 0*1; }";
			ExpressionParser.calculate(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
