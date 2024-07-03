package com.pathak.sqlitedemo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    DatabaseConstants.DATABASE_NAME,
    null,
    DatabaseConstants.DATABASE_VERSION
) {
    override fun onCreate(database: SQLiteDatabase) {
        val createTableQuery = """
         CREATE TABLE ${DatabaseConstants.TABLE_NAME} (
         ${DatabaseConstants.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
         ${DatabaseConstants.COLUMN_NAME} TEXT,
         ${DatabaseConstants.COLUMN_AGE} INTEGER 
         )
     """.trimIndent()

        database.execSQL(createTableQuery)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun insertData(user: MyUser): Long {
        val values = ContentValues().apply {
            put(DatabaseConstants.COLUMN_NAME, user.name)
            put(DatabaseConstants.COLUMN_AGE, user.age)
        }

        return writableDatabase.insert(DatabaseConstants.TABLE_NAME, null, values)
    }
}

//Finish the basic thing that i did here
//then create a recyclerview having item is id, name, age