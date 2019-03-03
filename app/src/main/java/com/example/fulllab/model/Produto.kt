package com.example.fulllab.model

import com.example.fulllab.R

//classe que ira processar os dados vindo da api
class Produto(precoAtual: Double, precoAnterior: Double,titulo: String,img : Int, parcela:Int, valor:Double ) {

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

    var parcela: Int = 0
        private set

    var valor:Double = 0.toDouble()
        private set

    init {
        this.titulo = titulo
        this.precoAtual = precoAtual
        this.precoAnterior = precoAnterior
        this.porcentagem = this.porcentagem(precoAnterior, precoAtual)
        this.img = img
        this.parcela = parcela
        this.valor = valor
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
