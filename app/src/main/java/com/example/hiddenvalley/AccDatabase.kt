package com.example.hiddenvalley

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class AccDatabase (context: Context): SQLiteOpenHelper(context, dbname, factory, version){

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table user (username varchar(15) primary key autoincrement," +
                "pass varchar(15));")
        p0?.execSQL("create table info (username varchar(15)," +
                "password varchar(15), points integer);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS"+ "user")
        p0?.execSQL("DROP TABLE IF EXISTS"+ "info")
        onCreate(p0)
    }

    fun insertUserData(username: String , pass: String){
        val db: SQLiteDatabase =  writableDatabase
        val values: ContentValues = ContentValues()
        val info: ContentValues = ContentValues()

            values.put("username", username)
            values.put("pass", pass)

            info.put("username", username)
            info.put("pass", pass)
            info.put("points", 0)

            db.insert("user", null, values)
            db.insert("info", null, info)
            db.close()
    }

    fun verifyUsername(username: String): Boolean {
        val db=  writableDatabase
        val query= "select * from user where username = '$username'"
        val cursor= db.rawQuery(query,null)
        if ( cursor.count <= 0){
            cursor.close()
            return true
        }
        cursor.close()
        return false
    }

    fun userPresent(username: String,pass: String): Boolean {
        val db=  writableDatabase
        val query= "select * from user where username = '$username' and pass = '$pass'"
        val cursor= db.rawQuery(query,null)
        if ( cursor.count <= 0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    fun retrieveData() : MutableList<User_details>{
        var list : MutableList<User_details> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from info"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do{
                var user = User_details()
                user.username = result.getString(0)
                user.password = result.getString(1)
                user.points = result.getString(2).toInt()
                list.add(user)
            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }
    companion object{
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1
    }



}