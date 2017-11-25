package com.example.vineeta.clubnotes.View;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vineeta.clubnotes.R;

import java.io.File;

public class TextOldActivity extends AppCompatActivity {
    EditText name;
    EditText note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_old);
        name = (EditText) findViewById(R.id.fname);
        note = (EditText) findViewById(R.id.note);
    }

    public void click(View view)
    {
        File mydir = new File(Environment.getExternalStorageDirectory() + "/Club Notes/Text Note/" + name.getText().toString());
        //File mynote = new File(Environment.getExternalStorageDirectory() + "/Club Notes/Text Note/" + name.getText().toString() + "/" + note.getText().toString() + ".txt");
        if ((name.getText().toString().trim().length() == 0) || (note.getText().toString().trim().length() == 0)) {
            alert("Error", "All Fields are mandatory");
            return;
        }
        else if (!mydir.exists())
            Toast.makeText(getApplicationContext(), "Folder Not Found", Toast.LENGTH_LONG).show();
        else
            {
                Intent i = new Intent(this, TextNote.class);
                i.putExtra("Note Name",note.getText().toString());
                i.putExtra("Folder Name", name.getText().toString());
                startActivity(i);
            }
        }
    public void alert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

