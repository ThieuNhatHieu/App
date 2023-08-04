package com.example.app.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;

import com.example.app.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView rcFood = findViewById(R.id.rcFood);
        FoodAdapter adapter = new FoodAdapter(MenuFoods());
        rcFood.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcFood.setAdapter(adapter);

    }

    private List<Food> MenuFoods(){
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Mua bán có tâm", "8K fan", "+10 bài viết mới nhất", "Nhóm Đóng", R.drawable.ic_food));
        foodList.add(new Food("Ăn để lăn", "8K fan", "+10 bài viết mới nhất", "Nhóm Kín", R.drawable.ic_food1));
        foodList.add(new Food("Chia sẻ kiến thức tài liệu Montessori", "1.7K fan", "20 bài viết mới nhất", "Nhóm Mở", R.drawable.ic_food2));
        foodList.add(new Food("Thực đơn Eat - Clean giảm cân khỏe đẹp", "1.1K fan", "20 bài viết mới nhất", "Nhóm Mở", R.drawable.ic_food3));
        foodList.add(new Food("Easy Kento for busy People", "8K fan", "+10 bài viết mới nhất", "Nhóm Kín", R.drawable.ic_food4));
        foodList.add(new Food("OFFB", "8K fan", "+10 bài viết mới nhất", "Nhóm Mở", R.drawable.ic_food5));
        foodList.add(new Food("Thực đơn Eat - Clean giảm cân khỏe đẹp", "1.1K fan", "20 bài viết mới nhất", "Nhóm Mở", R.drawable.ic_food3));
        foodList.add(new Food("Easy Kento for busy People", "8K fan", "+10 bài viết mới nhất", "Nhóm Kín", R.drawable.ic_food4));
        return foodList;
    }
}
