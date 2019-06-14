package cn.edu.imnu.ITOffer.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieExampleServlet
 */
@WebServlet("/CookieExampleServlet")
public class CookieExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieExampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String nowTime = sdf.format(new Date());
		
		String lastVistTime = "";
		int vistedCount = 0;
		
		Cookie[] cookies =  request.getCookies();
		if(cookies != null) {
			
			for(Cookie cookie : cookies) {
				if("lastVistTime".equals(cookie.getName())) {
					lastVistTime = cookie.getValue();
				}
				
				if("vistedCount".equals(cookie.getName())) {
					vistedCount = Integer.valueOf(cookie.getValue());
				}
			}
		}
		if(!"".equals(lastVistTime)) {
			System.out.println("!");
			out.println("您上一次访问的时间是：" + lastVistTime);
			out.println("");
		}
		out.println("您是第"+(vistedCount+1)+"次访问本站");
		Cookie lastVistTimeC = new Cookie("lastVistTime",nowTime);
		lastVistTimeC.setMaxAge(365*24*60*60);
		Cookie vistedCountC = new Cookie("vistedCount",String.valueOf(vistedCount +1));
		vistedCountC.setMaxAge(365*24*60*60);
		response.addCookie(lastVistTimeC);
		response.addCookie(vistedCountC);
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
