package com.andresbush.primeraappandresbush;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.sax.StartElementListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import static java.lang.Thread.*;

public class MainActivity extends ActionBarActivity {

    //private Button b1; // no hay nada que nos diga que ese boton es el que quiero usar en layout
    MediaPlayer mySound;
    Integer Estado=0;
    Integer Actual=0;
    Integer Pasado=0;
    Integer ActualTag=0;
    Integer PasadoTag=0;
    Integer Intentos=0;
    Integer Parejas=0;
    Button b;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // para decir escribo

        /*Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setText("1");
            }
        });*/

        setContentView(R.layout.activity_main);
        mySound = MediaPlayer.create(this, R.raw.beat);

        Button b1 = (Button) findViewById(R.id.button1);
        b1.setTag(1);
        Button b2 = (Button) findViewById(R.id.button3);
        b2.setTag(2);
        Button b3 = (Button) findViewById(R.id.button2);
        b3.setTag(3);
        Button b4 = (Button) findViewById(R.id.button5);
        b4.setTag(4);
        Button b5 = (Button) findViewById(R.id.button4);
        b5.setTag(5);
        Button b6 = (Button) findViewById(R.id.button7);
        b6.setTag(6);
        Button b7 = (Button) findViewById(R.id.button6);
        b7.setTag(7);
        Button b8 = (Button) findViewById(R.id.button8);
        b8.setTag(8);
        Button b9 = (Button) findViewById(R.id.button10);
        b9.setTag(9);
        Button b10 = (Button) findViewById(R.id.button11);
        b10.setTag(0);
        Button b11 = (Button) findViewById(R.id.button9);
        b11.setTag(1);
        Button b12 = (Button) findViewById(R.id.button12);
        b12.setTag(2);
        Button b13 = (Button) findViewById(R.id.button16);
        b13.setTag(3);
        Button b14 = (Button) findViewById(R.id.button20);
        b14.setTag(4);
        Button b15 = (Button) findViewById(R.id.button13);
        b15.setTag(5);
        Button b16 = (Button) findViewById(R.id.button18);
        b16.setTag(6);
        Button b17 = (Button) findViewById(R.id.button15);
        b17.setTag(7);
        Button b18 = (Button) findViewById(R.id.button14);
        b18.setTag(8);
        Button b19 = (Button) findViewById(R.id.button19);
        b19.setTag(9);
        Button b20 = (Button) findViewById(R.id.button17);
        b20.setTag(0);

    }

    public void Metodo(View view) throws InterruptedException {

        mySound.start();
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Integer numeroj = SP.getInt("nj", 0);
        Integer mayorp = SP.getInt("mp", 0);


        b=(Button) view ;
        Actual = b.getId();
        ActualTag = (Integer)b.getTag();

        switch (Estado){
            case 0:
                b.setText(ActualTag.toString());
                Estado = 1;
                break;
            case 1:
                if(Objects.equals(Actual, Pasado)){
                    Toast.makeText(this, R.string.Mensaje, Toast.LENGTH_LONG).show();
                }else{
                    b.setText(ActualTag.toString());
                    bt = (Button) findViewById(Pasado);
                    if(Objects.equals(ActualTag, PasadoTag)){
                        Parejas = Parejas+1;
                        b.setEnabled(false);
                        bt.setEnabled(false);
                    }else{
                        //sleep(1000);
                        Intentos = Intentos+1;

                        Handler del= new Handler();
                        del.postDelayed(new Runnable() {
                            public void run() {
                                bt.setText("???");
                                b.setText("???");
                            }
                        }, 1000);

                    }
                    TextView text1=(TextView)findViewById(R.id.textView5);
                    TextView text2=(TextView)findViewById(R.id.textView6);
                    text1.setText(Intentos.toString());
                    text2.setText(Parejas.toString());
                    Estado = 0;
                    if(Objects.equals(Parejas, 10)){
                        TextView text3=(TextView)findViewById(R.id.textView4);
                        text3.setText("Ganaste !!!!");
                        if(Intentos<10){
                            if(mayorp<100-Intentos*10 )
                            mayorp = 100-Intentos*10;
                        }
                        numeroj = numeroj+1;
                    }
                }
                break;
        }

        Pasado = Actual;
        PasadoTag = ActualTag;

        SharedPreferences.Editor editor = SP.edit();
        editor.putInt("nj", numeroj);
        editor.putInt("mp", mayorp);
        editor.commit();

    }

    public void Metodo2(View view) {
        startActivity(new Intent(getApplicationContext(), Historial.class));
    }

    public void newgame(View view) {
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setEnabled(true);
        b1.setText("???");
        Button b2 = (Button) findViewById(R.id.button3);
        b2.setEnabled(true);
        b2.setText("???");
        Button b3 = (Button) findViewById(R.id.button2);
        b3.setEnabled(true);
        b3.setText("???");
        Button b4 = (Button) findViewById(R.id.button5);
        b4.setEnabled(true);
        b4.setText("???");
        Button b5 = (Button) findViewById(R.id.button4);
        b5.setEnabled(true);
        b5.setText("???");
        Button b6 = (Button) findViewById(R.id.button7);
        b6.setEnabled(true);
        b6.setText("???");
        Button b7 = (Button) findViewById(R.id.button6);
        b7.setEnabled(true);
        b7.setText("???");
        Button b8 = (Button) findViewById(R.id.button8);
        b8.setEnabled(true);
        b8.setText("???");
        Button b9 = (Button) findViewById(R.id.button10);
        b9.setEnabled(true);
        b9.setText("???");
        Button b10 = (Button) findViewById(R.id.button11);
        b10.setEnabled(true);
        b10.setText("???");
        Button b11 = (Button) findViewById(R.id.button9);
        b11.setEnabled(true);
        b11.setText("???");
        Button b12 = (Button) findViewById(R.id.button12);
        b12.setEnabled(true);
        b12.setText("???");
        Button b13 = (Button) findViewById(R.id.button16);
        b13.setEnabled(true);
        b13.setText("???");
        Button b14 = (Button) findViewById(R.id.button20);
        b14.setEnabled(true);
        b14.setText("???");
        Button b15 = (Button) findViewById(R.id.button13);
        b15.setEnabled(true);
        b15.setText("???");
        Button b16 = (Button) findViewById(R.id.button18);
        b16.setEnabled(true);
        b16.setText("???");
        Button b17 = (Button) findViewById(R.id.button15);
        b17.setEnabled(true);
        b17.setText("???");
        Button b18 = (Button) findViewById(R.id.button14);
        b18.setEnabled(true);
        b18.setText("???");
        Button b19 = (Button) findViewById(R.id.button19);
        b19.setEnabled(true);
        b19.setText("???");
        Button b20 = (Button) findViewById(R.id.button17);
        b20.setEnabled(true);
        b20.setText("???");
        Estado=0;
        Actual=0;
        Pasado=0;
        ActualTag=0;
        PasadoTag=0;
        Intentos=0;
        Parejas=0;
        TextView text1=(TextView)findViewById(R.id.textView5);
        TextView text2=(TextView)findViewById(R.id.textView6);
        text1.setText(Intentos.toString());
        text2.setText(Parejas.toString());
    }
}
