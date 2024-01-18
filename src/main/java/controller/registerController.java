package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.dangkybo;
import utils.MaHoa;

/**
 * Servlet implementation class registerController
 */
@WebServlet("/registerController")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String un = request.getParameter("un");
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			if (un == null && pass == null && name == null) {
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			} else {
				pass = MaHoa.ecrypt(pass);
				dangkybo dkbo = new dangkybo();
				Boolean n = dkbo.ktdk(un);
				if (n) {
					dkbo.Dangky(name, null, null, null, un, pass);
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp?war=Đăng ký thành công!");
					rd.forward(request, response);

				} else {
					RequestDispatcher rd = request.getRequestDispatcher(
							"register.jsp?war=Tài khoản đã tồn tại hoặc chưa nhập đầy đủ thông tin!");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
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
