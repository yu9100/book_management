package practice02;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import beans.Rental;

public class RentalDAOImpl implements RentalDAO {

	public List<Rental> selectRental() {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> returnFlgs = new ArrayList<ArrayList<String>>();

		List<Rental> result = new ArrayList<>();

		CreateSQL crtsql = new CreateSQL();

		String sql = crtsql.selectRental();
		table = crtsql.dbConnection(sql,"select");

		crtsql = new CreateSQL();

		sql = crtsql.selectRentalDvd();

		for(ArrayList<String> rec : table){
			Rental rental = new Rental();
			ArrayList<String> judge = new ArrayList<>();

			rental.setId(Integer.parseInt(rec.get(0)));
			rental.setFriend(rec.get(1));
			rental.setDate(rec.get(2));

			returnFlgs = crtsql.dbConnection(sql,"select",rec.get(0));

			for(ArrayList<String> returnFlg : returnFlgs){
				judge.add(returnFlg.get(3));
			}

			if(judge.indexOf("1") == -1) {
				rental.setResult("OK");
			}
			else {
				rental.setResult("NG");
			}

			result.add(rental);
		}

        return result;
	}

	public String insertRental(String friendId, String[] dvds){
		CreateSQL crtsql = new CreateSQL();
		String sql = crtsql.insertRental();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strAutoIncrement = crtsql.dbConnection(sql, "insert", friendId, sdf.format(calendar.getTime())).get(0).get(0);

		crtsql = new CreateSQL();
		sql = crtsql.insertRentalDvd();
		for(String dvd : dvds) {
			crtsql.dbConnection(sql,"insert",strAutoIncrement,dvd,"1");
		}

		return strAutoIncrement;
	}

	public List<Rental> selectIdRental(String id) {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		List<Rental> result = new ArrayList<>();
		CreateSQL crtsql = new CreateSQL();
		String sql = crtsql.selectIdRental();
		table = crtsql.dbConnection(sql,"select",id);

		for(ArrayList<String> rec : table){
			Rental rental = new Rental();
			rental.setId(Integer.parseInt(rec.get(0)));
			rental.setFriend(rec.get(1));
			rental.setDate(rec.get(2));
			result.add(rental);
		}
		return result;
	}

}
