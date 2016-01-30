package sk.cyklosoft.currencymonitor.data;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * {
    "disclaimer": "https://openexchangerates.org/terms/",
    "license": "https://openexchangerates.org/license/",
    "timestamp": 982342800,
    "base": "USD",
    "rates": {
        "AED": 3.67246,
        "ALL": 144.529793,
        "ANG": 1.79,
        ...
    }
}
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponseData {
	
	private String disclaimer;
	private String license;
	private long timestamp;
	private String base;
	private Map<String, Double> rates;
	
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Map<String, Double> getRates() {
		return rates;
	}
	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

}
