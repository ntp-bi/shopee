package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class AdminSachController
 */
@WebServlet("/AdminSachController")
public class AdminSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSachController() {
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

		String them = request.getParameter("butthem");
		String sua = request.getParameter("butsua");
		String ms = request.getParameter("ms");
		String butxoa = request.getParameter("butxoa");
		
		try {
			sachbo sbo = new sachbo();
			ArrayList<sachbean> dssach = sbo.getsach();
			
			loaibo lbo = new loaibo();
			ArrayList<loaibean> ds = lbo.getloai();
			
			if (sua != null || them != null) {
				String masach = request.getParameter("txtms");
				String tensach = request.getParameter("txtts");
				String tacgia = request.getParameter("txttg");
				String soluong = request.getParameter("txtsl");
				String gia = request.getParameter("txtg");
				String anh = request.getParameter("txta");
				String maloai = request.getParameter("txtml");
				if (sua != null)
					sbo.updatesach(masach, tensach, tacgia, soluong, gia, maloai, anh);
				if (them != null)
					sbo.insertsach(masach, tensach, tacgia, soluong, gia, maloai, anh);
			}
			
			if (request.getParameter("tab") != null) {
				if (request.getParameter("tab").equals("delete")) {
					sbo.deletesach(butxoa);
				}
			}

			request.setAttribute("dsloai", lbo.getloai());
			request.setAttribute("dssach", sbo.getsach());
			
			if (ms != null) {
				request.setAttribute("ds", sbo.timsachtheoma(ms));
			}

			RequestDispatcher rd = request.getRequestDispatcher("AdminSach.jsp");
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
