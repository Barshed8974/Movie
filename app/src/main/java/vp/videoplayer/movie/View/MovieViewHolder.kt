package vp.videoplayer.movie.View

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*
import vp.videoplayer.movie.ModelClasses.ResultsItem
import vp.videoplayer.movie.Paging.onClick

class MovieViewHolder(itemView: View, val onClick: onClick) : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    fun setData(resultsItem: ResultsItem) {

        //setting image
        Glide.with(itemView.image).load("https://image.tmdb.org/t/p/w500${resultsItem.posterPath}")
            .into(itemView.image)

        //calling onclick method
        itemView.setOnClickListener {
            onClick.itemOnClick(resultsItem)
        }
    }

}