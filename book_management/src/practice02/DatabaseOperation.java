package practice02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseOperation  extends DatabaseManager{

	private ArrayList<ArrayList<String>> strResult = new ArrayList<ArrayList<String>>();

	public ArrayList<ArrayList<String>> dbConnection(String sql, String... conditions){
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//親メソッドでデータベース接続
			Connection con = super.getConnection();

			if(conditions[0].contentEquals("select")) {
				pstmt = con.prepareStatement(sql);
				System.out.println(conditions.length);
				if(conditions.length != 1) {
					for(int i =1; i < conditions.length; i++) {
						pstmt.setString(i, conditions[i]);
					}
				}
				//参照系SQL実行して値取得
				rs = pstmt.executeQuery();
				//ResultSetMetaDara使用
				ResultSetMetaData rsmt = rs.getMetaData();
				while(rs.next()) {
					ArrayList<String> rec = new ArrayList<String>();
					for(int i = 1; i <= rsmt.getColumnCount(); i++) {
						rec.add(rs.getString(i));
					}
					strResult.add(rec);
				}
			}
			else if(conditions[0].equals("insert")) {
				pstmt = con.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
				System.out.print(conditions.length);
				if(conditions.length != 1) {
					for(int  i = 1; i < conditions.length; i++) {
						pstmt.setString(i, conditions[i]);
					}
				}
				System.out.println(conditions[0]);
				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				ArrayList<String> rec = new ArrayList<String>();
				if(rs.next()) {
					rec.add(String.valueOf(rs.getInt(1)));
				}
				strResult.add(rec);
			}
			else if(conditions[0].contentEquals("update")){
				pstmt = con.prepareStatement(sql);
				System.out.println(conditions.length);
				if(conditions.length != 1) {
					for(int i = 1; i < conditions.length; i++) {
						pstmt.setString(i, conditions[i]);
					}
				}
				System.out.println(conditions[0]);
				pstmt.executeUpdate();
			}
			else if(conditions[0].equals("search")){
				pstmt = con.prepareStatement(sql);
				System.out.println(conditions.length);
				if(conditions.length != 1) {
					for(int i = 1; i < conditions.length; i++) {
						pstmt.setString(i,  "%" + conditions[i] + "%");
					}
				}
				//参照系SQL実行して値取得
				rs = pstmt.executeQuery();
				//ResultSetMetaDara使用
				ResultSetMetaData rsmt = rs.getMetaData();
				while(rs.next()) {
					ArrayList<String> rec = new ArrayList<String>();
					for(int i = 1; i <= rsmt.getColumnCount(); i++) {
						rec.add(rs.getString(i));
					}
					strResult.add(rec);
				}
			}
			else if(conditions[0].contentEquals("in")) {
				pstmt = con.prepareStatement(sql);
				System.out.println(conditions.length);
				String[] ids = conditions[1].split(",",0);
				System.out.println(Arrays.deepToString(ids));
				System.out.println("length" + ids.length);
				for(int i = 1; i < ids.length + 1; i++) {
					pstmt.setString(i,  ids[i - 1]);
				}
				//参照系SQL実行して値取得
				rs = pstmt.executeQuery();
				//ResultSetMetaDara使用
				ResultSetMetaData rsmt = rs.getMetaData();
				while(rs.next()) {
					ArrayList<String> rec = new ArrayList<String>();
					for(int i = 1; i <= rsmt.getColumnCount(); i++) {
						rec.add(rs.getString(i));
					}
					strResult.add(rec);
				}
			}
		}catch(SQLException e) {
			//コンソール出力
			System.out.println("SQLException" + e);
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					//コンソール出力
					System.out.println("ClassNotFoundException occured!");
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e){
					//コンソール出力
					System.out.println("SQLException occured!");
				}
			}
		}
		return strResult;
	}
}
