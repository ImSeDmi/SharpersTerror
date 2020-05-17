package com.example.sharpersterror;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
try{
    Intent intent = new Intent(GameLevels.this, MainActivity.class);
    startActivity(intent);finish();
}
catch(Exception e){
} } });
        // Уровень 1 --- Кнопка ---
        TextView button_1 = (TextView) findViewById(R.id.textView1);
        button_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Intent intent = new Intent(GameLevels.this, Level1.class);
                    startActivity(intent);finish();
                }
                catch(Exception e){
                } } });

        // Уровень 2 --- Кнопка ---
        TextView button_2 = (TextView) findViewById(R.id.textView2);
        button_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{

                }
                catch(Exception e){
                } } });


    }
@Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);finish();
        }catch(Exception e){
        }
    }





}
