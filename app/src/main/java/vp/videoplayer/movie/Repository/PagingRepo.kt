package vp.videoplayer.movie.Repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import vp.videoplayer.mvvm.Paging.MyPagingSource

class PagingRepo {
    fun getPageList()=Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 70,
        ),
        pagingSourceFactory = { MyPagingSource() }
    ).liveData
}