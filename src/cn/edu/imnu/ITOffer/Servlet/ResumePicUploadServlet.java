package cn.edu.imnu.ITOffer.Servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.edu.imnu.ITOffer.DAO.ResumeDAO;

/**
 * Servlet implementation class ResumePicUploadServlet
 */
@WebServlet("/ResumePicUploadServlet")
@MultipartConfig
public class ResumePicUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumePicUploadServlet() {
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
		

		request.setCharacterEncoding("utf-8");
		response.setContentType( "text/html;charset=utf-8");
		Part part = request.getPart("headShot");
		System.out.println("OK");
		String fileName = part.getSubmittedFileName();
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		String filepath = getServletContext().getRealPath("/images");
		System.out.println("头像保存路径为：" + filepath);
		File f = new File(filepath);
		if(!f.exists())
			f.mkdirs();
		part.write(filepath + "/" + newFileName);
		//int resumeID = (Integer)request.getSession().getAttribute("SESSION_RESUMEID");
		ResumeDAO dao  = new ResumeDAO();
		dao.updateHeadShot( 1 , newFileName);
		response.sendRedirect("resumeBasicInfoAdd.jsp");
		//doGet(request, response);
	}

}
