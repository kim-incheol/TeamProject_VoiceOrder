//�ֹ�������

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
 
public class Orderlist implements Initializable{
    @FXML private Button back;//�ڷΰ���
   
 
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
    
    
    public void payClick() {

    	System.out.println("�����Ϸ�");
//   	 Stage newStage = new Stage(); //�ڷΰ���
//        Stage stage = (Stage)back.getScene().getWindow();
//        Parent Main = null;
//        try {
//     	   Main = FXMLLoader.load(getClass().getResource("Choice.fxml"));
//        } catch (IOException e) {
// 		// TODO Auto-generated catch block
// 		e.printStackTrace();
// 		}
//        Scene sc = new Scene(Main); //�ڷΰ���
//        stage.setScene(sc);
//        stage.show();
          
       }
        

    }

