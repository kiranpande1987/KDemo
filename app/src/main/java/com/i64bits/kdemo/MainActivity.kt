package com.i64bits.kdemo

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.i64bits.kdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val listView: ListView? = null;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val header = Header("Kotlin Demos")
        binding.header = header;
        binding.executePendingBindings()

    }
}
