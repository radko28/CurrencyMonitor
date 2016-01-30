package sk.cyklosoft.currencymonitor.service.impl;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sk.cyklosoft.currencymonitor.data.CurrencyResponseData;
import sk.cyklosoft.currencymonitor.domain.CurrencyCodeType;
import sk.cyklosoft.currencymonitor.rest.OpenexChangeRatesRest;
import sk.cyklosoft.currencymonitor.service.CurrencyService;
import sk.cyklosoft.currencymonitor.vo.CurrencyVO;
import sk.cyklosoft.currencymonitor.vo.HistoricalCurrencyVO;

@Service("currencyService")
@Component
public class CurrencyServiceImpl implements CurrencyService {
	
	private final String USA_CODE= "USA";
	private final String SEPARATOR = System.getProperty("file.separator");
	
	
	@Autowired
	OpenexChangeRatesRest openexChangeRatesRest;
	
	CurrencyVO currency;
	CurrencyResponseData currencyResponseData;
	
	@Override
	public CurrencyVO getCurrentExchangeRate() {
		currency = new CurrencyVO();
		try {
			currencyResponseData = openexChangeRatesRest.getLatest();
			Map<String, Double> rates = new LinkedHashMap<String, Double>();
			if(currencyResponseData != null) {
				for(CurrencyCodeType currCode : CurrencyCodeType.values()) {
					rates.put(USA_CODE + SEPARATOR + currCode, currencyResponseData.getRates().get(currCode.name()));					
				}
			}
			currency.setRates(rates);
		} catch (Exception e) {
			currency.setErrorMessage(e.getMessage());
		}
		return currency;
	}

	@Override
	public CurrencyVO getHistorycalExchangeRate(HistoricalCurrencyVO historicalCurrency) {
		currency = new CurrencyVO();
		try {
			currencyResponseData = openexChangeRatesRest.getHistorical(historicalCurrency.getCurrDateString());

			Map<String, Double> rates = new LinkedHashMap<String, Double>();
			if(currencyResponseData != null) {
				for(String currCode : historicalCurrency.getCurrCodes()) {
					rates.put(USA_CODE + SEPARATOR + currCode, currencyResponseData.getRates().get(currCode));
				}
			}
			currency.setRates(rates);
		} catch (Exception e) {
			currency.setErrorMessage(e.getMessage());			
		}
		
		return currency;
	}

}
