package com.example.projetoandroidbsico.Connection


import com.example.projetoandroidbsico.Models.BitcoinsNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BitcoinsRequest {
    @GET("everything")
    fun getNews(
        @Query("q") q: String = "bitcoin",
        @Query("language") language: String = "pt",
        @Query("apiKey") apiKey: String = "0e13b0f38b2e44c192ea59394afab483"
    ):Call<BitcoinsNews>





}
