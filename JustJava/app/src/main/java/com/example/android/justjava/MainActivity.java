package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Get the last known value of the quantity and increment it.
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        // Get the updated value of quantity to calculate the price.
        int currentOrder = Integer.parseInt(quantityTextView.getText().toString());
        // Assuming $5.00 per coffee.
        int pricePerCoffee = 5;
        displayPrice(currentOrder * pricePerCoffee);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        // Increment the quantity by 1.
        number = number + 1;
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increaseQuantity(View view) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        // Increment the quantity by 1.
        int currentQuantity = Integer.parseInt(quantityTextView.getText().toString());
        currentQuantity = currentQuantity + 1;
        quantityTextView.setText("" + currentQuantity);
    }

    public void decreaseQuantity(View view) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        // Increment the quantity by 1.
        int currentQuantity = Integer.parseInt(quantityTextView.getText().toString());
        currentQuantity = currentQuantity - 1;
        quantityTextView.setText("" + currentQuantity);
    }
}
