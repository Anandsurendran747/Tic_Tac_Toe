package com.example.tictsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class gameactivity extends AppCompatActivity {

    String Xname2;
    String Oname2;
    int a=0;
    Boolean test1=false;
    public static final String name="com.example.tictsc.name";
    public static final String aname="com.example.tictsc.aname";
    public static final String x2="com.example.tictsc.x";
    public static final String o2="com.example.tictsc.o";

//    public String Xname;
//    public String Oname;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameactivity);





        Intent intent=getIntent();
        String Xname=intent.getStringExtra(MainActivity.First_name);
        String Oname=intent.getStringExtra(MainActivity.Second_name);

//        Intent intent=getIntent();
//        String Xname=intent.getStringExtra(MainActivity.First_name);
//        String Oname=intent.getStringExtra(MainActivity.Second_name);
//
//
//        TextView textView2=findViewById(R.id.textView8);
//        textView2.setText(Xname+Oname);
        Xname2=Xname;
        Oname2=Oname;



        String Xname1=intent.getStringExtra(status.x3);
        String Oname1=intent.getStringExtra(status.o3);
        Boolean test=intent.getBooleanExtra(status.testname,false);
        test1=test;
        if (test1){
            gameReset();
            Xname2=Xname1;
            Oname2=Oname1;
        }

        getSupportActionBar().setTitle(Xname2+" Vs "+Oname2);
        TextView textView=findViewById(R.id.textView2);
        textView.setText(Xname2+ " Tap To Play");




    }




    boolean gameActive=true;
    public static  int counter=0;
    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};


    

    public void  onclick(View view){

        ImageView img=(ImageView) view;
        int imgtag=Integer.parseInt(img.getTag().toString());



        if (gameState[imgtag]==2){
            counter++;

            if (counter==9){
                gameActive=false;
            }
            gameState[imgtag]=activePlayer;
            if (activePlayer==0 ){
                img.setImageResource(R.drawable.x);
                activePlayer=1;
                TextView textView=findViewById(R.id.textView2);
                textView.setText(Oname2+ " Tap To Play");

            }
            else if(activePlayer==1) {
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                TextView textView=findViewById(R.id.textView2);
                textView.setText(Xname2+ " Tap To Play");

            }
        }
        int flag=0;
//        String Xname=intent.getStringExtra(MainActivity.First_name);
//        String Oname=intent.getStringExtra(MainActivity.Second_name);
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                flag = 1;

                // Somebody has won! - Find out who!
                String winnerStr;

                // game reset function be called
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winnerStr =Xname2;
                    int a=1;

                    Intent intent1=new Intent(this,status.class);
                    intent1.putExtra(x2,Xname2);
                    intent1.putExtra(o2,Oname2);
                    intent1.putExtra(aname,a);
                    intent1.putExtra(name,winnerStr);
                    startActivity(intent1);
                } else {
                    winnerStr = Oname2;
                    int a=2;

                    Intent intent1=new Intent(this,status.class);
                    intent1.putExtra(x2,Xname2);
                    intent1.putExtra(o2,Oname2);
                    intent1.putExtra(aname,a);
                    intent1.putExtra(name,winnerStr);
                    startActivity(intent1);
                }


            }

        }
        if (counter == 9 && flag == 0) {
            int a=3;

            Intent intent1=new Intent(this,status.class);
            intent1.putExtra(x2,Xname2);
            intent1.putExtra(o2,Oname2);
            intent1.putExtra(aname,a);
            startActivity(intent1);
        }
    }

    public void gameReset() {
        gameActive = true;
        activePlayer = 0;
        counter=0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        // remove all the images from the boxes inside the grid
        ((ImageView) findViewById(R.id.imageView35)).setImageResource(R.drawable.white1);
        ((ImageView) findViewById(R.id.imageView36)).setImageResource(R.drawable.white1);
        ((ImageView) findViewById(R.id.imageView37)).setImageResource(R.drawable.white1);
        ((ImageView) findViewById(R.id.imageView40)).setImageResource(R.drawable.white1);
        ((ImageView) findViewById(R.id.imageView41)).setImageResource(R.drawable.white1);
        ((ImageView) findViewById(R.id.imageView42)).setImageResource(R.drawable.white1);
        ((ImageView) findViewById(R.id.imageView43)).setImageResource(R.drawable.white1);
        ((ImageView) findViewById(R.id.imageView38)).setImageResource(R.drawable.white1);
        ((ImageView) findViewById(R.id.imageView39)).setImageResource(R.drawable.white1);

        TextView status = findViewById(R.id.textView2);
        status.setText(Xname2+" Tap To Play");
    }



}