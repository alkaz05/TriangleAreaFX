package ipap.triangleareafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.InputMismatchException;

public class HelloController {

    @FXML
    private Button btnCalc;

    @FXML
    private TextArea result;

    @FXML
    private TextField side1;

    @FXML
    private TextField side2;

    @FXML
    private TextField side3;

    public void initialize(){
        result.setText("а у нас произошла инициализация!");
        btnCalc.setOnAction(a -> calculate());
//        btnCalc.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                calculate();
//            }
//        });
    }

    public void calculate(){
        try {
            double a = Double.parseDouble(side1.getText());
            double b = Double.parseDouble(side2.getText());
            double c = Double.parseDouble(side3.getText());

            double res = 0;
            result.setText(String.valueOf(res));
        }catch (NumberFormatException e)
        {
            result.setText("да это не числа вообще");
        }

    }

}
