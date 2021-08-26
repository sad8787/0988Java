package com.example.a21082021;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.a21082021.Database.UserDdSchema;

import java.util.UUID;

public class UserCursorWrapper extends CursorWrapper {
    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    //create User for cursor
    public User getUser(){
        String useruudi=getString(getColumnIndex(UserDdSchema.Cols.UUID));
        String username=getString(getColumnIndex(UserDdSchema.Cols.NAME));
        String userlastname=getString(getColumnIndex(UserDdSchema.Cols.LASTNAME));
        String userfonnumber=getString(getColumnIndex(UserDdSchema.Cols.FONNUMBER));
        //create User for cursor
        User user=new User(UUID.fromString(useruudi));
        user.setName(username);
        user.setLastname(userlastname);
        user.setFonNumber(userfonnumber);

        return user;

    }
}
