package com.example.calc;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CalcController {
    @FXML
    public Text actionSign;
    @FXML
    private Text fNum;
    @FXML
    private Text sNum;

    @FXML
    private TextField result;

    private StringBuffer firstBuffer = new StringBuffer();
    private StringBuffer secondBuffer = new StringBuffer();

    boolean secondInFlag = false;

    @FXML
    protected void onBut_1() {
        onNumButtonClick("1");
    }
    @FXML
    protected void onBut_2() {
        onNumButtonClick("2");
    }
    @FXML
    protected void onBut_3() {
        onNumButtonClick("3");
    }
    @FXML
    protected void onBut_4() {
        onNumButtonClick("4");
    }
    @FXML
    protected void onBut_5() {
        onNumButtonClick("5");
    }
    @FXML
    protected void onBut_6() {
        onNumButtonClick("6");
    }
    @FXML
    protected void onBut_7() {
        onNumButtonClick("7");
    }
    @FXML
    protected void onBut_8() {
        onNumButtonClick("8");
    }
    @FXML
    protected void onBut_9() {
        onNumButtonClick("9");
    }
    @FXML
    protected void onBut_0() {
        onNumButtonClick("0");
    }
    @FXML
    protected void onBut_comma() {
        onNumButtonClick(".");
    }

    protected void onNumButtonClick(String num) {
        if (!secondInFlag) {
            firstBuffer.append(num);
            fNum.setText(firstBuffer.toString());
        } else {
            secondBuffer.append(num);
            sNum.setText(secondBuffer.toString());
        }
    }

    @FXML
    protected void onPlus() {
        onSignButtonClick("+");
    }
    @FXML
    protected void onMinus() {
        onSignButtonClick("-");
    }
    @FXML
    protected void onMultiply() {
        onSignButtonClick("*");
    }
    @FXML
    protected void onDivide() {
        onSignButtonClick("/");
    }


    protected void onSignButtonClick(String sign) {
        secondInFlag = true;
        actionSign.setText(sign);
    }

    @FXML
    protected void onClearClick() {
        firstBuffer = new StringBuffer();
        fNum.setText(firstBuffer.toString());

        secondBuffer = new StringBuffer();
        sNum.setText(secondBuffer.toString());

        actionSign.setText("sign");

        result.setText("result");

        secondInFlag = false;
    }

    @FXML
    protected void onEqualsSignClick() {
        double firstNum = Double.parseDouble(firstBuffer.toString());
        double secondNum = Double.parseDouble(secondBuffer.toString());
        double resultNum = 0.0;

        switch (actionSign.getText()) {
            case "+" -> resultNum = firstNum + secondNum;
            case "-" -> resultNum = firstNum - secondNum;
            case "*" -> resultNum = firstNum * secondNum;
            case "/" -> resultNum = firstNum / secondNum;
            default -> {
            }
        }

        result.setText(String.valueOf(resultNum));
    }
}