package com.i64bits.kdemo.dashboard

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import com.i64bits.kdemo.BaseActivity
import com.i64bits.kdemo.R

import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_dashboard.view.*

class DashboardActivity : BaseActivity()
{
    lateinit var view: View
    private var demos: ArrayList<DashboardModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        populateRecyclerView()
    }

    private fun init()
    {
        setHeader("Kotlin Demos")

        view = View.inflate(this, R.layout.activity_dashboard, null)
        addView(view)

    }

    private fun populateRecyclerView()
    {
        addDemos()

        view.rvwForDashboard.layoutManager = LinearLayoutManager(this)
        view.rvwForDashboard.adapter = DashboardAdapter(demos)
    }

    private fun addDemos()
    {
        demos.add(DashboardModel("Basic UI"))
    }



}
