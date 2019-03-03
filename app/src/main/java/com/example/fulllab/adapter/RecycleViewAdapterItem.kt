package com.example.fulllab.adapter

import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.fulllab.R
import com.example.fulllab.model.Produto
import kotlinx.android.synthetic.main.item_layout.view.*


class RecycleViewAdapterItem(private val context: Context, private val produtoList: List<Produto>) :
        RecyclerView.Adapter<RecycleViewAdapterItem.ViewHolderCustom>() {

    // criando o layout da recycle view
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolderCustom {

        val view: View
        val layoutInflater = LayoutInflater.from(context)
        view = layoutInflater.inflate(R.layout.item_layout, viewGroup, false)
        return ViewHolderCustom(view)
    }

    //montando os widgets da item_layout
    override fun onBindViewHolder(viewHolderCustom: ViewHolderCustom, i: Int) {
        viewHolderCustom.precoAtual.text = "R$ "+produtoList[i].precoAtual.toString()
        viewHolderCustom.precoAnterior.text ="R$ "+produtoList[i].precoAnterior.toString()
        viewHolderCustom.porcentagem.text = (produtoList[i].porcentagem).toInt().toString()+"%"
        viewHolderCustom.titulo.text = produtoList[i].titulo
        viewHolderCustom.parcela.text = produtoList[i].parcela.toString()+" x R$ "+produtoList[i].valor.toString()
        viewHolderCustom.icone.setImageResource(produtoList[i].img)
    }


    //obtento o tamnaho da lista  do tipo produto pertencente a classe produto
    override fun getItemCount(): Int {
        return produtoList.size
    }

    //criacao da classe resposavel por instaciar os widgets
    inner class ViewHolderCustom(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //variveis
        var precoAtual: TextView
        var precoAnterior: TextView
        var titulo: TextView
        var porcentagem: TextView
        var icone: ImageView
        var parcela: TextView

        //inicializando sos componentes
        init {

            precoAtual = itemView.preco_atual_item
            precoAnterior = itemView.preco_anterior_item
            titulo = itemView.titulo_item
            porcentagem = itemView.porcentagem_item
            icone = itemView.img_item
            parcela = itemView.parcela_item
            precoAnterior.setPaintFlags(precoAnterior.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
        }
    }
}
