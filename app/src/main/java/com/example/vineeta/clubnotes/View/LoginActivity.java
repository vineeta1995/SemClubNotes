package com.example.vineeta.clubnotes.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.vineeta.clubnotes.R;

public class LoginActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void register(View view)
    {
        Intent i=new Intent(this,RegisterActivity.class);
        startActivity(i);
    }
}
