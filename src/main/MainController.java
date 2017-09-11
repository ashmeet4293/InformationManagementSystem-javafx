/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pckgcommon.Common;
import pckgdatabase.StudentDBUtils;

/**
 *
 * @author ashmeet
 */
public class MainController implements Initializable {

    private TextField txtIc;
    private Label txtNc;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pwPassword;
    @FXML
    private ComboBox<String> cmbUserType;
    
    Common common;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> userType = FXCollections.observableArrayList("Admin", "User");
        cmbUserType.setItems(userType);
//        cmbUserType.setItems(null);
    }

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {
        StudentDBUtils studentDBUtils = new StudentDBUtils();

        String userType = cmbUserType.getSelectionModel().getSelectedItem();
        if (userType.equals("Admin")) {
            if (studentDBUtils.loginAsAdmin(txtUsername.getText(), pwPassword.getText())) {
                System.out.println("Login Successfull");
                
                common=new Common();
                common.nextStage("/pckgadmin/AdminWindow.fxml", "Admin Window", true);
               
                Stage current = (Stage) txtUsername.getScene().getWindow();
                current.hide();

//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Login Message");
//                alert.setHeaderText("Login Succesfull");
//                alert.setContentText("You have Successfully logged in");
//                alert.showAndWait();
                
            } else {
                System.out.println("Login Failed");
            }
        } else {
            System.out.println("You are USer");
        }
    }

}
