package practice02;

import java.util.List;

import beans.Rental;

public interface RentalDAO {
	List<Rental> selectRental();
	String insertRental(String friendID, String[] dvd);
	List<Rental> selectIdRental(String id);
}
