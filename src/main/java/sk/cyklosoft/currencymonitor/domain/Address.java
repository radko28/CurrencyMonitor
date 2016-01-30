package sk.cyklosoft.currencymonitor.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    private static final long serialVersionUID = 2646683474075646849L;
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, columnDefinition = "varchar(32)")
    private String id;
    
    @Column(name = "email", nullable = false, columnDefinition = "varchar(32)")
    private String email;
    
    @Column(name = "birthdate", nullable = true)
    @Type(type = "jodaDateTime")
    private DateTime birthdate;
    
    @Column(name = "street", nullable = true, columnDefinition = "varchar(32)")
    private String street;
    
    @Column(name = "zip", nullable = true, columnDefinition = "varchar(10)")
    private String zip;
    
    @Column(name = "city", nullable = true, columnDefinition = "varchar(32)")
    private String city;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "country", nullable = true) 
    private CountryType country;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User users;

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    
    public void setZip(String zip) {
        this.zip = zip;
    }

    
    public String getCity() {
        return city;
    }

    
    public void setCity(String city) {
        this.city = city;
    }

    
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public User getUser() {
		return users;
	}


	public void setUser(User user) {
		this.users = user;
	}


	public CountryType getCountry() {
		return country;
	}


	public void setCountry(CountryType country) {
		this.country = country;
	}


	public DateTime getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(DateTime birthdate) {
		this.birthdate = birthdate;
	}

    

}
