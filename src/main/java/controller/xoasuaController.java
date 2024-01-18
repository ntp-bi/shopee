package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class xoasuaController
 */
@WebServlet("/xoasuaController")
public class xoasuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoasuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String masach = request.getParameter("ms");
		String sl = request.getParameter("txtsl");
		
		HttpSession session = request.getSession();
		if(masach != null){
			giohangbo ghbo=(giohangbo)session.getAttribute("gh");
			if(sl==null)
				ghbo.Xoa(masach);		
			else{
				ghbo.Capnhapsoluong(masach, Long.parseLong(sl));
			}

			session.setAttribute("gh", ghbo);
			response.sendRedirect("cartController");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
