package com.example.vineeta.clubnotes.View;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vineeta.clubnotes.R;

public class HomeActivity extends ListActivity {

    String[] menu = {
            "Audio Notes",
            "Text Notes",
            "Take Images",
            "View All",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Listview adapter
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,menu));
    }
    public void onListItemClick(ListView parent, View v, int position, long id)
    {
        Intent intent;
        if (position==0)
        {
            intent=new Intent(this,AudioStartActivity.class);
            startActivity(intent);
        }
        else if (position==1)
        {
            intent=new Intent(this,TextStartActivity.class);
            startActivity(intent);
        }
        else if (position==2)
        {
            intent=new Intent(this,ClickStartActivity.class);
            startActivity(intent);
        }
        else
        {
            intent=new Intent(this,ViewActivity.class);
            startActivity(intent);
        }

    }
}
