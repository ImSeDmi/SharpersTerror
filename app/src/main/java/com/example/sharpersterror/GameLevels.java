package com.example.sharpersterror;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sharpersterror.DBClasses.DatabaseHelperLC;
import com.example.sharpersterror.Levels.Level1;

public class GameLevels extends AppCompatActivity {

    DatabaseHelperLC databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // создаем базу данных
        databaseHelper = new DatabaseHelperLC(getApplicationContext());
        databaseHelper.create_db();

    }

    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = databaseHelper.open();
        //получаем данные из бд в виде курсора
        userCursor =  db.rawQuery("select * from "+ DatabaseHelperLC.TABLE, null);



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


        TextView button_1 = (TextView) findViewById(R.id.textView1);
        TextView button_2 = (TextView) findViewById(R.id.textView2);
        TextView button_3 = (TextView) findViewById(R.id.textView3);
        TextView button_4 = (TextView) findViewById(R.id.textView4);

        userCursor = db.rawQuery("select * from " + DatabaseHelperLC.TABLE + ";",null);
        userCursor.moveToFirst();
        do{
            int id = userCursor.getInt(0);
            int access = userCursor.getInt(2);
            switch(id){
                case 1:
                    ButtonVisualiser(access, button_1);
                    break;
                case 2:
                    ButtonVisualiser(access, button_2);
                    break;
                case 3:
                    ButtonVisualiser(access, button_3);
                    break;
                case 4:
                    ButtonVisualiser(access, button_4);
                    break;
            }

        }
        while(userCursor.moveToNext());

        // Уровень 1 --- Кнопка ---
        button_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Intent intent = new Intent(GameLevels.this, Level1.class);
                    intent.putExtra("id", 1);
                    startActivity(intent);
                    // Закрываем подключение и курсор
                    db.close();
                    userCursor.close();
                    finish();
                }
                catch(Exception e){
                } } });

        // Уровень 2 --- Кнопка ---
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

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }

    public void ButtonVisualiser(int access, TextView textView){
        if (access == 1){
            textView.setBackgroundResource(R.drawable.menu_button);
        } else {
            textView.setBackgroundResource(R.drawable.style_gamelevels_blocked_button);
        }
    }

}

