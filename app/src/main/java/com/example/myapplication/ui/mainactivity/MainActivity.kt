 package com.example.myapplication.ui.mainactivity

import android.os.Bundle
import androidx.activity.viewModels
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.mainactivity.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

 @AndroidEntryPoint
 class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(ActivityMainBinding::inflate) {
     override val viewModel: MainViewModel by viewModels()

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}