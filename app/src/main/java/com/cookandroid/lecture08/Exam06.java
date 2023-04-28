package com.cookandroid.lecture08;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Exam06 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam06);
        setTitle("예제6 (SD 디렉토리 생성 page41)");

        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        Button btnMkdir, btnRmdir;
        btnMkdir = (Button) findViewById(R.id.exam06_btn_make);
        btnRmdir = (Button) findViewById(R.id.exam06_btn_remove);

        final String strSDpath = Environment.getExternalStorageDirectory()
                .getAbsolutePath();
        final File myDir = new File(strSDpath + "/mydir");

        btnMkdir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myDir.mkdir();
                Toast.makeText(getApplication(), "생성: "+strSDpath+"/mydir", Toast.LENGTH_SHORT).show();
            }
        });

        btnRmdir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myDir.delete();
                Toast.makeText(getApplication(), "삭제: "+strSDpath+"/mydir", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
