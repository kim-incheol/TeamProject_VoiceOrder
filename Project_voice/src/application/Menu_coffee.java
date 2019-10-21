package application;

import java.awt.Window;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.*;


import javafx.application.Platform;
import com.example.speech.Recognize;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Menu_coffee implements Initializable {
    @FXML private Button back; //�ڷΰ���
    @FXML private Button americano;
    @FXML private Button latte;
    @FXML private Button caramel;
    @FXML private Button cappuccino;
    private ObservableList<TableRowDataModel> myList;
    
    @FXML
    private TableView<TableRowDataModel> myTableView;
    @FXML
    private TableColumn<TableRowDataModel, String> product_name;
    @FXML
    private TableColumn<TableRowDataModel, String> product_price;
    @FXML
    private TableColumn<TableRowDataModel, String> product_num;

    private Stack<Label> stack = new Stack<>();
    private Popup numPopup;
    private List<Popup> numPopList = new ArrayList<>();

    static int selectindex=0;

    
    // ���̺�信 ���� ������ ( ��ǰ��, ����, ���� )
    public void setOrderlist_Table(String name, String price, String num) {
		myList = FXCollections.observableArrayList(
    			new TableRowDataModel(new SimpleStringProperty(name), new SimpleStringProperty(price), new SimpleStringProperty(num))
    			);
    	selectindex++;
    }
    
    
    public void deleteRow(int selecteindex) {
    	if(selectindex>0) {
    		myList.remove(selecteindex);
        	selectindex--;
    	}
    }
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
    	if(myList==null) {System.out.println("myList"+"NULL");}
    	System.out.println("�ֱ���"+selectindex);
    	setOrderlist_Table("","","");
    	System.out.println("������"+selectindex);
    	product_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    	product_price.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
    	product_num.setCellValueFactory(cellData -> cellData.getValue().numProperty());
    	myTableView.setItems(myList);
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
    	try {
    		Stage stage = (Stage)americano.getScene().getWindow();
    		openNumPopup(stage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
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

    
    public void closeNumPopup(Button btn) {

        numPopup = (Popup)btn.getScene().getWindow(); // ��ư�� ���ؼ� ���� ���������� �˾Ƴ�
         numPopup.hide();

       System.out.println("���� �˾�â �ݱ�");
    }
    
    public void openNumPopup(Stage stage) {
        numPopup = new Popup();
        
        if(numPopup.isShowing()) {
           numPopup.hide();
        }else {
           Scene scene = stage.getScene();
           javafx.stage.Window window = scene.getWindow();
           
           numPopup.getContent().clear();
//           numPopList.add(numPopup);
           
           Parent numberboard = null;
           try {
              numberboard = FXMLLoader.load(getClass().getResource("numberboard.fxml"));
           } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
           }
//           stack.push(numPopup);
           
          numPopup.getContent().addAll(numberboard);
          numPopup.setAutoHide(true);
           
           Platform.runLater(new Runnable() {
             
             @Override
             public void run() {
                // TODO Auto-generated method stub
                numPopup.show(window);
             }
          });   
        }
     }

  //�����ν�
    public void VoiceRecoClick() {
    		RecoVoice();
    }
    
    public void RecoVoice(String... args) {
    	try {
			Recognize.sttstart(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
  

}

