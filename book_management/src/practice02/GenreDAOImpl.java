package practice02;

import java.util.ArrayList;
import java.util.List;

import beans.Genre;

public class GenreDAOImpl implements GenreDAO{

	public List<Genre> selectGenre(){
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		List<Genre> result = new ArrayList<>();
		CreateSQL ctrsql = new CreateSQL();
		String sql = ctrsql.selectGenre();
		table = ctrsql.dbConnection(sql, "select");

		for(ArrayList<String> rec : table) {
			Genre genre = new Genre();
			genre.setId(Integer.parseInt(rec.get(0)));
			genre.setName(rec.get(1));
			result.add(genre);
		}
		return result;
	}

	public void insertGenre(String name) {
		CreateSQL crtsql = new CreateSQL();
		String sql = crtsql.insertGenre();
		crtsql.dbConnection(sql, "insert", name);
	}

	public List<Genre> selectDvdGenre(){
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		List<Genre> result = new ArrayList<>();
		CreateSQL ctrsql = new CreateSQL();
		String sql = ctrsql.selectDvdGenre();
		table = ctrsql.dbConnection(sql, "select");

		for(ArrayList<String> rec : table) {
			Genre genre = new Genre();
			genre.setId(Integer.parseInt(rec.get(0)));
			genre.setName(rec.get(1));
			result.add(genre);
		}
		return result;
	}

	public List<Genre> selectSearchDvdGenre(String genreId){
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		List<Genre> result = new ArrayList<>();
		CreateSQL ctrsql = new CreateSQL();

		String sql = ctrsql.selectSearchDvdGenre();
		table = ctrsql.dbConnection(sql, "select");

		for(ArrayList<String> rec : table) {
			Genre genre = new Genre();
			genre.setId(Integer.parseInt(rec.get(0)));
			genre.setName(rec.get(1));
			result.add(genre);
		}
		return result;
	}

}
