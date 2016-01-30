package sk.cyklosoft.currencymonitor.dao;

import sk.cyklosoft.currencymonitor.domain.User;


public interface UserDao {
    
    public User findUserById(String userId);

    public void save(User user);

    public User findUserByUsername(String username);

}
