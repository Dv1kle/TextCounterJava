package com.example.textcounterjava;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private Spinner spinnerCountType;
    private Button buttonCount;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextInput = findViewById(R.id.editTextInput);
        spinnerCountType = findViewById(R.id.spinnerCountType);
        buttonCount = findViewById(R.id.buttonCount);
        textViewResult = findViewById(R.id.textViewResult);

        // Set up the spinner
        String[] options = {getString(R.string.count_words), getString(R.string.count_chars)};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountType.setAdapter(adapter);

        // Set button click listener
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countText();
            }
        });
    }

    private void countText() {
        String inputText = editTextInput.getText().toString();
        if (inputText.isEmpty()) {
            Toast.makeText(this, getString(R.string.empty_input_warning), Toast.LENGTH_SHORT).show();
            return;
        }

        String countType = spinnerCountType.getSelectedItem().toString();

        TextCounter counter = new TextCounter();

        int result;
        if (countType.equals(getString(R.string.count_words))) {
            result = counter.countWords(inputText);
        } else {
            result = counter.countCharacters(inputText);
        }

        textViewResult.setText(getString(R.string.result_label) + result);
    }
}
