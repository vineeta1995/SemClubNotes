package com.example.vineeta.clubnotes.View;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.vineeta.clubnotes.R;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements OnClickListener
{
    EditText email, password, name, location, institute, mobile;
    Button register;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        name = (EditText) findViewById(R.id.name);
        location = (EditText) findViewById(R.id.location);
        institute = (EditText) findViewById(R.id.institute);
        mobile = (EditText) findViewById(R.id.mobile);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
        db = openOrCreateDatabase("ClubNotes", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS REGISTER(EMAIL VARCHAR(50) PRIMARY KEY, PASSWORD VARCHAR(12) NOT NULL, NAME VARCHAR(20) NOT NULL, LOCATION VARCHAR(20),MOBILE INTEGER(10), INSTITUTE VARCHAR(50));");
    }

    public void onClick(View view)
    {
        //checking for blank fields
        if ((email.getText().toString().trim().length() == 0) && !(isValidEmaillId(email.getText().toString().trim())))
        {
            alert("Error", "Please enter  Email Address");
            return;
        }
        else if (password.getText().toString().trim().length() == 0)
        {
            alert("Error", "Please enter Password");
            return;
        }
        else if (password.getText().toString().trim().length() < 8)
        {
            alert("Error", "Password should be atleast 8 characters");
            return;
        }
        else if (name.getText().toString().trim().length() == 0)
        {
            alert("Error", "Please enter name");
            return;
        }
        // inserting values to DB.
        try {
            db.execSQL("INSERT INTO REGISTER VALUES('" + email.getText() + "','" + password.getText() +
                    "','" + name.getText() + "','" + location.getText() + "','" + mobile.getText() +
                    "','" + institute.getText() + "');");
            alert("Success", "Record added");
            Intent i =new Intent(this,HomeActivity.class);
            startActivity(i);
        }catch (SQLiteException e)
        {
            e.printStackTrace();
        }
    }

    private boolean isValidEmaillId(String email)
    {
        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }


    public void alert(String title, String message) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}





