package com.example.vineeta.clubnotes.View;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vineeta.clubnotes.R;

import java.io.File;

public class ClickActivity extends AppCompatActivity
{
    Button click;
    private EditText name;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        click = (Button) findViewById(R.id.click);
        name=(EditText)findViewById(R.id.folder);
        submit=(Button)findViewById(R.id.submit);
        click.setEnabled(false);
    }

    public void submit(View view)
    {

        File mydir = new File(Environment.getExternalStorageDirectory() + "/Club Notes/Image/" + name.getText().toString());
        if (name.getText().toString().trim().length() == 0) {
            alert("Error", "Please Enter Folder Name");
            return;
        }
        else if(!mydir.exists())
        {
            mydir.mkdirs();
            Toast.makeText(getApplicationContext(), "Folder Successfully Created", Toast.LENGTH_LONG).show();
            click.setEnabled(true);

        }
        else
            Log.d("error", "Folder Already Exist");

    }
    public void click(View view)
    {
        Intent i = new Intent(this, CameraActivity.class);
        i.putExtra("Folder Name", name.getText().toString());
        startActivity(i);
    }
    public void alert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
