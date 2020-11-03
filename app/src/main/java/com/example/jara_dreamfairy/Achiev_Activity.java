package com.example.jara_dreamfairy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

public class Achiev_Activity extends AppCompatActivity {

    private LinearLayout[] linearLayout = new LinearLayout[5];
    private ImageButton[] imageButton = new ImageButton[5];
    private ProgressBar[] progressBar = new ProgressBar[5];
    private ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achiev_);

        linearLayout[0] = (LinearLayout)findViewById(R.id.achiev_1);
        linearLayout[1] = (LinearLayout)findViewById(R.id.achiev_2);
        linearLayout[2] = (LinearLayout)findViewById(R.id.achiev_3);
        linearLayout[3] = (LinearLayout)findViewById(R.id.achiev_4);
        linearLayout[4] = (LinearLayout)findViewById(R.id.achiev_5);

        progressBar[0] = (ProgressBar)findViewById(R.id.achiev_1_progressbar);
        progressBar[1] = (ProgressBar)findViewById(R.id.achiev_2_progressbar);
        progressBar[2] = (ProgressBar)findViewById(R.id.achiev_3_progressbar);
        progressBar[3] = (ProgressBar)findViewById(R.id.achiev_4_progressbar);
        progressBar[4] = (ProgressBar)findViewById(R.id.achiev_5_progressbar);

        imageButton[0] = (ImageButton)findViewById(R.id.achiev_1_imagebutton);
        imageButton[1] = (ImageButton)findViewById(R.id.achiev_2_imagebutton);
        imageButton[2] = (ImageButton)findViewById(R.id.achiev_3_imagebutton);
        imageButton[3] = (ImageButton)findViewById(R.id.achiev_4_imagebutton);
        imageButton[4] = (ImageButton)findViewById(R.id.achiev_5_imagebutton);


    }
}