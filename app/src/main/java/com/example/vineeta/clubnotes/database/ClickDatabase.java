package com.example.vineeta.clubnotes.database;

/**
 * Created by vineeta on 22-11-2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.vineeta.clubnotes.Model.Click;

import java.util.ArrayList;
import java.util.List;

public class ClickDatabase extends SQLiteOpenHelper
{
    private	static final int DATABASE_VERSION =	5;
    private	static final String	DATABASE_NAME = "ClubNotes";
    private	static final String TABLE_IMAGE = "CLICK";
    private static final String FOLDER_NAME = "FOLDER";
    private static final String IMAGE_NAME= "IMAGE";
    private static final String DATE_CREATED= "DATE_CREATED";
    public ClickDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String	CREATE_IMAGE_TABLE = "CREATE	TABLE " + TABLE_IMAGE+ "(" + IMAGE_NAME + " TEXT PRIMARY KEY," + FOLDER_NAME+ " TEXT," + DATE_CREATED + " TEXT" + ")";
        db.execSQL(CREATE_IMAGE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGE);
        onCreate(db);
    }
    public List<Click> listClicks(){
        String sql = "select * from " + TABLE_IMAGE;
        SQLiteDatabase db = this.getReadableDatabase();
        List<Click> storeImages = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                String image = cursor.getString(1);
                String name = cursor.getString(2);
                String date = cursor.getString(3);
                storeImages.add(new Click(name,image, date));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeImages;
    }

    public void addImage(Click click){
        ContentValues values = new ContentValues();
        values.put(IMAGE_NAME, click.getImage());
        values.put(FOLDER_NAME, click.getName());
        values.put(DATE_CREATED, click.getImage());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_IMAGE, null, values);
    }
    public void updateProduct(Click click)
    {
        ContentValues values = new ContentValues();
        values.put(FOLDER_NAME, click.getName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_IMAGE, values, FOLDER_NAME	+ "	= ?", new String[] { String.valueOf(click.getName())});
    }
    public void deleteImage(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_IMAGE, FOLDER_NAME	+ "	= ?", new String[] { String.valueOf(name)});
    }
}
