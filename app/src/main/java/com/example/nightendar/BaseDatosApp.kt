package com.example.nightendar

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatosApp(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(database: SQLiteDatabase?) {
        val createUsersTable = "CREATE TABLE USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT UNIQUE, EMAIL TEXT UNIQUE, PASSWORD TEXT)"
        database?.execSQL(createUsersTable)
    }

    override fun onUpgrade(database: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}