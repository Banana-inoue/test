package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.DataBaseAcess;

public class Main {
	public static void main(String[] args) {
		
		// データベースにアクセスする機能を取得
		DataBaseAcess db = new DataBaseAcess();
		
		try {
			
			
			// データベースに接続
			db.open();
			
			// SELECT文を設定
			db.setSql("SELECT * FROM shohin");
			
			// SELECT文を実行
			ResultSet resultSet = db.select();
			
			// 実行結果を出力
			while(resultSet.next()) {
				System.out.println("ID：" + resultSet.getString("idno"));
				System.out.println("商品名：" + resultSet.getString("name"));
				System.out.println("区分：" + resultSet.getString("kbn"));
				System.out.println("単価：" + resultSet.getString("tanka"));
				System.out.println("登録日：" + resultSet.getString("torokubi"));
				
				// 改行
				System.out.println();
			}
			
			// データベース切断
			db.close();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
