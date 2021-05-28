package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    private Button back_button ;

    TextView tv1,tv2,tv3,tv4,tv5,tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView3);
        tv3=(TextView)findViewById(R.id.textView4);
        tv4=(TextView)findViewById(R.id.textView2);
        tv5=(TextView)findViewById(R.id.textView5);
        tv1.setText(getIntent().getStringExtra("itemName"));
        tv2.setText(getIntent().getStringExtra("Location"));
        tv3.setText(getIntent().getStringExtra("Number"));
        tv4.setText(getIntent().getStringExtra("Username"));
        tv5.setText(getIntent().getStringExtra("Expiry"));







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