package com.example.app.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> foodList = null ;

    public FoodAdapter(List<Food> menuFoods) {
        this.foodList = menuFoods;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foods,parent,false);
        return new FoodViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
            holder.setData(foodList.get(position));
    }

    @Override
    public int getItemCount() {

        return foodList != null ? foodList.size() : 0;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView countFan;
        private TextView nameFood;
        private TextView post;
        private TextView status;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            countFan = itemView.findViewById(R.id.countFan);
            nameFood = itemView.findViewById(R.id.nameFood);
            post = itemView.findViewById(R.id.post);
            status = itemView.findViewById(R.id.status);
        }

        public void setData(Food food){
            imageView.setImageResource(Integer.parseInt(food.getImage()));
            nameFood.setText(food.getFoodName());
            countFan.setText(food.getCountFan());
            post.setText(food.getPost());
            status.setText(food.getStatus());
        }
    }
}
