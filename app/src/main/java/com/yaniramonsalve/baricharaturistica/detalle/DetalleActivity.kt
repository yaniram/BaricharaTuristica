package com.yaniramonsalve.baricharaturistica.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.yaniramonsalve.baricharaturistica.R
import com.yaniramonsalve.baricharaturistica.databinding.ActivityDetalleBinding
import com.yaniramonsalve.baricharaturistica.model.BaricharaItemItem
import java.io.Serializable

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val barichara : BaricharaItemItem = intent.extras?.getSerializable("barichara") as BaricharaItemItem

        with(detalleBinding){
            nameTextView.text = barichara.name
            descriptionTextView.text = barichara.description
            Picasso.get().load(barichara.urlPicture).into(pictureImageView)
        }
    }
}