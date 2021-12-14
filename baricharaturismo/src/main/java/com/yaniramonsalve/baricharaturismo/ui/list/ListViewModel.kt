package com.yaniramonsalve.baricharaturismo.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.yaniramonsalve.baricharaturismo.model.BaricharaItem
import com.yaniramonsalve.baricharaturismo.model.BaricharaItemItem
import java.io.InputStream

class ListViewModel : ViewModel() {
    private var baricharaturisticaLoad : MutableLiveData<ArrayList<BaricharaItemItem>> = MutableLiveData()
    val onbaricharaturisticaLoaded : LiveData<ArrayList<BaricharaItemItem>> = baricharaturisticaLoad

    fun loadMockJson (baricharaString: InputStream?) {
        val baricharaString = baricharaString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        baricharaturisticaLoad.value = gson.fromJson(baricharaString, BaricharaItem::class.java)
    }

}