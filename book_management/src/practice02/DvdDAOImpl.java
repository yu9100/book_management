package practice02;

import java.util.ArrayList;
import java.util.List;

import beans.Dvd;

public class DvdDAOImpl implements DvdDAO {

	public List<Dvd> selectDvd() {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

        List<Dvd> result = new ArrayList<>();

        CreateSQL crtsql = new CreateSQL();

        String sql = crtsql.selectDvd();
        table = crtsql.dbConnection(sql,"select");

        for(ArrayList<String> rec : table){
        	Dvd dvd = new Dvd();

        	dvd.setId(Integer.parseInt(rec.get(0)));
        	dvd.setName(rec.get(1));

            result.add(dvd);
        }

        return result;
	}

	public void insertDvd(String name,String[] genres,String[] actors) {
		CreateSQL crtsql = new CreateSQL();

		String sql = crtsql.insertDvd();
		String strAutoIncrement = crtsql.dbConnection(sql, "insert", name).get(0).get(0);

		crtsql = new CreateSQL();
		sql = crtsql.insertDvdActor();
		for(String actor : actors) {
			crtsql.dbConnection(sql,"insert",strAutoIncrement,actor);
		}

		crtsql = new CreateSQL();
		sql = crtsql.insertDvdGenre();
		for(String genre : genres) {
			crtsql.dbConnection(sql,"insert",strAutoIncrement,genre);
		}
	}

	public List<Dvd> selectNoRentalDvd() {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

		List<Dvd> result = new ArrayList<>();

		CreateSQL crtsql = new CreateSQL();

		String sql = crtsql.selectDvd();
		table = crtsql.dbConnection(sql,"select");

		for(ArrayList<String> rec : table){
			Dvd dvd = new Dvd();

			dvd.setId(Integer.parseInt(rec.get(0)));
			dvd.setName(rec.get(1));

			result.add(dvd);
		}

		return result;
	}

	public List<Dvd> selectRentalDvd(String rentalId) {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

		CreateSQL crtsql = new CreateSQL();

		String sql = crtsql.selectRentalDvd();

		table = crtsql.dbConnection(sql,"select",rentalId);

		return rentDvd(table);
	}

	public List<Dvd> selectHistoryDvd(String rentalId) {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

		CreateSQL crtsql = new CreateSQL();

		String sql = crtsql.selectHistoryDvd();

		table = crtsql.dbConnection(sql,"select",rentalId);

		return rentDvd(table);
	}

	public List<Dvd> updateRentalDvd(String id, String[] dvds){
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

		CreateSQL crtsql = new CreateSQL();

		String sql = crtsql.updateRentalDvd();
		for(String dvd : dvds) {
			crtsql.dbConnection(sql,"update", id, dvd);
		}

		crtsql = new CreateSQL();

		sql = crtsql.selectRentalDvd();

		table = crtsql.dbConnection(sql,"select", id);

		return rentDvd(table);
	}

	private List<Dvd> rentDvd(ArrayList<ArrayList<String>> table) {
		List<Dvd> result = new ArrayList<>();
		for(ArrayList<String> rec : table){
			Dvd dvd = new Dvd();

			dvd.setId(Integer.parseInt(rec.get(0)));
			dvd.setDvdId(Integer.parseInt(rec.get(1)));
			dvd.setName(rec.get(2));
			dvd.setFlg(Integer.parseInt(rec.get(3)));

			result.add(dvd);
		}
		return result;
	}

	public List<Dvd> selectSearchDvd(String title) {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

		List<Dvd> result = new ArrayList<>();

		CreateSQL crtsql = new CreateSQL();

		String sql = crtsql.selectSearchDvd();
		table = crtsql.dbConnection(sql,"search",title);

		for(ArrayList<String> rec : table){
			Dvd dvd = new Dvd();

			dvd.setId(Integer.parseInt(rec.get(0)));
			dvd.setName(rec.get(1));

			result.add(dvd);
		}

		return result;
	}

	public List<Dvd> selectSearchGenreDvd(String genreId) {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

		List<String> genreresult = new ArrayList<>();

		CreateSQL crtsql = new CreateSQL();

		String sql = crtsql.selectSearchDvdGenre();
		table = crtsql.dbConnection(sql,"select",genreId);

		for(ArrayList<String> rec : table){
			genreresult.add(rec.get(0));
		}

		String id = String.join(",",genreresult);


		List<Dvd> dvdresult = new ArrayList<>();

		crtsql = new CreateSQL();

		sql = crtsql.selectSearchIdDvd(genreresult.size());
		table = crtsql.dbConnection(sql,"in",id);

		for(ArrayList<String> rec : table){
			Dvd dvd = new Dvd();

			dvd.setId(Integer.parseInt(rec.get(0)));
			dvd.setName(rec.get(1));
			dvdresult.add(dvd);
		}

		return dvdresult;
	}

	public List<Dvd> selectSearchActorDvd(String genreId) {
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

		List<String> actorresult = new ArrayList<>();

		CreateSQL crtsql = new CreateSQL();

		String sql = crtsql.selectSearchDvdActor();
		table = crtsql.dbConnection(sql,"select",genreId);

		for(ArrayList<String> rec : table){
			actorresult.add(rec.get(0));
		}

		String id = String.join(",",actorresult);

		List<Dvd> dvdresult = new ArrayList<>();

		crtsql = new CreateSQL();

		sql = crtsql.selectSearchIdDvd(actorresult.size());
		table = crtsql.dbConnection(sql,"in",id);

		for(ArrayList<String> rec : table){
			Dvd dvd = new Dvd();

			dvd.setId(Integer.parseInt(rec.get(0)));
			dvd.setName(rec.get(1));

			dvdresult.add(dvd);
		}

		return dvdresult;
	}
}

