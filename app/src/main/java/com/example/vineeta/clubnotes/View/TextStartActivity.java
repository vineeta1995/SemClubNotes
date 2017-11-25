package com.example.vineeta.clubnotes.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.vineeta.clubnotes.R;

public class TextStartActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_start);
    }

    public void newFolder(View view)
    {
        try {
            Intent i = new Intent(this, TextActivity.class);
            startActivity(i);
        }catch (Exception e)
        {
            Log.e("MYAPP", "exception", e);
        }
    }

    public void oldFolder(View view)
    {
        Intent i=new Intent(this,TextOldActivity.class);
        startActivity(i);
    }
}
