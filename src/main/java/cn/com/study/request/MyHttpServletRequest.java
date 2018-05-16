package cn.com.study.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyHttpServletRequest extends HttpServletRequestWrapper {

	HttpServletRequest request;
	HttpServletResponse response;

	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		this.request = request;
		this.response = response;
	}

	@Override
	public HttpSession getSession() {
		return super.getSession();
	}

}
