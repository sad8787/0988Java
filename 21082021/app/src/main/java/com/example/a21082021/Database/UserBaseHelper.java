package com.example.a21082021.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;//permite el control automatico de la vercion
    private static final String DATABASE_NAME="userBase.bd";

    public UserBaseHelper( Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+UserDdSchema.UserTable.NAME+"( " +
                "_id integer PRIMARY KEY AUTOINCREMENT,"+
                UserDdSchema.Cols.UUID+" INT NOT NULL  ,"+
                UserDdSchema.Cols.NAME+" ,"+
                UserDdSchema.Cols.LASTNAME+"  ,"+
                UserDdSchema.Cols.FONNUMBER+")"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
