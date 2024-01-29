package com.example.nightendar

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatosApp(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(database: SQLiteDatabase?) {
        val createUsersTable = "CREATE TABLE USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT UNIQUE, EMAIL TEXT UNIQUE, PASSWORD TEXT)"
        database?.execSQL(createUsersTable)
        database?.execSQL(
            "CREATE TABLE LOCAL (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "NAME TEXT, " +
                    "UBICACION TEXT, " +
                    "RATING DOUBLE)"
        )
        val createLocalesUserTable = "CREATE TABLE LOCALESUSER(ID INTEGER PRIMARY KEY AUTOINCREMENT,USERID INTEGER, LOCALID INTEGER, FOREIGN KEY(USERID) REFERENCES USERS(ID), FOREIGN KEY(LOCALID) REFERENCES LOCALS(ID))"
        database?.execSQL(createLocalesUserTable)
        val defaultLocals = "INSERT INTO LOCAL(NAME,UBICACION,RATING) VALUES (\"Ovella Negra\",\"Carrer de Zamora, 78, Sant Martí, 08018 Barcelona\",\"5.0\"),(\"Dixi 724 Barcelona\",\"C. de Pallars, 115, Sant Martí, 08018 Barcelona\",\"4.0\")"
        database?.execSQL(defaultLocals)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

}