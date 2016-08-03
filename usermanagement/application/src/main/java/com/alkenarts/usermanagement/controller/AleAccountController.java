package com.alkenarts.usermanagement.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alkenarts.usermanagement.account.AccountService;
import com.alkenarts.usermanagement.ale.ALEAccountInfo;
import com.alkenarts.usermanagement.ale.AccessCode;
import com.alkenarts.usermanagement.ale.AleAccountService;
import com.alkenarts.usermanagement.ale.AleReadException;
import com.alkenarts.usermanagement.ale.AleWriteException;

@RequestMapping("/ale/api/")
@RestController
public class AleAccountController {

	@Autowired
	AleAccountService aleAccountService;

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/generateAccessCodeSet", method = RequestMethod.POST)
	@ResponseBody
	public ALEAccountInfo generateAccessCodeSet(
			@RequestParam(value = "realm") String realm,
			@RequestParam(value = "duration") String duration,
			@RequestParam(value = "count") int count) throws AleWriteException {
		ALEAccountInfo response = null;
		response = aleAccountService
				.createAccessCodeSet(realm, duration, count);
		return response;
	}

	@RequestMapping(value = "/generateAccessCode", method = RequestMethod.POST)
	@ResponseBody
	public ALEAccountInfo generateAccessCode(
			@RequestParam(value = "accessCode") String accessCode,
			@RequestParam(value = "realm") String realm,
			@RequestParam(value = "duration") String duration,
			@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate)
			throws AleWriteException {
		ALEAccountInfo response = null;
		response = aleAccountService.createAccessCode(accessCode, realm,
				duration, startDate, endDate);
		return response;
	}

	@RequestMapping(value = "/getAllAccessCodes", method = RequestMethod.GET)
	@ResponseBody
	public Set<AccessCode> getAllAccessCodes() throws AleReadException {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		Set<AccessCode> response = aleAccountService
				.getAllAccessCodes(accountService.getGroups(userName));
		return response;
	}
}
