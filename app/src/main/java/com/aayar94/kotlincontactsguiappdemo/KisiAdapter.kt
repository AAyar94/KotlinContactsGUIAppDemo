package com.aayar94.kotlincontactsguiappdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class KisiAdapter(var allListe : ArrayList<Kisi>,itemClick :(position:Int)->Unit) :
    RecyclerView.Adapter<RvHolder>() {
    var itemClick = itemClick
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return RvHolder(v,itemClick)
    }

    override fun onBindViewHolder(holder: RvHolder, position: Int) {
        val k = allListe.get(position)
        holder.tvAdSoyad.text = k.Ad+" "+k.Soyad
        holder.tvEposta.text=k.Eposta
    }

    override fun getItemCount(): Int {
        return allListe.size
    }
}