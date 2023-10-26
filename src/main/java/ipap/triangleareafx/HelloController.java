package ipap.triangleareafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    @FXML
    private TextField side4;

    @FXML
    private RadioButton radioRec;

    @FXML
    private RadioButton radioTra;

    @FXML
    private RadioButton radioTre;

    FigureType fType = FigureType.Triangle;

    public void initialize(){
        result.setText("а у нас произошла инициализация!");
        //btnCalc.setOnAction(a -> calculateAreaTriangle());
        //side4.setVisible(false);
        switchFigure();
        switchVisibility();
//        btnCalc.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                calculateAreaTriangle();
//            }
//        });
    }
    public void switchFigure(){
        switch (fType){
            case Triangle:
                btnCalc.setOnAction(a -> calculateAreaTriangle());
                break;
            case Rectangle:
                btnCalc.setOnAction(a -> calculateAreaRect());
                break;
            default:
                btnCalc.setOnAction(a -> result.setText("у меня лапки"));
        }
    }
    public void switchVisibility(){
        switch (fType){
            case Triangle:
                side1.setVisible(true);
                side2.setVisible(true);
                side3.setVisible(true);
                side4.setVisible(false);
                //todo: спрятать надпись сторона 4
                break;
            case Rectangle:
                side1.setVisible(true);
                side2.setVisible(true);
                side3.setVisible(false);
                side4.setVisible(false);
                //todo: спрятать надпись сторона 3, сторона 4
                break;

            case Trapezia:
                side1.setVisible(true);
                side2.setVisible(true);
                side3.setVisible(true);
                side4.setVisible(true);
                //todo: показать надпись сторона 3, сторона 4
                break;
        }
    }

    @FXML
    void radioClick(ActionEvent event) {
        RadioButton selected = (RadioButton) event.getSource();
        if(selected == radioTre) {
            fType = FigureType.Triangle;
        }
        if(selected == radioRec){
            fType=FigureType.Rectangle;
        }
        if (selected == radioTra){
            fType=FigureType.Trapezia;
        }

        switchFigure();
        switchVisibility();
    }

    public void calculateAreaRect() {
        try {
            double a = Double.parseDouble(side1.getText());
            double b = Double.parseDouble(side2.getText());
            //double c = Double.parseDouble(side3.getText());
            Rectangle r = new Rectangle(a, b);
            double res = r.getArea();
            result.setText(String.valueOf(res));
        } catch (NumberFormatException e) {
            result.setText("да это не числа вообще");
        } catch (UnnaturalLengthEx e) {
            result.setText(e.getMessage() + " " + e.number);
        }
    }

    public void calculateAreaTriangle(){
        try {
            double a = Double.parseDouble(side1.getText());
            double b = Double.parseDouble(side2.getText());
            double c = Double.parseDouble(side3.getText());
            Triangle t = new Triangle(a, b, c);
            double res = t.getArea();
            result.setText(String.valueOf(res));
        }catch (NumberFormatException e)
        {
            result.setText("да это не числа вообще");
        } catch (UnnaturalLengthEx e) {
            result.setText(e.getMessage()+" "+e.number);
        } catch (ImpossibleTriangleEx e) {
            result.setText("ААААА"+"\n"+e.getMessage());
        }

    }

}
