package com.example.projetoandroidbsico.Connection

import com.example.projetoandroidbsico.Models.Results
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRepositories {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun BitcoinsRequest() = retrofit.create(BitcoinsRequest::class.java)


    private val retrofitMaps = Retrofit.Builder()
        .baseUrl("http://dados.recife.pe.gov.br/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun AcademiasRequest() = retrofitMaps.create(BitcoinsRequest::class.java)

}