package com.example.hiddenvalley

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AccDatabase (context: Context): SQLiteOpenHelper(context,dbname, factory, version){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table user(id integer primary key autoincrement," +
                "username varchar(30), pass varchar(15), password varchar(15)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS"+ "user")
        onCreate(db)
    }

    fun insertUserData(username:String,pass:String,password:String){
        val db: SQLiteDatabase =  writableDatabase;
        val values: ContentValues = ContentValues()
        values.put("username",username)
        values.put("pass",pass)
        values.put("password",password)


        db.insert("user",null,values)
        db.close()
    }

    fun userPresent(username:String,pass:String): Boolean {
        val db =  writableDatabase
        val query = "select * from user where username = $username and pass = $pass"
        val cursor = db.rawQuery(query,null)
        if ( cursor.count <= 0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
    companion object{
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1
    }



}