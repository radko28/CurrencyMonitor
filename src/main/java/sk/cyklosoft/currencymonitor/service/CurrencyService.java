package sk.cyklosoft.currencymonitor.service;

import sk.cyklosoft.currencymonitor.vo.CurrencyVO;
import sk.cyklosoft.currencymonitor.vo.HistoricalCurrencyVO;

public interface CurrencyService {
	
	public CurrencyVO getCurrentExchangeRate();
	public CurrencyVO getHistorycalExchangeRate(HistoricalCurrencyVO historicalCurrency);

}
