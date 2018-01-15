package com.example.brianchan.tipapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String costFormatted = "0.00";
    private String tipFormatted = "0.0";
    private double cost = -1;
    private double tip = -1;
    private String tipAmtFormatted = "0.00";
    private double tipAmt = 0;
    private double fin = 0;
    private String finalFormatted = "0.00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view) {
        EditText costEdit = (EditText) findViewById(R.id.costEdit);
        String price = costEdit.getText().toString();
        if (price.matches(""))
        {
            Toast.makeText(this, "You did not enter the cost.", Toast.LENGTH_SHORT).show();
            return;
        }
        cost = Double.parseDouble(price);
        costFormatted = String.format ("%.2f", cost);

        EditText tipEdit = (EditText) findViewById(R.id.tipEdit);
        String amount = tipEdit.getText().toString();
        if (amount.matches("")) {
            Toast.makeText(this, "You did not enter the tip amount.", Toast.LENGTH_SHORT).show();
            return;
        }
        tip = Double.parseDouble(amount);
        tipFormatted = String.format("%.1f", tip);


        if ((cost != -1) && (tip != -1)) {
            double temporary = tip/100;
            tipAmt = cost*temporary;
            tipAmtFormatted = String.format("%.2f", tipAmt);
        }

        fin = cost + tipAmt;
        finalFormatted = String.format("%.2f", fin);
        updateOutput();
    }

    //todo: round up or down option, change textview to red and update tip amount %, total tip, and final price to show adjustment made

    private void updateOutput(){
        TextView out = (TextView)findViewById(R.id.output);
        out.setText("Cost of Meal: $" + costFormatted + "\nTip Amount: "+ tipFormatted+"%\nTotal Tip: $" + tipAmtFormatted + "\nFinal Price: $"+ finalFormatted);

    }
}
