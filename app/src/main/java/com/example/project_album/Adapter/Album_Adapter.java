package com.example.project_album.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_album.Model.Album;
import com.example.project_album.R;

import java.util.List;

public class Album_Adapter extends RecyclerView.Adapter<Album_Adapter.AlbumViewHolder>{
    private List<Album> listAlbum;

    public void setData(List<Album> listAlbum)
    {
        this.listAlbum = listAlbum;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_album_item, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = this.listAlbum.get(position);
        if(album == null)
        {
            return;
        }

        holder.imgv_album.setImageResource(album.getResource_id());
        holder.tv_album.setText(album.getName());

    }

    @Override
    public int getItemCount() {
        if(this.listAlbum != null)
        {
            return  this.listAlbum.size();
        }
        return 0;
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgv_album;
        private TextView tv_album;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgv_album = (ImageView) itemView.findViewById(R.id.imgv_album);
            this.tv_album = (TextView) itemView.findViewById(R.id.tv_name_album);
        }
    }
}
