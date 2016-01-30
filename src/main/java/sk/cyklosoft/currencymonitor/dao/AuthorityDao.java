package sk.cyklosoft.currencymonitor.dao;

import sk.cyklosoft.currencymonitor.domain.Authority;


public interface AuthorityDao {
    
    public void remove(Authority authority);

    public void save(Authority authority);

    public void update(Authority authority);

}
