package com.example.example;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button btn;
ImageView left;
ImageView right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            btn=findViewById(R.id.roll);
            left=findViewById(R.id.leftdice);
            right=findViewById(R.id.rightdice);
            final int[] dicearray={
                    R.drawable.dice1,
                    R.drawable.dice2,
                    R.drawable.dice3,
                    R.drawable.dice4,
                    R.drawable.dice5,
                    R.drawable.dice6
            };
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("roll button!", "onClick: button is clicked");
                    Random randomnumbergenerator =new Random();
                     int number=randomnumbergenerator.nextInt(6);
                     left.setImageResource(dicearray[number]);
                    right.setImageResource(dicearray[number]);
                }
            });

            return insets;
        });
    }
}