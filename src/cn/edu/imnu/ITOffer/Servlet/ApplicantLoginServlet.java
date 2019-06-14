package cn.edu.imnu.ITOffer.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.ITOffer.Bean.Applicant;
import cn.edu.imnu.ITOffer.DAO.ApplicatDAO;
import cn.edu.imnu.ITOffer.DButil.CookieEncryptTool;

/**
 * Servlet implementation class ApplicantLoginServlet
 */
@WebServlet("/ApplicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		
		ApplicatDAO DAO = new ApplicatDAO();
		int applicantID = DAO.login(email, password);
		if(applicantID !=0) {
			Applicant applicant = new Applicant(applicantID,email,password);
			request.getSession().setAttribute("SESSION_APPLICANT", applicant);
			
			rememberMe(rememberMe,email,password,request,response);
			
			int resumeID = DAO.isExistResume(applicantID);
			if(resumeID !=0) {
				request.getSession().setAttribute("SEEION_RESUMEID", resumeID);
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("resumeGuide.jsp");
			}
		}else {
			out.println("<script type='text/javascript' >");
			out.println("alert('用户名或密码错误请重新输入');");
			out.println("window.location = 'login.jsp';");
			out.println("</script>");
		}
		//doGet(request, response);
	}
	
	private void rememberMe(String rememberMe,String email , String password,HttpServletRequest request,HttpServletResponse response) {
		if("true".equals(rememberMe)) {
			Cookie cookie = new Cookie("COOKIE_APPLICANTEMAIL",CookieEncryptTool.encodeBase64(email));
			cookie.setPath("/");
			cookie.setMaxAge(365*24*3600);
			response.addCookie(cookie);
			cookie = new Cookie("COOKIE_APPLICANTPWD",CookieEncryptTool.encodeBase64(password));
			cookie.setPath("/");
			cookie.setMaxAge(365*24*3600);
			response.addCookie(cookie);
		}else {
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if("COOKIE_APPLICANTEMAIL".equals(cookie.getName()) || "COOKIE_APPLICANTPWD".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}

			}
		}
	}

}
