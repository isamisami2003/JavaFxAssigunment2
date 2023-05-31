/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Accounts;
import Model.Accounts_1;
import Model.Users;
import View.ViewManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CreateAccountsController implements Initializable {

    @FXML
    private TextField CreationalDateTF;
    @FXML
    private Button saveNewUserBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField userIdTF;
    @FXML
    private TextField AccountNumberTF;
    @FXML
    private TextField UsernameTf;
    @FXML
    private TextField CurrancyTF;
    @FXML
    private TextField BalanceTF;
    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveNewUser(ActionEvent event) throws Exception {
        String UserIdText = userIdTF.getText();
        int UserId = Integer.parseInt(UserIdText);
        String AccountNumberText = AccountNumberTF.getText();
        int  AccountNumber= Integer.parseInt(AccountNumberText);
        String Username = UsernameTf.getText();        
        String Currancy = CurrancyTF.getText();
        String BalanceText = BalanceTF.getText();
        double  Balance= Double.parseDouble(BalanceText);
        String CreationalDate = CreationalDateTF.getText();
        
        Accounts U1= new Accounts(UserId,AccountNumber, Username,Currancy,Balance,CreationalDate);
        U1.save();
        
        ViewManager.adminPage.changeSceneToAccountsManagment();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Accounts inserted");
        alert.setContentText("Accounts inserted");
        alert.showAndWait();
    }

    @FXML
    private void cancelUserCreation(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToUsersManagment();

    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
        
    }
    
}
