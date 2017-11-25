package com.example.vineeta.clubnotes.Model;

/**
 * Created by vineeta on 22-11-2017.
 */
public class Click {
    private String name;
    private String image;
    private String date;

    public Click(String image, String name, String date)
    {
        this.image = image;
        this.name = name;
        this.date = date;
    }
    public Click(String name)
    {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
