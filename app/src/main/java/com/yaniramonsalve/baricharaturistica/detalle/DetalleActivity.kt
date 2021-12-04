package com.yaniramonsalve.baricharaturistica.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.yaniramonsalve.baricharaturistica.databinding.ActivityDetalleBinding
import com.yaniramonsalve.baricharaturistica.model.BaricharaItemItem

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val barichara: BaricharaItemItem = intent.extras?.getSerializable("barichara") as BaricharaItemItem
        with(detalleBinding){
            nameTextView.text = barichara.name
            descriptionPlaceView.text = barichara.descripcionLarga
            Picasso.get().load(barichara.urlPicture).into(pictureImageView)
        }


    }
}


