package practice02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Genre;

/**
 * Servlet implementation class GenreServlet
 */
@WebServlet("/GenreServlet")
public class GenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenreServlet() {
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

		String jspName = "/genrelist.jsp";

		DAOFactory factory = new DAOFactory();
		GenreDAO dao = factory.getGenreDAO();

		List<Genre> list = dao.selectGenre();
		request.setAttribute("LIST", list);
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

		String genre = request.getParameter("genre");
		String message = "登録しました";
		String jspName = "/ok.jsp";
		if(genre.equals("")) {
			message = "ジャンルを入力してください";
		}
		else {
			DAOFactory factory = new DAOFactory();
			GenreDAO dao = factory.getGenreDAO();
			dao.insertGenre(genre);
		}
		request.setAttribute("MESSAGE", message);
		RequestDispatcher rd = request.getRequestDispatcher(jspName);
		rd.forward(request, response);
	}

}
