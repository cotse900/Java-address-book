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

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * AddressPane
 */
public class AddressPane extends Pane {
    /**
     * Address pane
     * @param title     title
     */
    public AddressPane(String title) {
        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color: aliceblue; -fx-border-color: black;");
        pane1.setPrefSize(410, 200);

        Label nameL = new Label("Name:");
        nameL.relocate(10, 20);
        nameL.setPrefSize(80, 30);
        Label streetL = new Label("Street:");
        streetL.relocate(10, 55);
        streetL.setPrefSize(80, 30);
        Label cityL = new Label("City:");
        cityL.relocate(10, 90);
        cityL.setPrefSize(80, 30);

        Label provinceL = new Label("Province:");
        provinceL.relocate(10, 125);
        provinceL.setPrefSize(80, 30);

        Label postalCodeL = new Label("Postal Code:");
        postalCodeL.relocate(10, 160);
        postalCodeL.setPrefSize(80, 30);
        //Home address
        TextField HomeNameField = new TextField("a");
        HomeNameField.relocate(100, 20);
        HomeNameField.setPrefSize(300, 30);

        TextField HomeStreetField = new TextField("b");
        HomeStreetField.relocate(100, 55);
        HomeStreetField.setPrefSize(300, 30);

        TextField HomeCityField = new TextField("c");
        HomeCityField.relocate(100, 90);
        HomeCityField.setPrefSize(300, 30);

        ComboBox<String> HomeProvinceField = new ComboBox<>();
        HomeProvinceField.getItems().addAll("Alberta", "British Columbia", "Manitoba", "New Brunswick",
                "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut",
                "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon");
        HomeProvinceField.relocate(100, 125);
        HomeProvinceField.setPrefSize(300, 30);

        TextField HomePostalField = new TextField("d");
        HomePostalField.relocate(100, 160);
        HomePostalField.setPrefSize(300, 30);

        pane1.getChildren().addAll
                (nameL, streetL, cityL, provinceL, postalCodeL,
                        HomeNameField, HomeStreetField, HomeCityField, HomeProvinceField, HomePostalField);

        Label Label6 = new Label();
        Label6.setText(title);
        Label6.setStyle("-fx-background-color: aliceblue;");
        getChildren().addAll(pane1, Label6);
    }

    /**
     * constructor
     */
    public AddressPane() {

    }
}
