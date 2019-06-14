package cn.edu.imnu.ITOffer.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.ITOffer.DAO.ApplicatDAO;

/**
 * Servlet implementation class ApplicantRegisterServlet
 */
@WebServlet("/ApplicantRegisterServlet")
public class ApplicantRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode");
		
		String sessionVer =  (String)request.getSession().getAttribute("SESSION_VALIDATECODE");
		System.out.println(sessionVer);
		
		if(! sessionVer.equals(verifyCode)) {
			out.println("<script type = 'text/javascript'>");
			out.println("alert('验证码输入错误，请重新输入');");
			out.println("window.location = 'register.jsp';");
			out.println("</script>");
		}else {
			ApplicatDAO dao = new ApplicatDAO();
			boolean flag = dao.isExistEmail(mail);
			if(flag) {
				out.println("<script type = 'text/javascript'>");
				out.println("alert('用户名已经存在请重新输入');");
				out.println("window.location = 'register.jsp';");
				out.println("</script>");
			}else {
				dao.save(mail,password);
				response.sendRedirect("login.jsp");
			}
		}
		//doGet(request, response);
	}

}
