package com.example.projectserwin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//@Suppress("UNREACHABLE_CODE")
class ExampleAdapter (private val exampleList: List<ExampleItem>) :
    RecyclerView.Adapter <ExampleAdapter.ExampleViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exmpl_item, parent, false)
        return ExampleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return exampleList.size
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imgRsrc)
        holder.textName.text = currentItem.txtName
        holder.textPhone.text = currentItem.txtPhone
    }

    class ExampleViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.imgView)
        val textName : TextView = itemView.findViewById(R.id.tvName)
        val textPhone : TextView = itemView.findViewById(R.id.tvPhone)

    }

    }