package com.ks.baseball.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ks.baseball.dto.NumberInputDto;
import com.ks.baseball.exception.FMSystemException;
import com.ks.baseball.service.GameInfoService;
import com.ks.baseball.service.PointService;
import com.ks.baseball.util.MessageUtils;
import com.ks.baseball.vo.GameInfoVO;
import com.ks.baseball.vo.PointVO;

@Controller
public class GameController {

	@Autowired
	private PointService pointService;
	@Autowired
	private GameInfoService gameInfoService;
	
	public static int strike(String resultNum, String tryNum, int countStrike){ 
		for(int i=0; i<resultNum.length(); i++) {
			if(resultNum.charAt(i)==tryNum.charAt(i)) {
				countStrike += 1;
			}
		}
		return countStrike;
	}
//	
//	public static int ball(String resultNum, String tryNum, int countBall){
//		
//		String  strBallCnt 	= "";		
//		int 	intBallCnt 	= 0;	
//		
//		for(int i=0; i<resultNum.length(); i++) {
//	
//			if (resultNum.indexOf(tryNum.charAt(i))>=0 && resultNum.charAt(i)!=tryNum.charAt(i)) {
//				strBallCnt 	+= Integer.toString(i);
//				intBallCnt 	=  strBallCnt.length();
//				countBall 	=  intBallCnt;
//			}
//		}
//		return countBall;
//	}

	
	@RequestMapping(value = "/game", method = RequestMethod.GET)
	public ModelAndView gameViewForm(ModelAndView model,  HttpServletRequest request) {
		model.setViewName("game");
		HttpSession session = request.getSession();
		String member_number = (String) session.getAttribute("member_number");
		String entered_number = (String) session.getAttribute(member_number+"entered_number");
		String hidden_number = (String) session.getAttribute(member_number+"hidden_number");
		String game_number = (String) session.getAttribute(member_number+"game_number");
		String game_finish_flag = (String) session.getAttribute(member_number+"game_finish_flag");
		
		List<PointVO> pointList = null;
		PointVO pointlist = new PointVO();
		
		try {
			pointList = pointService.selectPointList(member_number);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
		
		
		if (pointList.size() == 0 ) {
			pointlist.setMember_number(member_number);
			try {
				pointService.insertPointList(pointlist);
			} catch (DataAccessException e) {
				String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
				throw new FMSystemException(messages, e);
			}
			try {
				pointList = pointService.selectPointList(member_number);
				} catch (DataAccessException e) {
					String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
					throw new FMSystemException(messages, e);
				}
			
		}
		
		if (entered_number.isEmpty()) {
			pointlist.setMember_number(member_number);
			pointlist.setGame_finish_flag("0");
			try {
				pointService.endPointList(pointlist);
				} catch (DataAccessException e) {
					String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
					throw new FMSystemException(messages, e);
				}
			try {
				pointList = pointService.selectPointList(member_number);
				} catch (DataAccessException e) {
					String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
					throw new FMSystemException(messages, e);
				}
			
		}
	
		
		session.setAttribute(member_number+"point", pointList.get(0).getPoint());
		session.setAttribute(member_number+"game_finish_flag", pointList.get(0).getGame_finish_flag());
		
		model.addObject("point", pointList.get(0).getPoint());
		if(entered_number.contains("/")) {
			int en = entered_number.length() - entered_number.replace("/", "").length();
			String[] enternumbers;
			enternumbers = entered_number.split("/");
			for (int i=0; i<en; i++) {
				model.addObject("en"+i , enternumbers[i]);
			}
		}
		
	
		
		return model;
	}
	
	@ModelAttribute
	public NumberInputDto setUpForm() {
		return new NumberInputDto();
	}
	
	@RequestMapping(value = "/game", method = RequestMethod.POST)
	public ModelAndView gameExcuteForm(NumberInputDto form, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		GameInfoVO gamelist = new GameInfoVO();
		PointVO pointlist = new PointVO();
		
		List<GameInfoVO> gameList = null;
		List<PointVO> pointList = null;
		
		HttpSession session = request.getSession();
		String member_number = (String) session.getAttribute("member_number");
		String entered_number = (String) session.getAttribute(member_number+"entered_number");
		String game_number = (String) session.getAttribute(member_number+"game_number");
		String hidden_number = (String) session.getAttribute(member_number+"hidden_number");
		String point = (String) session.getAttribute(member_number+"point");
		
		String enterNumber = form.getInput_number0() + form.getInput_number1() + form.getInput_number2();
		String hiddenNumber = hidden_number;
		
		int countStrike = 0;
//		int countBall 	= 0;
		
//		int bcnt = ball(hiddenNumber, enterNumber, countBall);
		int scnt = strike(hiddenNumber, enterNumber, countStrike);
		
		if ( entered_number != null) {
			enterNumber = entered_number + enterNumber + "/" ;
		} else {
			enterNumber = enterNumber + "/" ;
		}
		
		int pointResult;
		pointlist.setMember_number(member_number);
		gamelist.setGame_number(game_number);
		gamelist.setEntered_number(enterNumber);
		
		try {
			gameInfoService.updateGameList(gamelist);
		} catch (DataAccessException e) {
			String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
			throw new FMSystemException(messages, e);
		}
		
		if(scnt == 3 || enterNumber.length() == 40) {
			pointlist.setGame_finish_flag("1");
			try {
				pointService.endPointList(pointlist);
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
			try {
				pointList = pointService.selectPointList(member_number);
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
			
			session.setAttribute("game_finish_flag", pointList.get(0).getGame_finish_flag());
			
			if (enterNumber.length() <= 20) {
				pointResult = Integer.parseInt(point.trim()) + 1000;
			} else if (enterNumber.length() <= 28) {
				pointResult = Integer.parseInt(point.trim()) + 800;
			} else if (enterNumber.length() <= 40 && scnt == 3){
				pointResult = Integer.parseInt(point.trim()) + 500;
			} else  {
				pointResult =  Integer.parseInt(point.trim());
			}
			
			String ps = Integer.toString(pointResult);
			session.setAttribute(member_number+"point", ps);
			pointlist.setPoint(ps);
			pointlist.setMember_number(member_number);
			try {
				pointService.updatePointList(pointlist);
			} catch (DataAccessException e) {
				String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
				throw new FMSystemException(messages, e);
			}
			
			
		} else if (enterNumber.length() > 36) {
			pointlist.setMember_number(member_number);
			pointlist.setGame_finish_flag("1");
			try {
				pointService.endPointList(pointlist);
				} catch (DataAccessException e) {
					String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
					throw new FMSystemException(messages, e);
				}
		} 
		
		session.setAttribute(member_number+"entered_number", enterNumber);
		
		modelAndView.setViewName("redirect:/game");
		return modelAndView;
	}
	
	@RequestMapping(value = "/rule", method = RequestMethod.GET)
	public void rule(Model model, @RequestParam(value="make_date", defaultValue="") String make_date) throws Exception {
		
		model.addAttribute("make_date", make_date);
		
	}
	
	
	@RequestMapping(value = "menubt", method = RequestMethod.GET)
	public ModelAndView menubt() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("redirect:/menu");
		return modelAndView;
	}
}
