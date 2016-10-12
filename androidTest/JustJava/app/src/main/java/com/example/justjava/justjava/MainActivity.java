package com.example.justjava.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
//        display(quantity);
        String priceMessage = "Free";
        displayMessage(priceMessage);
    }

    public void increase(View view) {
        quantity ++;
        display(quantity);
    }

    public void decrease(View view) {
        if (quantity > 0)
            quantity --;
        display(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + number);
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText("$" + number*2.5);
    }

    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(message);
    }
}