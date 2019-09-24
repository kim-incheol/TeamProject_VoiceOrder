package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Menu_coffee implements Initializable {
    @FXML private Button back; //�ڷΰ���
    @FXML private Button americano;
    @FXML private Button latte;
    @FXML private Button caramel;
    @FXML private Button cappuccino;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
 
    }
 
  //�ڷΰ���
    public void backClick() {

    	 Stage newStage = new Stage(); 
         Stage stage = (Stage)back.getScene().getWindow();
         Parent Main = null;
         try {
      	   Main = FXMLLoader.load(getClass().getResource("Menu.fxml"));
         } catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}
         Scene sc = new Scene(Main);
         stage.setScene(sc);
         stage.show();
           
        }
    
    public void americanoClick() {
    	System.out.println("�Ƹ޸�ī�� Ŭ��");
    }
    
    public void latteClick() {
    	System.out.println("�� Ŭ��");
    }
    
    public void caramelClick() {
    	System.out.println("ī��Ḷ���ƶ� Ŭ��");
    }
  
    
    public void cappuccinoClick() {
    	System.out.println("īǪġ�� Ŭ��");
    }
  
  

    }