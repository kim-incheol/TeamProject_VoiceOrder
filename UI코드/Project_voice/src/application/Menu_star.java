//��õ�޴�

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
 
public class Menu_star implements Initializable{
    @FXML private Button back; //�ڷΰ���
    @FXML private Button allmenu; //��ü�޴�
    @FXML private Button starmenu; //��õ�޴�
   
 
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
      	   Main = FXMLLoader.load(getClass().getResource("Choice.fxml"));
         } catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}
         Scene sc = new Scene(Main);
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
    
   
        

    }