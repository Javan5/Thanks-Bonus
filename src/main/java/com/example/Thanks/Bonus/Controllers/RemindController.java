package com.example.Thanks.Bonus.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class RemindController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String getRemind(ModelMap model){
		return "Remind";
	}

}
