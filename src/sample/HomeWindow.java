package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomeWindow {

    Stage stage;
    Scene scene;
    Main main;
    Processes processes = new Processes();
    Transactions transactions = new Transactions();


    public HomeWindow(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {
        Label choose = new Label("Choose your process :");
        Button deposit = new Button("1.Deposit");
        Label output = new Label();
        Button withdrawal = new Button("2.Withdrawal");
        Button balance = new Button("3.Balance");
        Button next = new Button("4.Next");
        Button previous = new Button("5.Previous");
        Label text = new Label("Enter the amount of money you want to Deposit/Withdrawal: ");
        TextField choice = new TextField();


        GridPane grid = new GridPane();
        grid.add(choose, 0, 0);
        grid.add(deposit, 1, 0);
        grid.add(withdrawal, 1, 1);
        grid.add(balance, 1, 2);
        grid.add(next, 1, 3);
        grid.add(previous, 1, 4);
        grid.add(text, 0, 5);
        grid.add(choice, 1, 5);
        grid.add(output, 1, 6);

        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double depositedAmount = Double.parseDouble(choice.getText());
                if (depositedAmount <= 0) {
                    output.setText("Insufficient amount.");
                } else {
                    processes.Deposit(depositedAmount);
                    output.setText("You successfully deposited " + depositedAmount + " to your Card");
                    transactions.LinkedString("Deposit");
                    transactions.DoubleString(depositedAmount);
                }
            }
        });

        withdrawal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double withdrawaledAmount = Double.parseDouble(choice.getText());
                if (withdrawaledAmount <= 0) {
                    output.setText("Insufficient amount.");
                } else if (withdrawaledAmount > (processes.getBalance())) {
                    output.setText("Withdrawal amount is greater than Balance.");
                } else {
                    processes.Withdrawl(withdrawaledAmount);
                    output.setText("You successfully withdrawaled " + withdrawaledAmount + " to your Card");
                    transactions.LinkedString("Withdrawal");
                    transactions.DoubleString(withdrawaledAmount);
                }
            }
        });

        balance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                output.setText("Your Current Balance : " + processes.getBalance());
            }
        });

        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String w = transactions.getPreviousString();
                double x = transactions.getPreviousDouble();
                output.setText(" " + w + " " + x);
            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String y = transactions.getNextString();
                double z = transactions.getNextDouble();
                output.setText(" " + y + " " + z);
            }
        });

        scene = new Scene(grid, 800, 400);
    }

    public Scene getScene() {
        return scene;
    }

    public void setMainWindow(Main main) {
        this.main = main;
    }
}
