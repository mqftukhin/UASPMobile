package com.example.uas_pemograman_mobile.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dekontaminasi.com/api/id/covid19/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RumahSakitServiceApi {
    @GET("hospitals")
    suspend fun getRumahSakit() : List<RumahSakit>
}

object RumahSakitApi {
    val retrofitServiceApi: RumahSakitServiceApi by lazy {
        retrofit.create(RumahSakitServiceApi::class.java)
    }
}