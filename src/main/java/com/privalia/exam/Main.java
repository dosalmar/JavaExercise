package com.privalia.exam;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {

		
		Calendar cal = new GregorianCalendar(2018, 4, 0);
		cal.setLenient(true);
		
		
		cal.set(GregorianCalendar.DAY_OF_WEEK, Calendar.THURSDAY);
		cal.set(GregorianCalendar.DAY_OF_WEEK_IN_MONTH, -1);
		
		
		System.out.println("Last thursday: " + cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println("Next day after last Thursday: " + cal.getTime());
		
		
		
	}

	
	//Coger BigDecimals para no tener problema de float!!!
}
