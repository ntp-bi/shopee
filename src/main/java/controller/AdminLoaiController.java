package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.loaibean;
import bo.loaibo;

/**
 * Servlet implementation class AdminLoaiController
 */
@WebServlet("/AdminLoaiController")
public class AdminLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoaiController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// HttpSession session = request.getSession();
		String them = request.getParameter("butthem");
		String sua = request.getParameter("butsua");
		String ml = request.getParameter("ml");
		String butxoa = request.getParameter("butxoa");

		try {
			loaibo lbo = new loaibo();
			ArrayList<loaibean> ds = lbo.getloai();
			if (sua != null || them != null) {
				String maloai = request.getParameter("txtml");
				String tenloai = request.getParameter("txttl");
				if (sua != null)
					lbo.updateloai(maloai, tenloai);
				if (them != null)
					lbo.insertloai(maloai, tenloai);
			}
			if (request.getParameter("tab") != null) {
				if (request.getParameter("tab").equals("delete")) {
					lbo.deleteloai(butxoa);
				}
			}

			request.setAttribute("dsloai", lbo.getloai());

			if (ml != null) {
				request.setAttribute("ds", lbo.timloaitheoma(ml));
			}

			RequestDispatcher rd = request.getRequestDispatcher("Adminloai.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.getWriter().println("loi: " + e.getMessage());
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
