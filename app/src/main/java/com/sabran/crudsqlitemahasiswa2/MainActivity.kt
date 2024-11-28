package com.sabran.crudsqlitemahasiswa2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sabran.crudsqlitemahasiswa2.DBHelper.MasiswaDatabaseHelper
import com.sabran.crudsqlitemahasiswa2.adapter.DataAdapter
import com.sabran.crudsqlitemahasiswa2.screen.AddDataActivity
import com.sabran.crudsqlitemahasiswa2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var dataAdapter : DataAdapter
    private lateinit var db : MasiswaDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MasiswaDatabaseHelper(this)
        dataAdapter = DataAdapter(db.getAllData(),this)

        binding.dataRecycleview.layoutManager = LinearLayoutManager(this)
        binding.dataRecycleview.adapter = dataAdapter

        binding.addButton.setOnClickListener{
            val intent = Intent(this, AddDataActivity::class.java)
            startActivity(intent)
        }


    }
    override fun onResume() {
        super.onResume()
        val notes = db.getAllData()
        dataAdapter.refreshData(notes)
    }
}