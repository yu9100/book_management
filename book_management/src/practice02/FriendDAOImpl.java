package practice02;

import java.util.ArrayList;
import java.util.List;

import beans.Friend;

public class FriendDAOImpl implements FriendDAO{

	public List<Friend> selectFriend(){

		//String型の配列
		ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

		//検索結果用
		List<Friend> result = new ArrayList<Friend>();

		//データベース接続、データ取得
		CreateSQL ctrsql = new CreateSQL();

		String sql =  ctrsql.selectFrend();
		table = ctrsql.dbConnection(sql,"select");

		//String型配列からデータを取り出す
		for(ArrayList<String> rec : table) {
			Friend friend = new Friend();

			friend.setId(Integer.parseInt(rec.get(0)));
			friend.setName(rec.get(1));
			friend.setMail(rec.get(2));

			result.add(friend);
		}
		return result;
	}

	public void insertFriend(String name, String mail) {
		CreateSQL ctrsql = new CreateSQL();
		String sql = ctrsql.insertFrend();
		ctrsql.dbConnection(sql, "insert", name, mail);
	}
}
