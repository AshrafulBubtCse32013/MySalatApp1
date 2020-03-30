package com.example.mysalatapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity {

    private TextView textView;
    private TextView textView1;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        textView= (TextView) findViewById(R.id.textViewID);
        textView1= (TextView) findViewById(R.id.textViewDetailsID);
        imageView= (ImageView) findViewById(R.id.imageViewId);

        Bundle bundle= getIntent().getExtras();

        if(bundle!=null){

            textView.setText(bundle.getString("salat_names"));
            textView1.setText(bundle.getString("salat_description"));
            imageView.setImageResource(bundle.getInt("description_images"));

        }


    }
}

