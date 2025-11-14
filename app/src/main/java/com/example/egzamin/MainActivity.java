package com.example.egzamin;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button buttonLewo;
    private Button buttonPrawo;
    private EditText editTextNumber;
    private Switch switch1;
    private ImageView imageView;
    private LinearLayout main;
    int[] obrazy = {R.drawable.kot1, R.drawable.kot2, R.drawable.kot3};
    int aktualnyIndeks = 0;
    int indeks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonLewo = findViewById(R.id.buttonLewo);
        buttonPrawo = findViewById(R.id.buttonPrawo);
        editTextNumber = findViewById(R.id.editTextNumber);
        switch1 = findViewById(R.id.switch1);
        imageView = findViewById(R.id.imageView);
        main = findViewById(R.id.main);

        buttonLewo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aktualnyIndeks > 0){
                    aktualnyIndeks--;
                    imageView.setImageResource(obrazy[aktualnyIndeks]);
                } else {
                    aktualnyIndeks = 2;
                    imageView.setImageResource(obrazy[aktualnyIndeks]);
                }
            }
        });
        buttonPrawo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aktualnyIndeks < 2){
                    aktualnyIndeks++;
                    imageView.setImageResource(obrazy[aktualnyIndeks]);
                } else {
                    aktualnyIndeks = 0;
                    imageView.setImageResource(obrazy[aktualnyIndeks]);
                }
            }
        });
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                if (b){
                    main.setBackgroundColor(Color.parseColor("#2196F3"));
                } else {
                    main.setBackgroundColor(Color.parseColor("#00796B"));
                }
            }
        });
        editTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                String text = editTextNumber.getText().toString();

                if (!text.isEmpty()) {
                    int number = Integer.parseInt(text);

                    if (number == 1) {
                        imageView.setImageResource(obrazy[0]);
                    } else if (number == 2) {
                        imageView.setImageResource(obrazy[1]);
                    } else if (number == 3) {
                        imageView.setImageResource(obrazy[2]);
                    }
                }

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
        });
    }
}