package sk.cyklosoft.currencymonitor.dao;

import java.util.List;

import sk.cyklosoft.currencymonitor.domain.LiveExchangeRate;

public interface LiveExchangeRateDAO {

	public List<LiveExchangeRate> getLiveExhangeRateByDate(String currDate);

	public void save(LiveExchangeRate liveExchangeRate);

	public void delete(String currDate);

}
