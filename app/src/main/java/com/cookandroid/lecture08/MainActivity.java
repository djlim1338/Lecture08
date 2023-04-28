package com.cookandroid.lecture08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<Integer, Class> runMap = new HashMap<Integer, Class>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runMap.put(R.id.main_btn_exam01, Exam01.class);
        runMap.put(R.id.main_btn_exam02, Exam02.class);
        runMap.put(R.id.main_btn_exam03, Exam03.class);
        runMap.put(R.id.main_btn_exam04, Exam04.class);
        runMap.put(R.id.main_btn_exam05, Exam05.class);
    }

    public void btnChecked(View v){
        openIntent(runMap.get(v.getId()));
    }

    public void openIntent(Class openJava){
        Intent intent = new Intent(getApplicationContext(), openJava);
        startActivity(intent);
    }
}