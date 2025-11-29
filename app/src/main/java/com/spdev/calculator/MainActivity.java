package com.spdev.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText number1;
    private EditText number2;
    private Button addButton, subtractButton, multiplyButton, divideButton, moduloButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Initialized Views
            number1 = findViewById(R.id.number1);
            number2 = findViewById(R.id.number2);
            addButton = findViewById(R.id.addButton);
            subtractButton = findViewById(R.id.subtractButton);
            multiplyButton = findViewById(R.id.multiplyButton);
            divideButton = findViewById(R.id.divideButton);
            moduloButton = findViewById(R.id.moduloButton);
            result = findViewById(R.id.result);


        // set con click listeners

        addButton.setOnClickListener(v -> performOperation("+"));
        subtractButton.setOnClickListener(v -> performOperation("-"));
        multiplyButton.setOnClickListener(v -> performOperation("x"));
        divideButton.setOnClickListener(v -> performOperation("/"));
        moduloButton.setOnClickListener(v -> performOperation("%"));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void performOperation(String operation){
        String num1str = number1.getText().toString();
        String num2str = number2.getText().toString();

        try{
            double num1  = Double.parseDouble(num1str);
            double num2 = Double.parseDouble(num2str);
            double res = 0;

            switch (operation){
                case "+":
                    res = num1 + num2;
                    break;
                case "-" :
                    res = num1 - num2;
                    break;
                case "x":
                    res = num1 * num2;
                    break;
                case "/":
                    res = num1 / num2;
                    break;
                case "%":
                    res = num1 % num2;
                    break;
            }
            result.setText(String.valueOf(res));
        } catch (NumberFormatException e){
            Toast.makeText(this, "Please Enter Both Number", Toast.LENGTH_SHORT).show();
        }


    }


}