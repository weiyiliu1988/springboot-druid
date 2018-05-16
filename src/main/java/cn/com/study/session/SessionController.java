package cn.com.study.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. 把HttpServletRequest对象，换成我们自己定义的HttpServletRequest对象
 * 
 * 
 * @author weiyiLiu
 *
 */
@RestController
public class SessionController {

	@RequestMapping(path = "/login")
	public String login(HttpServletRequest req) {

		HttpSession session = req.getSession();
		session.setAttribute("name", req.getParameter("name"));
		session.setAttribute("password", req.getParameter("password"));
		return "";
	}
}
