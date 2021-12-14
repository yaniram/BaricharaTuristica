package com.yaniramonsalve.baricharaturismo.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.yaniramonsalve.baricharaturismo.databinding.FragmentListBinding
import com.yaniramonsalve.baricharaturismo.main.MainActivity
import com.yaniramonsalve.baricharaturismo.model.BaricharaItem
import com.yaniramonsalve.baricharaturismo.model.BaricharaItemItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var baricharaAdapter: BaricharaAdapter
    private var ListBarichara: ArrayList<BaricharaItemItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        ListBarichara = loadMockbaricharaturisticaFromJson()
        baricharaAdapter = BaricharaAdapter(ListBarichara, onItemClicked = { onBaricharaClicked(it) })

        listBinding.baricharaRecyclerView.apply {
            layoutManager = LinearLayoutManager (context)
            adapter = baricharaAdapter
            setHasFixedSize(false)

        }
    }

    private fun onBaricharaClicked(barichara: BaricharaItemItem) {
       findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(barichara = barichara))
       // findNavController().navigate(ListFragmentDirections.actionListFragmentToSettingsFragment3())


    }

    private fun loadMockbaricharaturisticaFromJson(): ArrayList<BaricharaItemItem> {
        val baricharaString: String = context?.assets?.open("baricharaturistica.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val BaricharaList = gson.fromJson(baricharaString, BaricharaItem::class.java)
        return BaricharaList

    }

}