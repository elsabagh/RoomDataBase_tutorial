package com.example.roomdatabase_tutorial.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.roomdatabase_tutorial.R
import com.example.roomdatabase_tutorial.data.database.NoteDatabase
import com.example.roomdatabase_tutorial.databinding.ActivityMainBinding
import com.example.roomdatabase_tutorial.ui.notes.NotesFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        NoteDatabase.getInstance(applicationContext)

        firstFragmentView()
    }

    private fun firstFragmentView() {
        addFragment(NotesFragment())
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainerView, fragment)
        transaction.commit()
    }

}