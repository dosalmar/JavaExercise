package model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Getter
@Setter

public class HistoricalStockRow extends DataRow{

	private Calendar date;
	private BigDecimal closingPrice;
	private BigDecimal openingPrice;
	
	
	public HistoricalStockRow(Calendar cal, BigDecimal x, BigDecimal y){
		if(cal.equals(null)) {	
			cal = (Calendar) Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
		}
		this.date = cal;
		this.closingPrice = x;
		this.openingPrice = y;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
		
		String s = formatter.format(this.date.getTime()) + " OpeningPrice: " + this.getOpeningPrice() ;
		
		return s;
	}



	public boolean isSameMonth(Calendar month) {	
		Integer dateRow = this.getDate().get(Calendar.MONTH);
		Integer dateTmp= month.get(Calendar.MONTH);
			
		return dateRow == dateTmp;
	}


	public boolean isBuyingDayOrAfter(Calendar buyDate) {
		boolean isBuyingDate = this.date.equals(buyDate);
		boolean isAfterBuyingDate = this.date.after(buyDate);
		
		return (isBuyingDate || isAfterBuyingDate);
	}
	
	public int compare(Object obj1, Object obj2) {
	       Calendar p1 = ((HistoricalStockRow) obj1).getDate();
	       Calendar p2 = ((HistoricalStockRow) obj2).getDate();

	       if (p1.after(p2)) {
	           return 1;
	       } else if (p1.before(p2)){
	           return -1;
	       } else {
	           return 0;
	       }
	    }
	
}