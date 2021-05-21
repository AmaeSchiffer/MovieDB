package com.amaeschiffer.moviedb.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amaeschiffer.moviedb.R
import com.amaeschiffer.moviedb.model.tvshow.ResultTvShow
import com.amaeschiffer.moviedb.ui.DetailActivity
import com.amaeschiffer.moviedb.ui.fragment.TvShowFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv.view.*

class TvShowAdapter (private val context: Context?) : RecyclerView.Adapter<TvShowAdapter.Holder>() {
    private var list: MutableList<ResultTvShow> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv, parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {

        if(list[position].poster_path != null){
            val url = "https://image.tmdb.org/t/p/w500"+list[position].poster_path
            Glide.with(holder.itemView.context).load(url).into(holder.itemView.bgImage)
        }else{
            Glide.with(holder.itemView.context).load(R.drawable.ic_baseline_broken_image).into(holder.itemView.bgImage)
        }

        holder.itemView.titleTvShow.text = list[position].name
        val rate = "%.0f".format((list[position].vote_average?.times(10)))
        holder.itemView.ratingTvShow.text = "${rate}%"
        holder.itemView.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            i.putExtra("key", TvShowFragment.tvShow)
            i.putExtra(TvShowFragment.tvShow, list[position])
            context?.startActivity(i)
        }
    }

    override fun getItemCount(): Int = list.size
    class Holder(view: View) : RecyclerView.ViewHolder(view)

    fun setData(data: ArrayList<ResultTvShow>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}