package com.dicoding.pedulisatwaindonesia.detail

import androidx.lifecycle.ViewModel
import com.dicoding.pedulisatwaindonesia.data.AnimalEntity
import com.dicoding.pedulisatwaindonesia.data.DataAnimal

class DetailViewModel: ViewModel() {
    companion object {
        const val ANIMAL = "animal"
    }

    private lateinit var animal: AnimalEntity

    fun setAnimal(id: String, category: String) {
        when (category) {
            ANIMAL -> {
                for (movie in DataAnimal.getAnimal()) {
                    if (movie.id == id) animal = movie
                }
            }
        }
    }

    fun getAnimalDetail() = animal

}