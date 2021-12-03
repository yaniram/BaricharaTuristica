package com.yaniramonsalve.baricharaturistica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListBaricharaActivity : AppCompatActivity() {

    private lateinit var listBarichara : ArrayList<BaricharaItem>
    private lateinit var baricharaAdapter: BaricharaAdapter
    private lateinit var baricharaRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_barichara)

        baricharaRecyclerView = findViewById(R.id.barichara_recycler_view)

        listBarichara = createMockBarichara()

        baricharaAdapter = BaricharaAdapter(listBarichara)

        baricharaRecyclerView.apply {
            layoutManager = LinearLayoutManager (context)
            adapter = baricharaAdapter
            setHasFixedSize(false)

        }

    }

    private fun createMockBarichara() : ArrayList<BaricharaItem>{
        return arrayListOf(
            BaricharaItem(
                urlPicture = "https://baricharavive.com/",
                name = "Camino Real",
                introduction = "El Camino Real que une Barichara y Guane fue declarado Monumento Nacional en 1977",
                valoration = "4,0"
            ),
            BaricharaItem(
                urlPicture = "https://baricharavive.com/",
                name = "Cementerio Inmaculada Concepcion",
                introduction = "Es un Museo al aire libre",
                valoration = "4,6"

            ),

            BaricharaItem(
                urlPicture = "https://baricharavive.com/",
                name = "Bioparque Móncora",
                introduction = "La mejor vista de Barichara al lado del Cañón del Suárez",
                valoration = "4,9"
            ),

            BaricharaItem(
                urlPicture = "https://baricharavive.com/",
                name = "Parque Para las Artes",
                introduction = "Es una de las construcciones recientes más valoradas del municipio. Levantado en 1988",
                valoration = "5,0"
            ),

            BaricharaItem(
                urlPicture = "https://baricharavive.com/",
                name = "Salto del Mico",
                introduction = "Es uno de los miradores de Barichara, donde se observa el Cañón del río Suárez",
                valoration = "4,8"
            )

        )
    }
}