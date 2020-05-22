package com.PhotoApplicationAccountManager.api.ws.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountManager")
public class controller {
	
	@GetMapping("/getStatus")
	public String getStatus() {
		return "working";
	}
}