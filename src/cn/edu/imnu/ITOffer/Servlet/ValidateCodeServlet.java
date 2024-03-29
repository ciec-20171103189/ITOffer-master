package cn.edu.imnu.ITOffer.Servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateCodeServlet
 */
@WebServlet("/ValidateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		
		int width = 70;
		int height = 30;
		BufferedImage imgbuf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = imgbuf.createGraphics();
		g.setColor(getRandColor(200,250));
		g.fillRect(0, 0, width, height);
		
		Random r = new Random();
		g.setColor(getRandColor(160, 200));
		for(int i = 0 ; i<100 ; i++) {
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			int xl = r.nextInt(12);
			int yl = r.nextInt(12);
			g.drawLine(x, y, x+xl, y+yl);
		}
		g.setColor(getRandColor(120, 240));
		for(int i = 0 ;i<100 ; i++) {
			int x = r.nextInt(width);
			int y =r.nextInt(height);
			g.drawOval(x, y, 0, 0);
		}
		g.setFont(new Font("Times New Roman",Font.PLAIN,22));
		String code = "";
		for(int i = 0;i<4;i++) {
			String rand = String .valueOf(r.nextInt(10));
			code += rand;
			g.setColor(new Color(20 + r.nextInt(110),20 + r.nextInt(100),20+r.nextInt(110)));
			g.drawString(rand, 13*i+10, 22);
		}
		request.getSession().setAttribute("SESSION_VALIDATECODE", code);
		ImageIO.write(imgbuf, "JPEG", out);
		out.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
	private Color getRandColor(int fc,int bc){
		Random random = new Random();
		if(fc>255)
			fc = 255;
		if(fc<0)
			fc = 0;
		if(bc>255)
			bc = 255;
		if(bc < 0)
			bc = 0;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r,g,b);
	}
}