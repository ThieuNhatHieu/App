package com.example.app.Recycler2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

public class recycle2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle2);
        RecyclerView rc2 = findViewById(R.id.rc2);

        PDFAdapter adapter = new PDFAdapter(createPDF());
        rc2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rc2.setAdapter(adapter);
    }

    private List<PDF> createPDF(){
        List<PDF> menu = new ArrayList<>();
        menu.add(new PDF(R.drawable.ic_pdf, "To kill a Mockingbird"));
        menu.add(new PDF(R.drawable.ic_pdf, "To kill a Mockingbird"));
        menu.add(new PDF(R.drawable.ic_pdf, "To kill a Mockingbird"));
        menu.add(new PDF(R.drawable.ic_pdf, "To kill a Mockingbird"));
        menu.add(new PDF(R.drawable.ic_pdf, "To kill a Mockingbird"));
        return menu;
    }

}