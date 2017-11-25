package com.example.vineeta.clubnotes.View;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vineeta.clubnotes.R;

import java.io.File;

public class AudioOld extends AppCompatActivity {
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_old);
        name=(EditText)findViewById(R.id.folder);
    }

    public void click(View view)
    {
        File mydir = new File(Environment.getExternalStorageDirectory() + "/Club Notes/Audio/" + name.getText().toString());
        if (name.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter Folder Name", Toast.LENGTH_LONG).show();
        }
        else if (!mydir.exists())
        {
            Toast.makeText(getApplicationContext(), "Folder Not Found", Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent i = new Intent(this, QrScanRecorderActivity.class);
            i.putExtra("Folder Name", name.getText().toString());
            startActivity(i);
        }
    }
}
