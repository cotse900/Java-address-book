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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * App 2
 */
public class App2 extends Application {
    /**
     * Constructor
     */
    public App2(){}
    private Button addButton;
    private Button removeButton;

    //private Address address = new Address();

    public void start(Stage stage2) {
        //setup
        Pane pane2 = new Pane();
        pane2.setPrefSize(590, 450);

        ListView<String> listView = new ListView<>();
        listView.relocate(10, 10);
        listView.setPrefSize(150, 420);
        ObservableList<String> items = FXCollections.observableArrayList
                ("Bob E. Pins", "Sunny Day", "Jen Tull",
                        "Bea Keeper", "Ivona Pass");
        listView.setItems(items);
        pane2.getChildren().add(listView);
        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                removeButton.setDisable(false);
            }
        });

        VBox formBox = new VBox(10);
        formBox.setAlignment(Pos.TOP_CENTER);
        formBox.relocate(170, 10);
        formBox.setPrefSize(410, 420);

        AddressPane homeAddress = new AddressPane("HOME ADDRESS");
        homeAddress.relocate(170, 10);
        pane2.getChildren().add(homeAddress);

        AddressPane alternateAddress = new AddressPane("ALTERNATE ADDRESS");
        alternateAddress.relocate(170, 230);
        pane2.getChildren().add(alternateAddress);

        addButton = new Button("Add");
        addButton.relocate(200, 420);
        addButton.setDefaultButton(true);
        pane2.getChildren().add(addButton);

        removeButton = new Button("Remove");
        removeButton.relocate(250, 420);
        removeButton.setDisable(true);
        removeButton.getStyleClass().add("remove-button");
        pane2.getChildren().add(removeButton);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPrefSize(480, 50);

        formBox.getChildren().addAll(homeAddress, alternateAddress, buttonBox);
        pane2.getChildren().add(formBox);
        stage2.setTitle("App 2");
        stage2.setScene(new Scene(pane2, 590, 480));
        stage2.show();

        //the meat is here
        addButton.setOnAction(e -> {
        });

        removeButton.setOnAction(e -> {

        });
    }

    /**
     * Main for App2 using AddressPane
     * @param args  args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
