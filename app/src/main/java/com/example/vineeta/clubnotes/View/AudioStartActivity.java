package com.example.vineeta.clubnotes.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.vineeta.clubnotes.R;

public class AudioStartActivity extends AppCompatActivity
{
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_start);
    }
    public void oldFolder(View view)
    {
        i=new Intent(this,AudioOld.class);
        startActivity(i);
    }
    public void newFolder(View view)
    {
        i=new Intent(this,AudioActivity.class);
        startActivity(i);
    }

    public void play(View view)
    {
        i=new Intent(this,AudioPlayActivity.class);
        startActivity(i);
    }
}
