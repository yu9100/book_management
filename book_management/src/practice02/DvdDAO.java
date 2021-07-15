package practice02;

import java.util.List;

import beans.Dvd;

public interface DvdDAO {
	List<Dvd> selectDvd();
	void insertDvd(String name,String[] genre,String[] actor);
	List<Dvd> selectRentalDvd(String RentalId);
	List<Dvd> updateRentalDvd(String id, String[] dvd);
	List<Dvd> selectSearchDvd(String title);
	List<Dvd> selectSearchGenreDvd(String genreId);
	List<Dvd> selectSearchActorDvd(String genreId);
	List<Dvd> selectHistoryDvd(String rentalId);
}
