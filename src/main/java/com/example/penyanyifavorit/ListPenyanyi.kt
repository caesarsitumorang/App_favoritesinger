package com.example.penyanyifavorit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ListPenyanyi(private val listPenyanyi: ArrayList<Penyanyi>) : RecyclerView.Adapter<ListPenyanyi.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPenyanyi.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_penyanyi, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListPenyanyi.ListViewHolder, position: Int) {
        val penyanyi = listPenyanyi[position]
        holder.imgPhoto.setImageResource(penyanyi.photo)
        holder.tvName.text = penyanyi.name
        holder.tvDescription.text = penyanyi.description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.key_penyanyi, penyanyi)
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listPenyanyi.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}

