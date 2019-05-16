package com.i64bits.kdemo.webservice

import android.util.Log

class RetroCoroutine
{
    fun call()
    {
        val data: GetData = RetrofitFactory.makeRetrofitService()
        val monkies:List<Monkey> = data.getMonkeyList()

        Log.e("LIST", monkies.toString())
    }
}