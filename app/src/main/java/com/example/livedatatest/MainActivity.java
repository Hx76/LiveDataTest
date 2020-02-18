package com.example.livedatatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.livedatatest.ViewModelWithLiveData;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewModelWithLiveData viewModelWithLiveData;
    TextView textView;
    ImageButton imageButton1,imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModelWithLiveData = new ViewModelProvider(this).get(ViewModelWithLiveData.class);

        imageButton1 = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
        textView = findViewById(R.id.textView);

        viewModelWithLiveData.getLikedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelWithLiveData.addLikedNumber(1);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelWithLiveData.addLikedNumber(2);
            }
        });



    }
}
