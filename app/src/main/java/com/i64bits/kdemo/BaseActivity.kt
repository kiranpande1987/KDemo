package com.i64bits.kdemo

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.i64bits.kdemo.databinding.ActivityBaseBinding

open class BaseActivity: AppCompatActivity() {

    var binding: ActivityBaseBinding? = null
    protected lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_base)

    }

    protected fun setHeader(header: String)
    {
        val header = Header(header)
        binding?.header = header
        binding?.executePendingBindings()
    }

    protected fun addView(view: View?)
    {
        binding?.baseLayout?.removeAllViews()
        binding?.baseLayout?.addView(view)
    }
}
