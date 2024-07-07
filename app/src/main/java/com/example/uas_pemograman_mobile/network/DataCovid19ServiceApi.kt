package com.example.uas_pemograman_mobile.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://covid19.mathdro.id/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DataCovid19ServiceApi {
    @GET("confirmed")
    suspend fun getDataCovid19Data() : List<DataCovid19>
}

object DataCovid19Api {
    val retrofitServiceApi: DataCovid19ServiceApi by lazy {
        retrofit.create(DataCovid19ServiceApi::class.java)
    }
}