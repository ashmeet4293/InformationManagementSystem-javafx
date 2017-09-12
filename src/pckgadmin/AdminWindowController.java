/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgadmin;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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

    private Common common = new Common();
    @FXML
    private DatePicker dateDob;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> colId;
    @FXML
    private TableColumn<Student, String> colName;
    @FXML
    private TableColumn<Student, String> colAddress;
    @FXML
    private TableColumn<Student, Integer> colRoll;
    @FXML
    private TableColumn<Student, String> colUsername;
    @FXML
    private TableColumn<Student, String> colPassword;
    @FXML
    private TableColumn<Student, Date> colRegDate;
    @FXML
    private TableColumn<Student, String> colDob;
    @FXML
    private TableColumn<Student, Integer> colSem;
    @FXML
    private Button btnLoad;
    private StudentDBUtils stundentDbUtils;
    private Student student;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void hanldeSaveAction(ActionEvent event) {
        student = new Student();
        stundentDbUtils = new StudentDBUtils();

        student.setName(txtUsername.getText());
        student.setAddress(txtAddress.getText());
        student.setSem(Integer.parseInt(txtSem.getText()));
        student.setRoll(Integer.parseInt(txtRoll.getText()));
        student.setUsername(txtUsername.getText());
        student.setPassword(txtPassword.getText());
        student.setDob(dateDob.getEditor().getText());  //converting calendar value to string and setting in student object

        if (stundentDbUtils.createStudent(student)) {
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

    public void clear() {
        txtId.clear();
        txtUsername.clear();

    }

    @FXML
    private void handleLoadAction(ActionEvent event) {
        student = new Student();
        stundentDbUtils = new StudentDBUtils();
        ObservableList<Student> data;

        if ((data = stundentDbUtils.fetchData()) != null) {
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colSem.setCellValueFactory(new PropertyValueFactory<>("sem"));
            colRoll.setCellValueFactory(new PropertyValueFactory<>("roll"));
            colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
            colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
            colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
            colRegDate.setCellValueFactory(new PropertyValueFactory<>("regDate"));

            tableView.setItems(data);

        }
    }

    @FXML
    private void handleMousePressedAction(MouseEvent event) {
        showTableData() ;// dateDob.set
    }

    private void showTableData() {
        Student stdnt = (Student) tableView.getSelectionModel().getSelectedItem();

        txtId.setText("" + stdnt.getId());
        txtName.setText(stdnt.getName());
        txtAddress.setText(stdnt.getAddress());
        txtSem.setText("" + stdnt.getSem());
        txtRoll.setText("" + stdnt.getRoll());
        txtUsername.setText(stdnt.getUsername());
        txtPassword.setText(stdnt.getPassword());
    }

    @FXML
    private void handleTableKeyPressedAction(KeyEvent event) {
        showTableData();
    }

}
