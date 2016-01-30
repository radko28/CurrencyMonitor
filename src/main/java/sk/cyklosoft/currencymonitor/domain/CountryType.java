package sk.cyklosoft.currencymonitor.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public enum CountryType {

	AUSTRIA("Austria"),
	GERMANY("Germany"),
	NORWAY("Norway"),
    SLOVAKIA("Slovakia");

    private String value;
    
    CountryType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public static Map<CountryType, String> getCountryTypeMap() {
        Map<CountryType, String> countryTypeMap = new LinkedHashMap<CountryType, String>();
        for(CountryType type:CountryType.values()) {
        	countryTypeMap.put(type, type.getValue());
        }
        return countryTypeMap;
    }
}

