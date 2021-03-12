package com.abc.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] color = {"Red", "Green", "Blue"};
    LinearLayout main;
    EditText inputText;
    Spinner spinner;
    TextView showText;
    Button update;
    String choosenColor,input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        main = findViewById(R.id.mainLinearLayout);
        inputText = findViewById(R.id.editText);
        showText = findViewById(R.id.textView);
        update = findViewById(R.id.buttonUpdate);

        spinner = findViewById(R.id.spinnerInput);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,color);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input =  inputText.getText().toString();
                showText.setText(input);
                if(choosenColor=="Red"){
                    main.setBackgroundColor(Color.RED);
                }else if(choosenColor=="Green"){
                    main.setBackgroundColor(Color.rgb(0,100,0));
                }else if(choosenColor=="Blue"){
                    main.setBackgroundColor(Color.BLUE);
                }else{
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        choosenColor = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}