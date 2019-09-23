package tts_testt;



//���� ���� ���ǽ��� 

//�ν��Ͻ� ���� ��  dbcreate �� ������ ����
//SelectDB(table);    
//SelectDB_all(table, 3);
//ó���� �� �ΰ� �� ����  (�ؽ�,Ʈ���� ��������)

//�Լ� ����� �ƴ϶� ���������� �ؽ�, Ʈ������ �����ؼ� ������ �� �� ������ �� select,select_all ��ɾ ����ؼ� �����͸� �ʱ�ȭ�� �ѹ� ���� �� �־���Ѵ�.

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Db_inven {
	   Connection conn=null;
	   Statement stmt=null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   Boolean connect=false;
//	   ArrayList<String> array_list= new ArrayList<String>();
	   static TreeMap<String, String> tree_list = new TreeMap<String, String>();
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


	   public void dbCreate_inventory(String table) {    //�����������ͺ��̽� ���̺� ����(inventory)
		   connect_DB();
		   try {
		         String query_create = "CREATE table "+table+"("
		            + "num int not null primary key auto_increment, category varchar(20),"
		            +" product_name varchar(20), number_of_products int(11)"+");";
		         stmt.executeUpdate(query_create);
		      }catch(Exception e){
		         connect=false;
		         System.out.println("table ���� ����");
		       }
		   }
	   
	   
	   public void dbInsert_inventory(String table, String category, String product_name, String number_of_products) {//inventory ���̺� �����Է�
		   connect_DB();
		   try {
		         String query_insert = "INSERT INTO "+table +" VALUES(NULL,'"+category+"','"+product_name+"','"+number_of_products+"');";
		         stmt.executeUpdate(query_insert);
		         SelectDB(table);    //�ؽ�,Ʈ���� ��������
		         SelectDB_all(table, 3);
		      }catch(Exception e){
		         System.out.println("insert ����");
		         connect=false;
		      }
		   }


	   
	   //����Ʈ�� ���� ���� �ؽ��� ���� �ϱ�
	   public void dbRemove_inventory(String table,String product_name) {
		   Boolean hash_B=false;
		   connect_DB();
		      try {
		    	  hash_B=tree_list.containsKey(product_name);
		    	  if(hash_B) {
		    		  System.out.println("�ش� ��ǰ���� �����մϴ�.");
		    	  }
		    	  else {
		    		  System.out.println("�ش� ��ǰ���� �����ϴ�.");
		    	  }
		      }catch(Exception e){
		    	  System.out.println(" �ش� ��ǰ���� ã�µ� �����Ͽ����ϴ�.");
		      }
		      try {
		    	  stmt.executeUpdate("delete from "+table+" where product_name="+"'"+product_name+"';");
			         SelectDB(table);    //�ؽ�,Ʈ���� ��������
			         SelectDB_all(table, 3);
		      }
		      catch(Exception e){
		    	  System.out.println("��ǰ ���� ����");
		    	  connect=false;
		      }
		   
	   }
	   
	   

	   //��� �߰��ϴ°� �Ű������޾Ƽ��߰�
	   public void dbUpdate_inventory(String table,String product_name,int num) { //���⼭ num�� ����߰�/������ ���� ����   
		   Boolean hash_B=false;
		   int update_num=0;
		   connect_DB();
		      try {
		    	  hash_B=tree_list.containsKey(product_name);
		    	  if(hash_B) {
		    		  String g=tree_list.get(product_name);     //��ǰ���Ȯ��
		    		  update_num=Integer.parseInt(g);
		    		  if(update_num>0) {
		    			update_num+=num;
		    		  }
		    		  else {
		    			  System.out.println("��ǰ ��� �����ϴ�");
		    			  hash_B=false;
		    		  }
		    		  if(update_num<0)
		    			  update_num=0;    //-���Ǹ� -������� ��ȯ�ص� ��������
		    	  }
		    	  else {
		    		  System.out.println("�ش� ��ǰ���� �����ϴ�.");
		    	  }
		      }catch(Exception e){
		    	  System.out.println(" ��ǰ���� ã�µ� �����Ͽ����ϴ�.");
		      }
		      try {
		    	  if(hash_B) {
		    		  stmt.executeUpdate("UPDATE "+table+" SET number_of_products='"+update_num+"' WHERE product_name= '"+product_name+"';");
				      SelectDB(table);    //�ؽ�,Ʈ���� ��������
				      SelectDB_all(table, 3);
		    	  }
		      }
		      catch(Exception e){
		    	  System.out.println("��ǰ ������Ʈ ����");
		    	  connect=false;
		      }
		   
		   
	   }
	   
	   public void dbUpdate_inventory(String table,String product_name) {    //��ǰ���� ã�Ƽ� �����ϸ� ���� �ϳ� ������ ������
		   Boolean hash_B=false;
		   int update_num=0;
		   connect_DB();
		      try {
		    	  hash_B=tree_list.containsKey(product_name);
		    	  if(hash_B) {
		    		  System.out.println("�ش� ��ǰ���� �����մϴ�.");
		    		  String g=tree_list.get(product_name);     //��ǰ���Ȯ��
		    		  update_num=Integer.parseInt(g);
		    		  if(update_num>0) {
		    			update_num--;  
		    		  }
		    		  else {
		    			  System.out.println("��ǰ ��� �����ϴ�");
		    			  hash_B=false;
		    		  }
		    	  }
		    	  else {
		    		  System.out.println("�ش� ��ǰ���� �����ϴ�.");
		    	  }
		      }catch(Exception e){
		    	  System.out.println(" ��ǰ���� ã�µ� �����Ͽ����ϴ�.");
		      }
		      try {
		    	  if(hash_B) {
		    		  System.out.println(update_num);
		    		  stmt.executeUpdate("UPDATE "+table+" SET number_of_products='"+update_num+"' WHERE product_name= '"+product_name+"';");
				      SelectDB(table);    //�ؽ�,Ʈ���� ��������
				      SelectDB_all(table, 3);
		    	  }
		      }
		      catch(Exception e){
		    	  System.out.println("��ǰ ������Ʈ ����");
		    	  connect=false;
		      }
		   
		   
	   }
	   
	   public TreeMap<String, String> SelectDB(String table)  //��ǰ �ϳ� �ϳ��� ���� ��� Ȯ��                        ////////Ű�� ��ǰ������ ��ȯ
	   {
		   connect_DB();
		   tree_list.keySet().removeAll(tree_list.keySet());  //Ʈ���� ��� �ʱ�ȭ
	      
	      try {
	         rs=stmt.executeQuery("SELECT * FROM "+table);
	   
	      } catch (SQLException e1) {
	         e1.printStackTrace();
	      }
	      try {
	         while(rs.next()) {
	            tree_list.put(rs.getString(3),rs.getString(4));
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	         connect=false;
	      }
	      return tree_list;
	   }
	   
	   public TreeMap<Integer, String[]> SelectDB_all(String table, int number)   //������ ���̽� �� num�� ������ ������ Į���Ǽ�  number�� �Է�(3)  //////////////Ű��: num ���� ��ȯ(db�� num)
	   {
		   connect_DB();
		   tree_list_all.keySet().removeAll(tree_list_all.keySet());  //Ʈ���� ��� �ʱ�ȭ
	      try {
	         rs=stmt.executeQuery("SELECT * FROM "+table);
	   
	      } catch (SQLException e1) {
	         e1.printStackTrace();
	      }
	      try {
	         while(rs.next()) {
	        	 String[] s_all = new String[number];
	        	 for(int i=0;i<number;i++) {
	        		 s_all[i]=rs.getString(i+2);
	        	 }
	        	 tree_list_all.put(rs.getInt(1),s_all);
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
	         connect=false;
	      }
	      return tree_list_all;
	   }
	   //order_list ��ü���
	   public void SelectDB_all_sys(TreeMap<Integer, String[]> tree){
		   Iterator<Integer> keySetIterator = tree.keySet().iterator();
		   while(keySetIterator.hasNext()) {
			   Integer key = keySetIterator.next();
			   System.out.print("key:"+key);
			   for(int i=0;i<3;i++) {
			   System.out.print("    "+tree.get(key)[i]);
			   }
			   System.out.println("\n");
		   }
	   }
	   public void SelectDB_sys(String product_name) {             //�ش� ��ǰ������ ��� ���
		   System.out.println(tree_list.get(product_name));   
	   }
	   
	   public static void main(String[] args) {
		   	
			Db_inven db= new Db_inven();
			db.SelectDB("inventory");    //�ؽ�,Ʈ���� ��������
			db.SelectDB_all("inventory", 3);
//			db.dbCreate_inventory("inventory");
//			db.dbInsert_inventory("inventory","coffee","iceAmericano","15");   
//			TreeMap<String, String> map = new TreeMap<>();
//			TreeMap<Integer, String[]> map1 = new TreeMap<>();
			db.dbUpdate_inventory("inventory","iceAmericano",+50);
//			map=db.SelectDB("inventory");
			db.SelectDB_sys("iceAmericano");
//			map1=db.SelectDB_all("inventory",3);   //number_of_products ���� int������ �ٲ㵵 �������� ���� �ƴϸ� ���ʿ� int������ �ȹٲ㵵 �� ���ɼ��� ���� toint�̷��Լ��� ����ؼ�
//			db.dbUpdate_inventory("inventory","iceAmericano");
			db.SelectDB_all_sys(tree_list_all);
	   }
	}

//usessL����