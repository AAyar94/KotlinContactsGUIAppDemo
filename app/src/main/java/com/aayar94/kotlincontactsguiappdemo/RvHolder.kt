package com.aayar94.kotlincontactsguiappdemo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RvHolder(itemView: View, itemClick : (position : Int)->Unit) : RecyclerView.ViewHolder(itemView) {
    lateinit var tvAdSoyad : TextView
    lateinit var tvEposta : TextView

    init {
        tvAdSoyad = itemView.findViewById(R.id.tvAdSoyad)
        tvEposta = itemView.findViewById(R.id.tvEposta)

        itemView.setOnClickListener {
            itemClick(adapterPosition)
        }
    }

}