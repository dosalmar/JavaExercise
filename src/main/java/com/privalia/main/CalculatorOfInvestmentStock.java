package com.privalia.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import model.DataRow;
import model.HistoricalStockRow;


@Getter
@Setter

public class CalculatorOfInvestmentStock {

	private BigDecimal brokerComission;
	private List<DataRow> historicalStocks;
	private BigDecimal monthlyInvestment;
	private static BigDecimal investmentWOcomision;

	
	public CalculatorOfInvestmentStock(BigDecimal brokerComission, BigDecimal monthlyInvestment, 
			List<DataRow> historicalStocks) {
		this.brokerComission = brokerComission;
		this.historicalStocks =  historicalStocks;
		this.monthlyInvestment = monthlyInvestment;
		this.investmentWOcomision = substractBrokerComision(this.monthlyInvestment, this.brokerComission);
		
	}


	public BigDecimal getResultingProfit() {

		Calendar lastDate = ((HistoricalStockRow) this.historicalStocks.get(this.historicalStocks.size()-1)).getDate();
		BigDecimal priceToSell = ((HistoricalStockRow) this.historicalStocks.get(this.historicalStocks.size()-1)).getClosingPrice();


		//BigDecimal invesmentWOcomision = substractBrokerComision(this.monthlyInvestment, this.brokerComission);
		BigDecimal totalStockQuantity = getTotalStock();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
		
		BigDecimal profit = totalStockQuantity.multiply(priceToSell);

		System.out.println("Selling price on "+ formatter.format(lastDate.getTime()) + ": " + priceToSell);
		System.out.println("Total stocks: "+ totalStockQuantity);
		System.out.println("------------------------------------------------");
		return profit.setScale(3, RoundingMode.HALF_DOWN);
	}
	
	public BigDecimal getTotalStock() {

		boolean isBuyingDayFound = false;
		BigDecimal totalStockQuantity = new BigDecimal(0);
		Calendar searchingMonth = ((HistoricalStockRow) this.historicalStocks.get(0)).getDate();
		
		System.out.println(searchingMonth.getTime());
		Integer numBuying = 0;
		
		Iterator<DataRow> i = this.historicalStocks.iterator();
		
		while(i.hasNext()) {	
			HistoricalStockRow tmp = (HistoricalStockRow) i.next();
			System.out.println("Actual day: " + tmp);
			Calendar buyDate = getBuyingDay(searchingMonth);
			System.out.println("Buy day : " + buyDate.getTime());
			
			
			
				//if(!isBuyingDayFound) {		
					if(tmp.isBuyingDayOrAfter(buyDate)) {
						BigDecimal priceToBuy = tmp.getOpeningPrice();
						//isBuyingDayFound = true;
						System.out.println("Buying day: " + tmp);
						BigDecimal monthStockQuantity = getStockQuantityToBuy(priceToBuy);
						numBuying ++;
						searchingMonth.add(Calendar.MONTH, 1);
						System.out.println("Buyed Stocks: " + monthStockQuantity.toString());
						totalStockQuantity = totalStockQuantity.add(monthStockQuantity);
						System.out.println("------------------------------------------------");
					}
				//}else {
					//isBuyingDayFound = false;
			//}
		}
		
		System.out.println("Number of buying days: " + numBuying);
		
		return totalStockQuantity;
	}
	
	public static BigDecimal getStockQuantityToBuy( BigDecimal price) {	
		BigDecimal t = investmentWOcomision.divide(price, 3, RoundingMode.HALF_DOWN);
		return t;
	}
	
	
	public static BigDecimal substractBrokerComision(BigDecimal monthlyInvestment, BigDecimal brokerComission) {
		BigDecimal subt = monthlyInvestment.multiply(brokerComission).divide(new BigDecimal (100));
		
		return monthlyInvestment.subtract(subt) ;
	}
	
	public static Calendar getBuyingDay(Calendar cal) {
		Calendar lastThursday = getLastThursdayOfMonth(cal);
		lastThursday.add(Calendar.DATE, 1);
		
		return lastThursday;
	}
	
	
	public static Calendar getLastThursdayOfMonth(Calendar cal) {		
		Calendar gregCal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		
		gregCal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		gregCal.set(Calendar.DAY_OF_WEEK_IN_MONTH, -1);
		
		return gregCal;	
	}

}
