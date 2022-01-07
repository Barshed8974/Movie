package vp.videoplayer.movie.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vp.videoplayer.movie.ModelClasses.MyModel
import vp.videoplayer.movie.ModelClasses.ResultsItem
import vp.videoplayer.movie.Paging.onClick
import vp.videoplayer.movie.R
import vp.videoplayer.movie.ViewModel.PagingViewModel

class MainActivity : AppCompatActivity(),onClick {
    lateinit var pagingViewModel: PagingViewModel
    lateinit var movieAdapter: MyMovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pagingViewModel= ViewModelProvider(this).get(PagingViewModel::class.java)
        setAdapter()
        pagingViewModel.searchQuotes().observe(this,{
            it?.let {
                CoroutineScope(Dispatchers.Main).launch {
                    movieAdapter.submitData(it)
                }
            }
        })
    }

    //setting adapter to recyclerView
    private fun setAdapter() {
        movieAdapter= MyMovieAdapter(this,this)
        val gridLayoutManager= GridLayoutManager(this,3)
        recycler.apply {
            layoutManager=gridLayoutManager
            adapter=movieAdapter
        }
        val linearLayoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)
        recycler1.apply {
            layoutManager=linearLayoutManager
            adapter=movieAdapter
        }
    }

    //from onClick
    override fun itemOnClick(resultItem: ResultsItem) {
        val intent = Intent(this, New::class.java)
        val myModel=resultItem.run {
            MyModel(overview,originalLanguage,originalTitle,video,title, posterPath, backdropPath, releaseDate, popularity, voteAverage, id, adult, voteCount)
        }
        intent.putExtra("identifier",myModel)
        startActivity(intent)
    }
}