package com.ks.baseball.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ks.baseball.exception.FMSystemException;
import com.ks.baseball.service.GameInfoService;
import com.ks.baseball.util.MessageUtils;
import com.ks.baseball.vo.GameInfoVO;

@Controller
public class MenuController {

	private static final String messageNotGame = "KS_FMSYS_ERRMSG_001_JV";

	private static boolean checkNum(int nums[], int index) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == index)
				return true;
		}
		return false;
	}

	@Autowired
	private GameInfoService gameInfoService;

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public ModelAndView menuViewForm(ModelAndView model, HttpServletRequest request) {
		model.setViewName("menu");
		HttpSession session = request.getSession();
		String member_number = (String) session.getAttribute("member_number");
		List<GameInfoVO> gameList = null;

		try {
			gameList = gameInfoService.selectGameList(member_number);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		if (gameList.size() != 0) {
			session.setAttribute(member_number+"game_number", gameList.get(0).getGame_number());
			session.setAttribute(member_number+"entered_number", gameList.get(0).getEntered_number());
			session.setAttribute(member_number+"hidden_number", gameList.get(0).getHidden_number());
			session.setAttribute(member_number+"game_rec_create_date", gameList.get(0).getRec_create_date());
			session.setAttribute(member_number+"logical_del_flag", gameList.get(0).getLogical_del_flag());
		}

		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		session = request.getSession();
		session.invalidate();

		modelAndView.setViewName("redirect:/login");
		return modelAndView;
	}

	@ModelAttribute
	public GameInfoVO setUpForm() {
		return new GameInfoVO();
	}

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public ModelAndView start(HttpServletRequest request) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		GameInfoVO gamelist = new GameInfoVO();

		List<GameInfoVO> gameList = null;

		HttpSession session = request.getSession();
		String member_number = (String) session.getAttribute("member_number");
		String entered_number = (String) session.getAttribute(member_number+"entered_number");
		String game_number = (String) session.getAttribute(member_number+"game_number");
		String game_rec_create_date = (String) session.getAttribute(member_number+"game_rec_create_date");
		String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (game_number == null) {
			gamelist.setMember_number(member_number);
			
			int nums[] = new int[3];
			int index = 0;

			for (int i = 0; i < nums.length; i++) {
				do {
					index = (int) (Math.random() * 10);
				} while (checkNum(nums, index));
				nums[i] = index;
			}
			
			String hidden_number = Arrays.toString(nums).replace(", ","").replace("[","").replace("]","");
			gamelist.setHidden_number(hidden_number);
			
			try {
				gameInfoService.insertGameList(gamelist);
			} catch (DataAccessException e) {
				String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
				throw new FMSystemException(messages, e);
			}
			try {
				gameList = gameInfoService.selectGameList(member_number);
			} catch (DataAccessException e) {
				String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
				throw new FMSystemException(messages, e);
			}

			

		} else {
			Date date = new Date(dateFormat.parse(game_rec_create_date).getTime());

			Date today = new Date(dateFormat.parse(todayfm).getTime());

			int compare = date.compareTo(today);

			if (compare < 0) {

				gamelist.setGame_number(game_number);
				try {
					gameInfoService.deleteGameList(gamelist);
				} catch (DataAccessException e) {
					String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
					throw new FMSystemException(messages, e);
				}

				gamelist.setMember_number(member_number);
				
				int nums[] = new int[3];
				int index = 0;

				for (int i = 0; i < nums.length; i++) {
					do {
						index = (int) (Math.random() * 10);
					} while (checkNum(nums, index));
					nums[i] = index;
				}
				
				String hidden_number = Arrays.toString(nums).replace(", ","").replace("[","").replace("]","");
				gamelist.setHidden_number(hidden_number);
			
				try {
					gameInfoService.insertGameList(gamelist);
				} catch (DataAccessException e) {
					String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
					throw new FMSystemException(messages, e);
				}
				try {
					gameList = gameInfoService.selectGameList(member_number);
				} catch (DataAccessException e) {
					String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
					throw new FMSystemException(messages, e);
				}


			} else {
				gamelist.setGame_number(game_number);
				gamelist.setEntered_number(entered_number);
				try {
					gameInfoService.updateGameList(gamelist);
				} catch (DataAccessException e) {
					String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
					throw new FMSystemException(messages, e);
				}
				try {
					gameList = gameInfoService.selectGameList(member_number);
				} catch (DataAccessException e) {
					String messages = MessageUtils.getMessage("KS_FMSYS_ERRMSG_S01_JV");
					throw new FMSystemException(messages, e);
				}

			}
		}

		session.setAttribute(member_number+"game_number", gameList.get(0).getGame_number());
		session.setAttribute(member_number+"entered_number", gameList.get(0).getEntered_number());
		session.setAttribute(member_number+"hidden_number", gameList.get(0).getHidden_number());
		session.setAttribute(member_number+"game_rec_create_date", gameList.get(0).getRec_create_date());
		session.setAttribute(member_number+"logical_del_flag", gameList.get(0).getLogical_del_flag());
		
		modelAndView.setViewName("redirect:/game");
		return modelAndView;
	}

}
