package com.abdohfox.abdallah.schedules.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.abdohfox.abdallah.schedules.data.SchContract.SchEntry;

/**
 * Created by abdoh on 2017-04-11.
 */

public class SchDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";

    private static final String SQL_CREATE_SCH_TABLE =
            "CREATE TABLE " + SchEntry.TABLE_NAME + "(" +
                    SchEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    SchEntry.COLUMN_SCH_VALUE + " INTEGER, " +
                    SchEntry.COLUMN_SCH_FROM + " TEXT, " +
                    SchEntry.COLUMN_SCH_TO + " TEXT);";



    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SchEntry.TABLE_NAME;

    public SchDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_SCH_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}
