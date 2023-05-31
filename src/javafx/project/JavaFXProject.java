/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.project;

import Controller.Admin.UsersJpaController;
import Model.User;
import Model.Users;
import View.RegisterPage;
import View.ViewManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Yahya
 */
public class JavaFXProject extends Application {
    
    @Override
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
       ViewManager.openRegisterPage();

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BankPu");
//        UsersJpaController userController=new UsersJpaController(emf);
//        Users U1= new Users(4,"ismail5", "ismail44", "ismail@", "male", "admin");
//        userController.create(U1);
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
