/**********************************************
 Workshop 7
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 24 Mar 2023
 **********************************************/
package ws07;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * App 1
 */
public class App1 extends Application {
    /**
     * Constructor
     */
    public App1(){}
    public void start(Stage stage1) {
        Pane pane1 = new Pane();

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPrefWidth(410);
        comboBox.setPrefHeight(30);
        comboBox.setLayoutX(10);
        comboBox.setLayoutY(10);

        ObservableList<String> Addresses = FXCollections.observableArrayList(
                "Home Address", "Work Address", "Alternate Address");
        comboBox.setItems(Addresses);
        pane1.getChildren().add(comboBox);

        AddressPane contact = new AddressPane("CONTACT ADDRESS");
        contact.relocate(10,50);
        contact.setPrefSize(400, 180);
        pane1.getChildren().add(contact);
        stage1.setTitle("App 1");
        stage1.setScene(new Scene(pane1, 420,250));
        stage1.show();
    }

    /**
     * Main for App1 using AddressPane
     * @param args  args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
