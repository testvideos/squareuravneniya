package shvab.shapiro.squareuravneniya;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        setSupportActionBar(toolbar);

    }
    void snekbar(String s,View view){
        Snackbar.make(view, s, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    public void vydela(View view){
        EditText a = findViewById(R.id.coefficient_a);
        a.selectAll();
    }
    public void vydelb(View view){
        EditText a = findViewById(R.id.coefficient_b);
        a.selectAll();
    }
    public void vydelc(View view){
        EditText a = findViewById(R.id.coefficient_c);
        a.selectAll();
    }
    public void solveEquation(View view) {
        EditText texta=findViewById(R.id.coefficient_a);
        EditText textb=findViewById(R.id.coefficient_b);
        EditText textc=findViewById(R.id.coefficient_c);
        double a,b,c;

        try{if (Double.parseDouble(texta.getText().toString())==0) {texta.setText("");a=0;}else{
            a = Double.parseDouble(texta.getText().toString());}}catch(NumberFormatException e){texta.setText("");a=0;}
        try{if (Double.parseDouble(textb.getText().toString())==0) {textb.setText("");b=0;}else{
            b = Double.parseDouble(textb.getText().toString());}}catch(NumberFormatException e){textb.setText("");b=0;}
        try{if (Double.parseDouble(textc.getText().toString())==0) {textc.setText("");c=0;}else{
            c = Double.parseDouble(textc.getText().toString());}}catch(NumberFormatException e){textc.setText("");c=0;}
        double d = b*b-4*a*c;
        TextView result = (TextView) findViewById(R.id.result);
        if(a!=0){
            // ax2+bx+c=0
            if(d>0){
                double x1=(-b+Math.sqrt(d))/2/a;
                double x2=(-b-Math.sqrt(d))/2/a;
                if(x1==-0){x1=0;}
                if(x2==-0){x2=0;}
                if(x1%1==0){
                    if(x2%1==0){
                        result.setText(String.valueOf(Math.round(x1)) + " \n " + String.valueOf(Math.round(x2)));
                    }else{
                        result.setText(String.valueOf(Math.round(x1)) + " \n " + String.valueOf(x2));
                    }
                }else{
                    if(x2%1==0){
                        result.setText(String.valueOf(x1) + " \n " + String.valueOf(Math.round(x1)));
                    }else{
                        result.setText(String.valueOf(x1) + " \n " + String.valueOf(x2));
                    }
                }
            }
            if(d==0){
                double x1=(-b+Math.sqrt(d))/2/a;
                result.setText("" + String.valueOf(x1));
                if(x1==-0){x1=0;}
                if(x1%1==0){
                    result.setText("" + String.valueOf(Math.round(x1)));
                }else{
                    result.setText("" + String.valueOf(x1));
                }
            }
            if(d<0){
                result.setText("Ø");
            }
        }else{
            // bx+c=0
            if(b!=0){
                double x1=-c/b;
                if(x1==-0){x1=0;}
                if(x1%1==0){
                    result.setText("" + String.valueOf(Math.round(x1)));
                }else{
                    result.setText("" + String.valueOf(x1));
                }
            }else{
                if(c!=0){
                    result.setText("Ø");
                }else{
                    result.setText("хер");
                }
            }
        }
    }

}
