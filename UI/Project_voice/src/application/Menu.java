//메뉴

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
 
public class Menu implements Initializable{
    @FXML private Button back; //뒤로가기버튼
    @FXML private Button allmenu; //전체메뉴
    @FXML private Button starmenu; //추천메뉴
   
   
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
 
    }
 
    //뒤로가기
    public void backClick() {

    	 Stage newStage = new Stage(); //뒤로가기
         Stage stage = (Stage)back.getScene().getWindow();
         Parent Main = null;
         try {
      	   Main = FXMLLoader.load(getClass().getResource("Choice.fxml"));
         } catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		}
         Scene sc = new Scene(Main); //뒤로가기
         stage.setScene(sc);
         stage.show();
           
        }
    
    //전체메누
    
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
           System.out.println("전체메뉴클릭");
             
          }
    
    //추천메뉴
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
         System.out.println("추천메뉴클릭");
        }
    
    public void americanoClick() {

        System.out.println("아메리카노메뉴클릭");
       }
    
    
    public void latteClick() {

        System.out.println("라떼메뉴클릭");
       }
    
    public void jamongClick() {

        System.out.println("자몽에이드메뉴클릭");
       }
    
    public void lemonClick() {

        System.out.println("레몬에이드메뉴클릭");
       }
    
    public void smoothieClick() {

        System.out.println("스무디메뉴클릭");
       }
    
    public void chocoClick() {

        System.out.println("초코메뉴클릭");
       }
    
    public void breadClick() {

        System.out.println("허니브레드메뉴클릭");
       }
    
    public void cakeClick() {

        System.out.println("케이크메뉴클릭");
       }

        

    }

