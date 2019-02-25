package com.example.fulllab.util

import com.example.fulllab.interfaces.ProdutoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//classe responsavel por configurar o retrofit
class RetrofitInitializer  {

    //constatntte co base url
    private val baseurl = "https://desafio.mobfiq.com.br/Search/Criteria/"
    var retrofitConfig: Retrofit

    //inicializando o retrofit
    init {
        retrofitConfig = Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    //criando conexao com o recurso da api

    fun produtoService() = retrofitConfig.create(ProdutoService::class.java)

}