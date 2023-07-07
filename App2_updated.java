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
package ws07_updated;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.Optional;


/**
 * App2 but with working address book
 */
public class App2_updated extends Application {
    /**
     * Constructor
     */
    public App2_updated(){}
    private final Address address = new Address();

    public void start(Stage stage2) {
        //pane1
        GridPane pane1 = new GridPane();
        pane1.setStyle("-fx-background-color: aliceblue; -fx-border-color: black;");
        //larger than original AddressPane
        pane1.setPrefSize(590, 450);
        pane1.setHgap(10);
        pane1.setVgap(10);
        pane1.setPadding(new Insets(10, 10, 10, 10));

        pane1.getColumnConstraints().addAll(
                //entirely revamped to display properly
                new ColumnConstraints(150),//listView
                new ColumnConstraints(5),//padding
                new ColumnConstraints(80),//address labels
                new ColumnConstraints(280),//address textfields
                new ColumnConstraints(5),//padding
                new ColumnConstraints(5)//padding
        );

        pane1.setAlignment(Pos.CENTER_LEFT);
        stage2.setTitle("App 2");
        //larger than original app2
        //v1: scene or entire window height
        stage2.setScene(new Scene(pane1, 590, 620));
        stage2.show();

        // Add labels and fields for home address

        //column1, row0, column span3, row span6
        BorderPane borderPane = new BorderPane();
        pane1.add(borderPane, 1, 0, 4, 6);
        borderPane.setPrefSize(500, 300);
        borderPane.setStyle("-fx-border-color: gray; -fx-border-width: 1px;");

        Label homeAddressLabel = new Label("Home Address");
        homeAddressLabel.setStyle("-fx-font-weight: bold");
        pane1.add(homeAddressLabel, 2, 0, 4, 1);
        GridPane.setValignment(homeAddressLabel, VPos.TOP);

        Label homeNameLabel = new Label("Name:");
        TextField homeNameField = new TextField();
        pane1.add(homeNameLabel, 2, 1);
        pane1.add(homeNameField, 3, 1);

        Label homeStreetLabel = new Label("Street:");
        TextField homeStreetField = new TextField();
        pane1.add(homeStreetLabel, 2, 2);
        pane1.add(homeStreetField, 3, 2);

        Label homeCityLabel = new Label("City:");
        TextField homeCityField = new TextField();
        pane1.add(homeCityLabel, 2, 3);
        pane1.add(homeCityField, 3, 3);

        Label homeProvinceLabel = new Label("Province:");
        ComboBox<String> homeProvinceField = new ComboBox<>();
        homeProvinceField.getItems().addAll("Unspecified", "Alberta", "British Columbia", "Manitoba",
                "New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut",
                "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon", "Outside Canada");
        homeProvinceField.getSelectionModel().selectFirst();
        pane1.add(homeProvinceLabel, 2, 4);
        pane1.add(homeProvinceField, 3, 4);

        Label homePostalLabel = new Label("Postal Code:");
        TextField homePostalField = new TextField();
        pane1.add(homePostalLabel, 2, 5);
        pane1.add(homePostalField, 3, 5);

        // Add labels and fields for alternate address

        BorderPane borderPane2 = new BorderPane();
        pane1.add(borderPane2, 1, 6, 4, 6);
        borderPane2.setPrefSize(500, 300);
        borderPane2.setStyle("-fx-border-color: gray; -fx-border-width: 1px;");

        Label altAddressLabel = new Label("Alternate Address");
        altAddressLabel.setStyle("-fx-font-weight: bold");
        pane1.add(altAddressLabel, 2, 6, 2, 1);
        GridPane.setValignment(altAddressLabel, VPos.TOP);

        Label alternateNameLabel = new Label("Name:");
        TextField alternateNameField = new TextField();
        pane1.add(alternateNameLabel, 2, 7);
        pane1.add(alternateNameField, 3, 7);

        Label alternateStreetLabel = new Label("Street:");
        TextField alternateStreetField = new TextField();
        pane1.add(alternateStreetLabel, 2, 8);
        pane1.add(alternateStreetField, 3, 8);

        Label alternateCityLabel = new Label("City:");
        TextField alternateCityField = new TextField();
        pane1.add(alternateCityLabel, 2, 9);
        pane1.add(alternateCityField, 3, 9);

        Label alternateProvinceLabel = new Label("Province:");
        ComboBox<String> alternateProvinceField = new ComboBox<>();
        alternateProvinceField.getItems().addAll("Unspecified", "Alberta", "British Columbia", "Manitoba",
                "New Brunswick", "Newfoundland and Labrador", "Northwest Territories", "Nova Scotia", "Nunavut",
                "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Yukon", "Outside Canada");
        alternateProvinceField.getSelectionModel().selectFirst();
        pane1.add(alternateProvinceLabel, 2, 10);
        pane1.add(alternateProvinceField, 3, 10);

        Label alternatePostalLabel = new Label("Postal Code:");
        TextField alternatePostalField = new TextField();
        pane1.add(alternatePostalLabel, 2, 11);
        pane1.add(alternatePostalField, 3, 11);

        Button addButton = new Button("Add");
        pane1.add(addButton, 2, 13);
        addButton.setDefaultButton(true);
        addButton.setPrefSize(70, 20);

        Button removeButton = new Button("Remove");
        pane1.add(removeButton, 3, 13);
        removeButton.setDisable(true);
        removeButton.getStyleClass().add("remove-button");
        removeButton.setPrefSize(70, 20);

        Button modifyButton = new Button("Modify");
        pane1.add(modifyButton, 2, 14);
        modifyButton.getStyleClass().add("modify-button");
        modifyButton.setPrefSize(70, 20);

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPrefSize(480, 50);

        ListView<String> listView = new ListView<>();
        listView.setPrefSize(150, 420);
        ObservableList<String> items = getNamesFromFile();
        ObservableList<String> displayItems = FXCollections.observableArrayList();

        // Parse the address strings and add only the names to the display list
        for (String item : items) {
            String[] parts = item.split(",");
            if (parts.length > 0) {
                displayItems.add(parts[0]);
            }
        }

        listView.setItems(displayItems);
        pane1.add(listView, 0, 0, 1, 14);
        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                for (String item : items) {
                    String[] parts = item.split(",");
                    if (parts.length > 0 && parts[0].equals(newValue)) {
                        homeNameField.setText(parts[0]);
                        homeStreetField.setText(parts[1]);
                        homeCityField.setText(parts[2]);
                        homeProvinceField.setValue(parts[3]);
                        homePostalField.setText(parts[4]);
                        alternateNameField.setText(parts[5]);
                        alternateStreetField.setText(parts[6]);
                        alternateCityField.setText(parts[7]);
                        alternateProvinceField.setValue(parts[8]);
                        alternatePostalField.setText(parts[9]);
                        removeButton.setDisable(false);
                        break;
                    }
                }
            } else {
                addButton.setDisable(false);
                removeButton.setDisable(true);
                Platform.runLater(() -> listView.getSelectionModel().select(newValue));
            }
        });

        pane1.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                Node target = (Node) event.getTarget();
                if (!(target instanceof TextField)) {
                    listView.getSelectionModel().clearSelection();
                    removeButton.setDisable(true);
                }
            }
        });

        addButton.setOnAction(e -> {
            String name = homeNameField.getText();
            String street = homeStreetField.getText();
            String city = homeCityField.getText();
            String postal = homePostalField.getText();

            if (name.isEmpty() || street.isEmpty() || city.isEmpty() || postal.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Home Address is mandatory.", ButtonType.OK);
                alert.showAndWait();
                return;}

            String altName = (!alternateNameField.getText().isEmpty()) ? alternateNameField.getText() : name;
            String altStreet = (!alternateStreetField.getText().isEmpty()) ? alternateStreetField.getText() : street;
            String altCity = (!alternateCityField.getText().isEmpty()) ? alternateCityField.getText() : city;
            String altPostal = (!alternatePostalField.getText().isEmpty()) ? alternatePostalField.getText() : postal;

            String str = name + "," + street + "," + city + "," +
                    homeProvinceField.getValue() + "," + postal + "," +
                    altName + "," + altStreet + "," + altCity + "," +
                    alternateProvinceField.getValue() + "," + altPostal + '\n';
            address.addAddress(str);
            items.add(str);
            displayItems.clear();
            for (String item : items) {
                String[] parts = item.split(",");
                if (parts.length > 0) {
                    displayItems.add(parts[0]);
                }
            }
        });

        modifyButton.setOnAction(e -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Apply changes?", ButtonType.YES, ButtonType.CANCEL);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                    String newAddress = homeNameField.getText() + "," + homeStreetField.getText() + "," +
                            homeCityField.getText() + "," + homeProvinceField.getValue() + "," +
                            homePostalField.getText() + "," +
                            alternateNameField.getText() + "," + alternateStreetField.getText() + "," +
                            alternateCityField.getText() + "," + alternateProvinceField.getValue() + "," +
                            alternatePostalField.getText();
                    try {
                        address.modifyAddress(selectedItem, newAddress);
                        ObservableList<String> newItems = getNamesFromFile();
                        listView.setItems(newItems);
                        displayItems.clear();
                        for (String item : newItems) {
                            String[] parts = item.split(",");
                            if (parts.length > 0) {
                                displayItems.add(parts[0]);
                            }
                        }
                        listView.setItems(displayItems);
                        listView.getSelectionModel().select(newAddress.split(",")[0]);

                        String[] parts = newAddress.split(",");
                        Platform.runLater(()->{
                            homeNameField.setText(parts[0]);
                            homeStreetField.setText(parts[1]);
                            homeCityField.setText(parts[2]);
                            homeProvinceField.setValue(parts[3]);
                            homePostalField.setText(parts[4]);
                            alternateNameField.setText(parts[5]);
                            alternateStreetField.setText(parts[6]);
                            alternateCityField.setText(parts[7]);
                            alternateProvinceField.setValue(parts[8]);
                            alternatePostalField.setText(parts[9]);
                        });
                        //System.out.println(parts[1]);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        Alert alert2 = new Alert(Alert.AlertType.ERROR, "An error occurred while modifying the address.", ButtonType.OK);
                        alert2.showAndWait();
                    }
                }
            }
            else {
                Alert alert3 = new Alert(Alert.AlertType.ERROR, "Please select an address to modify.", ButtonType.OK);
                alert3.showAndWait();
            }
        });

        removeButton.setOnAction(e -> {
            String selectedName = listView.getSelectionModel().getSelectedItem();
            if (selectedName != null) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Deletion");
                alert.setHeaderText("Are you sure you want to delete this address?");
                alert.setContentText("Selected address: " + selectedName);
                ButtonType okButton = new ButtonType("Delete anyway", ButtonBar.ButtonData.OK_DONE);
                ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(okButton, cancelButton);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == okButton){
                    displayItems.remove(selectedName);
                    // Remove the selected address from the items list
                    for (String item : items) {
                        String[] parts = item.split(",");
                        if (parts.length > 0 && parts[0].equals(selectedName)) {
                            items.remove(item);
                            // Update the address book file by writing the updated items list
                            try (PrintWriter writer = new PrintWriter(new FileWriter("addressBook.txt"))) {
                                for (String updatedItem : items) {
                                    writer.println(updatedItem);
                                }
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            break;
                        }
                    }
                }
            }
        });

        Button reloadButton = new Button("Reload");
        pane1.add(reloadButton, 3, 14);
        reloadButton.getStyleClass().add("reload-button");
        reloadButton.setPrefSize(70, 20);
        reloadButton.setOnAction(event -> Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to reload? " +
                    "Unsaved changes will be discarded.", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                Platform.runLater(() -> {
                    try {
                        stop();
                        stage2.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    start(new Stage());
                });
            }
        }));

        Button quitButton = new Button("Quit");
        pane1.add(quitButton, 2, 15);
        quitButton.getStyleClass().add("quit-button");
        quitButton.setPrefSize(70, 20);
        quitButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to quit?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                System.exit(0);
            }
        });
        //Tool tips here
        homeNameField.setOnMouseEntered(e1 -> {
            Tooltip tooltip = new Tooltip
                    ("""
                          Please use a unique name here
                          """);
            Point2D mouseLocation = homeNameField.localToScreen(e1.getX(), e1.getY());
            tooltip.show(homeNameField, mouseLocation.getX() + 10, mouseLocation.getY() + 10);
            homeNameField.setOnMouseExited(e2 -> tooltip.hide());
        });
        alternateNameField.setOnMouseEntered(e1 -> {
            Tooltip tooltip = new Tooltip
                    ("""
                          A blank Alternate Address is filled by Home Address details
                          """);
            Point2D mouseLocation = alternateNameField.localToScreen(e1.getX(), e1.getY());
            tooltip.show(alternateNameField, mouseLocation.getX() + 10, mouseLocation.getY() + 10);
            alternateNameField.setOnMouseExited(e2 -> tooltip.hide());
        });
        modifyButton.setOnMouseEntered(e1 -> {
            Tooltip tooltip = new Tooltip
                    ("To see an updated list, please press Reload");
            Point2D mouseLocation = modifyButton.localToScreen(e1.getX(), e1.getY());
            tooltip.show(modifyButton, mouseLocation.getX() + 10, mouseLocation.getY() + 10);
            modifyButton.setOnMouseExited(e2 -> tooltip.hide());
        });
        listView.setOnMouseEntered(e1 -> {
            Tooltip tooltip = new Tooltip
                    ("To modify an address, please select an entry first");
            Point2D mouseLocation = listView.localToScreen(e1.getX(), e1.getY());
            tooltip.show(listView, mouseLocation.getX() + 10, mouseLocation.getY() + 10);
            listView.setOnMouseExited(e2 -> tooltip.hide());
        });
    }

    private ObservableList<String> getNamesFromFile() {
        ObservableList<String> StringLine = FXCollections.observableArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader("addressBook.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 10) {
                    StringBuilder addressString = new StringBuilder(parts[0]);
                    for (int i = 1; i < parts.length; i++) {
                        addressString.append(",").append(parts[i]);
                    }
                    StringLine.add(addressString.toString());
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringLine;
    }

    /**
     * Main
     * @param args  args
     */
    public static void main(String[] args) {
        launch(args);
    }

    static class Address{
        public Address() {}
        public void addAddress(String address) {
            try (RandomAccessFile file = new RandomAccessFile("addressBook.txt", "rw")) {
                file.seek(file.length());
                file.writeBytes(address);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void modifyAddress(String selectedItem, String newAddress) throws IOException {
            String tempFileName = "temp.txt";
            File inputFile = new File("addressBook.txt");
            File tempFile = new File(tempFileName);

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] fields = currentLine.split(",");
                String name = fields[0];
                if (name.equals(selectedItem)) {
                    writer.write(newAddress + "\n");
                } else {
                    writer.write(currentLine + "\n");
                }
            }
            writer.close();
            reader.close();

            boolean isDeleted = inputFile.delete();
            boolean isRenamed = tempFile.renameTo(inputFile);

            if (!isDeleted || !isRenamed) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "An error occurred while modifying the address.", ButtonType.OK);
                alert.showAndWait();
            }
        }
    }
}
