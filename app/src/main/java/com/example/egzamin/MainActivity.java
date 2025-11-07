package com.example.egzamin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
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
    int[] obrazy = {R.drawable.luki, R.drawable.kamil, R.drawable.zdjecie1};
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
    }
}