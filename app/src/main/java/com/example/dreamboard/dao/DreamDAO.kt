package com.example.dreamboard.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.dreamboard.database.DBHelper
import com.example.dreamboard.model.Dream

class DreamDAO ( var context: Context) {

    fun insertDream( dream: Dream) {
        val database: SQLiteDatabase = DBHelper( context, "dreams_db", null, 1).writableDatabase
        val content: ContentValues = ContentValues();
        content.put( "name", dream.name )

        database.insert("dreams", null, content )
    }

    fun getDream(): ArrayList<Dream> {
        val database: SQLiteDatabase = DBHelper( context, "dreams_db", null, 1).readableDatabase
        val listDreams: ArrayList<Dream> = ArrayList()
        val cursor: Cursor =
            database.query("dreams", arrayOf("id", "name"), null, null, null, null, null )
        while ( cursor.moveToNext() ) {
            val id: Int = cursor.getInt( cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString( cursor.getColumnIndexOrThrow("name"))
            listDreams.add( Dream( name) )
        }
        return listDreams
    }
}