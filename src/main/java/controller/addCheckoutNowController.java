package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bo.giohangbo;

/**
 * Servlet implementation class addCheckoutNowController
 */
@WebServlet("/addCheckoutNowController")
public class addCheckoutNowController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addCheckoutNowController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		khachhangbean kh = (khachhangbean) session.getAttribute("login");
		if (kh == null) {
			response.sendRedirect("loginController");
		} else {
			String ms = request.getParameter("ms");
			String ts = request.getParameter("ts");
			String giatam = request.getParameter("gia");
			if (ms != null && ts != null & giatam != null) {// Dua hang vao gio hangf
				giohangbo ck = null;
				if (session.getAttribute("ck") == null) {// mua lan dau
					ck = new giohangbo();
					ck.Them(ms, ts, Long.parseLong(giatam), (long) 1);
					session.setAttribute("ck", ck);					
				}else {
					session.removeAttribute("ck");
					ck = new giohangbo();
					ck.Them(ms, ts, Long.parseLong(giatam), (long) 1);
					session.setAttribute("ck", ck);		
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("checkoutNowController");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
