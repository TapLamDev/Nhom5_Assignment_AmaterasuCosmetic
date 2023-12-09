package com.poly.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBufferUtils.Matcher;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;
import com.poly.service.SessionService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Pattern;

@Controller
public class ProfileController {
	@Autowired
	SessionService sessionService;
	@Autowired
	AccountDao accountDao;
	@Autowired
	ServletContext app;

	@GetMapping("/profile")
	public String profileIndex(Model model) {
		String username = (String) sessionService.getAttribute("username");
		Account ac = accountDao.findByUsername(username);
		model.addAttribute("ac", ac);
		return "User/profileIndex";
	}

	@RequestMapping("/profile/save")
	public String profileSave(Model model, @RequestParam(value = "email") String email,
			@RequestParam("numberPhone") String numberPhone,
			@RequestParam("birthDay") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDay,
			@RequestParam("address") String address, @RequestParam("photo_file") MultipartFile img)
			throws IllegalStateException, IOException {

		// Validate form data
		// Get current account
		String username = (String) sessionService.getAttribute("username");
		Account ac = accountDao.findByUsername(username);

		// validate phone
		String phonePattern = "^[0-9]{10}$";
		// Kiểm tra số điện thoại
		if (!numberPhone.matches(phonePattern)) {
			model.addAttribute("messagePhonePattern",
					"Số điện thoại phải có 10 số và không được chứa chữ & ký tự đặc biệt");
			return "User/profileIndex";
		} else {
			ac.setNumberPhone(numberPhone);
		}

		// Validate ngày sinh
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int yearOld = birthDay.getYear() + 1900;
		System.out.println("currentyear" + currentYear);
		System.out.println("yearOld: " + yearOld);
		int total = currentYear - yearOld;
		System.out.println("total: " + total);
		if (currentYear - yearOld < 12) {
			model.addAttribute("messageYearUnder", "Ngày sinh không hợp lệ");
			return "User/profileIndex";
		} else {
			ac.setBirthDay(birthDay);
		}

		ac.setAddress(address);
		ac.setEmail(email);

		if (!img.isEmpty()) {
			String uploadDir = app.getRealPath("/imagesProfile") + File.separator;
	        String filename = img.getOriginalFilename();
	        File file = new File(uploadDir + filename);
	        
	        if (!file.getParentFile().exists()) {
	            file.getParentFile().mkdirs();
	        }
	        
	        img.transferTo(file);
	        ac.setImage(filename);
	    }

		accountDao.save(ac);
		if (!ac.isAdmin()) {
			return "redirect:/";
		} else {
			return "redirect:/Admin/index";
		}
	}
}
