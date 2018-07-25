package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;

public class Controller {

    private double value1, value2, result;
    private String sign;
    private boolean comma = false,      //is there already a comma (dot/point) in a value
            isSign = false,             //has the "sign" been chosen
            isFirstValueSet = false,    //as it states
            minus = false,              //is there already a minus in front of first value
            isResult = false;           //has the "=" sign been pressed

    @FXML
    private TextArea text_area = new TextArea();
    @FXML
    private AnchorPane Calc_Panel = new AnchorPane();

    private String getText = text_area.getText();

    @FXML
    public void numberClicked(ActionEvent event){
        Button b = (Button) event.getSource();
        String x = b.getText();
        if (x == "." && !comma){
            if (text_area.getText() == "") {
                text_area.appendText("0" + x);
            }
            else{
                text_area.appendText(x);
            }
        }
        else if (x.matches("[0-9]"))
            text_area.appendText(x);
    }

    @FXML
    public void signClicked(ActionEvent event) {
        if(!isSign) {
            if(getText!= null && getText != "" && getText != "-" && getText != "0." && getText !="-0.") {
                value1 = Double.parseDouble(text_area.getText());
                text_area.clear();
                Button b = (Button) event.getSource();
                sign = b.getText();
                isSign = true;
            }
        }
    }

    @FXML
    public void clearEnter(){

    }

    @FXML
    public void clearAll(){
        value1 = value2 = result = 0;
        sign = "";
        isSign = false;
        text_area.clear();
    }

    @FXML
    public void calculate(){
        if(getText != null && getText != "" && getText != "-" && getText != "0." && getText !="-0."){
            value2 = Double.parseDouble(text_area.getText());
            switch (sign) {
                case "+":
                    result = value1 + value2;
                    break;
                case "-":
                    result = value1 - value2;
                    break;
                case "*":
                    result = value1 * value2;
                    break;
                case "/":
                    if (value2 != 0)
                        result = value1 / value2;
                    else {
                        clearAll();
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("You cannot divide by 0!\nTry again.");
                        alert.show();
                        return;
                    }
                    break;
            }
            text_area.setText(Double.toString(result));
        }
        System.out.println(result);
        isSign = false;
        value2 = 0;
    }

}
