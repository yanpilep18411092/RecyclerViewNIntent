package com.example.projectserwin

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImgAdapter (
    private val context: Context,
    private val imgs: List<ImgData>,
    val listener: (ImgData) -> Unit
) : RecyclerView.Adapter<ImgAdapter.ImgViewHolder>()
{
    class ImgViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val imgSrc = view.findViewById<ImageView>(R.id.imgView)
        val title = view.findViewById<TextView>(R.id.tvTitle)
//        val desc = view.findViewById<TextView>(R.id.tvDesc)
        fun bindView(img:ImgData, listener: (ImgData) -> Unit) {
            imgSrc.setImageResource(img.imgSrc)
            title.text = img.imgTitle
//            desc.text = img.imgDesc
            itemView.setOnClickListener { listener(img) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImgViewHolder
    = ImgViewHolder(LayoutInflater.from(context).inflate(R.layout.item_img, parent, false))

    override fun getItemCount(): Int = imgs.size

    override fun onBindViewHolder(holder: ImgViewHolder, position: Int) {
        holder.bindView(imgs[position], listener)
    }

}