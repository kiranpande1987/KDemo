package com.i64bits.kdemo

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.i64bits.kdemo.databinding.ActivityBaseBinding
import com.i64bits.kdemo.databinding.ActivityMainBinding

open class BaseActivity : AppCompatActivity() {

    var binding: ActivityBaseBinding? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_base)

    }

    protected fun setHeader(header: String)
    {
        val header = Header("Kotlin Demos")
        binding?.header = header;
        binding?.executePendingBindings()
    }
}
