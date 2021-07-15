package practice02;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Friend;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String strName = "/friendlist.jsp";

		DAOFactory factory = new DAOFactory();
		FriendDAO dao = factory.getFriendDAO();

		List<Friend> list = dao.selectFriend();
		request.setAttribute("LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher(strName);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String message = "登録が完了しました。";
		String strName = "/ok.jsp";
		if(name.equals("")) {
			message = "名前が入力されていません。";
		}
		else if(mail.equals("")) {
			message = "メールアドレスが入力されていません。";
		}
		else {
			DAOFactory factory = new DAOFactory();
			FriendDAO dao = factory.getFriendDAO();
			dao.insertFriend(name,mail);
		}
		request.setAttribute("MESSAGE", message);
		RequestDispatcher rd = request.getRequestDispatcher(strName);
		rd.forward(request, response);
	}

}
