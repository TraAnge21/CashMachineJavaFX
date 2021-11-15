package rocks.zipcode.atm;


import javafx.scene.layout.*;
import javafx.scene.text.FontWeight;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;

import static javafx.stage.Stage.*;


/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

//    private TextField field = new TextField();
    private TextField idFld = new TextField();
    private TextField depositFld = new TextField();
    private TextField withdrawFld = new TextField();
//    private TextField newWindow = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());
//    private Stage window;
//    private Button button;

    private Parent createContent() {

        VBox vbox = new VBox(20);
        vbox.setPrefSize(1000, 500);

        TextArea areaInfo = new TextArea();

        Button btnSubmit = new Button("Set Account ID");
        btnSubmit.setStyle("-fx-background-color: yellow; -fx-text-fill: blue;");
        btnSubmit.setOnAction(e -> {
            int id = Integer.parseInt(idFld.getText());
            cashMachine.login(id);

            areaInfo.setText(cashMachine.toString());
        });
        idFld.setPromptText("Input your account ID");


        Button btnDeposit = new Button("Deposit");
        btnDeposit.setStyle("-fx-background-color: black; -fx-text-fill: blue;");
        btnDeposit.setOnAction(e -> {
            float amount = Float.parseFloat(depositFld.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
        });
        depositFld.setPromptText("How much do you want to deposit ?");




        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setStyle("-fx-background-color: #ff0000; ");
        btnWithdraw.setOnAction(e -> {
            float amount = Float.parseFloat(withdrawFld.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());

        });
        withdrawFld.setPromptText("How much do you want to withdraw ? ");
       
        
        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> {
            cashMachine.exit();

            areaInfo.setText(cashMachine.toString());

        });

        Button newWindow = new Button();

        FlowPane flowpane = new FlowPane();

        flowpane.getChildren().add(btnSubmit);
        flowpane.getChildren().add(btnDeposit);
        flowpane.getChildren().add(btnWithdraw);
        flowpane.getChildren().add(btnExit);
        vbox.getChildren().addAll(idFld, depositFld,withdrawFld, flowpane, areaInfo);
        return vbox;

    }

    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setScene(new Scene(createContent()));
        depositFld.setVisible(true);
        withdrawFld.setVisible(true);
        idFld.setVisible(true);
        stage.setTitle("CASH MACHINE JAVAFX APP");
        stage.show();

//        window= stage;
        AlertBox alertbox= new AlertBox();
        alertbox.display("AlertBox", "Overdraft Limit Alert");
//
//        button.setOnAction(e -> alertBox.display("Alert Box", "Overdraft Limit!"));
//
//        StackPane layout = new StackPane();
//        layout.getChildren().add(button);
//        Scene scene = new Scene(layout, 150, 200);
//        window.setScene(scene);
//        window.show();


    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
