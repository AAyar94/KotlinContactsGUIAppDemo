package com.aayar94.kotlincontactsguiappdemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseOpenHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val sql = "CREATE TABLE Kisi (Id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Ad TEXT, Soyad TEXT, Eposta TEXT)"

        p0!!.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}