package com.example.projectserwin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImgData (
    val imgSrc:Int,
    val imgTitle:String,
    val imgDesc:String
) : Parcelable
