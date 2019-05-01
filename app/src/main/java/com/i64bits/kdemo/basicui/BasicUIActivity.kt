package com.i64bits.kdemo.basicui

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.i64bits.kdemo.BaseActivity
import com.i64bits.kdemo.R

class BasicUIActivity : BaseActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init()
    {
        setHeader(intent.getStringExtra("Header"))
        view = View.inflate(this, R.layout.activity_basic_ui, null)
        addView(view)
    }
}
