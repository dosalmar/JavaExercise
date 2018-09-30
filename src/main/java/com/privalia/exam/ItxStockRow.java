package com.privalia.exam;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.function.Function;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ItxStockRow {

	public Calendar date;
	public BigDecimal cierre;
	public BigDecimal apertura;
	
	
	public ItxStockRow(Calendar cal, BigDecimal x, BigDecimal y){
		if(cal.equals(null)) {	
			cal = (CalendarPriv) Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
		}
		this.date = cal;
		this.cierre = x;
		this.apertura = y;
	}
	
	
	
	public boolean isLastThursdayOfMonth() {
		 Boolean isLastThursdayOfMonth = this.date.equals(this.getLastThursdayOfMonth(this.date));
		
		return isLastThursdayOfMonth;
	}

	
	private Calendar getLastThursdayOfMonth(Calendar cal) {		
		Calendar gregCal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		
		
		gregCal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		gregCal.set(Calendar.DAY_OF_WEEK_IN_MONTH, -1);
		
		return gregCal;	
	}
	
	
	@Override
	public String toString() {
		Date dateFormated = date.getTime(); 
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");    

		String s = "Fecha: "+ format1.format(dateFormated);
		//String s = "Fecha: "+ format1.format(dateFormated) + "\nCierre: " + cierre + "\nApertura: " + apertura;
		return s;
	}







}
