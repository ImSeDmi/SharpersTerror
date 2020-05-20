package com.example.sharpersterror.Levels;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sharpersterror.Array;
import com.example.sharpersterror.DBClasses.DatabaseHelperLC;
import com.example.sharpersterror.GameLevels;
import com.example.sharpersterror.R;

import java.util.Random;

public class Level1 extends AppCompatActivity {

    Dialog dialog;

    Array array = new Array(); // создали новый объект из класса Array

    public int i = 0;

    DatabaseHelperLC sqlHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1);

        sqlHelper = new DatabaseHelperLC(this);
        db = sqlHelper.open();

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Line00();
    }


    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level1.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }

    //меняем стили кнопок в зависимости от i
    public void ChangeColor00() {
        Button button_prev = (Button) findViewById(R.id.PrevButton);
        Button button_next = (Button) findViewById(R.id.NextButton);
        if (i == 0) {

            button_prev.setVisibility(View.INVISIBLE);
            button_next.setBackgroundResource(R.drawable.style_nextprev_normal_button);
        }
        if (i > 0 && i < array.dialog1.length - 1) {
            button_prev.setVisibility(View.VISIBLE);
            button_prev.setBackgroundResource(R.drawable.style_nextprev_normal_button);
            button_next.setBackgroundResource(R.drawable.style_nextprev_normal_button);
        }
        if (i == array.dialog1.length - 1) {
            button_prev.setVisibility(View.VISIBLE);
            button_prev.setBackgroundResource(R.drawable.style_nextprev_normal_button);
            button_next.setBackgroundResource(R.drawable.style_nextprev_accepted_button);
        }
    }
    public void ChangeColor01() {
        Button button_prev = (Button) findViewById(R.id.PrevButton);
        Button button_next = (Button) findViewById(R.id.NextButton);
        if (i == 0) {

            button_prev.setVisibility(View.INVISIBLE);
            button_next.setBackgroundResource(R.drawable.style_nextprev_normal_button);
        }
        if (i > 0 && i < array.dialog01.length - 1) {
            button_prev.setVisibility(View.VISIBLE);
            button_prev.setBackgroundResource(R.drawable.style_nextprev_normal_button);
            button_next.setBackgroundResource(R.drawable.style_nextprev_normal_button);
        }
        if (i == array.dialog01.length - 1) {
            button_prev.setVisibility(View.VISIBLE);
            button_prev.setBackgroundResource(R.drawable.style_nextprev_normal_button);
            button_next.setBackgroundResource(R.drawable.style_nextprev_accepted_button);
        }
    }
    public void ChangeColor02() {
        Button button_prev = (Button) findViewById(R.id.PrevButton);
        Button button_next = (Button) findViewById(R.id.NextButton);
        if (i == 0) {

            button_prev.setVisibility(View.INVISIBLE);
            button_next.setBackgroundResource(R.drawable.style_nextprev_normal_button);
        }
        if (i > 0 && i < array.dialog02.length - 1) {
            button_prev.setVisibility(View.VISIBLE);
            button_prev.setBackgroundResource(R.drawable.style_nextprev_normal_button);
            button_next.setBackgroundResource(R.drawable.style_nextprev_normal_button);
        }
        if (i == array.dialog02.length - 1) {
            button_prev.setVisibility(View.VISIBLE);
            button_prev.setBackgroundResource(R.drawable.style_nextprev_normal_button);
            button_next.setBackgroundResource(R.drawable.style_nextprev_accepted_button);
        }
    }
    public void ChangeColor04() {
        Button button_prev = (Button) findViewById(R.id.PrevButton);
        Button button_next = (Button) findViewById(R.id.NextButton);
        if (i == 0) {

            button_prev.setVisibility(View.INVISIBLE);
            button_next.setBackgroundResource(R.drawable.style_nextprev_normal_button);
        }
        if (i > 0 && i < array.dialog04.length - 1) {
            button_prev.setVisibility(View.VISIBLE);
            button_prev.setBackgroundResource(R.drawable.style_nextprev_normal_button);
            button_next.setBackgroundResource(R.drawable.style_nextprev_normal_button);
        }
        if (i == array.dialog04.length - 1) {
            button_prev.setVisibility(View.VISIBLE);
            button_prev.setBackgroundResource(R.drawable.style_nextprev_normal_button);
            button_next.setBackgroundResource(R.drawable.style_nextprev_accepted_button);
        }
    }


    //сюжетные линии
    public void Line00() {
        //Вызов диалогового окна в начале игры
        dialog = new Dialog(this);  //создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialog.setContentView(R.layout.previewdialog1); //путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон окна
        dialog.setCancelable(false); //нельзя закрыть окно кнопкой НАЗАД

        //кнопка которая закроет диалоговое окно

        TextView buttonclose = (TextView) dialog.findViewById(R.id.button_close);
        buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                dialog.dismiss();
            }
        });

        //кнопка продолжить

        Button buttoncontinue = (Button) dialog.findViewById(R.id.button_continue);
        buttoncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dialog.dismiss();
                } catch (Exception e) {
                }
            }
        });

        dialog.show(); //показать окно


        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }//конец
            }

        });


        ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
        TextView char_name = (TextView) findViewById(R.id.CharName);
        TextView char_text = (TextView) findViewById(R.id.CharText);
        char_img.setImageResource(array.images1[array.dialog1[i]]);
        char_name.setText(array.names1[array.dialog1[i]]);
        char_text.setText(array.texts00[i]);
        ChangeColor00();

        //тестируем кнопку prev
        Button button_prev = (Button) findViewById(R.id.PrevButton);
        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (i != 0) {
                        ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
                        TextView char_name = (TextView) findViewById(R.id.CharName);
                        TextView char_text = (TextView) findViewById(R.id.CharText);
                        i--;


                        char_img.setImageResource(array.images1[array.dialog1[i]]);
                        char_name.setText(array.names1[array.dialog1[i]]);
                        char_text.setText(array.texts00[i]);
                        ChangeColor00();
                    }
                } catch (Exception e) {
                }
            }

        });

        // тестируем кнопку next
        Button button_next = (Button) findViewById(R.id.NextButton);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i != array.dialog1.length - 1) {
                    try {
                        if (i < array.dialog1.length - 1) {
                            ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
                            TextView char_name = (TextView) findViewById(R.id.CharName);
                            TextView char_text = (TextView) findViewById(R.id.CharText);

                            i++;

                            char_img.setImageResource(array.images1[array.dialog1[i]]);
                            char_name.setText(array.names1[array.dialog1[i]]);
                            char_text.setText(array.texts00[i]);
                            ChangeColor00();
                        }


                    } catch (Exception e) {
                    }
                } else {

                    dialog.setContentView(R.layout.previewdilemma0); //путь к макету диалогового окна
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон окна
                    dialog.setCancelable(false); //нельзя закрыть окно кнопкой НАЗАД

                    //кнопка которая закроет диалоговое окно
                    TextView buttonclose = (TextView) dialog.findViewById(R.id.button_close);
                    buttonclose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                            }

                        }
                    });
                    //кнопка 1

                    final Button button01 = (Button) dialog.findViewById(R.id.button1);
                    button01.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Line02();
                                dialog.dismiss();


                            } catch (Exception e) {
                            }

                        }
                    });

                    //кнопка 2
                    final Button button02 = (Button) dialog.findViewById(R.id.button2);
                    button02.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Line01();
                                dialog.dismiss();

                            } catch (Exception e) {
                            }

                        }
                    });

                    dialog.show(); //показать окно

                }
            }
        });


    }
    public void Line01() {
        i = 0;
        ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
        TextView char_name = (TextView) findViewById(R.id.CharName);
        TextView char_text = (TextView) findViewById(R.id.CharText);

        ChangeColor01();

        char_img.setImageResource(array.images1[array.dialog01[i]]);
        char_name.setText(array.names1[array.dialog01[i]]);
        char_text.setText(array.texts01[i]);

        Button button_prev = (Button) findViewById(R.id.PrevButton);
        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (i != 0) {
                        ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
                        TextView char_name = (TextView) findViewById(R.id.CharName);
                        TextView char_text = (TextView) findViewById(R.id.CharText);
                        i--;
                        char_img.setImageResource(array.images1[array.dialog01[i]]);
                        char_name.setText(array.names1[array.dialog01[i]]);
                        char_text.setText(array.texts01[i]);
                        ChangeColor01();
                    }
                } catch (Exception e) {
                }
            }

        });

        Button button_next = (Button) findViewById(R.id.NextButton);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i != array.dialog01.length - 1) {
                    try {
                        if (i < array.dialog01.length - 1) {
                            ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
                            TextView char_name = (TextView) findViewById(R.id.CharName);
                            TextView char_text = (TextView) findViewById(R.id.CharText);
                            i++;
                            char_img.setImageResource(array.images1[array.dialog01[i]]);
                            char_name.setText(array.names1[array.dialog01[i]]);
                            char_text.setText(array.texts01[i]);
                            ChangeColor01();
                        }
                    } catch (Exception e) {
                    }
                } else {
                    dialog.setContentView(R.layout.previewdialog0); //путь к макету диалогового окна
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон окна
                    dialog.setCancelable(false); //нельзя закрыть окно кнопкой НАЗАД

                    //кнопка которая закроет диалоговое окно
                    TextView buttonclose = (TextView) dialog.findViewById(R.id.button_close);
                    buttonclose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Intent intent = new Intent(Level1.this, GameLevels.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e) {
                            }
                            dialog.dismiss();
                        }
                    });
                    //кнопка 1
                    final Button button_end = (Button) dialog.findViewById(R.id.button_end);
                    button_end.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Intent intent = new Intent(Level1.this, GameLevels.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e) {
                            }
                            dialog.dismiss();
                        }
                    });
                    dialog.show(); //показать окно
                }
            }

        });
    }
    public void Line02() {
        i = 0;
        ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
        TextView char_name = (TextView) findViewById(R.id.CharName);
        TextView char_text = (TextView) findViewById(R.id.CharText);

        ChangeColor02();

        char_img.setImageResource(array.images1[array.dialog02[i]]);
        char_name.setText(array.names1[array.dialog02[i]]);
        char_text.setText(array.texts02[i]);

        Button button_prev = (Button) findViewById(R.id.PrevButton);
        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (i != 0) {
                        ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
                        TextView char_name = (TextView) findViewById(R.id.CharName);
                        TextView char_text = (TextView) findViewById(R.id.CharText);
                        i--;
                        char_img.setImageResource(array.images1[array.dialog02[i]]);
                        char_name.setText(array.names1[array.dialog02[i]]);
                        char_text.setText(array.texts02[i]);
                        ChangeColor02();
                    }
                } catch (Exception e) {
                }
            }

        });
        Button button_next = (Button) findViewById(R.id.NextButton);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i != array.dialog02.length - 1) {
                    try {
                        if (i < array.dialog02.length - 1) {
                            ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
                            TextView char_name = (TextView) findViewById(R.id.CharName);
                            TextView char_text = (TextView) findViewById(R.id.CharText);
                            i++;
                            char_img.setImageResource(array.images1[array.dialog02[i]]);
                            char_name.setText(array.names1[array.dialog02[i]]);
                            char_text.setText(array.texts02[i]);
                            ChangeColor02();
                        }
                    } catch (Exception e) {
                    }
                } else {
                    dialog.setContentView(R.layout.previewdilemma1); //путь к макету диалогового окна
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон окна
                    dialog.setCancelable(false); //нельзя закрыть окно кнопкой НАЗАД

                    TextView buttonclose = (TextView) dialog.findViewById(R.id.button_close);
                    buttonclose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                            }
                        }
                    });
                    final Button button1 = (Button) dialog.findViewById(R.id.button1);
                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Line03();
                                dialog.dismiss();
                            } catch (Exception e) {
                            }
                        }
                    });
                    final Button button2 = (Button) dialog.findViewById(R.id.button2);
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Line04();
                                dialog.dismiss();
                            } catch (Exception e) {
                            }
                        }
                    });
                    final Button button3 = (Button) dialog.findViewById(R.id.button3);
                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Line03();
                                dialog.dismiss();
                            } catch (Exception e) {
                            }
                        }
                    });
                    dialog.show(); //показать окно
                }
            }
        });
    }
    public void Line03() {
        i = 0;
        ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
        TextView char_name = (TextView) findViewById(R.id.CharName);
        TextView char_text = (TextView) findViewById(R.id.CharText);

        ChangeColor02();

        char_img.setImageResource(array.images1[array.dialog03[i]]);
        char_name.setText(array.names1[array.dialog03[i]]);
        char_text.setText(array.texts03[i]);
        Button button_prev = (Button) findViewById(R.id.PrevButton);
        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (i != 0) {
                        ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
                        TextView char_name = (TextView) findViewById(R.id.CharName);
                        TextView char_text = (TextView) findViewById(R.id.CharText);
                        i--;
                        char_img.setImageResource(array.images1[array.dialog03[i]]);
                        char_name.setText(array.names1[array.dialog03[i]]);
                        char_text.setText(array.texts03[i]);
                        ChangeColor02();
                    }
                } catch (Exception e) {
                }
            }

        });
        Button button_next = (Button) findViewById(R.id.NextButton);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i != array.dialog03.length - 1) {
                    try {
                        if (i < array.dialog03.length - 1) {
                            ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
                            TextView char_name = (TextView) findViewById(R.id.CharName);
                            TextView char_text = (TextView) findViewById(R.id.CharText);
                            i++;
                            char_img.setImageResource(array.images1[array.dialog03[i]]);
                            char_name.setText(array.names1[array.dialog03[i]]);
                            char_text.setText(array.texts03[i]);
                            ChangeColor02();
                        }
                    } catch (Exception e) {
                    }
                } else {
                   Line02();;
                }
            }
        });
    }
    public void Line04(){
        i = 0;
        ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
        TextView char_name = (TextView) findViewById(R.id.CharName);
        TextView char_text = (TextView) findViewById(R.id.CharText);

        ChangeColor04();

        char_img.setImageResource(array.images1[array.dialog04[i]]);
        char_name.setText(array.names1[array.dialog04[i]]);
        char_text.setText(array.texts04[i]);
        Button button_prev = (Button) findViewById(R.id.PrevButton);
        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (i != 0) {
                        ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
                        TextView char_name = (TextView) findViewById(R.id.CharName);
                        TextView char_text = (TextView) findViewById(R.id.CharText);
                        i--;
                        char_img.setImageResource(array.images1[array.dialog04[i]]);
                        char_name.setText(array.names1[array.dialog04[i]]);
                        char_text.setText(array.texts04[i]);
                        ChangeColor04();
                    }
                } catch (Exception e) {
                }
            }

        });
        Button buttonNext = (Button) findViewById(R.id.NextButton);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i != array.dialog04.length - 1) {
                    try {
                        if (i < array.dialog04.length - 1) {
                            ImageView char_img = (ImageView) findViewById(R.id.characterPic); //картинка персонажа
                            TextView char_name = (TextView) findViewById(R.id.CharName);
                            TextView char_text = (TextView) findViewById(R.id.CharText);
                            i++;
                            char_img.setImageResource(array.images1[array.dialog04[i]]);
                            char_name.setText(array.names1[array.dialog04[i]]);
                            char_text.setText(array.texts04[i]);
                            ChangeColor04();
                        }
                    } catch (Exception e) {
                    }
                } else {
                    dialog.setContentView(R.layout.previewdialog2); //путь к макету диалогового окна
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон окна
                    dialog.setCancelable(false); //нельзя закрыть окно кнопкой НАЗАД

                    TextView buttonclose = (TextView) dialog.findViewById(R.id.button_close);
                    buttonclose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                dialog.dismiss();
                            } catch (Exception e) {
                            }
                        }
                    });
                    final Button button1 = (Button) dialog.findViewById(R.id.button_end);
                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Intent intent = new Intent(Level1.this, GameLevels.class);
                                startActivity(intent);
                                dialog.dismiss();
                                finish();

                            } catch (Exception e) {
                            }
                        }
                    });
                    dialog.show(); //показать окно
                    ContentValues cv = new ContentValues();
                    cv.put(DatabaseHelperLC.COLUMN_ACCESS, 1);
                    db.update(DatabaseHelperLC.TABLE, cv, DatabaseHelperLC.COLUMN_ID + "=" + 2, null);
                    db.close();
                }
            }
        });
    }
}
