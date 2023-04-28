package com.cookandroid.lecture08;

import java.io.File;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Exam08 extends AppCompatActivity {
    Button btnPrev, btnNext;
    TextView tvNum;
    Exam08MyPictureView myPicture;
    int curNum=0;
    File[] imageFiles = new File[0];
    String imageFname;
    String imagePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam08);
        setTitle("예제8 (SD 이미지 뷰어 page49)");
        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        tvNum = (TextView) findViewById(R.id.exam08_tv_num);
        myPicture = (Exam08MyPictureView) findViewById(R.id.myPictureView1);
        File[] allFiles = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath()+"/Pictures/renoir").listFiles();
        for (int i=0; i<allFiles.length; i++)
            if (allFiles[i].isFile()) {
                imageFiles = Arrays.copyOf(imageFiles, imageFiles.length + 1);
                imageFiles[imageFiles.length-1] = allFiles[i];
            }
        imageFname = imageFiles[curNum].toString();
        myPicture.imagePath=imageFname;

        imagePage = (curNum + 1) + " / " + (imageFiles.length);
        tvNum.setText(imagePage);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum <= 0) {
                    //Toast.makeText(getApplicationContext(), "첫번째 그림입니다", Toast.LENGTH_SHORT).show();
                    curNum = imageFiles.length - 1;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    imagePage = (curNum + 1) + " / " + (imageFiles.length);
                    tvNum.setText(imagePage);
                } else {
                    curNum--;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    imagePage = (curNum + 1) + " / " + (imageFiles.length);
                    tvNum.setText(imagePage);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (curNum >= imageFiles.length - 1) {
                    //Toast.makeText(getApplicationContext(), "마지막 그림입니다", Toast.LENGTH_SHORT).show();
                    curNum = 0;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    imagePage = (curNum + 1) + " / " + (imageFiles.length);
                    tvNum.setText(imagePage);
                } else {
                    curNum++;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    imagePage = (curNum + 1) + " / " + (imageFiles.length);
                    tvNum.setText(imagePage);
                }
            }
        });
    }
}
