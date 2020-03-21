package com.noorifytech.cleanarchitecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.noorifytech.cleanarchitecture.databinding.ActivityMainBinding
import com.noorifytech.shared.navigation.GetDataScreen
import com.noorifytech.shared.navigation.MoviesListingsScreen
import com.noorifytech.shared.navigation.navigateTo

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.feature1Btn.setOnClickListener {
            navigateTo(GetDataScreen)
        }

        binding.feature2Btn.setOnClickListener {
            navigateTo(MoviesListingsScreen)
        }
    }
}
