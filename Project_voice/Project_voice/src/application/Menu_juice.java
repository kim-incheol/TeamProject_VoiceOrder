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
 
public class Menu_juice implements Initializable{
    @FXML private Button back; //�ڷΰ���

 
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
    
    public void jamongClick() {
    	System.out.println("�ڸ����̵� Ŭ��");
    }
    
    public void lemonClick() {
    	System.out.println("�����̵� Ŭ��");
    }
    
    public void blueberryClick() {
    	System.out.println("��纣�������� Ŭ��");
    }
  
    
    public void mangoClick() {
    	System.out.println("�������� Ŭ��");
    }
  

    }