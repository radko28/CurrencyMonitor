package sk.cyklosoft.currencymonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sk.cyklosoft.currencymonitor.service.UserService;
import sk.cyklosoft.currencymonitor.util.AppHelper;

@Controller
public class LoginController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap model) {

        return "homeView";

    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String printLogin(ModelMap model) {
        return "loginView";

    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        String page = "";
        if (AppHelper.hasUserRole()) {
            page = "redirect:user";
        } else if (AppHelper.hasAdminRole()) {
            page = "redirect:admin";
        }

        return page;

    }


    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginFailed(ModelMap model) {
        String page = "loginView";
        model.addAttribute("error", "true");
        return page;

    }

    @RequestMapping(value = {"admin/logout","/logout"}, method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "homeView";

    }
    


}
