package com.example.vineeta.clubnotes.Model;

/**
 * Created by vineeta on 23-11-2017.
 */

public class Audio
{
    String name;
    String qrcode;
    String audio;
    String date;

    public Audio(String name, String qrcode, String audio, String date)
    {
        this.name = name;
        this.qrcode = qrcode;
        this.audio = audio;
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

    public String getQrcode()
    {
        return qrcode;
    }

    public void setQrcode(String qrcode)
    {
        this.qrcode = qrcode;
    }

    public String getAudio()
    {
        return audio;
    }

    public void setAudio(String audio)
    {
        this.audio = audio;
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
