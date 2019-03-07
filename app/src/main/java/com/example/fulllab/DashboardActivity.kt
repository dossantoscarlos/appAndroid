package com.example.fulllab

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import com.example.fulllab.adapter.RecycleViewAdapterItem
import com.example.fulllab.model.Produto
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.app_bar_dashboard.*
import kotlinx.android.synthetic.main.content_dashboard.*
import kotlinx.android.synthetic.main.nav_header_dashboard.view.*

class DashboardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setSupportActionBar(toolbar)

        val listaProduto: List<Produto>

        listaProduto = ArrayList()
        for(x in 1..8) {
            listaProduto.add(Produto(10.0,20.0,"camisa esporte",
                    R.drawable.abc_ic_star_black_48dp,2,5.0))
        }

        this.exibeLista(listaProduto)

        //abre a activity do login
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val header = nav_view.getHeaderView(0)
        header.textViewLogin.setOnClickListener{
            startActivity(Intent(it.context,LoginActivity::class.java))
        }
    }


    private fun exibeLista(produtos: List<Produto>) {
        val mAdapter = RecycleViewAdapterItem(this, produtos as ArrayList<Produto>)
        recycle_view_main_id.layoutManager = GridLayoutManager(this, 2)
        recycle_view_main_id.adapter = mAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.dashboard, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.action_search)
                .actionView as SearchView
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(componentName))

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

            R.id.nav_camera -> {
                startActivity(Intent(this,LoginActivity::class.java))
            }

            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.textViewLogin -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
