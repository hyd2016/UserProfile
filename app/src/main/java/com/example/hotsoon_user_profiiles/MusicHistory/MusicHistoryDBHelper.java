package com.example.hotsoon_user_profiiles.MusicHistory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MusicHistoryDBHelper extends SQLiteOpenHelper {
    public static final String CREATE_MUSIC = "create table Music ("
            + "id integer primary key autoincrement, "
            + "title text, "
            + "url text, "
            + "cover text, "
            + "position integer)";

    private Context mContext;



    public MusicHistoryDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MUSIC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
