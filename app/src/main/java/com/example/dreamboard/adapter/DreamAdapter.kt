package com.example.dreamboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dreamboard.R
import com.example.dreamboard.model.Dream

class DreamAdapter( var dreamsList: ArrayList<Dream>, var context: Context): RecyclerView.Adapter<DreamAdapter.MyHolder>(){

    class MyHolder(itemView: View): ViewHolder(itemView) {
        val text = itemView.findViewById<TextView>(R.id.dreamText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.item_dream, parent, false )
        val holder: MyHolder = MyHolder( vista )
        return holder;
    }

    override fun getItemCount(): Int {
        return dreamsList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val dream = dreamsList[position]
        holder.text.text = dream.name

    }


}