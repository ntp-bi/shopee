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
 * Servlet implementation class addCartController
 */
@WebServlet("/addCartController")
public class addCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addCartController() {
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
			if (ms != null && ts != null && giatam != null) {// Dua hang vao gio hangf
				giohangbo gh = null;
				if (session.getAttribute("gh") == null) {// mua lan dau
					gh = new giohangbo();
					session.setAttribute("gh", gh);
				}
				gh = (giohangbo) session.getAttribute("gh");
				gh.Them(ms, ts, Long.parseLong(giatam), (long) 1);
				session.setAttribute("gh", gh);

				RequestDispatcher rd = request.getRequestDispatcher("cartController");
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
