package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
	@Autowired
	HttpSession session;
	
	 public Object getAttribute(String name) {
	        // Kiểm tra xem attribute có tồn tại hay không
	        if (session.getAttribute(name) != null) {
	            // Trả về giá trị của attribute
	            return session.getAttribute(name);
	        }

	        // Không tìm thấy attribute
	        return null;
	    }
	 public void setAttribute(String name, Object value) {
		    // Kiểm tra xem attribute có tồn tại hay không
		    if (session.getAttribute(name) != null) {
		        // Ghi đè giá trị của attribute
		        session.setAttribute(name, value);
		    } else {
		        // Tạo mới attribute
		        session.setAttribute(name, value);
		    }
		}
	 public void removeAttribute(String name) {
		    // Kiểm tra xem attribute có tồn tại hay không
		    if (session.getAttribute(name) != null) {
		        // Xóa attribute
		        session.removeAttribute(name);
		    }
		}
	 public void invalidate(HttpSession session) {
	        session.invalidate();
	    }
}
