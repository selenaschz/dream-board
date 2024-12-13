package com.example.dreamboard.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.dreamboard.dao.DreamDAO
import com.example.dreamboard.databinding.ActivityMainBinding
import com.example.dreamboard.model.Dream

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var textDream: String
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        textDream = savedInstanceState?.getString("inputText") ?: ""

        setListeners()
    }



    fun setListeners(){
        binding.addBt.setOnClickListener( this )
        binding.viewListBt.setOnClickListener( this )
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.addBt.id -> {
                val dreamDAO = DreamDAO( applicationContext )
                textDream = binding.inputDream.text.toString()
                if (textDream.isNotEmpty()) {
                    dreamDAO.insertDream( Dream(textDream) )
                }
                binding.inputDream.setText("")
            }
            binding.viewListBt.id -> {
                val dreamDAO = DreamDAO( applicationContext )
                val listDreams: ArrayList<Dream> = dreamDAO.getDream()
                val intent = Intent( this, DreamsActivity::class.java )
                val bundle = Bundle()
                bundle.putSerializable( "listDreams", listDreams )
                intent.putExtra( "dream", bundle )
                startActivity( intent )
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("inputText", textDream)
    }

}