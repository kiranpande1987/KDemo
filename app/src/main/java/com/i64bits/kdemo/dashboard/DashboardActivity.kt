package com.i64bits.kdemo.dashboard

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.i64bits.kdemo.BaseActivity
import com.i64bits.kdemo.R
import com.i64bits.kdemo.basicui.BasicUIActivity
import com.i64bits.kdemo.webservice.WebserviceActivity

import kotlinx.android.synthetic.main.activity_dashboard.view.*

class DashboardActivity : BaseActivity()
{
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
        view.rvwForDashboard.adapter = DashboardAdapter(demos, this)
    }

    private fun addDemos()
    {
        demos.add(DashboardModel("Basic UI", BasicUIActivity()))
        demos.add(DashboardModel("Webservice", WebserviceActivity()))
    }

    inner class OnClick(var item: DashboardModel) : View.OnClickListener
    {
        override fun onClick(v: View?)
        {
            navigate(item)
        }
    }

    fun navigate(item: DashboardModel)
    {
        val intent: Intent = Intent(this@DashboardActivity, item.activity::class.java)
        intent.putExtra("Header", item.title)
        startActivity(intent)
    }
}
