package com.aayar94.kotlincontactsguiappdemo

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class KisiIslemleri(context : Context) {
    var dbOpenHelper : DatabaseOpenHelper
    var dbKisi : SQLiteDatabase? = null

    init {
        dbOpenHelper = DatabaseOpenHelper(context,"KisiDb",null,1)

    }

    fun Ac(){
        dbKisi = dbOpenHelper.writableDatabase
    }
    fun Kapat(){
        if (dbKisi != null && dbKisi!!.isOpen){
            dbKisi!!.close()
        }
    }
    fun ekle(kisi:Kisi){
        val cv = ContentValues()
        cv.put("Ad",kisi.Ad)
        cv.put("Soyad",kisi.Soyad)
        cv.put("Eposta",kisi.Eposta)

        Ac()
        dbKisi!!.insert("Kisi",null,cv)
        Kapat()
    }

    fun Guncelle(kisi:Kisi){
        val cv = ContentValues()
        cv.put("Ad",kisi.Ad)
        cv.put("Soyad",kisi.Soyad)
        cv.put("Eposta",kisi.Eposta)

        Ac()
        dbKisi!!.update("Kisi",cv,"Id = ?", arrayOf(kisi.Id.toString()))
        Kapat()
    }

    fun Sil(id : Int){
        Ac()
        dbKisi!!.delete("Kisi","Id = ?", arrayOf(id.toString()))
        Kapat()

    }

    @SuppressLint("Range")
    fun TumKisilerGetir() : ArrayList<Kisi>{
        val kisiListesi = ArrayList<Kisi>()
        Ac()
        val sql="Select * from Kisi"
        val c = dbKisi!!.rawQuery(sql,null)
        if (c.moveToFirst()){
            var kisi : Kisi
            do {
                kisi = Kisi()
                kisi.Id = c.getInt(c.getColumnIndex("Id"))
                kisi.Ad = c.getString(c.getColumnIndex("Ad"))
                kisi.Soyad = c.getString(c.getColumnIndex("Soyad"))
                kisi.Eposta = c.getString(c.getColumnIndex("Eposta"))

                kisiListesi.add(kisi)
            }while (c.moveToNext())
        }

        return kisiListesi
    }
    @SuppressLint("Range")
    fun kisiGetir(id: Int): Kisi? {
        var kisi: Kisi? = null
        Ac()
        val sql = "Select * from Kisi where Id = ?"
        val c = dbKisi!!.rawQuery(sql, arrayOf(id.toString()))
        if (c.moveToFirst()) {
                kisi = Kisi()
                kisi.Id = c.getInt(c.getColumnIndex("Id"))
                kisi.Ad = c.getString(c.getColumnIndex("Ad"))
                kisi.Soyad = c.getString(c.getColumnIndex("Soyad"))
                kisi.Eposta = c.getString(c.getColumnIndex("Eposta"))
            }
            Kapat()
        return kisi
        }
    }
