package com.example.app.RecyclerView;

public class Food {
    String FoodName;
    String CountFan;
    String Post;
    String Status;
    String Image;

    public Food(String foodName, String countFan, String post, String status, int image) {
        FoodName = foodName;
        CountFan = countFan;
        Post = post;
        Status = status;
        Image = String.valueOf(image);
    }
    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getCountFan() {
        return CountFan;
    }

    public void setCountFan(String countFan) {
        CountFan = countFan;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
