package vp.videoplayer.movie.View

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import vp.videoplayer.movie.ModelClasses.ResultsItem
import vp.videoplayer.movie.Paging.onClick
import vp.videoplayer.movie.R


class MyMovieAdapter(val context: Context, val onClick: onClick):PagingDataAdapter<ResultsItem, MovieViewHolder>(diffUtil) {

    companion object{
        val diffUtil= object :DiffUtil.ItemCallback<ResultsItem>(){
            override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem==newItem
            }

        }
    }

    override fun onBindViewHolder(movieViewHolder: MovieViewHolder, position: Int) {
        val data=getItem(position)
        if (data != null) {
            movieViewHolder.setData(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val viewType=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MovieViewHolder(viewType,onClick)
    }
}