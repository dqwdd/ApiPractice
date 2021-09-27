package com.example.apipractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apipractice.json.Item


class RecyclerAdapter(
    val mContext: Context,
    val mList: List<Item>) :
    RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

    class ItemViewHolder(val mContext: Context, view : View) : RecyclerView.ViewHolder(view) {

        val textView = view.findViewById<TextView>(R.id.textView)
        val textView2 = view.findViewById<TextView>(R.id.textView2)
        val textView3 = view.findViewById<TextView>(R.id.textView3)

        fun bind( context: Context, data: Item ) {
            textView.text =data.DESC_KOR
            textView2.text =data.SERVING_WT
            textView3.text =data.BGN_YEAR
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.my_place_list_item, parent, false)
        return ItemViewHolder(mContext, view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = mList[position]
        holder.bind(mContext, data)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}