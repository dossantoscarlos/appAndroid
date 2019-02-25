package com.example.fulllab.interfaces

import com.example.fulllab.model.Produto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ProdutoService {
    @Headers("Content-Type:application/json")
    @POST("/")
    fun busca(@Body produto: List<Produto>): Call<Produto>
}
