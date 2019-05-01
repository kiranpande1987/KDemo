package com.i64bits.kdemo

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ListView
import com.i64bits.kdemo.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    var b: ActivityMainBinding? = null;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        b = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setHeader("Kotlin Demos")
        addView(b?.listView);
    }


}
