package com.apusx.movieapp.Adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apusx.movieapp.Models.Item
import com.apusx.movieapp.R
import com.apusx.movieapp.ui.MovieView
import com.bumptech.glide.Glide

class CustomAdapter(private val items: MutableList<Item>,var context: Context) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name_of_film: TextView? = null
        var year: TextView? = null
        var image: ImageView? = null
        var button: Button? = null

        init {
            name_of_film = itemView.findViewById(R.id.textView4)
            year = itemView.findViewById(R.id.textView3)
            image = itemView.findViewById(R.id.imageView)
            button = itemView.findViewById(R.id.button_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.name_of_film?.text = items.get(position).title
        holder.year?.text = items.get(position).year
        holder.image?.let {
            Glide.with(context)
                .load(items.get(position).image)
                .centerCrop()
                .into(it)
        }
        holder.button?.setOnClickListener {
            val intent = Intent(context,MovieView::class.java)

            intent.putExtra("id",items.get(position).id)

            context.startActivity(intent)
        }




    }

    override fun getItemCount() = items.size


}