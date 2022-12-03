package com.aayar94.kotlincontactsguiappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.aayar94.kotlincontactsguiappdemo.databinding.ActivityMainBinding
import com.aayar94.kotlincontactsguiappdemo.databinding.ActivityYeniKisiBinding


/*
* Uygulama ana ekranında bir liste olacak,kaydedilen kişiler bu listede gösterilecek
* sag üst kösede bir ekle butonu olacak,tıklandıgında yeni kişi ekleme sayfası acılacak
* kişilerin ad soyad epostası tutulacak veriler veri tabanına işlenecek
* kişiler ana ekranda alfabetik olarak listelenecek
* kişi bilgisine tıklandıgında bilgi ekranına gidilecek bilgiler silinip güncellenebilecek.
* bu sayfa kişi eklme eile aynı tasarıma sahip olacak
* */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var kisiListesi = ArrayList<Kisi>()
    var kisiIslemleri : KisiIslemleri

    init {
        kisiIslemleri = KisiIslemleri(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        kisiListesi = kisiIslemleri.TumKisileriGetir()

        val adapter = KisiAdapter(kisiListesi,this::RvItemOnClick)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.rvKisiler.layoutManager = layoutManager
        binding.rvKisiler.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        binding.rvKisiler.adapter=adapter

    }

    fun btnYeniKisiEkle_onClick(view: View) {
        val i = Intent(this, activityYeniKisi::class.java)
        startActivityForResult(i, 1)
    }

    fun RvItemOnClick(position: Int) {
        val i = Intent(this, activityYeniKisi::class.java)
        i.putExtra(
            "kisiId", kisiListesi.get(position).Id
        )
        startActivityForResult(i, 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            kisiListesi.clear()
            kisiListesi.addAll(kisiIslemleri.TumKisileriGetir())
            binding.rvKisiler.adapter!!.notifyDataSetChanged()
        }
    }
}