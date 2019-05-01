package com.i64bits.kdemo.basicui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.i64bits.kdemo.BaseActivity
import com.i64bits.kdemo.R
import kotlinx.android.synthetic.main.activity_basic_ui.*
import kotlinx.android.synthetic.main.activity_basic_ui.view.*

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

        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        updateRecyclerView()
    }

    private fun setListener()
    {
        txtSubmit.setOnClickListener {

            var string: String = edtText.text.toString()

            if(!string.isEmpty())
            {
                addToPreferences(string)
                Log.e("SET", getSetOfString().toString())
            }
            else
            {
                Toast.makeText(this, "Please, enter text.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addToPreferences(string: String)
    {
        var pref: SharedPreferences = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        var set:MutableSet<String> = pref.getStringSet(PREF_NAME, mutableSetOf<String>())
        set.add(string)

        val editor = pref.edit()
        editor.putStringSet(PREF_NAME, set)
        editor.apply()

        updateRecyclerView()
    }

    private fun getSetOfString(): MutableSet<String>
    {
        var pref: SharedPreferences = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
        var set:MutableSet<String> = pref.getStringSet(PREF_NAME, mutableSetOf<String>())

        return set
    }

    private fun updateRecyclerView()
    {
        var list: List<String> = getSetOfString().toList()
        recyclerView.adapter = BasicUIAdapter(list)
    }
}
