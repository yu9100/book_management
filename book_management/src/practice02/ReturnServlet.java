package practice02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Dvd;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");

		String number = request.getParameter("value");
		String jspName = "/returndvdlist.jsp";
		DAOFactory factory = new DAOFactory();
		DvdDAO dvddao = factory.getDvdDAO();

		List<Dvd> dvdlist = dvddao.selectRentalDvd(number);
		request.setAttribute("DVDLIST", dvdlist);
		RequestDispatcher rd = request.getRequestDispatcher(jspName);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String[] dvd = request.getParameterValues("dvd");
		String jspName = "/ok_return.jsp";

		if(dvd == null) {
			String message = "返却するDVDを選択してください。";
	        jspName = "/ok.jsp";
	        request.setAttribute("MESSAGE", message);
		} else {
			DAOFactory factory = new DAOFactory();
			DvdDAO dvdDao = factory.getDvdDAO();
			List<Dvd> dvdlist = dvdDao.updateRentalDvd(id, dvd);
			request.setAttribute("DVDLIST", dvdlist);
		}
		RequestDispatcher rd = request.getRequestDispatcher(jspName);
		rd.forward(request, response);
	}

}
