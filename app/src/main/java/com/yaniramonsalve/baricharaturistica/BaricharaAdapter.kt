package com.yaniramonsalve.baricharaturistica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BaricharaAdapter(
    private val baricharaList: ArrayList<BaricharaItem>
    ) : RecyclerView.Adapter<BaricharaAdapter.BaricharaViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaricharaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_barichara_item, parent, false)
        return BaricharaViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaricharaViewHolder, position: Int) {
        val barichara = baricharaList[position]
        holder.bind(barichara)
    }

    override fun getItemCount(): Int {
        return baricharaList.size
    }

    class BaricharaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.description_place_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(barichara : BaricharaItem){
            nameTextView.text = barichara.name
            descriptionTextView.text = barichara.introduction

        }

    }
}

