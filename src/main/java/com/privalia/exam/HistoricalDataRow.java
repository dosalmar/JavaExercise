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
public class HistoricalDataRow {

	public Calendar date;
	public BigDecimal cierre;
	public BigDecimal apertura;
	
	
	public HistoricalDataRow(Calendar cal, BigDecimal x, BigDecimal y){
		if(cal.equals(null)) {	
			cal = (CalendarPriv) Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
		}
		this.date = cal;
		this.cierre = x;
		this.apertura = y;
	}
	


	public boolean isLastThursdayOfMonthOrAfter() {
		Calendar lastThursdayOfMonth = this.getLastThursdayOfMonth(this.date);
		
		Boolean isLastThursdayOfMonth= this.date.equals(lastThursdayOfMonth);
		Boolean isAfterLastThursdayOfMonth = this.date.after(lastThursdayOfMonth);
		Boolean isLastThursdayOfMonthOrAfter = false;
		
		if (isLastThursdayOfMonth || isAfterLastThursdayOfMonth){
			isLastThursdayOfMonthOrAfter = true;
		}
		
		return isLastThursdayOfMonthOrAfter;
	}

	
	private Calendar getLastThursdayOfMonth(Calendar cal) {		
		Calendar gregCal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		
		gregCal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		gregCal.set(Calendar.DAY_OF_WEEK_IN_MONTH, -1);
		
		return gregCal;	
	}
	
	
	@Override
	public String toString() {
		Date dateFormated = this.date.getTime(); 
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");    

		String s = format1.format(dateFormated);
		//String s = "Fecha: "+ format1.format(dateFormated) + "\nCierre: " + cierre + "\nApertura: " + apertura;
		return s;
	}



	public boolean isSameMonth(Calendar month) {	
		Integer dateRow = this.getDate().get(Calendar.MONTH);
		Integer dateTmp= month.get(Calendar.MONTH);
			
		//System.out.println("*********************");
		//System.out.println(this.getDate().getTime().toString());
		//System.out.println("Mes de la row: "+ dateRow);
		//System.out.println("Mes bucle: "+ dateTmp );
		//System.out.println("*********************");
		
		return dateRow == dateTmp;
	}





}
