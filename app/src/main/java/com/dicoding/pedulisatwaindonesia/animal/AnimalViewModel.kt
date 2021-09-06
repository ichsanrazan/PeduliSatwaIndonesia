package com.dicoding.pedulisatwaindonesia.animal

import androidx.lifecycle.ViewModel
import com.dicoding.pedulisatwaindonesia.data.DataAnimal

class AnimalViewModel: ViewModel() {
    fun getAnimal() = DataAnimal.getAnimal()
}