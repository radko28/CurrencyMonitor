package sk.cyklosoft.currencymonitor.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sk.cyklosoft.currencymonitor.domain.CountryType;
import sk.cyklosoft.currencymonitor.domain.RoleType;
import sk.cyklosoft.currencymonitor.service.CurrencyService;
import sk.cyklosoft.currencymonitor.service.UserService;
import sk.cyklosoft.currencymonitor.util.AppHelper;
import sk.cyklosoft.currencymonitor.validation.PasswordValidator;
import sk.cyklosoft.currencymonitor.vo.CurrencyVO;
import sk.cyklosoft.currencymonitor.vo.HistoricalCurrencyVO;
import sk.cyklosoft.currencymonitor.vo.UserVO;

@Controller
public class UserController {
	
	
    @Autowired
    UserService userService;
    @Autowired
    CurrencyService currencyService;

    @RequestMapping(value = {"user","user/userIndex"}, method = RequestMethod.GET)
    public String getView(Model model, Locale locale) {
    	CurrencyVO liveCurrencyVO = currencyService.getCurrentExchangeRate();
    	
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        model.addAttribute("liveCurrencyList", liveCurrencyVO.getRates());
        model.addAttribute("errorMessageLive", liveCurrencyVO.getErrorMessage());
        model.addAttribute("historicalCurrency", new HistoricalCurrencyVO());
        model.addAttribute("historicalCurrencyList", null);
        model.addAttribute("userId", userService.getUserIdByUsername(AppHelper.getUsername()));
        return "userIndexView";
    }
    
    @RequestMapping(value = {"user","user/userIndex"}, method = RequestMethod.POST)
    public String getHistorical(@ModelAttribute("historicalCurrency") @Valid HistoricalCurrencyVO historicalCurrency,BindingResult result,  
    		Model model, Locale locale) {
    	CurrencyVO liveCurrencyVO = currencyService.getCurrentExchangeRate();
    	
    	if(result.hasErrors()) {
    		model.addAttribute("historicalCurrencyList", null);
        	model.addAttribute("errorMessageHistorical", null);
        } else {
        	CurrencyVO historicalCurrencyVO = currencyService.getHistoricalExchangeRate(historicalCurrency);
        	model.addAttribute("historicalCurrencyList", historicalCurrencyVO.getRates());
        	model.addAttribute("errorMessageHistorical", historicalCurrencyVO.getErrorMessage());
        }
    	model.addAttribute("liveCurrencyList", liveCurrencyVO.getRates());
        model.addAttribute("errorMessageLive", liveCurrencyVO.getErrorMessage());    	
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        model.addAttribute("historicalCurrency", historicalCurrency);
        model.addAttribute("userId", userService.getUserIdByUsername(AppHelper.getUsername()));
            
        return "userIndexView";
        
    }

    
    @RequestMapping(value = {"register"}, method = RequestMethod.GET)
    public String addUser(Model model, Locale locale,ModelMap modelMap) {
        model.addAttribute("user", new UserVO());
        modelMap.put("countryTypeList",CountryType.getCountryTypeMap());
        if(AppHelper.hasAdminRole()) {
            model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        }
        
        return "userAddView";
    }
    
    @RequestMapping(value = {"register"}, method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user")
    @Valid UserVO user, BindingResult result, Errors errors, Model model, Locale locale) {
        String page = null;
        
        PasswordValidator passwordValidator = new PasswordValidator();
        passwordValidator.validate(user, errors);
        
        if(result.hasErrors()) {
            page = "userAddView";
        } else {
        	user.setRole(RoleType.ROLE_USER.name());
            userService.addUser(user);
             page = "redirect:login";
         }
        return page;
    }
  
}
