package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainWindow {

    Stage stage;
    Processes processes;
    Scene scene;
    HomeWindow homeWindow;

    public MainWindow(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {
        processes = new Processes();

        Label welcome = new Label("Welcome to our Simple ATM");
        Label checkCardNumber = new Label("Enter your Card Number: ");
        TextField checkCard = new TextField();
        Button validateCardNumber = new Button("Submit");
        Label validateCreditCard = new Label();

        GridPane grid = new GridPane();
        grid.add(welcome, 1, 0);
        grid.add(checkCardNumber, 0, 3);
        grid.add(checkCard, 1, 3);
        grid.add(validateCardNumber, 1, 5);
        grid.add(validateCreditCard, 1, 6);

        validateCardNumber.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String cardNumber = checkCard.getText();
                processes.validate(cardNumber);
                boolean valid = processes.validate(cardNumber);
                if (valid) {
                    validateCreditCard.setText("Login Successful");
                    stage.setScene(homeWindow.getScene());
                } else {
                    validateCreditCard.setText("Wrong CardNumber ,Please try again.");
                }
            }
        });

        scene = new Scene(grid, 700, 400);
    }

    public Scene getScene() {
        return this.scene;
    }

    public void setHomeWindow(HomeWindow homeWindow) {
        this.homeWindow = homeWindow;
    }
}

