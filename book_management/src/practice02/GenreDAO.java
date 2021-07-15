package practice02;

import java.util.List;
import beans.Genre;

public interface GenreDAO {
	List<Genre> selectGenre();
	void insertGenre(String name);
	List<Genre> selectDvdGenre();
	List<Genre> selectSearchDvdGenre(String genreId);
}
