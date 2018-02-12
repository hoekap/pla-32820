package com.myapp.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate_plus(View view){
        EditText field1 = findViewById(R.id.plus1);
        EditText field2 = findViewById(R.id.plus2);
        double value1;
        double value2;
        if (field1.getText().toString().isEmpty()){
            value1 = 0.0;
        }
        else {
            value1 = Double.parseDouble(field1.getText().toString());
        }
        if (field2.getText().toString().isEmpty()){
            value2 = 0.0;
        }
        else {
            value2 = Double.parseDouble(field2.getText().toString());
        }
        TextView target = findViewById(R.id.plusvalue);
        target.setText(String.valueOf(value1+value2));
        save_log(String.format("%.2f + %.2f = %.2f", value1, value2, value1+value2));
    }
    public void calculate_minus(View view){
        EditText field1 = findViewById(R.id.minus1);
        EditText field2 = findViewById(R.id.minus2);
        double value1;
        double value2;
        if (field1.getText().toString().isEmpty()){
            value1 = 0.0;
        }
        else {
            value1 = Double.parseDouble(field1.getText().toString());
        }
        if (field2.getText().toString().isEmpty()){
            value2 = 0.0;
        }
        else {
            value2 = Double.parseDouble(field2.getText().toString());
        }
        TextView target = findViewById(R.id.minusvalue);
        target.setText(String.valueOf(value1-value2));
        save_log(String.format("%.2f - %.2f = %.2f", value1, value2, value1-value2));
    }
    public void calculate_product(View view) {
        EditText field1 = findViewById(R.id.product1);
        EditText field2 = findViewById(R.id.product2);
        double value1;
        double value2;
        if (field1.getText().toString().isEmpty()){
            value1 = 0.0;
        }
        else {
            value1 = Double.parseDouble(field1.getText().toString());
        }
        if (field2.getText().toString().isEmpty()){
            value2 = 0.0;
        }
        else {
            value2 = Double.parseDouble(field2.getText().toString());
        }
        TextView target = findViewById(R.id.productvalue);
        target.setText(String.valueOf(value1*value2));
        save_log(String.format("%.2f x %.2f = %.2f", value1, value2, value1*value2));
    }
    public void calculate_division(View view) {
        EditText field1 = findViewById(R.id.division1);
        EditText field2 = findViewById(R.id.division2);
        double value1;
        double value2;
        if (field1.getText().toString().isEmpty()){
            value1 = 0.0;
        }
        else {
            value1 = Double.parseDouble(field1.getText().toString());
        }
        if (field2.getText().toString().isEmpty()){
            value2 = 0.0;
        }
        else {
            value2 = Double.parseDouble(field2.getText().toString());
        }
        TextView target = findViewById(R.id.divisionvalue);
        if (value2 == 0){
            target.setText("NaN");
            save_log(String.format("%.2f / %.2f = NaN", value1, value2));
        }
        else {
            target.setText(String.format("%.2f", (value1/value2)));
            save_log(String.format("%.2f / %.2f = %.2f", value1, value2, (value1/value2)));
        }
    }
    public void clear_all(View view){
        EditText[] factors = new EditText[8];
        TextView[] results = new TextView[4];
        factors[0] = findViewById(R.id.plus1);
        factors[1] = findViewById(R.id.plus2);
        results[0] = findViewById(R.id.plusvalue);
        factors[2] = findViewById(R.id.minus1);
        factors[3] = findViewById(R.id.minus2);
        results[1] = findViewById(R.id.minusvalue);
        factors[4] = findViewById(R.id.product1);
        factors[5] = findViewById(R.id.product2);
        results[2] = findViewById(R.id.productvalue);
        factors[6] = findViewById(R.id.division1);
        factors[7] = findViewById(R.id.division2);
        results[3] = findViewById(R.id.divisionvalue);
        for (int i = 0; i < factors.length; ++i){
            factors[i].setText("0");
        }
        for (int i = 0; i < results.length; ++i){
            results[i].setText("0");
        }
    }

    private String log_ = "";

    private void save_log(String str){
        log_ = str + "\n" + log_;
        System.out.print(log_);
    }

    public void show_log(View view) {
        Intent intent = new Intent(this, LogActivity.class);
        intent.putExtra("Log", log_);
        startActivity(intent);
    }
}
