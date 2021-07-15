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
import beans.Friend;
import beans.Rental;

/**
 * Servlet implementation class RentalServlet
 */
@WebServlet("/RentalServlet")
public class RentalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentalServlet() {
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

		String method = request.getParameter("value");
		String jspName = null;
		DAOFactory factory = new DAOFactory();
		RentalDAO rentaldao = factory.getRentalDAO();
		FriendDAO frienddao = factory.getFriendDAO();
		DvdDAO dvddao = factory.getDvdDAO();
		if(method.equals("select")) {
			List<Rental> rentallist = rentaldao.selectRental();
			request.setAttribute("RENTALLIST", rentallist);
			jspName = "/rentalhistory.jsp";
		}
		else if(method.equals("insert")) {
			List<Friend> friendlist = frienddao.selectFriend();
			request.setAttribute("FRIENDLIST", friendlist);
			List<Dvd> dvdlist = dvddao.selectDvd();
			System.out.println(dvdlist);
			request.setAttribute("DVDLIST", dvdlist);
			jspName = "/t_rental.jsp";
		}
		else if(method.equals("detail")) {
			String id = request.getParameter("id");
			List<Rental> rentallist = rentaldao.selectIdRental(id);
			request.setAttribute("RENTALLIST", rentallist);
			List<Dvd> dvdlist = dvddao.selectHistoryDvd(id);
			request.setAttribute("DVDLIST", dvdlist);
			jspName = "/rentaldetail.jsp";
		}
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

		String friend = request.getParameter("friend");
		String[] dvd = request.getParameterValues("dvd");
		String jspName = "/ok_rental.jsp";
		if(dvd == null) {
			String message = "DVDを選択してください";
			jspName = "/ok.jsp";
			request.setAttribute("MESSAGE", message);
		}
		else {
			String number = null;
			DAOFactory factory = new DAOFactory();
			RentalDAO rentaldao = factory.getRentalDAO();
			number = rentaldao.insertRental(friend, dvd);
			request.setAttribute("NUMBER", number);
		}

		RequestDispatcher rd = request.getRequestDispatcher(jspName);
		rd.forward(request, response);
	}

}
