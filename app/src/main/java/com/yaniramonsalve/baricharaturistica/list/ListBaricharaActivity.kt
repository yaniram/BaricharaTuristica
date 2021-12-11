package com.yaniramonsalve.baricharaturistica.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.yaniramonsalve.baricharaturistica.R
import com.yaniramonsalve.baricharaturistica.detalle.DetalleActivity
import com.yaniramonsalve.baricharaturistica.model.BaricharaItem
import com.yaniramonsalve.baricharaturistica.model.BaricharaItemItem

class ListBaricharaActivity : AppCompatActivity() {

    private lateinit var ListBarichara : ArrayList<BaricharaItemItem>
    private lateinit var baricharaAdapter: BaricharaAdapter
    private lateinit var baricharaRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_barichara)

        baricharaRecyclerView = findViewById(R.id.barichara_recycler_view)

       // listBarichara = createMockBarichara()
        ListBarichara = loadMockbaricharaturisticaFromJson()

        baricharaAdapter = BaricharaAdapter(ListBarichara, onItemClicked = { onBaricharaClicked(it) })

        baricharaRecyclerView.apply {
            layoutManager = LinearLayoutManager (context)
            adapter = baricharaAdapter
            setHasFixedSize(false)

        }

    }

    private fun onBaricharaClicked(barichara: BaricharaItemItem) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("barichara", barichara)
        startActivity(intent)

    }

    private fun loadMockbaricharaturisticaFromJson(): ArrayList<BaricharaItemItem> {
        val baricharaString:String = applicationContext.assets
            .open("baricharaturistica.json").bufferedReader().use {  it.readText() }
        val gson = Gson()
        val BaricharaList = gson.fromJson(baricharaString, BaricharaItem::class.java)
        return BaricharaList

    }

   /* private fun createMockBarichara() : ArrayList<BaricharaItem>{
        return arrayListOf(
            BaricharaItem(
                urlPicture = "https://www.treksnappy.com/wp-content/uploads/2014/03/Camino-Real-17-1024x768.jpg",
                name = "Camino Real",
                introduction = "El Camino Real que une Barichara y Guane fue declarado Monumento Nacional en 1977",
                valoration = "4,0"
            ),
            BaricharaItem(
                urlPicture = "https://static.wixstatic.com/media/70bdc8_452674fe9f0d4cc4b29aba6f9d81b466~mv2.jpg",
                name = "Cementerio\nInmaculada Concepcion",
                introduction = "Es un Museo al aire libre",
                valoration = "4,6"

            ),

            BaricharaItem(
                urlPicture = "https://static.wixstatic.com/media/70bdc8_a01b44c9e5254215848fc32abe6646ef~mv2.jpg",
                name = "Bioparque Móncora",
                introduction = "La mejor vista de Barichara al lado del Cañón del Suárez",
                valoration = "4,9"
            ),

            BaricharaItem(
                urlPicture = "https://as1.ftcdn.net/v2/jpg/01/92/23/60/500_F_192236070_uLWhD3p18wvxYuWC0Lz51iwIKLZWK8Q4.jpg",
                name = "Parque Para las Artes",
                introduction = "Es una de las construcciones recientes más valoradas del municipio. Levantado en 1988",
                valoration = "5,0"
            ),

            BaricharaItem(
                urlPicture = "https://cdn.baquianos.com/img/blog/2021/9/salto-del-mico-davx640.jpg",
                name = "Salto del Mico",
                introduction = "Es uno de los miradores de Barichara, donde se observa el Cañón del río Suárez",
                valoration = "4,8"
            )

        )
    }*/
}