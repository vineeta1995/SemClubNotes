package com.example.vineeta.clubnotes.Model;

/**
 * Created by vineeta on 23-11-2017.
 */

public class Text
{
    String name;
    String note;
    String date;

    public Text(String name, String note, String date)
    {
        this.name = name;
        this.note = note;
        this.date = date;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
}
