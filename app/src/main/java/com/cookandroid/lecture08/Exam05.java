package com.cookandroid.lecture08;

import java.io.FileInputStream;
import java.io.IOException;

import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Exam05 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam05);
        setTitle("예제5 (SD card page37)");

        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        Button btnRead;
        final EditText edtSD;
        btnRead = (Button) findViewById(R.id.btnRead);
        edtSD = (EditText) findViewById(R.id.edtSD);

        btnRead.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    final String realPath = Environment.getExternalStorageDirectory().getPath().toString() + "/sd_test.txt";
                    Toast.makeText(getApplication(), realPath, Toast.LENGTH_LONG).show();
                    //FileInputStream inFs = new FileInputStream( "/storage/emulated/0/sd_test.txt");
                    //FileInputStream inFs = new FileInputStream( "/sdcard/sd_test.txt");
                    FileInputStream inFs = new FileInputStream(realPath);
                    byte[] txt = new byte[inFs.available()];
                    inFs.read(txt);
                    edtSD.setText(new String(txt));
                    inFs.close();
                } catch (IOException e) {
                }
            }
        });
    }

}
