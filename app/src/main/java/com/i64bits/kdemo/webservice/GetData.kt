package com.i64bits.kdemo.webservice

import retrofit2.http.GET

interface GetData
{
    @GET("197lky")
    fun getMonkeyList(): List<Monkey>
}