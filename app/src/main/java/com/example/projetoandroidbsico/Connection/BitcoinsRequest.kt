package com.example.projetoandroidbsico.Connection


import com.example.projetoandroidbsico.Models.BitcoinsNews
import com.example.projetoandroidbsico.Models.Results
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



    @GET ( "api/3/action/datastore_search")
    fun getGyms (
        @Query("resource_id") resource_id : String = "78fccbb7-b44d-49a8-8c82-bcc1dc8463b4",
        @Query("limit") limit : String = "20"
    ):Call<Results>





}
