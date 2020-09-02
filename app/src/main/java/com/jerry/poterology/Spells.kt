package com.jerry.poterology

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jerry.poterology.Adapter.Adapter.Detail.AdapterDetailSpell


class Spells : Fragment() {
    lateinit var adapterSpell: AdapterDetailSpell

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spells, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onViewCreated(view, savedInstanceState)

        val recyclerSpell: RecyclerView = view.findViewById(R.id.recyclerView)

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerSpell.layoutManager = linearLayoutManager

        var adapterSpell = AdapterDetailSpell()

        recyclerSpell.adapter = adapterSpell

    }
}

