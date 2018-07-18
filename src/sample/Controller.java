package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class Controller {

    private int value1, value2, result;
    private String sign;
    private boolean isSign = false;

    @FXML
    private TextArea text_area = new TextArea();
    @FXML
    private AnchorPane Calc_Panel = new AnchorPane();

    @FXML
    public void numberClicked(ActionEvent event){
        Button b = (Button) event.getSource();
        text_area.appendText(b.getText());
    }

    @FXML
    public void signClicked(ActionEvent event){
        value1 = Integer.parseInt(text_area.getText());
        text_area.clear();
        Button b = (Button) event.getSource();
        sign = b.getText();
        System.out.println(sign);
        isSign = true;
    }

    @FXML
    public void calculate(){
        value2 = Integer.parseInt(text_area.getText());
        switch(sign){
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
                result = value1 / value2;
                break;
        }
        text_area.setText(Integer.toString(result));
        isSign = false;
        value2 = 0;
    }

}
