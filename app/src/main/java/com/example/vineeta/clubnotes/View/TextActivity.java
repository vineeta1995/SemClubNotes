package com.example.vineeta.clubnotes.View;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vineeta.clubnotes.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextActivity extends AppCompatActivity
{
    String check;
    private EditText name;
    private EditText note;
    private Button submit;
    private Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        click = (Button) findViewById(R.id.btnclick);
        name=(EditText)findViewById(R.id.fname);
        submit=(Button)findViewById(R.id.btnsubmit);
        note= (EditText) findViewById(R.id.note);
        click.setEnabled(false);
    }

    public void submit(View view) throws IOException {

        File mydir = new File(Environment.getExternalStorageDirectory() + "/Club Notes/Text Note/" + name.getText().toString());
        if ((name.getText().toString().trim().length() == 0) ||(note.getText().toString().trim().length() == 0))
        {
            alert("Error", "All Fields are mandatory");
            return;
        }
        else if(!mydir.exists())
        {
            mydir.mkdirs();
            File file= new File(mydir, note.getText().toString()+ ".txt");
            FileWriter filewriter = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(filewriter);
            out.write(" ");
            out.close();
            Toast.makeText(getApplicationContext(),"Note successfully created",Toast.LENGTH_LONG).show();
            click.setEnabled(true);
        }
        else
            Toast.makeText(getApplicationContext(),"Folder Already Created",Toast.LENGTH_LONG).show();

    }
    public void click(View view)
    {
        Intent i = new Intent(this, TextNote.class);
        i.putExtra("Note Name",note.getText().toString());
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
