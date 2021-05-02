package com.example.tictsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText name1;
    EditText name2;
    public static final String First_name="com.example.tictsc.first.name";
    public static final String Second_name="com.example.tictsc.second.name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void startGame(View view){
        Intent intent=new Intent(this,gameactivity.class);
         name1= findViewById(R.id.editTextTextPersonName);
         name2=findViewById(R.id.editTextTextPersonName2);
         String Xname=name1.getText().toString();
         String Oname=name2.getText().toString();

         if (Xname.equals("") && Oname.equals("")){
             Toast.makeText(this, "Enter the Names", Toast.LENGTH_SHORT).show();
         }
         else {
             intent.putExtra(First_name,Xname);
             intent.putExtra(Second_name,Oname);
             startActivity(intent);

         }



    }





}