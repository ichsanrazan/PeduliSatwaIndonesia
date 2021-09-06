package com.dicoding.pedulisatwaindonesia.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnimalEntity(
    val id: String,
    val name: String,
    val species: String,
    val status: String,
    val population: String,
    val overview: String,
    val habitat: String,
    val threat: String,
    val location: String,
    val poster: Int,
    val map: Int,
    val link: String,
) : Parcelable