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

    boolean minusSign = false;

    @FXML
    private TextField result;

    private StringBuilder firstBuffer = new StringBuilder();
    private StringBuilder secondBuffer = new StringBuilder();

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
        appendNumToBuffer(num);
        setTextBufferTextToCalc();
    }

    protected void setTextBufferTextToCalc() {
        if (!secondInFlag) {
            fNum.setText(firstBuffer.toString());
        } else {
            sNum.setText(secondBuffer.toString());
        }
    }

    protected void appendNumToBuffer(String num) {
        if (!secondInFlag) {
            firstBuffer.append(num);
        } else {
            secondBuffer.append(num);
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
        firstBuffer = new StringBuilder();
        fNum.setText(firstBuffer.toString());

        secondBuffer = new StringBuilder();
        sNum.setText(secondBuffer.toString());

        actionSign.setText("sign");

        result.setText("result");

        secondInFlag = false;

        minusSign = false;
    }

    @FXML
    protected void onPlusMinusClick() {
        if (!secondInFlag) {
            if (!minusSign) {
                firstBuffer.insert(0, "-");
                minusSign = true;
            } else {
                firstBuffer.deleteCharAt(0);
                minusSign = false;
            }
        } else {
            if (!minusSign) {
                secondBuffer.insert(0, "-");
                minusSign = true;
            } else {
                secondBuffer.deleteCharAt(0);
                minusSign = false;
            }
        }
        setTextBufferTextToCalc();
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