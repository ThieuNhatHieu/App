package com.example.app.Recycle3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;

import java.util.List;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.FolderView> {
    public void setCreateFolder(List<Folder> createFolder) {
        CreateFolder = createFolder;
    }

    private List<Folder> CreateFolder = null;

    public FolderAdapter(List<Folder> createFolder) {
        CreateFolder = createFolder;
    }

    @NonNull
    @Override
    public FolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_folder, parent, false);
        return new FolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FolderView holder, int position) {
        holder.setData(CreateFolder.get(position));
    }

    @Override
    public int getItemCount() {
        return CreateFolder != null ? CreateFolder.size() : 0;
    }

    public class FolderView extends RecyclerView.ViewHolder {
        ImageView imageFolder;
        TextView namefolder;
        public FolderView(@NonNull View itemView) {
            super(itemView);
            imageFolder = itemView.findViewById(R.id.imagefolder);
            namefolder = itemView.findViewById(R.id.namefolder);
        }

        public void setData(Folder folder){
            imageFolder.setImageResource(folder.getImage());
            namefolder.setText(folder.getName());
        }
    }
}
