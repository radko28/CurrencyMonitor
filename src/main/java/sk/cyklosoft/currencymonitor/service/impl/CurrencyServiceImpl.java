package sk.cyklosoft.currencymonitor.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sk.cyklosoft.currencymonitor.dao.LiveExchangeRateDAO;
import sk.cyklosoft.currencymonitor.data.CurrencyResponseData;
import sk.cyklosoft.currencymonitor.domain.CurrencyCodeType;
import sk.cyklosoft.currencymonitor.domain.LiveExchangeRate;
import sk.cyklosoft.currencymonitor.rest.OpenexChangeRatesRest;
import sk.cyklosoft.currencymonitor.service.CurrencyService;
import sk.cyklosoft.currencymonitor.util.AppHelper;
import sk.cyklosoft.currencymonitor.vo.CurrencyVO;
import sk.cyklosoft.currencymonitor.vo.HistoricalCurrencyVO;

@Service("currencyService")
@Component
public class CurrencyServiceImpl implements CurrencyService {

	private final String USA_CODE= "USA";
	private final String SEPARATOR = System.getProperty("file.separator");
	
	@Autowired
	OpenexChangeRatesRest openexChangeRatesRest;
	@Autowired
	LiveExchangeRateDAO liveExchangeRateDAO;
	
	CurrencyVO currency;
	CurrencyResponseData currencyResponseData;
	
	@Override
	public CurrencyVO getCurrentExchangeRate() {
		currency = readDB();
		if(currency == null) {
			currency = new CurrencyVO();
			try {
				currencyResponseData = openexChangeRatesRest.getLatest();
				Map<String, Double> rates = new LinkedHashMap<String, Double>();
				if(currencyResponseData != null) {
					for(CurrencyCodeType currCode : CurrencyCodeType.values()) {
						rates.put(USA_CODE + SEPARATOR + currCode, currencyResponseData.getRates().get(currCode.name()));
						saveDB(USA_CODE + SEPARATOR + currCode, currencyResponseData.getRates().get(currCode.name()));					
					}
				}
				currency.setRates(rates);
				deleteDB();
			} catch (Exception e) {
				currency.setErrorMessage(e.getMessage());
			}
		}
		return currency;
	}

	@Override
	public CurrencyVO getHistoricalExchangeRate(HistoricalCurrencyVO historicalCurrency) {
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

	private void saveDB(String currency, Double exchangeRate) {
		LiveExchangeRate liveExchangeRate = new LiveExchangeRate();
		liveExchangeRate.setCurrency(currency);
		liveExchangeRate.setExhangeRate(exchangeRate);
		liveExchangeRate.setCreated(AppHelper.liveExaxhangeDate());
		liveExchangeRateDAO.save(liveExchangeRate);
	}
	private void deleteDB() {
		liveExchangeRateDAO.delete(AppHelper.liveExaxhangeDate());
	}

	private CurrencyVO readDB() {
		List<LiveExchangeRate> liveExchangeRateList = liveExchangeRateDAO.getLiveExhangeRateByDate(AppHelper.liveExaxhangeDate());
		Map<String, Double> rates = new LinkedHashMap<String, Double>();
		if(liveExchangeRateList != null && liveExchangeRateList.size() > 0) {
			currency = new CurrencyVO();
			for(LiveExchangeRate liveExchangeRate : liveExchangeRateList) {
				rates.put(liveExchangeRate.getCurrency(), liveExchangeRate.getExchangeRate());					
			}
			currency.setRates(rates);
		}
		return currency;
	}
}
