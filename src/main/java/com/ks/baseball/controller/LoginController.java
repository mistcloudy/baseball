package com.ks.baseball.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ks.baseball.dto.LoginInputDto;
import com.ks.baseball.exception.FMSystemException;
import com.ks.baseball.exception.MemberException;
import com.ks.baseball.service.MemberService;
import com.ks.baseball.util.MessageUtils;
import com.ks.baseball.vo.MemberVO;

@Controller
public class LoginController {
	
    private static final String messageNotUser     = "KS_FMSYS_ERRMSG_001_JV";
    private static final String messageIncorrectPW = "KS_FMSYS_ERRMSG_002_JV";
@Autowired
private MemberService memberService;

private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

@RequestMapping(value ="/login", method = RequestMethod.GET)
public ModelAndView viewForm(ModelAndView model) {
	model.setViewName("login");
	return model;
	
}

@ModelAttribute
public LoginInputDto setUpForm() {
	return new LoginInputDto();
}

@RequestMapping(value = "/login", method = RequestMethod.POST)
public ModelAndView excuteForm(LoginInputDto form, HttpServletRequest request) {
	List<MemberVO> memberList = null;
	ModelAndView modelAndView = new ModelAndView();
	try {
	memberList = memberService.getLoginMemberList(form.getMember_number());
	} catch (DataAccessException e) {
		 String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
         throw new FMSystemException(messages, e);
	}
	
	
    if (memberList.size() != 1) {
        String messages = MessageUtils.getMessage(messageNotUser,
            new Object[] { form.getMember_number() });
        throw new MemberException(messages);
    }

    if (!form.getMember_password().equals(memberList.get(0).getMember_password())) {
        String messages = MessageUtils.getMessage(messageIncorrectPW);
        throw new MemberException(messages);
    }
    
	
	HttpSession session = request.getSession();
	session.setAttribute("member_number", memberList.get(0).getMember_number());
	session.setAttribute("member_name", memberList.get(0).getMember_name());
	modelAndView.setViewName("redirect:/menu");
    return modelAndView;
	
}
}
