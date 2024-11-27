package com.example.midtermakhil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText radiusInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI elements to code
        radiusInput = findViewById(R.id.radius_input);
        resultText = findViewById(R.id.result_text);
        Button calculateButton = findViewById(R.id.calculate_button);

        // Set up the button click listener
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radiusStr = radiusInput.getText().toString();
                if (!radiusStr.isEmpty()) {
                    try {
                        double radius = Double.parseDouble(radiusStr);
                        double area = 3.14 * radius * radius;  // Calculate area
                        resultText.setText("Area: " + String.format("%.2f", area));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a radius", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}