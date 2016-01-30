package sk.cyklosoft.currencymonitor.vo;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import sk.cyklosoft.currencymonitor.domain.Address;
import sk.cyklosoft.currencymonitor.domain.CountryType;
import sk.cyklosoft.currencymonitor.domain.RoleType;
import sk.cyklosoft.currencymonitor.util.AppHelper;

public class UserVO {
	
	private final DateTimeFormatter dtf = DateTimeFormat.forPattern(AppHelper.DATE_FORMAT);
	

    private String userId;
    @Size(min=4, max=32, message = "{validate.user.username}")
    private String username; 
    @Size(min=1, max=15, message = "{validate.user.lastname}")
    private String lastname; 
    @Size(min=1, max=15, message = "{validate.user.firstname}")
    private String firstname;
    private String password; 
    private boolean enabled; 
    private RoleType authority;
    private String role;
    private String oldpassword;
    private String confirm;
    private String enabledValue;
    @Pattern(
            regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            flags = {Pattern.Flag.CASE_INSENSITIVE},
            message = "{validate.user.email}"
    ) 
    private String email;
    @Size(min=2, max=32,message = "{validate.user.city}")
    private String city;
    private CountryType country;
    @Pattern(regexp="(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.(19|20)\\d\\d", message = "{validate.user.birthdate}")
    private String birthdateString;
    @Size(min=2, max=32, message = "{validate.user.street}")
    private String street;
    @Digits( fraction = 0, integer = 10, message = "{validate.user.zip}")
    private String zip;
    
    
    
    public UserVO(String userId, String username, String firstname, String lastname, String password, boolean enabled, 
    		RoleType authority, Address address) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname; 
        this.password= password; 
        setEnabled(enabled);
        setRole(authority.toString());
        this.email = address.getEmail();
        this.city = address.getCity();
        this.country = address.getCountry();
        this.birthdateString = getBirthdateString(address.getBirthdate());
        this.street = address.getStreet();
        this.zip = address.getZip();
        
    }

    
    private String getBirthdateString(DateTime birthdate) {
		return org.joda.time.format.DateTimeFormat.forPattern(AppHelper.DATE_FORMAT).print(birthdate);
	}


	public UserVO() {
    }


    public String getUserId() {
        return userId;
    }

    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getLastname() {
        return lastname;
    }

    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public boolean isEnabled() {
        return enabled;
    }

    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        this.enabledValue = enabled ? "checked" : new String();
    }

    
    public RoleType getAuthorityType() {
        return authority;
    }

    public String getAuthority() {
        return authority.name();
    }

    
    public void setAuthority(RoleType authority) {
        this.authority = authority;
    }


    
    public String getFirstname() {
        return firstname;
    }


    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    
    public String getOldpassword() {
        return oldpassword;
    }


    
    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }


    
    public String getConfirm() {
        return confirm;
    }


    
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role != null && (role.equals("checked") || role.equals(RoleType.ROLE_ADMIN.toString()))) {
            this.role = "checked";
            this.authority = RoleType.ROLE_ADMIN;
        } else {
            this.role = new String();
            this.authority = RoleType.ROLE_USER;
        }
    }


    
    public String getEnabledValue() {
        return enabledValue;
    }


    
    public void setEnabledValue(String enabledValue) {
        this.enabledValue = enabledValue;
        if(enabledValue != null && enabledValue.equals("checked")) {
            this.enabled = true;
        } else {
            this.enabled = false;
        }
    }


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public CountryType getCountry() {
		return country;
	}


	public void setCountry(CountryType country) {
		this.country = country;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public DateTime getBirthdate() {
		return dtf.parseDateTime(birthdateString);
		
	}


	public void setBirthdate(String birthdate) {
	}


	public String getBirthdateString() {
		return birthdateString;
	}


	public void setBirthdateString(String birthdateString) {
		this.birthdateString = birthdateString;
	}


}
