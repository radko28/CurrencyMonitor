package sk.cyklosoft.currencymonitor.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "LIVE_EXCHANGE_RATE")
public class LiveExchangeRate implements Serializable {

	private static final long serialVersionUID = -3770916588124310252L;
	
	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", nullable = false, columnDefinition = "varchar(32)")
    private String id;
	
    @Column(name = "created", nullable = false)
    private String created;
    
    @Column(name = "exchange_rate", nullable = false)
    private Double exchangeRate;
    
    
    @Column(name = "currency", nullable = false)
    private String currency;


	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExhangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCreated() {
		return created;
	}


	public void setCreated(String created) {
		this.created = created;
	}

	
}
