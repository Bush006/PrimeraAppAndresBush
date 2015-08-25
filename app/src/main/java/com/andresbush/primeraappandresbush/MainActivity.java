package com.andresbush.primeraappandresbush;

import android.media.MediaPlayer;
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

        Button b=(Button) view ;
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
                    Button bt = (Button) findViewById(Pasado);
                    if(Objects.equals(ActualTag, PasadoTag)){
                        Parejas = Parejas+1;
                        b.setEnabled(false);
                        bt.setEnabled(false);
                    }else{
                        sleep(1000);
                        Intentos = Intentos+1;
                        bt.setText("???");
                        b.setText("???");
                    }
                    TextView text1=(TextView)findViewById(R.id.textView5);
                    TextView text2=(TextView)findViewById(R.id.textView6);
                    text1.setText(Intentos.toString());
                    text2.setText(Parejas.toString());
                    Estado = 0;
                    if(Objects.equals(Parejas, 10)){
                        TextView text3=(TextView)findViewById(R.id.textView4);
                        text3.setText("Ganaste !!!!");
                    }
                }
                break;
        }

        Pasado = Actual;
        PasadoTag = ActualTag;
    }
}
