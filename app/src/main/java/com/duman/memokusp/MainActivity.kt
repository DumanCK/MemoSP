package com.duman.memokusp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var spf : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor
    private lateinit var judulMemo : EditText
    private lateinit var isiMemo : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        judulMemo = findViewById(R.id.etJudul)
        isiMemo = findViewById(R.id.etMemo)

        spf = getSharedPreferences("memoku", MODE_PRIVATE)
        editor = spf.edit()
    }

    override fun onPause() {
        super.onPause()
        val judul = judulMemo.text.toString()
        val isi = isiMemo.text.toString()
        editor.apply{
            putString("sp_judul",judul)
            putString("sp_isi",isi)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val judul = spf.getString("sp_judul",null)
        val isi =  spf.getString("sp_isi",null)
        judulMemo.setText(judul)
        isiMemo.setText(isi)
    }

}