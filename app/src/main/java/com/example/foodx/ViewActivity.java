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
    Button b_ch ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView3);
        tv3=(TextView)findViewById(R.id.textView4);
        tv4=(TextView)findViewById(R.id.textView2);
        tv5=(TextView)findViewById(R.id.textView5);
        String uname = getIntent().getStringExtra("Username");
        tv1.setText(getIntent().getStringExtra("itemName"));
        tv2.setText(getIntent().getStringExtra("Location"));
        tv3.setText(getIntent().getStringExtra("Number"));
        tv4.setText(uname);
        tv5.setText(getIntent().getStringExtra("Expiry"));
        String uid = getIntent().getStringExtra("userid");



        b_ch = findViewById(R.id.b_ch);
        b_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ViewActivity.this, MessageActivity.class);
                intent.putExtra("userid",uid);
                startActivity(intent);

            }
        });


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