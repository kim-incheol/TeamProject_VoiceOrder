
package tts_testt;

//���� ���� ���ǽ��� 
//SelectDB_all(table, 7);// �ν��Ͻ� ���� �� dbcreate �� ������ ���� Ʈ���� �ʱ�ȭ�� ó���� �ѹ� �� �����ؾ���
//�Լ� ����� �ƴ϶� ���������� �ؽ�, Ʈ������ �����ؼ� ������ �� �� ������ �� select,select_all ��ɾ ����ؼ� �����͸� �ʱ�ȭ�� �ѹ� ���� �� �־���Ѵ�.

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Iterator;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Db_order {
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

	// �ֹ���ȣ �ֹ��ð� �̸�(���̺��?) ī�װ� ��ǰ�� (�ֹ�)���� �ϷῩ�� �Ѱ���
	public void dbCreate_orderList(String table) { // �ֹ���ϵ����ͺ��̽� ���̺� ����(orderList)
		connect_DB();
		try {
			String query_create = "CREATE table " + table + "("
					+ "order_num int not null primary key auto_increment, order_time varchar(20),"
					+ " autoBot_name varchar(20), category varchar(20), product_name varchar(20), number_of_products int(11), order_result varchar(20), "
					+ "total_price int(15)" + ");";
			stmt.executeUpdate(query_create);
		} catch (Exception e) {
			connect = false;
			System.out.println("table ���� ����");
		}
	}

	// �ֹ���ȣ �ֹ��ð� �̸�(���̺��?) ī�װ� ��ǰ�� (�ֹ�)���� �ϷῩ�� �Ѱ���
	public void dbInsert_orderList(String table, String order_time, String autoBot_name, String category,
			String product_name, String number_of_products, String order_result, String total_price) {// inventory ���̺�
																										// �����Է�
		connect_DB();

		try {
			String query_insert = "INSERT INTO " + table + " VALUES(NULL,'" + order_time + "','" + autoBot_name + "','"
					+ category + "','" + product_name + "','" + number_of_products + "','" + order_result + "','"
					+ total_price + "');";
			stmt.executeUpdate(query_insert);
			SelectDB_all(table, 7);// Ʈ���� �ʱ�ȭ
		} catch (Exception e) {
			System.out.println("insert ����");
			connect = false;
		}
	}

	// ����Ʈ�� ���� ���� �ؽ��� ���� �ϱ�
	public void dbRemove_orderList(String table) { //dbUpdate_orderList�޼��带 ����success�� ����� ����Ʈ�� ã�Ƽ� ����
		connect_DB();
		try {
			stmt.executeUpdate("delete from " + table + " where order_result='success';");
			SelectDB_all(table, 7);// Ʈ���� �ʱ�ȭ
		} catch (Exception e) {
			System.out.println("��ǰ ���� ����");
			connect = false;
		}

	}

	public void dbRemove_orderList(String table, int order_num) { // �ֹ���ȣ �̿��ؼ� ����
		connect_DB();
		try {
			stmt.executeUpdate("delete from " + table + " where order_num=" + "'" + order_num + "';");
			SelectDB_all(table, 7);// Ʈ���� �ʱ�ȭ
		} catch (Exception e) {
			System.out.println("��ǰ ���� ����");
			connect = false;
		}

	}

	public void dbUpdate_orderList(String table, int order_num) { // �ֹ���ȣ�� ã�� �ֹ���ȣ�� �����ϸ� �ش� �ֹ���ȣ������ �Ϸ� ���� ����
		Boolean hash_B = false;
		connect_DB();

		hash_B = tree_list_all.containsKey(order_num);
		if (hash_B==false) {
			System.out.println("�ش� �ֹ���ȣ�� �����ϴ�.");
		}

		try {
			if (hash_B) {
				stmt.executeUpdate(
						"UPDATE " + table + " SET order_result='success' WHERE order_num= '" + order_num + "';");
				SelectDB_all(table, 7);// Ʈ���� �ʱ�ȭ
			}
		} catch (Exception e) {
			System.out.println("��ǰ ������Ʈ ����");
			connect = false;
		}

	}

	public TreeMap<Integer, String[]> SelectDB_all(String table, int number) // ������ ���̽� �� num�� ������ ������ ���� number�� �Է�(7)
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
//	        	 SelectDB_all(table, 7);//Ʈ���� �ʱ�ȭ
//	        	 String[] temp1;
//	        	 temp1 = tree_list_all.get(rs.getString(1));
//	        	 for(int i=0; i< temp1.length; i++)
//	             {
//	           	  System.out.println("tree_list_all,get " + 
//	            "key_value = " +rs.getString(1)+"  "+ temp1[i].toString());
//	             }
			}
		} catch (Exception e) {
			e.printStackTrace();
			connect = false;
		}
		return tree_list_all;
	}

	// order_list ��ü���
	public void SelectDB_all_sys(TreeMap<Integer, String[]> tree) {
		Iterator<Integer> keySetIterator = tree.keySet().iterator();
		while (keySetIterator.hasNext()) {
			Integer key = keySetIterator.next();
			System.out.print("key:" + key);
			for (int i = 0; i < 7; i++) {
				System.out.print("    " + tree.get(key)[i]);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {

//			Db_order db= new Db_order();
////			db.dbCreate_inventory("inventory");
////			db.dbInsert_inventory("inventory","coffee","iceAmericano","15");    //�μ�Ʈ�� ���� �ϳ� ����µ� �˾ƺ��� usessL����
//			TreeMap<String, String> map = new TreeMap<>();
//			TreeMap<String, String[]> map1 = new TreeMap<>();
//			map=db.SelectDB("inventory");
//			System.out.println(map.get("iceAmericano"));
//			map1=db.SelectDB_all("inventory",3);   //number_of_products ���� int������ �ٲ㵵 �������� ���� �ƴϸ� ���ʿ� int������ �ȹٲ㵵 �� ���ɼ��� ���� toint�̷��Լ��� ����ؼ�
////			db.dbRemove("inventory","nokcha"); 
//			db.dbUpdate("inventory","iceAmericano");

		// -------------------------------------------//
		Db_order db = new Db_order();
		   db.dbCreate_orderList("orderList");
			db.SelectDB_all("orderList", 7);
		   db.dbInsert_orderList("orderList","13:58","bixbee","bread","honey_bread","3","fail","20000");
		   db.dbInsert_orderList("orderList","14:58","ddd","bread","c","2","fail","31000");
		   db.dbInsert_orderList("orderList","14:58","ss","bread","a","1","fail","5000");
		   db.dbInsert_orderList("orderList","14:58","aa","bread","s","1","fail","2000");
		   db.dbInsert_orderList("orderList","14:58","aa","bread","d","1","fail","3000");
		   db.dbInsert_orderList("orderList","14:58","bbbee","bread","f","1","fail","1000");

		   db.dbUpdate_orderList("orderList",6);
			db.SelectDB_all_sys(tree_list_all);
		   db.dbRemove_orderList("orderList");
		   db.dbRemove_orderList("orderList",5);
		db.SelectDB_all_sys(tree_list_all);
	}
}
