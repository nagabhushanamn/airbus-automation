package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Account;
import com.example.service.TxrService;

@Controller
public class TxrController {

	@Autowired
	private TxrService txrService;

	@PostMapping(value = "/txr")
	public @ResponseBody TxrResponse doTxr(@RequestBody TxrRequest request) {
		
		Account account = txrService.transfer(
				request.getAmount(), 
				request.getFromAccNumber(),
				request.getToAccNumber());
		
		TxrResponse response = new TxrResponse();
		response.setMessage("Transfer success");
		response.setAccount(account);
		
		return response;
	}

}
