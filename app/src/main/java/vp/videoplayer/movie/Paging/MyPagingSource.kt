package vp.videoplayer.mvvm.Paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import vp.videoplayer.movie.ModelClasses.ResultsItem
import vp.videoplayer.mvvm.Api.Network

class MyPagingSource: PagingSource<Int, ResultsItem>() {

    private val apiservices= Network.getApiServices()
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultsItem> {

        //initial Page Number
        val pagenumber=params.key?:1

        //calling api
        val quotes=apiservices.getQuotes(pagenumber)

        //receiving the list of Response Item
        val movieList:List<ResultsItem> = quotes.results as List<ResultsItem>

        //returning Paging Source
        return try {
            LoadResult.Page(
                data = movieList,
                prevKey = null,
                nextKey =if (movieList.isEmpty()) null else pagenumber+1
            )
        }
        catch (exception:Exception)
        {
            LoadResult.Error(exception)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, ResultsItem>): Int? {

        //returns the most recent access
        return state.anchorPosition
    }

}