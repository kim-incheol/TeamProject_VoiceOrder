package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Menu_coffee implements Initializable {
    @FXML private Button back; //�ڷΰ���
    @FXML private Button americano;
    @FXML private Button latte;
    @FXML private Button caramel;
    @FXML private Button cappuccino;
    ObservableList<TableRowDataModel> myList;
    
    @FXML
    private TableView<TableRowDataModel> myTableView;
    @FXML
    private TableColumn<TableRowDataModel, String> product_name;
    @FXML
    private TableColumn<TableRowDataModel, String> product_price;
    @FXML
    private TableColumn<TableRowDataModel, String> product_num;
 
    
    
    // ���̺�信 ���� ������ ( ��ǰ��, ����, ���� )
    public void setOrderlist_Table(String name, String price, String num) {
    	myList = FXCollections.observableArrayList(
    			new TableRowDataModel(new SimpleStringProperty(name), new SimpleStringProperty(price), new SimpleStringProperty(num))
    			);
    }
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
    	setOrderlist_Table("�Ƹ޸�ī��","4500","1");
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