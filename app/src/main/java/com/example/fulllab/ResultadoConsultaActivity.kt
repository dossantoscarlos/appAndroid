package com.example.fulllab

import android.app.SearchManager
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.Toolbar
import com.example.fulllab.model.ResultadoBusca
import com.example.fulllab.adapter.RecycleViewResult
import kotlinx.android.synthetic.main.activity_resultado_consulta.*


class ResultadoConsultaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_consulta)

        val actionbar = action as Toolbar?

        action.setBackgroundColor(Color.RED)
        (action as Toolbar?)?.title = "Resultado"
        setSupportActionBar(actionbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        onNewIntent(intent)

    }

    override fun onNewIntent(intent: Intent) {
        setIntent(intent)
        handleIntent(intent)
    }

    /**
     * intent handle
     */
    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            var busca = intent.getStringExtra(SearchManager.QUERY)

            //verifica se a busca e nula
            if (busca === null) {
                busca = "Nao funcionou "
            }

            val listBusca: ArrayList<ResultadoBusca> = ArrayList()
               listBusca.add(ResultadoBusca(busca))
               exibeLista(listBusca)
            }

    }

    private fun exibeLista(resultado: List<ResultadoBusca>) {
        val mAdapter = RecycleViewResult(this,resultado as ArrayList<ResultadoBusca>)
        lista_consulta.layoutManager = GridLayoutManager(this,2)
        lista_consulta.adapter = mAdapter
    }
}
