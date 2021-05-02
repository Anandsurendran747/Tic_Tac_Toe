package com.example.tictsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class status extends AppCompatActivity {
    Boolean test=false;
    TextView textView;
    TextView textView2;
    Button button;
    String Xname2;
    String Oname2;
    String name;
    public static final String x3="com.example.tictsc.x2";
    public static final String o3="com.example.tictsc.o2";
    public static final String testname="com.example.tictsc.test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Intent intent1=getIntent();
        int a=intent1.getIntExtra(gameactivity.aname,0);
        String Xname2=intent1.getStringExtra(gameactivity.x2);
        String Oname2=intent1.getStringExtra(gameactivity.o2);
        String name=intent1.getStringExtra(gameactivity.name);
        textView=findViewById(R.id.textView5);
        if (a==1){
            textView.setText("Congradulations...\n"+Xname2+"    Wins");
        }else if(a==2){
            textView.setText("Congradulations...\n"+Oname2+"    Wins");
        }else if (a==3){
            textView.setText("Tie Game");
        }

        Button gamereset=findViewById(R.id.button3);
        Button gohome=findViewById(R.id.button4);
        gamereset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test=true;
                Intent intent2=new Intent(status.this,gameactivity.class);
                intent2.putExtra(x3,Xname2);
                intent2.putExtra(o3,Oname2);
                intent2.putExtra(testname,test);
                startActivity(intent2);
            }
        });
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(status.this,MainActivity.class);
                startActivity(intent3);
            }
        });


    }

}

