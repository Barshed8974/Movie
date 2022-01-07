package vp.videoplayer.movie.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_new.*
import vp.videoplayer.movie.ModelClasses.MyModel
import vp.videoplayer.movie.R

class New : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        val myObject = intent.getParcelableExtra<MyModel>("identifier")
        setData(myObject)
        imageViewBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setData(myObject: MyModel?) {
        val rate= (myObject?.voteAverage?.toFloat()?.times(10))?.toInt()
        Glide.with(mIvMoviePoster).load("https://image.tmdb.org/t/p/w500${myObject?.posterPath}")
            .into(mIvMoviePoster)
        mTvMoviesName.text=myObject?.title
        if (rate != null) {
            mRating.progress=rate
        }
        mTvRating.text=myObject?.voteAverage.toString()
        mTvOverView.text=myObject?.overview
    }
}