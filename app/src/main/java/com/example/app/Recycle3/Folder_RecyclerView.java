package com.example.app.Recycle3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

public class Folder_RecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder_recycler_view);
        RecyclerView rc3 = findViewById(R.id.rc_folder);
        FolderAdapter adapter = new FolderAdapter(CreateFolder());
        rc3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rc3.setAdapter(adapter);
    }

    private List<Folder> CreateFolder(){
        List<Folder> folderList = new ArrayList<>();
        folderList.add(new Folder(R.drawable.ic_folder, "Video"));
        folderList.add(new Folder(R.drawable.ic_folder, "Android"));
        folderList.add(new Folder(R.drawable.ic_folder, "Applock"));
        folderList.add(new Folder(R.drawable.ic_folder, "Books"));
        folderList.add(new Folder(R.drawable.ic_folder, "Map"));
        folderList.add(new Folder(R.drawable.ic_folder, "Authenticate Using Google"));
        folderList.add(new Folder(R.drawable.ic_folder, "New Folder"));
        folderList.add(new Folder(R.drawable.ic_folder, "New Folder 1"));
        return folderList;
    }
}