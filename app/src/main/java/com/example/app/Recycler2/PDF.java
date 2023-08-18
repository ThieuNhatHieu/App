package com.example.app.Recycler2;

public class PDF {
    private int Image;
    private String Topic;

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }



    public PDF(int image, String topic) {
        Image = image;
        Topic = topic;
    }

}
