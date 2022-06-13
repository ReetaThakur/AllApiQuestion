package com.reeta.allapiquestion.commonClassess

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    val BASE_URL="https://reqres.in/"
    val BASE_URL1="https://jsonplaceholder.typicode.com/"
    val BASE_URL2="https://reqres.in/"

 //  private val httpLoggingInterceptor= HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    fun getRetrofit():Retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
       // .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getRetrofit1():Retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL1)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getRetrofit2():Retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL2)
        .addConverterFactory(GsonConverterFactory.create()).build()
}