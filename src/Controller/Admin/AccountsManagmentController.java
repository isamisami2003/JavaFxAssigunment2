/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;


import Model.Accounts;
import Model.User;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yahya
 */
public class AccountsManagmentController implements Initializable {
    
    public static Accounts selectedAccountsToUpdate;
    public static Stage updateStage;

    @FXML
    private TableView<Accounts> AccountTableView;

    @FXML
    private TableColumn<Accounts, Double> BalanceCol;

    @FXML
    private TableColumn<Accounts, String> CreationCol;

    @FXML
    private TableColumn<Accounts, String> CurrancyCol;

    @FXML
    private TableColumn<Accounts, Integer> NumCol;

    @FXML
    private TableColumn<Accounts, Integer> UserCol;

    @FXML
    private TextField accontSearchTF;

    @FXML
    private Button accountsPageBtn;

    @FXML
    private Button createNewAccountrBtn;

    @FXML
    private Button deleteSelectedAccountBtn;

    @FXML
    private TableColumn<Accounts, Integer> idCol;

    @FXML
    private Button operationsPageBtn;

    @FXML
    private Button searchAccountBtn;

    @FXML
    private Button showAllAccountsBtn;

    @FXML
    private Button updateSelectedAccountBtn;

    @FXML
    private Button usersManagmentPageBtn;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idCol.setCellValueFactory(new PropertyValueFactory("userId"));
        NumCol.setCellValueFactory(new PropertyValueFactory("AccountNumber"));
        UserCol.setCellValueFactory(new PropertyValueFactory("username"));
        CreationCol.setCellValueFactory(new PropertyValueFactory("creationDate"));
        CurrancyCol.setCellValueFactory(new PropertyValueFactory("balance"));
        BalanceCol.setCellValueFactory(new PropertyValueFactory("gender"));
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

    @FXML
    private void showAccountCreationPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToCreatAccount();
    }

    @FXML
    private void showAllAccounts(ActionEvent event) throws ClassNotFoundException, SQLException {
      ObservableList<Accounts> AccountsList = FXCollections.observableArrayList(Accounts.getAllUsers());
      AccountTableView.setItems(AccountsList);  
    }

    @FXML
    private void updateSelectedAccount(ActionEvent event) throws IOException{
        if(AccountTableView.getSelectionModel().getSelectedItem() != null){
        selectedAccountsToUpdate = AccountTableView.getSelectionModel().getSelectedItem();
        FXMLLoader loaderUpdate = new FXMLLoader(getClass().getResource("/View/AdminFXML/UpdateAccountsPage.fxml"));
        Parent rootUpdate = loaderUpdate.load();     
        Scene updateUserScene = new Scene(rootUpdate); 
        updateStage = new Stage();
        updateStage.setScene(updateUserScene);
        updateStage.setTitle("Update Accounts " + selectedAccountsToUpdate.getUsername() );
        updateStage.show();
    }  
}
    
    @FXML
    private void deleteSelectedAccount(ActionEvent event) {
        if(AccountTableView.getSelectionModel().getSelectedItem() != null){
            Accounts selectedUser = AccountTableView.getSelectionModel().getSelectedItem();
            Alert deleteConfirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteConfirmAlert.setTitle("User delete");
            deleteConfirmAlert.setContentText("Are you sure to delete this user ?");
            deleteConfirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    selectedUser.delete();
                } catch (SQLException ex) {
                    Logger.getLogger(UsersManagmentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UsersManagmentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            Alert deletedSuccessAlert = new Alert(Alert.AlertType.INFORMATION);
            deletedSuccessAlert.setTitle("User deleted");
            deletedSuccessAlert.setContentText("User deleted");
            deletedSuccessAlert.show();  
            }
            });
        
        }else{
        Alert warnAlert = new Alert(Alert.AlertType.WARNING);
        warnAlert.setTitle("Select an user");
        warnAlert.setContentText("Please select an user from the table view");
        warnAlert.show();  
    }
   }
}

