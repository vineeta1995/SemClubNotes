package com.example.vineeta.clubnotes.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vineeta.clubnotes.R;

import java.io.File;
import java.io.FileOutputStream;

public class TextNote extends AppCompatActivity
{
    EditText EditText1;
    String folder;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        folder=intent.getStringExtra("Folder Name");
        name=intent.getStringExtra("Note Name");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Save();
            }
        });
        EditText1 = (EditText) findViewById(R.id.EditText1);
    }
    public void Save()
    {
        String note;
        note=name+".txt";
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/Club Notes/Text Note/" + folder + "/" + name + ".txt" );
        try {
            FileOutputStream os = new FileOutputStream(file);
            os.write(EditText1.getText().toString().getBytes());
            os.close();
            Toast.makeText(this,"Text Saved !",Toast.LENGTH_LONG).show();
        }
        catch (java.io.IOException e)
        {

            //do something if an IOException occurs.
            Toast.makeText(this,"ERROR - Text could't be added",Toast.LENGTH_LONG).show();
        }
    }
}