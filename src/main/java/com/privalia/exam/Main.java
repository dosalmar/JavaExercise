package com.privalia.exam;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		

		
		Calendar from = new GregorianCalendar(2017, 0, 0);
		Calendar to = new GregorianCalendar(2017, 11, 0);

		
	}

	
	//Coger BigDecimals para no tener problema de float!!!
	
	
	
	
	
	
	public ArrayList<Calendar> getThursdaysFromTo(Calendar from, Calendar to){
		//ToDo: buscar todos los dias que hace falta hacer el calculo. 
		
		
		ArrayList<Calendar> allThursdays = null;
	
		return allThursdays;
	}
	
	
	public Calendar getLastThursday(int year, int month, int day) {
		Calendar cal = new GregorianCalendar(year, month, day);
		
		cal.set(GregorianCalendar.DAY_OF_WEEK, Calendar.THURSDAY);
		cal.set(GregorianCalendar.DAY_OF_WEEK_IN_MONTH, -1);
		
		return cal;	
	}
	
}
