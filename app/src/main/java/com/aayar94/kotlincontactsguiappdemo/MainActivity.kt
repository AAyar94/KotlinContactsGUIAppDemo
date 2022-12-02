package com.aayar94.kotlincontactsguiappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


/*
* Uygulama ana ekranında bir liste olacak,kaydedilen kişiler bu listede gösterilecek
* sag üst kösede bir ekle butonu olacak,tıklandıgında yeni kişi ekleme sayfası acılacak
* kişilerin ad soyad epostası tutulacak veriler veri tabanına işlenecek
* kişiler ana ekranda alfabetik olarak listelenecek
* kişi bilgisine tıklandıgında bilgi ekranına gidilecek bilgiler silinip güncellenebilecek.
* bu sayfa kişi eklme eile aynı tasarıma sahip olacak
* */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}