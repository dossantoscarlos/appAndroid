package com.example.fulllab

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import com.example.fulllab.model.Produto
import com.example.fulllab.adapter.RecycleViewAdapterItem
import com.example.fulllab.util.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import android.app.SearchManager
import android.content.Context
import android.widget.SearchView

class MainActivity : AppCompatActivity() {

    private var listProduto: List<Produto>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        minha_action_bar.setBackgroundColor(Color.RED)

        val actionbar = minha_action_bar as Toolbar?

        setSupportActionBar(actionbar)

        listProduto = ArrayList()

        val resposta = RetrofitInitializer().produtoService().busca(listProduto as ArrayList<Produto>)

        resposta.enqueue(object : Callback, retrofit2.Callback<Produto> {

            override fun onFailure(call: Call<Produto>, t: Throwable) {
                Log.e("Api Error : ", t.message)
            }

            override fun onResponse(call: Call<Produto>, response: Response<Produto>) {
                response.body()?.let {
                    val p = it

                    (listProduto as ArrayList<Produto>).add(Produto(p.precoAtual,p.precoAnterior,p.titulo,p.img))
                    exibeLista(listProduto as ArrayList<Produto>)

                    Log.i("Api informacao", response.message().toString())
                }
            }
        })

     }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.activity_main_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.action_search)
                .actionView as SearchView
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(componentName))

        return super.onCreateOptionsMenu(menu)
    }

    private fun exibeLista(produtos: List<Produto>) {

        val mAdapter = RecycleViewAdapterItem(this, produtos as ArrayList<Produto>)
        recycle_view_main_id.layoutManager = GridLayoutManager(this, 2)
        recycle_view_main_id.adapter = mAdapter
    }
}
