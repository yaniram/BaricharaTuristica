package com.yaniramonsalve.baricharaturistica.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yaniramonsalve.baricharaturistica.R
import com.yaniramonsalve.baricharaturistica.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)

        val nombre = intent.extras?.getString("nombre")
        detalleBinding.nameTextView.text = nombre
    }
}