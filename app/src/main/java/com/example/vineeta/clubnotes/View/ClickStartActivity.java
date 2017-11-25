package com.example.vineeta.clubnotes.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.vineeta.clubnotes.R;

public class ClickStartActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_start);
    }

    public void newFolder(View view)
    {
        Intent i=new Intent(this,ClickActivity.class);
        startActivity(i);
    }

    public void oldFolder(View view)
    {
        Intent i=new Intent(this,ClickOldActivity.class);
        startActivity(i);
    }
}
