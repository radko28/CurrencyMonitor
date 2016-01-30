package sk.cyklosoft.currencymonitor.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sk.cyklosoft.currencymonitor.dao.AddressDao;
import sk.cyklosoft.currencymonitor.dao.AuthorityDao;
import sk.cyklosoft.currencymonitor.dao.UserDao;
import sk.cyklosoft.currencymonitor.domain.Address;
import sk.cyklosoft.currencymonitor.domain.Authority;
import sk.cyklosoft.currencymonitor.domain.User;
import sk.cyklosoft.currencymonitor.service.UserService;
import sk.cyklosoft.currencymonitor.vo.UserVO;

@Service("userService")
@Component
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDao userDao;
    @Autowired
    AuthorityDao authorityDao;
    @Autowired
    AddressDao addressDao;

    @Override
    public String getWholeNameByUsername(String username) {
        User user = userDao.findUserByUsername(username); 
        String wholeName = user.getFirstname() + " " + user.getLastname();
        return wholeName;
    }

    @Override
    public UserVO getUserById(String userId) {
        User user = userDao.findUserById(userId);
        UserVO result = user.copy();
        return result;
    }

    @Override
    public void addUser(UserVO userVO) {
        User user = new User();
        user.setFirstname(userVO.getFirstname());
        user.setLastname(userVO.getLastname());
        user.setUsername(userVO.getUsername());
        user.setPassword(userVO.getPassword());
        user.setEnabled(true);
        user.setCreated(new DateTime());
        userDao.save(user);
        
        Address address = new Address();
        address.setEmail(userVO.getEmail());
        address.setCountry(userVO.getCountry());
        address.setZip(userVO.getZip());
        address.setStreet(userVO.getStreet());
        address.setCity(userVO.getCity());
        address.setBirthdate(userVO.getBirthdate());
        address.setUser(user);
        addressDao.save(address);
        
        Authority auth = new Authority();
        auth.setAuthority(userVO.getAuthorityType());
        auth.setUsername(userVO.getUsername());
        auth.setUsers(user);
        authorityDao.save(auth);
    }

    @Override
    public boolean existUser(String username) {
        User user = userDao.findUserByUsername(username); 
        return user == null ? false : true;
    }

    @Override
    public String getUserIdByUsername(String username) {
        User user = userDao.findUserByUsername(username); 
        return user.getUserId();
    }

}
