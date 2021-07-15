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
import beans.Dvd;
import beans.Genre;

/**
 * Servlet implementation class DvdServlet
 */
@WebServlet("/DvdServlet")
public class DvdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DvdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("value");

		String strName = null;
		DAOFactory factory = new DAOFactory();
		DvdDAO dvddao = factory.getDvdDAO();
		GenreDAO genredao = factory.getGenreDAO();
		ActorDAO actordao = factory.getActorDAO();

		if(method.equals("select")) {
			List<Dvd> dvdlist = dvddao.selectDvd();
			request.setAttribute("DVDLIST", dvdlist);
			List<Genre> dvdgenrelist = genredao.selectDvdGenre();
			request.setAttribute("DVDGENRELIST", dvdgenrelist);
			List<Actor> dvdactorlist = actordao.selectDvdActor();
			request.setAttribute("DVDACTORLIST", dvdactorlist);
			List<Genre> genrelist = genredao.selectGenre();
			request.setAttribute("GENRELIST", genrelist);
			List<Actor> actorlist = actordao.selectActor();
			request.setAttribute("ACTORLIST", actorlist);
			strName = "/dvdlist.jsp";
		}
		else if(method.equals("insert")){
			List<Genre> genrelist = genredao.selectGenre();
			request.setAttribute("GENRELIST", genrelist);
			List<Actor> actorlist = actordao.selectActor();
			request.setAttribute("ACTORLIST", actorlist);
			strName = "/t_dvd.jsp";
		}
		else if(method.equals("search")) {
			String type = request.getParameter("type");
			String text = request.getParameter("text");
			List<Genre> genrelist = genredao.selectGenre();
			request.setAttribute("GENRELIST", genrelist);
			List<Actor> actorlist = actordao.selectActor();
			request.setAttribute("ACTORLIST", actorlist);

			if(type.equals("title")) {
				List<Dvd> dvdlist = dvddao.selectSearchDvd(text);
				request.setAttribute("DVDLIST", dvdlist);
				List<Genre> dvdgenrelist = genredao.selectDvdGenre();
				request.setAttribute("DVDGENRELIST", dvdgenrelist);
				List<Actor> dvdactorlist = actordao.selectDvdActor();
				request.setAttribute("DVDACTORLIST", dvdactorlist);
			}
			else if(type.equals("genre")) {
				List<Dvd> dvdlist = dvddao.selectSearchGenreDvd(text);
				request.setAttribute("DVDLIST", dvdlist);
				List<Genre> dvdgenrelist = genredao.selectDvdGenre();
				request.setAttribute("DVDGENRELIST", dvdgenrelist);
				List<Actor> dvdactorlist = actordao.selectDvdActor();
				request.setAttribute("DVDACTORLIST", dvdactorlist);
			}
			else if(type.equals("actor")) {
				List<Dvd> dvdlist = dvddao.selectSearchActorDvd(text);
				System.out.println(dvdlist);
				request.setAttribute("DVDLIST", dvdlist);
				List<Genre> dvdgenrelist = genredao.selectDvdGenre();
				request.setAttribute("DVDGENRELIST", dvdgenrelist);
				List<Actor> dvdactorlist = actordao.selectDvdActor();
				request.setAttribute("DVDACTORLIST", dvdactorlist);
			}
			strName = "/dvdlist.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(strName);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String[] genre = request.getParameterValues("genre");
		String[] actor = request.getParameterValues("actor");
		String message = "登録が完了しました。";
		String strName = "/ok.jsp";
		if(name.equals("")) {
			message = "DVD名を入力してください。";
		}
		else if(genre == null) {
			message = "ジャンルを１つ以上選択してください。";
		}
		else if(actor == null) {
			message = "出演者を１人以上選択してください。";
		}
		else {
			DAOFactory factory = new DAOFactory();
			DvdDAO dvddao = factory.getDvdDAO();
			dvddao.insertDvd(name,genre,actor);
		}

		request.setAttribute("MESSAGE", message);
		RequestDispatcher rd = request.getRequestDispatcher(strName);
		rd.forward(request, response);
	}

}
