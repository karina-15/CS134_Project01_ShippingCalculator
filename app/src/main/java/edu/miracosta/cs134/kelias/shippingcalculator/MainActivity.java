package edu.miracosta.cs134.kelias.shippingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracosta.cs134.kelias.shippingcalculator.model.ShipItem;

/**
 * Main Activity
 */
public class MainActivity extends AppCompatActivity {
    // Instance variables
    // Bridge the View and Model
    private ShipItem currentShipment;
    // in activity_main.xml
    private EditText weightEditText;
    private TextView baseCostTextView;
    private TextView addedCostTextView;
    private TextView totalShippingTextView;

    // Instance variables to format output (currency)
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    /**
     * Creates the ShipItem object, initializes TextViews that will change,
     * and creates a listener for weightEditText when user changes the text
     * @param savedInstanceState    state of Activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // "Wire up" instance variables (initialize them)
        currentShipment = new ShipItem();
        weightEditText = findViewById(R.id.weightEditText);
        baseCostTextView = findViewById(R.id.baseCostTextView);
        addedCostTextView = findViewById(R.id.addedCostTextView);
        totalShippingTextView = findViewById(R.id.totalShippingTextView);

        // Implement the interface for the EditText
        weightEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            // use while user is typing
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Read the input from the weightEditText (View) and store in the
                // currentShipment (Model)
                // getText is converted to string and string is converted to double
                try {
                    double weight = Double.parseDouble(weightEditText.getText().toString());
                    // Store the weight in the shipping calculations
                    currentShipment.setWeight(weight);
                } catch (NumberFormatException e) {
                    currentShipment.setWeight(0);
                }
                calculateShipping();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * Updates the added cost and total shipping cost labels (TextView)
     * Displays all costs as currency
     */
    public void calculateShipping() {
        // Update the addedCostTextView and totalShippingTextView
        baseCostTextView.setText(currency.format(currentShipment.getBaseCost()));
        addedCostTextView.setText(currency.format(currentShipment.getAddedCost()));
        totalShippingTextView.setText(currency.format(currentShipment.getTotalShippingCost()));
    }
}
