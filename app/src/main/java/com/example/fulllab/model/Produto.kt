package com.example.fulllab.model

import android.graphics.drawable.Drawable
import com.example.fulllab.R
import java.net.URI

//classe que ira processar os dados vindo da api
class Produto(precoAtual: Double, precoAnterior: Double, titulo: String,img : Int ){

    //titulo do produto
    var titulo: String = ""
        private set
    //imagem do produto
    var img: Int = R.drawable.ic_launcher_background
        private set
    //valor do preco atual
    var precoAtual: Double = 0.toDouble()
        private set

    //valor do preco anterior
    var precoAnterior: Double = 0.toDouble()
        private set

    //variavel que ira controlar a exibicao do percentual
    var porcentagem: Double = 0.toDouble()
        private set


    init {
        this.titulo = titulo
        this.precoAtual = precoAtual
        this.precoAnterior = precoAnterior
        this.porcentagem = this.porcentagem(precoAnterior, precoAtual)
        this.img = img
    }

    /*
        obtem a  porcentagem de desconto
        varlorA * % /100 = valorB
        % = valorB * 100 /valorA
    */
    private fun porcentagem(valorAnt: Double, valorAt: Double): Double {
        return valorAt * 100 / valorAnt
    }


}
