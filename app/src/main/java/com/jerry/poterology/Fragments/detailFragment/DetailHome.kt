package com.jerry.poterology.Fragments.detailFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jerry.poterology.Adapter.Adapter.Detail.AdapterDetailCharacter
import com.jerry.poterology.Adapter.Adapter.Detail.AdapterDetailSpell
import com.jerry.poterology.R
import com.jerry.poterology.Spells

class DetailHome : Fragment() {
    lateinit var adapterSpell:AdapterDetailSpell
    lateinit var adapterhouseChar:AdapterDetailCharacter
    lateinit var butoon1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerspell: RecyclerView = view.findViewById(R.id.recyclerspell)
        val recyclerchar: RecyclerView = view.findViewById(R.id.recylerchar)
        val recyclerhouse: RecyclerView = view.findViewById(R.id.recyclerhouse)
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        val linearLayoutManager1 = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        val linearLayoutManager2 = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerspell.setLayoutManager(linearLayoutManager)
        recyclerchar.setLayoutManager(linearLayoutManager1)
        recyclerhouse.setLayoutManager(linearLayoutManager2)
        adapterSpell = AdapterDetailSpell()
        adapterhouseChar = AdapterDetailCharacter()
        recyclerspell.adapter = adapterSpell
        recyclerchar.adapter = adapterhouseChar
        recyclerhouse.adapter = adapterhouseChar


        butoon1 = view.findViewById(R.id.button1)

        butoon1.setOnClickListener{
            val transaction = childFragmentManager?.beginTransaction()
            transaction!!.replace(R.id.frame, Spells())
            transaction.commit()
        }
    }
}

