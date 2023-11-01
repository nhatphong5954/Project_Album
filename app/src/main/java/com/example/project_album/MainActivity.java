package com.example.project_album;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GridView gridview;
    TextView txtSoloMsg;
    ImageView imgSoloPhoto;
    Button btnSoloBack, btnDelete, btnAlbum;
    Bundle myOriginalMemoryBundle;
    String[] items={"Image 1","Image 2","Image 3","Image 4"};
    Integer[] thumbnails = {R.drawable.lake_1, R.drawable.lake_2, R.drawable.lake_3, R.drawable.mountain_1};
    Integer[] largeImages = {R.drawable.lake_1, R.drawable.lake_2, R.drawable.lake_3, R.drawable.mountain_1};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview = (GridView) findViewById(R.id.gv_ListItems);
        gridview.setAdapter(new MyImageAdapter(this, thumbnails));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { showBigScreen(position); }
        });

        btnAlbum = (Button) findViewById(R.id.btn_album);
        btnAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListAlbumActiviti.class);
                startActivity(intent);
            }
        });
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