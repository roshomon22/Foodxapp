package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    private Button back_button ;

    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tv1=(TextView)findViewById(R.id.textView);
        tv1.setText(getIntent().getStringExtra("itemName"));



        back_button = findViewById( R.id.item_view_back_btn);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ViewActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}