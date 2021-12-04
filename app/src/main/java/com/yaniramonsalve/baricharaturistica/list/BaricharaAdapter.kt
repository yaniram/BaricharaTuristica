package com.yaniramonsalve.baricharaturistica.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yaniramonsalve.baricharaturistica.model.BaricharaItemItem
import com.yaniramonsalve.baricharaturistica.R

class BaricharaAdapter(
    private val BaricharaList: ArrayList<BaricharaItemItem>,
    private val onItemClicked: (BaricharaItemItem) -> Unit
    ) : RecyclerView.Adapter<BaricharaAdapter.BaricharaViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaricharaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_barichara_item, parent, false)
        return BaricharaViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaricharaViewHolder, position: Int) {
        val barichara = BaricharaList[position]
        holder.itemView.setOnClickListener{ onItemClicked(BaricharaList[position])}
        holder.bind(barichara)
    }

    override fun getItemCount(): Int {
        return BaricharaList.size
    }

    class BaricharaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descriptionTextView: TextView = itemView.findViewById(R.id.description_place_view)
       // private var valorationTextView: TextView = itemView.findViewById(R.id.)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(barichara : BaricharaItemItem){
            nameTextView.text = barichara.name
            descriptionTextView.text = barichara.introduction
           // valorationTextView.text = barichara.valoration.toString()
            Picasso.get().load(barichara.urlPicture).into(pictureImageView);

        }

    }
}

