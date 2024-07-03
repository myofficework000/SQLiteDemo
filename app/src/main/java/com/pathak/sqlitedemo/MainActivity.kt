package com.pathak.sqlitedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pathak.sqlitedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initDatabase()
        initViews()
    }

    private fun initViews() {
        with(binding) {
            btnInsert.setOnClickListener {
                val myUser = MyUser(name = "Abhishek", age = 22)
                databaseHelper.insertData(myUser)
            }
        }
    }

    private fun initDatabase() {
        databaseHelper = DatabaseHelper(this)
    }
}