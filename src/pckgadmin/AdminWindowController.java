/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgadmin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pckgcommon.Common;
import pckgdatabase.StudentDBUtils;
import pckgmodel.Student;

/**
 * FXML Controller class
 *
 * @author ashmeet
 */
public class AdminWindowController implements Initializable {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtSem;
    @FXML
    private TextField txtRoll;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    
    private Common common=new Common();
    @FXML
    private DatePicker dateDob;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private TableColumn<?, ?> colName;
    @FXML
    private TableColumn<?, ?> colAddress;
    @FXML
    private TableColumn<?, ?> colRoll;
    @FXML
    private TableColumn<?, ?> colUsername;
    @FXML
    private TableColumn<?, ?> colPassword;
    @FXML
    private TableColumn<?, ?> colRegDate;
    @FXML
    private TableColumn<?, ?> colDob;
    @FXML
    private TableColumn<?, ?> colSem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void hanldeSaveAction(ActionEvent event) {
          Student student=new Student();
          StudentDBUtils stundentDbUtils=new StudentDBUtils();
          
     
          
          
          student.setName(txtUsername.getText());
          student.setAddress(txtAddress.getText());
          student.setSem(Integer.parseInt(txtSem.getText()));
          student.setRoll(Integer.parseInt(txtRoll.getText()));
          student.setUsername(txtUsername.getText());
          student.setPassword(txtPassword.getText());
          student.setDob(dateDob.getEditor().getText());  //converting calendar value to string and setting in student object
          
          
          if(stundentDbUtils.createStudent(student)){
              System.out.println("Student Created");
              clear();
              common.alertMessage("INFORMATION", "Success", "Student Inserted", "Student Inserted into Database");
          }
          
          
    
    }

    @FXML
    private void handleUpdateAction(ActionEvent event) {
    }

    @FXML
    private void handleDeleteAction(ActionEvent event) {
    }

    @FXML
    private void handleNewAction(ActionEvent event) {
    }
    public void clear(){
        txtId.clear();
        txtUsername.clear();
        
        
    }
    
}
