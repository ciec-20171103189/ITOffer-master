package cn.edu.imnu.ITOffer.Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.ITOffer.Bean.Applicant;
import cn.edu.imnu.ITOffer.Bean.ResumeBasicinfo;
import cn.edu.imnu.ITOffer.DAO.ResumeDAO;

/**
 * Servlet implementation class ResumeBasicinfoServlet
 */
@WebServlet("/ResumeBasicinfoServlet")
public class ResumeBasicinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeBasicinfoServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		if("add".equals(type)) {
			
			ResumeBasicinfo basicinfo = this.requestDataObj(request);
			Applicant applicant = (Applicant) request.getSession().getAttribute("SESSION_APPLICANT");
			ResumeDAO DAO = new ResumeDAO();
			int basicinfoID = DAO.add(basicinfo,applicant.getApplicantID());
			request.getSession().setAttribute("SESSION_RESUMEID", basicinfoID);
			response.sendRedirect("applysuccess.jsp");
		}
		
		//doGet(request, response);
	}
	
	private ResumeBasicinfo requestDataObj(HttpServletRequest request) {
		ResumeBasicinfo basicinfo = null;
		String realName = request.getParameter("realName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String telephone = request.getParameter("telephone");
		String residentLoc = request.getParameter("residentLoc");
		String currentLoc = request.getParameter("currentLoc");
		String email = request.getParameter("email");
		String jobIntension = request.getParameter("jobIntension");
		String jobExperience = request.getParameter("jobExperience");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate = null;
		try {
			birthdayDate=sdf.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		basicinfo = new ResumeBasicinfo(realName,gender,birthdayDate,telephone,residentLoc,currentLoc,email,jobIntension,jobExperience);
		return basicinfo;
	}
}
