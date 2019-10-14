//�޴�

package application;
 
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AmbientLight;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
 
public class Menu implements Initializable{
    @FXML private Button back; //�ڷΰ����ư
    @FXML private Button allmenu; //��ü�޴�
    @FXML private Button starmenu; //��õ�޴�
    @FXML private Button coffee;
    @FXML private Button juice;
    @FXML private Button desert;
    
    
    
//    @FXML private Button americano; 
//    @FXML private Button latte; 
//    @FXML private Button jamong;
//    @FXML private Button lemon;
//    @FXML private Button smoothie;
//    @FXML private Button choco;
//    @FXML private Button bread;
//    @FXML private Button cake;
//    
// 
//    static ArrayList<String> mArray = new ArrayList<>();
//    
//    static String menu_americano;
//    static String menu_latte;
//    static String menu_jamong;
//    static String menu_lemon;
//    static String menu_smoothie;
//    static String menu_choco;
//    static String menu_bread;
//    static String menu_cake;
    
   
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
 
    }
 
    //�ڷΰ���
    public void backClick() {

    	 Stage newStage = new Stage(); //�ڷΰ���
         Stage stage = (Stage)back.getScene().getWindow();
         Parent Main = null;
         try {
      	   Main = FXMLLoader.load(getClass().getResource("Choice.fxml"));
         } catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}
         Scene sc = new Scene(Main); //�ڷΰ���
         stage.setScene(sc);
         stage.show();
           
        }
    
    //��ü�޴�
    
    public void allmenuClick() {

      	 Stage newStage1 = new Stage(); 
           Stage stage1 = (Stage)allmenu.getScene().getWindow();
           Parent allMenu = null;
           try {
           	allMenu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
           } catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		}
           Scene sc1 = new Scene(allMenu); 
           stage1.setScene(sc1);
           stage1.show();
           System.out.println("��ü�޴�Ŭ��");
             
          }
    
    //��õ�޴�
    public void starmenuClick() {

    	 Stage newStage2 = new Stage(); 
         Stage stage2 = (Stage)starmenu.getScene().getWindow();
         Parent Menu_star = null;
         try {
        	 Menu_star = FXMLLoader.load(getClass().getResource("Menu_star.fxml"));
         } catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}
         Scene sc2 = new Scene(Menu_star); 
         stage2.setScene(sc2);
         stage2.show();
         System.out.println("��õ�޴�Ŭ��");
        }
    
    //Ŀ��Ŭ��
    public void coffeeClick() {

   	 Stage newStage3 = new Stage(); 
        Stage stage3 = (Stage)coffee.getScene().getWindow();
        Parent Menu_coffee = null;
        try {
        	Menu_coffee = FXMLLoader.load(getClass().getResource("Menu_coffee.fxml"));
        } catch (IOException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 		}
        Scene sc3 = new Scene(Menu_coffee); 
        stage3.setScene(sc3);
        stage3.show();
        System.out.println("Ŀ�Ǹ޴�Ŭ��");
       }
    
    //�ֽ�Ŭ��
    public void juiceClick() {

   	 Stage newStage4 = new Stage(); 
        Stage stage4 = (Stage)juice.getScene().getWindow();
        Parent Menu_juice = null;
        try {
        	Menu_juice = FXMLLoader.load(getClass().getResource("Menu_juice.fxml"));
        } catch (IOException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 		}
        Scene sc4 = new Scene(Menu_juice); 
        stage4.setScene(sc4);
        stage4.show();
        System.out.println("�ֽ��޴�Ŭ��");
       }
    
    //����ƮŬ��
    public void desertClick() {

   	 Stage newStage5 = new Stage(); 
        Stage stage5 = (Stage)desert.getScene().getWindow();
        Parent Menu_desert = null;
        try {
        	Menu_desert = FXMLLoader.load(getClass().getResource("Menu_desert.fxml"));
        } catch (IOException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 		}
        Scene sc5 = new Scene(Menu_desert); 
        stage5.setScene(sc5);
        stage5.show();
        System.out.println("����Ʈ�޴�Ŭ��");
       }
    

    
    
    
//    public void americanoClick() {
//    	//menu_americano=americano.getText().toString();
//    	JOptionPane.showMessageDialog(null, "�Ƹ޸�ī�밡 �ֹ��Ǿ����ϴ�.");
//    	americano.setText("�Ƹ޸�ī��");
//    	menu_americano=americano.getText().toString();
//    	
//    	mArray.add(menu_americano);
//        System.out.println("�޴� : "+ menu_americano);
//       }
//    
//    
//    
//    public void latteClick() {
//    	JOptionPane.showMessageDialog(null, "ī��󶼰� �ֹ��Ǿ����ϴ�.");
//    	latte.setText("ī���");
//    	menu_latte=latte.getText().toString();
//    	mArray.add(menu_latte);
//        System.out.println("�޴� : "+menu_latte);
//       }
//    
//    public void jamongClick() {
//    	JOptionPane.showMessageDialog(null, "�ڸ����̵尡 �ֹ��Ǿ����ϴ�.");
//    	jamong.setText("�ڸ����̵�");
//    	menu_jamong=jamong.getText().toString();
//    	mArray.add(menu_jamong);
//        System.out.println("�޴� : "+menu_jamong);
//       }
//    
//    public void lemonClick() {
//    	JOptionPane.showMessageDialog(null, "�����̵尡 �ֹ��Ǿ����ϴ�.");
//    	lemon.setText("�����̵�");
//    	menu_lemon=lemon.getText().toString();
//    	mArray.add(menu_lemon);
//        System.out.println("�޴� : "+menu_lemon);
//       }
//    
//    public void smoothieClick() {
//    	JOptionPane.showMessageDialog(null, "������ �ֹ��Ǿ����ϴ�.");
//    	smoothie.setText("������");
//    	menu_smoothie=smoothie.getText().toString();
//    	mArray.add(menu_smoothie);
//        System.out.println("�޴� : "+menu_smoothie);
//       }
//    
//    public void chocoClick() {
//    	JOptionPane.showMessageDialog(null, "���������䰡 �ֹ��Ǿ����ϴ�.");
//    	choco.setText("����������");
//    	menu_choco=choco.getText().toString();
//    	mArray.add(menu_choco);
//        System.out.println("�޴� : "+menu_choco);
//       }
//    
//    public void breadClick() {
//    	JOptionPane.showMessageDialog(null, "��Ϻ극�尡 �ֹ��Ǿ����ϴ�.");
//    	bread.setText("��Ϻ극��");
//    	menu_bread=bread.getText().toString();
//    	mArray.add(menu_bread);
//        System.out.println("�޴� : "+menu_bread);
//       }
//    
//    public void cakeClick() {
//    	JOptionPane.showMessageDialog(null, "����ũ�� �ֹ��Ǿ����ϴ�.");
//    	cake.setText("����ũ");
//    	menu_cake=cake.getText().toString();
//    	mArray.add(menu_cake);
//        System.out.println("�޴� : "+menu_cake);
//       }

        

    }

