package com.reeta.allapiquestion.getWithListAndQuery

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.reeta.allapiquestion.R


class ItemAdapter(var list:ListResponseDTO):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.api_item_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val apiList:ListResponseDTOItem=list[position]
        holder.setData(apiList)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val name:TextView=itemView.findViewById(R.id.tvPostName)
        val content:TextView=itemView.findViewById(R.id.tvContent)
        val email:TextView=itemView.findViewById(R.id.tvEmail)

        fun setData(listResponseDTO: ListResponseDTOItem){
         name.text=listResponseDTO.name
            content.text=listResponseDTO.body
            email.text=listResponseDTO.email
        }
    }
}