package vp.videoplayer.movie.ViewModel


import androidx.lifecycle.ViewModel
import vp.videoplayer.movie.Repository.PagingRepo

class PagingViewModel:ViewModel() {
    private val repo= PagingRepo()
    fun searchQuotes()=repo.getPageList()
}