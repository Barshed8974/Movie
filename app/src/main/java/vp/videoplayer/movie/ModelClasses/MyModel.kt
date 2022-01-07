package vp.videoplayer.movie.ModelClasses

import android.os.Parcel
import android.os.Parcelable

data class MyModel(
    val overview: String? = null, val originalLanguage: String? = null,
    val originalTitle: String? = null, val video: Boolean? = null,
    val title: String? = null, val posterPath: String? = null,
    val backdropPath: String? = null, val releaseDate: String? = null,
    val popularity: Double? = null, val voteAverage: Double? = null, val id: Int? = null,
    val adult: Boolean? = null, val voteCount: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(overview)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeValue(video)
        parcel.writeString(title)
        parcel.writeString(posterPath)
        parcel.writeString(backdropPath)
        parcel.writeString(releaseDate)
        parcel.writeValue(popularity)
        parcel.writeValue(voteAverage)
        parcel.writeValue(id)
        parcel.writeValue(adult)
        parcel.writeValue(voteCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyModel> {
        override fun createFromParcel(parcel: Parcel): MyModel {
            return MyModel(parcel)
        }

        override fun newArray(size: Int): Array<MyModel?> {
            return arrayOfNulls(size)
        }
    }
}
