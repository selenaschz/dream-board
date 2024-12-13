package com.example.dreamboard.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dreamboard.adapter.DreamAdapter
import com.example.dreamboard.dao.DreamDAO
import com.example.dreamboard.databinding.ActivityDreamsBinding
import com.example.dreamboard.databinding.ItemDreamBinding
import com.example.dreamboard.model.Dream

class DreamsActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityDreamsBinding
    private lateinit var bindingItem: ItemDreamBinding
    private var retrievedData: Bundle? = null
    private lateinit var dreamsList: ArrayList<Dream>
    private lateinit var adapter: DreamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDreamsBinding.inflate( layoutInflater)
        bindingItem = ItemDreamBinding.inflate( layoutInflater )
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        instances()

    }

    override fun onClick(v: View?) {
    }

    private fun instances() {
        retrievedData = intent.extras?.getBundle("dream")
        dreamsList = retrievedData?.getSerializable("listDreams") as? ArrayList<Dream> ?: ArrayList()
        adapter = DreamAdapter( dreamsList, this )
        binding.recyclerDreams.adapter = adapter
        binding.recyclerDreams.layoutManager = LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false)
    }
}