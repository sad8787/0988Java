package com.example.a21082021;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a21082021.Database.UserBaseHelper;
import com.example.a21082021.Database.UserDdSchema;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> userList = new ArrayList<>();
    private SQLiteDatabase database;
    private Context context;
    public Users(Context context){
        this.context=context;
        this.database=new UserBaseHelper(this.context).getWritableDatabase();
    }

    public ArrayList<User> getUserslist() {
       /* String[] names={"Sadiel","Rafael","Juan","Michel","Maria","Elena","Roza",
                "Firulay","Fulano","Mengano","Putin"};
        String[] lastNames={"Sadiel","Rafael","Juan","Michel","Maria","Elena","Roza",
                "Firulay","Fulano","Mengano","Putin"};
        for (int i = 1; i < 30; i++) {
            int a=i%11;
            User user=new User();
            user.setName(names[a]);
            user.setLastname(lastNames[a]);
            user.setFonNumber("+796388555456");
            userList.add(user);
        }*/
        this.userList=new ArrayList<>();
        UserCursorWrapper cursorWrapper=queryUsers();
        try {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                User user= cursorWrapper.getUser();
                userList.add(user);
                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }
        return this.userList;
    }

    public UserCursorWrapper queryUsers(){
        Cursor cursor=database.query(UserDdSchema.UserTable.NAME,null,null,null,null,null,null);
        return new UserCursorWrapper(cursor);


    }
    public void addUser(User user){
        ContentValues values=getContentValues( user);
        database.insert(UserDdSchema.UserTable.NAME,null,values);
    }
    private static ContentValues getContentValues(User user){
        ContentValues values=new ContentValues();
        values.put(UserDdSchema.Cols.UUID,user.getUuid().toString());
        values.put(UserDdSchema.Cols.NAME,user.getName());
        values.put(UserDdSchema.Cols.LASTNAME,user.getLastname());
        values.put(UserDdSchema.Cols.FONNUMBER,user.getFonNomer());

        return values;
    }
    private void ubdateUser(User user){

    }
    private void deleteUser(User user){

    }
}
