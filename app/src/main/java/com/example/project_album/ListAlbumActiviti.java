package com.example.project_album;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import com.example.project_album.Adapter.Album_Adapter;
import com.example.project_album.R;
import com.example.project_album.Model.Album;

import java.util.ArrayList;
import java.util.List;
public class ListAlbumActiviti extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private RecyclerView rcv_list_album;

    private ImageButton imgb_popup;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_album_activiti);

        recyclerViewAlbum();

        this.imgb_popup = (ImageButton) findViewById(R.id.popup_menu);
        this.imgb_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        });
    }

    private void recyclerViewAlbum() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        this.rcv_list_album = (RecyclerView) findViewById(R.id.rcv_list_album);
        this.rcv_list_album.setLayoutManager(layoutManager);

        Album_Adapter albumAdapter = new Album_Adapter();
        albumAdapter.setData(loadAlbum());
        rcv_list_album.setAdapter(albumAdapter);

    }

    private List<Album> loadAlbum()
    {
        List<Album> albumList = new ArrayList<>();
        albumList.add(new Album(1, R.drawable.ic_launcher_foreground, "Tất cả"));
        albumList.add(new Album(1, R.drawable.ic_launcher_background, "Camera"));
        albumList.add(new Album(1, R.drawable.ic_launcher_foreground, "Screen short"));
        albumList.add(new Album(1, R.drawable.custom_item_album, "Đã thích"));
        albumList.add(new Album(1, R.drawable.ic_launcher_foreground, "Riêng tư"));

        return albumList;
    }

    public void showPopup(View v)
    {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
//        switch (menuItem.getItemId())
//        {
//            case R.id.item1:
//                //todo
//                return true;
//            case R.id.item2:
//                //todo
//                return true;
//            default:
//                return false;
//        }
        return false;
    }
}