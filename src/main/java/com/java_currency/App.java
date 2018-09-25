package com.java_currency;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;

import org.apache.log4j.Logger;
import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

/**
 * Hello world!
 *
 */
public class App {
	static final Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		// logs a debug message
		if (logger.isDebugEnabled()) {
			logger.debug("This is debug");
		}

		CurrencyUnit mxn = Monetary.getCurrency("MXN");
		MonetaryAmount fstAmtMXN = Monetary.getDefaultAmountFactory().setCurrency(mxn).setNumber(150).create();
		Money moneyof = Money.of(100, mxn);
		FastMoney fastmoneyof = FastMoney.of(10, mxn);
		logger.info(mxn);
		logger.info(fstAmtMXN);
		logger.info(moneyof);
		logger.info(fastmoneyof);
		
		MonetaryAmount oneDollar = Monetary.getDefaultAmountFactory().setCurrency("USD").setNumber(20).create();
		CurrencyConversion conversionMXN = MonetaryConversions.getConversion("MXN");
		MonetaryAmount convertedAmountUSDtoMXN = oneDollar.with(conversionMXN);
		logger.info("USD 20 " + oneDollar.toString());
		logger.info(convertedAmountUSDtoMXN);

	}
}