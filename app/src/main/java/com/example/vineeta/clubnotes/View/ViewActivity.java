package com.example.vineeta.clubnotes.View;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.example.vineeta.clubnotes.R;

public class ViewActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Uri selectedUri = Uri.parse(Environment.getExternalStorageDirectory() + "/Club%20Notes/");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(selectedUri, "resource/folder");

        if (intent.resolveActivityInfo(getPackageManager(), 0) != null)
        {
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please download esExplorer First",Toast.LENGTH_LONG).show();
        }

    }
}

