package com.example.devde.cardviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetails extends AppCompatActivity {

    ImageView imageView;
    TextView tx_name,tx_email,tx_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details_layout);

        imageView = findViewById(R.id.d_contact_image);
        tx_name = findViewById(R.id.d_contact_name);
        tx_email = findViewById(R.id.d_contact_email);
        tx_phone = findViewById(R.id.d_contact_phone);
        imageView.setImageResource(getIntent().getIntExtra("img_id",00));
        tx_name.setText(getIntent().getStringExtra("name"));
        tx_email.setText(getIntent().getStringExtra("email"));
        tx_phone.setText(getIntent().getStringExtra("phone"));
    }
}
