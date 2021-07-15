package practice02;

import java.util.ArrayList;
import java.util.List;

import beans.Actor;

public class ActorDAOImpl implements ActorDAO{

	public List<Actor> selectActor(){
		//String型の配列
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		//検索結果用
		List<Actor> result = new ArrayList<Actor>();
		//データベース接続、データ取得
		CreateSQL ctrsql = new CreateSQL();
		String sql =  ctrsql.selectActor();
		table = ctrsql.dbConnection(sql, "select");

		//String型配列からデータを取り出す
		for(ArrayList<String> rec : table) {
			Actor actor = new Actor();
			actor.setId(Integer.parseInt(rec.get(0)));
			actor.setName(rec.get(1));
			result.add(actor);
		}
		return result;
	}
	public void insertActor(String name) {
		CreateSQL ctrsql = new CreateSQL();
		String sql = ctrsql.insertActor();
		ctrsql.dbConnection(sql, "insert", name);
	}
	public List<Actor> selectDvdActor(){
		//String型の配列
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
		//検索結果用
		List<Actor> result = new ArrayList<Actor>();
		//データベース接続、データ取得
		CreateSQL ctrsql = new CreateSQL();
		String sql =  ctrsql.selectDvdActor();
		table = ctrsql.dbConnection(sql, "select");

		//String型配列からデータを取り出す
		for(ArrayList<String> rec : table) {
			Actor actor = new Actor();
			actor.setId(Integer.parseInt(rec.get(0)));
			actor.setName(rec.get(1));
			result.add(actor);
		}
		return result;
	}
}
