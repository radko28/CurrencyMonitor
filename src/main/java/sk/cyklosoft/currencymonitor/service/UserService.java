package sk.cyklosoft.currencymonitor.service;

import sk.cyklosoft.currencymonitor.vo.UserVO;

public interface UserService {

    String getWholeNameByUsername(String username);

    UserVO getUserById(String userId);

    void addUser(UserVO userVO);

    boolean existUser(String username);

    String getUserIdByUsername(String username);

}
