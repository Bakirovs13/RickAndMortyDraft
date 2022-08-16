package com.example.rickandmortydraft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.rickandmortydraft.MainUtils.MAIN
import com.example.rickandmortydraft.presentation.list.ListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MAIN = this
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_container) as NavHostFragment
        navController = navHostFragment.navController
    }


}