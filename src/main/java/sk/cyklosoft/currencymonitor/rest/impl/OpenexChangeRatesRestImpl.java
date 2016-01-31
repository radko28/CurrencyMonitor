package sk.cyklosoft.currencymonitor.rest.impl;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import sk.cyklosoft.currencymonitor.data.CurrencyResponseData;
import sk.cyklosoft.currencymonitor.rest.OpenexChangeRatesRest;


@Repository("openexChangeRatesRest")
public class OpenexChangeRatesRestImpl implements OpenexChangeRatesRest {
	private final String URL_LATEST = "https://openexchangerates.org/api/latest.json?app_id=";
	private final String URL_HISTORICAL = "https://openexchangerates.org/api/historical/{date}.json?app_id=";
	private final String APP_ID="6c5eda63d1354709a95736309f463429";
	private CurrencyResponseData response = null;
	private RestTemplate restTemplate = null; 

	@Override
	public CurrencyResponseData getHistorical(String date) throws Exception {
		restTemplate = new RestTemplate();
		//response = restTemplate.getForObject(URL_HISTORICAL + APP_ID, CurrencyResponseData.class, date);
		return response;
	}

	@Override
	public CurrencyResponseData getLatest() throws Exception {
		restTemplate= new RestTemplate();
		//response = restTemplate.getForObject(URL_LATEST + APP_ID, CurrencyResponseData.class);
		return response;
	}
	
}
