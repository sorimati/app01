package com.test.sotusei102;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //リスナ設定
        Button btClick=findViewById(R.id.Calculation);
        Calculation Calculation=new Calculation();
        btClick.setOnClickListener(Calculation);

        Button btClick2=findViewById(R.id.Clear);
        Clear Clear=new Clear();
        btClick2.setOnClickListener(Clear);

        //アプリ名セット
        setTitle(getString(R.string.app_name));


    }

    //画面が破棄される前に状態を保持
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView output=findViewById(R.id.textView);
        TextView output2=findViewById(R.id.textView2);
        TextView output3=findViewById(R.id.textView3);
        outState.putString("output",output.getText().toString());
        outState.putString("output2",output2.getText().toString());
        outState.putString("output3",output3.getText().toString());
    }

    //画面が復元される時に状態を取り出し
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView output=findViewById(R.id.textView);
        TextView output2=findViewById(R.id.textView2);
        TextView output3=findViewById(R.id.textView3);
        output.setText(savedInstanceState.getString("output"));
        output2.setText(savedInstanceState.getString("output2"));
        output3.setText(savedInstanceState.getString("output3"));
    }

    //クリアボタンをクリックした時のリスナ
    private  class Clear implements View.OnClickListener{
        public void onClick(View v) {
            //原稿・表示ビュー取得
            EditText input=findViewById(R.id.input);
            TextView output=findViewById(R.id.textView);
            TextView output2=findViewById(R.id.textView2);
            TextView output3=findViewById(R.id.textView3);

            //中身消去
            input.setText("");
            output.setText(getString(R.string.textView));
            output2.setText(getString(R.string.textView2));
            output3.setText(getString(R.string.textView3));
        }
    }

    //計算ボタンをクリックした時のリスナ
    private class Calculation implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //原稿・表示ビュー取得
            EditText input=findViewById(R.id.input);
            TextView output=findViewById(R.id.textView);
            TextView output2=findViewById(R.id.textView2);
            TextView output3=findViewById(R.id.textView3);

            //文字数取得・表示
            String inputStr=input.getText().toString();
            int count=inputStr.trim().length();
            output.setText(getString(R.string.textView)+count+"文字");

            //時間計算・表示
            int best=count/5;
            int Fast=count/8;

            int sec, min, hour;
            sec=best;

            hour = sec / 3600;
            min = (sec%3600) / 60;
            sec = sec % 60;

            output2.setText(getString(R.string.textView2)+hour+"時間"+min+"分"+sec+"秒");

            sec=Fast;

            hour = sec / 3600;
            min = (sec%3600) / 60;
            sec = sec % 60;

            output3.setText(getString(R.string.textView3)+hour+"時間"+min+"分"+sec+"秒");

        }
    }
}
