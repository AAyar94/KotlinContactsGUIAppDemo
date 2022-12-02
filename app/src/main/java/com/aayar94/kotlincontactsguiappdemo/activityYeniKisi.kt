package com.aayar94.kotlincontactsguiappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.aayar94.kotlincontactsguiappdemo.databinding.ActivityYeniKisiBinding

class activityYeniKisi : AppCompatActivity() {
    private lateinit var binding:ActivityYeniKisiBinding
    var kisi : Kisi? = null
    var kisiIslemleri : KisiIslemleri
    init {

        kisiIslemleri = KisiIslemleri(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYeniKisiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var kisiId = intent.getIntExtra("kisiId",-1)
        if (kisiId == -1){
            kisi = Kisi()
            binding.btnSil.visibility = View.GONE
            //btnSil = findViewById<>(R.id.btnSil)
        }else{
            kisi = kisiIslemleri.kisiGetir(kisiId)
            binding.etName.setText(kisi!!.Ad)
            binding.etSurname.setText(kisi!!.Soyad)
            binding.etEposta.setText(kisi!!.Eposta)

            binding.btnSil.visibility = View.VISIBLE

        }

        binding.btnKaydet.setOnClickListener {
            kisi!!.Ad = binding.etName.text.toString()
            kisi!!.Soyad = binding.etSurname.text.toString()
            kisi!!.Eposta = binding.etEposta.text.toString()

            if (kisi!!.Id == null ){

                kisiIslemleri.ekle(kisi!!)

            }else{
                kisiIslemleri.Guncelle(kisi!!)
            }
            setResult(RESULT_OK)
            finish()



        }
        binding.btnSil.setOnClickListener {
            kisiIslemleri.Sil(kisi!!.Id!!)
        setResult(RESULT_OK)
        finish()}

    }
}