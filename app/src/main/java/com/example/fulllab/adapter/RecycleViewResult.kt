package com.example.fulllab.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fulllab.model.ResultadoBusca
import com.example.fulllab.R
import kotlinx.android.synthetic.main.resultado_layout.view.*

class RecycleViewResult(private val context:Context,private var listResult: ArrayList<ResultadoBusca>) : RecyclerView.Adapter<RecycleViewResult.ViewHolderCustom>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolderCustom {
        val view: View
        val layoutInflate = LayoutInflater.from(context)
        view = layoutInflate.inflate(R.layout.resultado_layout,viewGroup,false)
        return ViewHolderCustom(view)
    }


    override fun getItemCount(): Int {
        return listResult.size
    }

    override fun onBindViewHolder(vHC: ViewHolderCustom, index: Int) {

        vHC.resultado.text = listResult[index].resultado
    }


    inner class ViewHolderCustom (itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var resultado: TextView = itemView.resultado_consulta
    }
}