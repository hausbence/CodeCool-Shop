package com.codecool.shop.model;

public class Exercise extends BaseModel {
    private String title;
    private String text;
    public Exercise(String title, String text) {
        super(title);
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
