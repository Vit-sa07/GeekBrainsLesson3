package com.example.geekbrainslesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private static final String BY_ZERO = "Деление на ноль не возможно";

    private TextView textViewFormula;
    private TextView textViewResult;
    private StringBuilder tempFormula = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFormula = findViewById(R.id.textView_formula);
        textViewResult = findViewById(R.id.textView_result);

        initButton();
    }

    public void initButton() {
        Button button1 = findViewById(R.id.btn3A);
        Button button2 = findViewById(R.id.btn3B);
        Button button3 = findViewById(R.id.btn3C);
        Button button4 = findViewById(R.id.btn4A);
        Button button5 = findViewById(R.id.btn4B);
        Button button6 = findViewById(R.id.btn4C);
        Button button7 = findViewById(R.id.btn5A);
        Button button8 = findViewById(R.id.btn5B);
        Button button9 = findViewById(R.id.btn5C);
        Button button0 = findViewById(R.id.btn6A);
        Button button_plus = findViewById(R.id.btn5D);
        Button button_minus = findViewById(R.id.btn4D);
        Button button_divide = findViewById(R.id.btn2D);
        Button button_mult = findViewById(R.id.btn3D);
        Button button_decimalSeparator = findViewById(R.id.btn2A);
        Button button_c = findViewById(R.id.btn1C);
        Button button_backspace = findViewById(R.id.btn1D);
        Button button_plus_minus = findViewById(R.id.btn1B);
        Button button_equal = findViewById(R.id.button23);


        View.OnClickListener OnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn3A:
                        setTextViewFormulaNum(ButtonData.ONE);
                        break;
                    case R.id.btn3B:
                        setTextViewFormulaNum(ButtonData.TWO);
                        break;
                    case R.id.btn3C:
                        setTextViewFormulaNum(ButtonData.THREE);
                        break;
                    case R.id.btn4A:
                        setTextViewFormulaNum(ButtonData.FOUR);
                        break;
                    case R.id.btn4B:
                        setTextViewFormulaNum(ButtonData.FIVE);
                        break;
                    case R.id.btn4C:
                        setTextViewFormulaNum(ButtonData.SIX);
                        break;
                    case R.id.btn5A:
                        setTextViewFormulaNum(ButtonData.SEVEN);
                        break;
                    case R.id.btn5B:
                        setTextViewFormulaNum(ButtonData.EIGHT);
                        break;
                    case R.id.btn5C:
                        setTextViewFormulaNum(ButtonData.NINE);
                        break;
                    case R.id.btn6A:
                        setTextViewFormulaNum(ButtonData.ZERO);
                        break;
                    case R.id.btn5D:
                        setTextViewFormulaSymb(ButtonData.PLUS);
                        break;
                    case R.id.btn4D:
                        setTextViewFormulaSymb(ButtonData.MINUS);
                        break;
                    case R.id.btn2D:
                        setTextViewFormulaSymb(ButtonData.DIVIDE);
                        break;
                    case R.id.btn3D:
                        setTextViewFormulaSymb(ButtonData.MULTIPLY);
                        break;
                    case R.id.btn2A:
                        setTextViewFormulaSymbPoint(ButtonData.POINT);
                        break;
                    case R.id.btn1C:
                        delTextViewFormulaFull();
                        break;
                    case R.id.btn1D:
                        delTextViewFormula();
                        break;
                    case R.id.btn1B:
                        break;
                    case R.id.button23:
                        setTextViewResult();
                        break;
                }
            }
        };


        button1.setOnClickListener(OnClickListener);
        button2.setOnClickListener(OnClickListener);
        button3.setOnClickListener(OnClickListener);
        button4.setOnClickListener(OnClickListener);
        button5.setOnClickListener(OnClickListener);
        button6.setOnClickListener(OnClickListener);
        button7.setOnClickListener(OnClickListener);
        button8.setOnClickListener(OnClickListener);
        button9.setOnClickListener(OnClickListener);
        button0.setOnClickListener(OnClickListener);
        button_plus.setOnClickListener(OnClickListener);
        button_minus.setOnClickListener(OnClickListener);
        button_divide.setOnClickListener(OnClickListener);
        button_mult.setOnClickListener(OnClickListener);
        button_decimalSeparator.setOnClickListener(OnClickListener);
        button_c.setOnClickListener(OnClickListener);
        button_backspace.setOnClickListener(OnClickListener);
        button_plus_minus.setOnClickListener(OnClickListener);
        button_equal.setOnClickListener(OnClickListener);

    }


    private void setTextViewFormulaNum(ButtonData value) {
        textViewFormula.setText(tempFormula.append(value.getSymbol()));
    }


    private void setTextViewFormulaSymb(ButtonData value) {
        if (tempFormula.length() >= 1) {
            if (tempFormula.indexOf("+") == -1 && tempFormula.indexOf("-") == -1 &&
                    tempFormula.indexOf("/") == -1 && tempFormula.indexOf("*") == -1) {
                textViewFormula.setText(tempFormula.append(value.getSymbol()));
            }
        }
    }


    private void setTextViewFormulaSymbPoint(ButtonData value) {

        if (tempFormula.length() >= 1) {
            if (tempFormula.indexOf("+") >= 0 || tempFormula.indexOf("-") >= 0 ||
                    tempFormula.indexOf("/") >= 0 || tempFormula.indexOf("*") >= 0) {
                if (!tempFormula.substring(tempFormula.length() - 1).equals("+") &&
                        !tempFormula.substring(tempFormula.length() - 1).equals("-") &&
                        !tempFormula.substring(tempFormula.length() - 1).equals("/") &&
                        !tempFormula.substring(tempFormula.length() - 1).equals("*")) {
                    if ((tempFormula.substring(tempFormula.indexOf("+") + 1).indexOf(",") == -1) ||
                            (tempFormula.substring(tempFormula.indexOf("-") + 1).indexOf(",") == -1) ||
                            (tempFormula.substring(tempFormula.indexOf("/") + 1).indexOf(",") == -1) ||
                            (tempFormula.substring(tempFormula.indexOf("*") + 1).indexOf(",") == -1)) {
                        textViewFormula.setText(tempFormula.append(value.getSymbol()));
                    }
                }
            } else {
                if (tempFormula.indexOf(",") == -1) {
                    if (!tempFormula.substring(tempFormula.length() - 1).equals(",")) {
                        textViewFormula.setText(tempFormula.append(value.getSymbol()));
                    }
                }
            }
        }
    }


    private void delTextViewFormulaFull() {
        if (tempFormula.length() >= 0) {
            textViewFormula.setText(tempFormula.delete(0, tempFormula.length()));
            textViewResult.setText(tempFormula.delete(0, tempFormula.length()));
        }
    }


    private void delTextViewFormula() {
        if (tempFormula.length() > 0) {
            textViewFormula.setText(tempFormula.deleteCharAt(tempFormula.length() - 1));
        }
    }


    private void setTextViewResult() {

        if (tempFormula.length() != 0) {

            String[] strArr = tempFormula.toString()
                    .replaceAll(",", ".")
                    .split("\\+|\\-|\\/|\\*");
            String strSymb = tempFormula.toString()
                    .replaceAll("\\d|\\,", " ")
                    .trim();
            boolean isZero = false;

            float result = Float.parseFloat(strArr[0]);

            for (int j = 1; j < strArr.length; j++) {
                switch (strSymb) {
                    case "+":
                        result = result + Float.parseFloat(strArr[j]);
                        break;
                    case "-":
                        result = result - Float.parseFloat(strArr[j]);
                        break;
                    case "/":
                        if (Float.parseFloat(strArr[j]) == 0) {
                            isZero = true;
                        }
                        result = result / Float.parseFloat(strArr[j]);
                        break;
                    case "*":
                        result = result * Float.parseFloat(strArr[j]);
                        break;
                }
            }


            if (isZero) {
                textViewResult.setText(BY_ZERO);
            } else if (result % 1 < 0.0001) {
                textViewResult.setText(String.format("%.0f=", result));
            } else {
                textViewResult.setText(String.format("%f=", result).replace(".", ","));
            }

        }
    }
}