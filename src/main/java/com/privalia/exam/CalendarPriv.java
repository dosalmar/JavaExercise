package com.privalia.exam;

import java.util.Calendar;
import java.util.GregorianCalendar;



public class CalendarPriv extends Calendar{
	
	private Calendar getLastThursdayOfMonth(GregorianCalendar cal) {		
		Calendar gregCal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		
		gregCal.set(GregorianCalendar.DAY_OF_WEEK, Calendar.THURSDAY);
		gregCal.set(GregorianCalendar.DAY_OF_WEEK_IN_MONTH, -1);
		
		return cal;	
	}
	
	
	@Override
	public String toString() {
		String s = "a";
				
		return s;
	}


	@Override
	protected void computeTime() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void computeFields() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void add(int field, int amount) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void roll(int field, boolean up) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getGreatestMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getLeastMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}
}
