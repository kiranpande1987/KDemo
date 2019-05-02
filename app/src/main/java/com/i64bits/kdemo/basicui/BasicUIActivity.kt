package com.i64bits.kdemo.basicui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.i64bits.kdemo.BaseActivity
import com.i64bits.kdemo.R
import kotlinx.android.synthetic.main.activity_basic_ui.*

class BasicUIActivity : BaseActivity()
{
    private val PREF_NAME: String = "PREF_LIST"
    private val PREF_FILE_NAME: String = "BASIC_ACTIVITY_PREFERENCES"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        init()
        setListener()
    }

    private fun init()
    {
        setHeader(intent.getStringExtra("Header"))
        view = View.inflate(this, R.layout.activity_basic_ui, null)
        addView(view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        updateRecyclerView()
    }

    private fun setListener()
    {
        txtSubmit.setOnClickListener {

            val string: String = edtText.text.toString()

            if(!string.isEmpty())
            {
                addToPreferences(string)
            }
            else
            {
                Toast.makeText(this, "Please, enter text.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addToPreferences(string: String)
    {
        val pref: SharedPreferences = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        var set:String = pref.getString(PREF_NAME,"")

        if(set.isEmpty())
            set = string
        else
            set = set +"@"+ string

        val editor = pref.edit()
        editor.putString(PREF_NAME, set)
        editor.apply()

        updateRecyclerView()
    }

    private fun getSetOfString(): List<String>
    {
        val pref: SharedPreferences = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        val set:String = pref.getString(PREF_NAME,"")

        return set.split("@")
    }

    private fun updateRecyclerView()
    {
        recyclerView.adapter = BasicUIAdapter(getSetOfString().toList())
    }
}
