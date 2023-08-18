package com.example.app.Recycler2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;

import java.util.List;

public class PDFAdapter extends RecyclerView.Adapter<PDFAdapter.PdfHolder> {
    private List<PDF> menu = null;

    public PDFAdapter(List<PDF> menu) {
        this.menu = menu;
    }

    public void setMenu(List<PDF> menu) {
        this.menu = menu;
    }

    @NonNull
    @Override
    public PdfHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pdf,parent,false);
        return  new PdfHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PdfHolder holder, int position) {
        holder.setDataPdf(menu.get(position));
    }

    @Override
    public int getItemCount() {
        return menu != null ? menu.size() : 0;
    }

    class PdfHolder extends RecyclerView.ViewHolder {

        private ImageView imagepdf;
        private TextView topic;


        public PdfHolder(@NonNull View itemView) {
            super(itemView);
            imagepdf = itemView.findViewById(R.id.imagepdf);
            topic = itemView.findViewById(R.id.topic);
        }

        public void setDataPdf(PDF pdf){
            imagepdf.setImageResource(pdf.getImage());
            topic.setText(pdf.getTopic());
        }
    }


}
