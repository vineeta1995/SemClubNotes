package com.example.vineeta.clubnotes.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vineeta.clubnotes.R;

import java.io.File;

public class AudioActivity extends Activity
{

    Button click;
    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        name=(EditText)findViewById(R.id.folder);
        click=(Button)findViewById(R.id.click);
        click.setEnabled(false);
    }

    public void submit(View view)
    {
        File mydir = new File(Environment.getExternalStorageDirectory() + "/Club Notes/Audio/" + name.getText().toString());
        if (name.getText().toString().trim().length() == 0)
        {
            alert("Error", "Please Enter Folder Name");
            return;
        }
        if(!mydir.exists())
        {
            mydir.mkdirs();
            Toast.makeText(getApplicationContext(), "Folder Successfully Created", Toast.LENGTH_LONG).show();
            click.setEnabled(true);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Directory Already Exists", Toast.LENGTH_LONG).show();
        }
    }
    public void alert(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void click(View view)
    {
         Intent i = new Intent(this, QrScanActivity.class);
         i.putExtra("Folder Name", name.getText().toString());
         startActivity(i);
    }
}