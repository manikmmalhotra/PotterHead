package com.jerry.poterology.Fragments.detailFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jerry.poterology.Adapter.Adapter.Detail.AdapterDetailCharacter
import com.jerry.poterology.Adapter.Adapter.Detail.AdapterDetailSpell
import com.jerry.poterology.R
class Spells : Fragment() {
    lateinit var adapterspells: AdapterDetailSpell


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spells, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerchar: RecyclerView = view.findViewById(R.id.recylerspells)
        val linearLayoutManager1 = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        recyclerchar.setLayoutManager(linearLayoutManager1)
        adapterspells = AdapterDetailSpell()
        recyclerchar.adapter = adapterspells


    }
}