package com.example.mysalatapp1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button1;
    private AlertDialog.Builder alertdialogbuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.buttonId);
        button1=(Button) findViewById(R.id.buttonWebId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1= new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent1);

            }
        });


    }
    @Override

    public void onBackPressed() {
        alertdialogbuilder= new AlertDialog.Builder(MainActivity.this);

        alertdialogbuilder.setTitle(R.string.title_text);
        alertdialogbuilder.setMessage(R.string.message_text);
        alertdialogbuilder.setIcon(R.drawable.question);
        alertdialogbuilder.setCancelable(false);
        alertdialogbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();

            }
        });

        alertdialogbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this,"You have clicked on no button",Toast.LENGTH_SHORT).show();

            }
        });

        alertdialogbuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this,"You have clicked on cancel button",Toast.LENGTH_SHORT).show();

            }
        });

        AlertDialog alertDialog=alertdialogbuilder.create();
        alertDialog.show();
    }
}
