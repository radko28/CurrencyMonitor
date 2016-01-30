package sk.cyklosoft.currencymonitor.rest;

import sk.cyklosoft.currencymonitor.data.CurrencyResponseData;

public interface OpenexChangeRatesRest {
	
	public CurrencyResponseData getHistorical(String date) throws Exception;
	public CurrencyResponseData getLatest() throws Exception;

}
