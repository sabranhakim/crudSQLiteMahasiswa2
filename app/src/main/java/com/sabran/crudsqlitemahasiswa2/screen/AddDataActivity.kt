package com.sabran.crudsqlitemahasiswa2.screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sabran.crudsqlitemahasiswa2.DBHelper.MasiswaDatabaseHelper
import com.sabran.crudsqlitemahasiswa2.ModeldataMahasiswa
import com.sabran.crudsqlitemahasiswa2.databinding.ActivityAddDataBinding

class AddDataActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddDataBinding
    private lateinit var db: MasiswaDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MasiswaDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val nama = binding.namaEditText.text.toString()
            val nim = binding.nimEditText.text.toString()
            val jurusan = binding.jurusanEditText.text.toString()

            val data = ModeldataMahasiswa(0, nama,nim,jurusan)

            db.insertData(data)
            finish()
            Toast.makeText(this, "Data disimpan", Toast.LENGTH_SHORT).show()
        }
    }
}