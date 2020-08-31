package com.jerry.poterology.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.jerry.poterology.Fragments.detailFragment.DetailHome
import com.jerry.poterology.R
import javax.xml.datatype.DatatypeFactory.newInstance

class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val transaction = childFragmentManager?.beginTransaction()
        transaction!!.replace(R.id.detailFrame, DetailHome())
        transaction.commit()
        Log.d("manik","working")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}