/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import com.sun.org.glassfish.gmbal.Description;
import com.sun.deploy.association.utility.WinRegistryUtil;
import java.net.URL;
import java.time.LocalDate;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author Ahmad
 */
public class FXMLDocumentController implements Initializable {
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     DatePick.setValue(LocalDate.now());
    }    
    @FXML
    Button AddButton;
    @FXML
    TextField textField;
    @FXML
    DatePicker DatePick;
    @FXML
    ListView<LocalEvent> EventList;
    
    ObservableList<LocalEvent> list = FXCollections.observableArrayList();

    
    @FXML
    private void addEvent(Event e){
    list.add(new LocalEvent(DatePick.getValue(), textField.getText()));
    EventList.setItems(list);
    }
    
    public void refresh(){
        DatePick.setValue(LocalDate.now());
        textField.setText(null);
    }
}
