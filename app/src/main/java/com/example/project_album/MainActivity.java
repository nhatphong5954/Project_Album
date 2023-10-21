package com.example.project_album;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtSoloMsg;
    ImageView imgSoloPhoto;
    Button btnSoloBack, btnDelete;
    Bundle myOriginalMemoryBundle;
    String[] items={"Image 1","Image 2"};
    Integer[] largeImages;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void showBigScreen(int position) {
        // show the selected picture as a single frame in the second layout
        setContentView(R.layout.solo_image_layout);
        // plumbing – second layout
        txtSoloMsg = (TextView) findViewById(R.id.txtSoloMsg);
        imgSoloPhoto = (ImageView) findViewById(R.id.imgSolo);
        // set caption-and-large picture
        txtSoloMsg.setText(" Position= " + position + " " + items[position]);
        imgSoloPhoto.setImageResource( largeImages[position] );
        // set GO BACK button to return to layout1 (GridView)
        btnSoloBack = (Button) findViewById(R.id.btnSoloBack);
        btnDelete=(Button) findViewById(R.id.btnSoloDelete);
        btnSoloBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // redraw the main screen showing the GridView
                onCreate(myOriginalMemoryBundle);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}