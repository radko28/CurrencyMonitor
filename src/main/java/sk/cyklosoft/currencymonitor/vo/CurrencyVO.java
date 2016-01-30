package sk.cyklosoft.currencymonitor.vo;

import java.util.LinkedHashMap;
import java.util.Map;

public class CurrencyVO {
	
	private Map<String, Double> rates = new LinkedHashMap<String, Double>();
	private String errorMessage;
	
	public Map<String, Double> getRates() {
		return rates;
	}
	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
