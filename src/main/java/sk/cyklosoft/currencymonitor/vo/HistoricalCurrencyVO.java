package sk.cyklosoft.currencymonitor.vo;

import java.util.ArrayList;

import javax.validation.constraints.Pattern;



import sk.cyklosoft.currencymonitor.domain.CurrencyCodeType;

public class HistoricalCurrencyVO {
	
	private CurrencyCodeType currCode1;
	private CurrencyCodeType currCode2;
	private CurrencyCodeType currCode3;
	@Pattern(regexp="(19|20)\\d\\d\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])", message = "{validate.user.currdate}")
    private String currDateString;
	
	public CurrencyCodeType getCurrCode1() {
		return currCode1;
	}
	public void setCurrCode1(CurrencyCodeType currCode1) {
		this.currCode1 = currCode1;
	}
	public CurrencyCodeType getCurrCode2() {
		return currCode2;
	}
	public void setCurrCode2(CurrencyCodeType currCode2) {
		this.currCode2 = currCode2;
	}
	public CurrencyCodeType getCurrCode3() {
		return currCode3;
	}
	public void setCurrCode3(CurrencyCodeType currCode3) {
		this.currCode3 = currCode3;
	}
	public String getCurrDateString() {
		return currDateString;
	}
	public void setCurrDateString(String currDateString) {
		this.currDateString = currDateString;
	}
	
	public ArrayList<String> getCurrCodes() {
		ArrayList<String> result = new ArrayList<String>();
		result.add(currCode1.name());
		result.add(currCode2.name());
		result.add(currCode3.name());
		return result;
	}

}
