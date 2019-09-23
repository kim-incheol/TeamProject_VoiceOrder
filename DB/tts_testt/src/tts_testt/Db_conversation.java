package tts_testt;

//SelectDB_all(table, 2);// �ν��Ͻ� ���� �� dbcreate �� ������ ����  Ʈ���� �ʱ�ȭ�� ó���� �ѹ� �� �����ؾ���
//�Լ� ����� �ƴ϶� ���������� �ؽ�, Ʈ������ �����ؼ� ������ �� �� ������ �� select,select_all ��ɾ ����ؼ� �����͸� �ʱ�ȭ�� �ѹ� ���� �� �־���Ѵ�.

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.TreeMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Db_conversation {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Boolean connect = false;
	static TreeMap<Integer, String[]> tree_list_all = new TreeMap<>();
	
	public void connect_DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe_manager?useSSL=false",
					"root", "sylphide1");
		} catch (Exception k) {
			System.out.println("���� ����");
		}
		try {
			connect = true;
			stmt = (Statement) conn.createStatement();
		} catch (Exception e) {
			System.out.println("����Ȯ������");
		}
		
	}
	
	public void dbCreate_conv(String table) {
		connect_DB();
		try {
			String query_create = "CREATE table " + table + "(" + "num int not null primary key auto_increment, "+"compare_string varchar(20), output_string varchar(20)"
					+ ");";
			stmt.executeUpdate(query_create);
			System.out.println("table ���� �Ϸ�");
		} catch (Exception e) {
			connect = false;
			System.out.println("table ���� ����");
		}
	}

	public void dbInsert_conv(String table, String compare_string, String output_string) {// inventory ���̺�
		// �����Է�
		connect_DB();

		try {
			String query_insert = "INSERT INTO " + table + " VALUES(NULL,'" + compare_string + "','" + output_string+ "');";
			stmt.executeUpdate(query_insert);
			SelectDB_all(table, 2);// Ʈ���� �ʱ�ȭ
		} catch (Exception e) {
			System.out.println("insert ����");
			connect = false;
		}
	}
	public void dbInsert_conv(String table,int num, String compare_string, String output_string) {// inventory ���̺�
		// �����Է�
		connect_DB();

		try {
			String query_insert = "INSERT INTO " + table + " VALUES("+num+",'" + compare_string + "','" + output_string+ "');";
			stmt.executeUpdate(query_insert);
			SelectDB_all(table, 2);// Ʈ���� �ʱ�ȭ
		} catch (Exception e) {
			System.out.println("insert ����");
			connect = false;
		}
	}
	
	
	public void dbRemove_conv(String table, int num) { // �ֹ���ȣ �̿��ؼ� ����
		connect_DB();
		try {
			stmt.executeUpdate("delete from " + table + " where num=" + "'" + num + "';");
			SelectDB_all(table, 2);// Ʈ���� �ʱ�ȭ
		} catch (Exception e) {
			System.out.println("��ǰ ���� ����");
			connect = false;
		}

	}
	

	public TreeMap<Integer, String[]> SelectDB_all(String table,int number)// ������ ���̽� �� num�� ������ ������ ���� number�� �Է�(2)
	// //////////////Ű��: num ���� ��ȯ
	{
		
		connect_DB();
		tree_list_all.keySet().removeAll(tree_list_all.keySet());  //Ʈ���� ��� �ʱ�ȭ
		try {
			rs = stmt.executeQuery("SELECT * FROM " + table);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			while (rs.next()) {
					String[] s_all = new String[number];
					for (int i = 0; i < number; i++) {
						s_all[i] = rs.getString(i + 2);
					}
					tree_list_all.put(rs.getInt(1), s_all);
				}
		} catch (Exception e) {
			e.printStackTrace();
			connect = false;
		}
		return tree_list_all;
	}
	
	public void conv(TreeMap<Integer, String[]> tree,String input_string) {
		Iterator<Integer> itr = tree.keySet().iterator();
		while(itr.hasNext()) {
			int key = itr.next();
			String compare_string=tree.get(key)[0];
			String output_string=tree.get(key)[1];
//			System.out.println(compare_string);
//			System.out.println(output_string); 
			if(input_string.equals(compare_string)) {
				System.out.println(output_string);
			};
		}
	}
	
	public void SelectDB_all_sys(TreeMap<Integer,String[]> tree) {
		Iterator<Integer> itr = tree.keySet().iterator();
		while(itr.hasNext()) {
			int key=itr.next();
			System.out.println("key:"+ key);
			System.out.println("   "+ tree.get(key)[0]+"  "+tree.get(key)[1]);
			System.out.println("\n");
		}
	}


	public static void main(String[] args) {
		Db_conversation db = new Db_conversation();
//		db.dbCreate_conv("conversation");
//		db.dbInsert_conv("conversation", "����", "���� õ���� ��ǳ���Ǻ����ϴ�");
//		db.dbInsert_conv("conversation", "����", "����2");
//		db.dbInsert_conv("conversation", "����", "����3");
//		db.dbRemove_conv("conversation", 2);
//		System.out.println("\n\n\n\n");
		db.SelectDB_all("conversation",2);
		db.SelectDB_all_sys(tree_list_all);
		db.conv(tree_list_all, "����");
//		db.conv(map, "����");
		
		// TODO Auto-generated method stub

	}

}
