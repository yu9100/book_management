package practice02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Actor;

/**
 * Servlet implementation class ActorServlet
 */
@WebServlet("/ActorServlet")
public class ActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String jspName = "/actorlist.jsp";

		DAOFactory factory = new DAOFactory();
		ActorDAO dao = factory.getActorDAO();

		List<Actor> list = dao.selectActor();
		request.setAttribute("LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher(jspName);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("actor");
		String message = "登録が完了しました。";
		String jspName = "/ok.jsp";

		if(name.equals("")) {
			message = "名前を入力してください。";
		}
		else {
			DAOFactory factory = new DAOFactory();
			ActorDAO dao = factory.getActorDAO();
			dao.insertActor(name);
		}
		request.setAttribute("MESSAGE", message);
		RequestDispatcher rd = request.getRequestDispatcher(jspName);
		rd.forward(request, response);
	}

}
