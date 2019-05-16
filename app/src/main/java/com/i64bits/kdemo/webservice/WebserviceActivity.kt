package com.i64bits.kdemo.webservice

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.i64bits.kdemo.BaseActivity
import com.i64bits.kdemo.R
import kotlinx.android.synthetic.main.activity_webservice.view.*

class WebserviceActivity : BaseActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setData()
        setListener()
    }

    fun init()
    {
        setHeader(intent.getStringExtra("Header"))
        view = View.inflate(this, R.layout.activity_webservice, null)
        addView(view)

        view.rvwForWebservice.layoutManager = LinearLayoutManager(this)
    }

    fun setData()
    {
        val data: GetData = RetrofitFactory.makeRetrofitService()
        val monkies:ArrayList<Monkey> = data.getMonkeyList() as ArrayList<Monkey>

        Log.e("LIST", monkies.toString())

        view.rvwForWebservice.adapter = WebserviceAdapter(monkies, this)
    }

    fun setListener()
    {

    }
}
