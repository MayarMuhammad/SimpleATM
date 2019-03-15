package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simple ATM");

        MainWindow main=new MainWindow(primaryStage);
        HomeWindow homeScreen=new HomeWindow(primaryStage);

        main.prepareScene();
        homeScreen.prepareScene();

        main.setHomeWindow(homeScreen);

        primaryStage.setScene(main.getScene());
        primaryStage.show();
    }
}
